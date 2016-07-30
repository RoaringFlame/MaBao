package com.mabao.service.impl;

import com.mabao.controller.vo.GoodsDetailVO;
import com.mabao.enums.BabyType;
import com.mabao.enums.OrderStatus;
import com.mabao.enums.Quality;
import com.mabao.pojo.*;
import com.mabao.repository.GoodsRepository;
import com.mabao.service.*;
import com.mabao.util.BaseAction;
import com.mabao.util.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class GoodsServiceImpl extends BaseAction implements GoodsService {

    @Autowired
    private GoodsRepository goodsRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private GoodsTypeService goodsTypeService;
    @Autowired
    private GoodsBrandService goodsBrandService;
    @Autowired
    private GoodsSizeService goodsSizeService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private OrderService orderService;

    /**
     * 新品
     */
    @Override
    public Page<Goods> getNewGoods(int page, int pageSize) {
        return this.goodsRepository.findAll(new PageRequest(page, pageSize));
    }

    /**
     * 首页商品模糊搜索
     */
    @Override
    public Page<Goods> goodsSearch(Long goodsTypeId,String title, int page, int pageSize) {
        if (goodsTypeId == null && (title == null || "".equals(title))){
            return this.goodsRepository.findByStateOrderByUpTimeDesc(Boolean.TRUE,new PageRequest(page, pageSize));
        }if (goodsTypeId != null && title != null && !"".equals(title)){
            title = "%"+title+"%";
            return this.goodsRepository.findByTitleLikeAndTypeIdAndState(title,goodsTypeId,Boolean.TRUE,new PageRequest(page, pageSize));
        }else if (title == null || "".equals(title)){
            return this.goodsRepository.findByTypeIdAndState(goodsTypeId,Boolean.TRUE,new PageRequest(page, pageSize));
        }else if (goodsTypeId == null){
            title = "%"+title+"%";
            return this.goodsRepository.findByTitleLikeAndState(title,Boolean.TRUE,new PageRequest(page, pageSize));
        }else {
            return null;
        }

    }
    /**
     * 查询商品信息
     */
    @Override
    public Goods get(Long goodsId) {
        return this.goodsRepository.findOne(goodsId);
    }

    /**
     * （首页猜你喜欢）
     * @param page              页码
     * @param pageSize          一页大小
     * @return                  商品集合，分页
     */
    @Override
    public Page<Goods> goodsListGuess(Baby baby, int page, int pageSize) {
        return this.goodsRepository.findByStateOrderByUpTimeDesc(Boolean.TRUE,new PageRequest(page, pageSize));
    }
    /**
     * 保存商品
     * @param newGoods        商品对象，需包含用户ID
     * @return                保存的商品对象
     */
    @Override
    public Goods saveOne(Goods newGoods) {
        return this.goodsRepository.save(newGoods);
    }
    /**
     * 根据商品ID查商品list
     * @param goodsIdList           商品ID集合
     * @return                      商品list
     */
    @Override
    public List<Goods> findGoodsByIdIn(List<Long> goodsIdList) {
        return this.goodsRepository.findByIdIn(goodsIdList);
    }


    /**
     * 自助发布宝物
     * 添加商品
     * @param goodsVO             商品对象
     * @param goodsPic
     * @param request
     * @return                  寄售成功页
     */
    @Override
    public Goods releaseGoods(GoodsDetailVO goodsVO, MultipartFile[] goodsPic, HttpServletRequest request) throws Exception  {
       try {
            User user = UserManager.getUser();
            assert user != null;
            //保存宝物
            Goods goods = new Goods();
            goods.setUser(user);
            goods.setTitle(goodsVO.getTitle());
            goods.setOldPrice(goodsVO.getOldPrice());
            goods.setPrice(goodsVO.getPrice());
            goods.setBabyType(BabyType.valueOf(goodsVO.getBabyType()));
            GoodsType goodsType = this.goodsTypeService.get(goodsVO.getTypeId());
            goods.setType(goodsType);
            goods.setTypeName(goodsType.getTypeName());
            GoodsBrand brand = this.goodsBrandService.get(goodsVO.getBrandId());
            goods.setBrand(brand);
            goods.setBrandName(brand.getBrandName());
            goods.setUpTime(goodsVO.getUpTime());
            goods.setNewDegree(Quality.valueOf(goodsVO.getNewDegree()));
            goods.setSize(this.goodsSizeService.get(Long.valueOf(goodsVO.getSize())));
            goods.setPack(goodsVO.getPack());
            goods.setReceipt(goodsVO.getReceipt());
            goods.setMessage(goodsVO.getMessage());
            goods.setState(true);
            goods.setStockNumber(1);
           //保存文件
           if (goodsPic !=null){
               String picURL = "/upload/"+user.getId()+"/";
               //上传文件过程
               super.uploads(goodsPic, picURL, request);
               String [] nameArray = super.getFileNames();
               StringBuilder pictureList = new StringBuilder();
               for (int i=0; i < nameArray.length;i++){
                   String name = nameArray[i].substring(nameArray[i].indexOf(picURL)+picURL.length(),nameArray[i].length());
                   pictureList.append(user.getId()).append("/").append(name);
                   if (i < (nameArray.length-1)){
                       pictureList.append(",");
                   }
               }
               goods.setPicture(user.getId()+"/"+nameArray[0].substring(nameArray[0].indexOf(picURL)+picURL.length(),nameArray[0].length()));
               goods.setPictureList(pictureList.toString());
           }
            Goods saveGoods = this.goodsRepository.save(goods);
            //生成订单
            Order order = new Order();
            order.setBuyer(this.userService.get(1L));
            order.setSellerId(user.getId());
            order.setQuantity(1);
            order.setAddress(this.addressService.getDefaultAddress(user.getId()));
            order.setMessage("自助寄卖");
            order.setCreateTime(new Date());
            order.setState(OrderStatus.ToBeRelease);
            order.setFreight(10.00);                    //运费
            order.setTotalSum(order.getFreight()+saveGoods.getPrice());
            this.orderService.saveOrder(order);
            //订单明细
            OrderDetail od = new OrderDetail();
            od.setGoods(saveGoods);
            od.setOrder(order);
            od.setUnitCost(saveGoods.getPrice());
            od.setSize(saveGoods.getSize().getName());
            od.setNewDegree(saveGoods.getNewDegree().getText());
            od.setTitle(saveGoods.getTitle());
            od.setTypeName(saveGoods.getType().getTypeName());
            od.setUpTime(saveGoods.getUpTime());
            od.setBrand(saveGoods.getBrand().getBrandName());
            this.orderService.saveOrderDetail(od);
            return saveGoods;
        }catch (Exception e){
            return null;
        }
    }


    /**
     * 为文件重新命名，命名规则为当前系统时间毫秒数
     * @return string
     */
    private String getFileNameNew() {
        SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        return fmt.format(new Date());
    }
}
