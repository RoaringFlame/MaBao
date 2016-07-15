package com.mabao.controller.rest;

import com.mabao.controller.vo.BabyVO;
import com.mabao.controller.vo.BannerVO;
import com.mabao.controller.vo.GoodsVO;
import com.mabao.controller.vo.HomeInitVO;
import com.mabao.enums.Gender;
import com.mabao.pojo.Baby;
import com.mabao.pojo.Goods;
import com.mabao.pojo.User;
import com.mabao.service.BabyService;
import com.mabao.service.BannerService;
import com.mabao.service.GoodsService;
import com.mabao.service.GoodsTypeService;
import com.mabao.util.PageVO;
import com.mabao.util.Selector;
import com.mabao.util.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/home")
public class HomeRESTController {
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private GoodsTypeService goodsTypeService;
    @Autowired
    private BannerService bannerService;
    @Autowired
    private BabyService babyService;

    /**
     * 首页初始化
     *（查询商品类别，轮播图片，宝宝性别）
     * @return              index首页
     */
    @RequestMapping(method = RequestMethod.GET)
    public HomeInitVO homeInit() {
        HomeInitVO homeInitVO = new HomeInitVO();
        //商品类别
        List<Selector> goodsTypeList = this.goodsTypeService.getAllGoodsTypeForSelector();
        homeInitVO.setGoodsTypeList(goodsTypeList);
        //轮播图片列表
        List<BannerVO> smallBanner =BannerVO.generateBy(this.bannerService.findByStatusOrderBySortDesc(true));
        homeInitVO.setSmallBanner(smallBanner);
        //猜你喜欢，宝宝信息
        User user = UserManager.getUser();
        if (user != null){
            try{
                Baby baby = this.babyService.findBabyByUserId(user.getId()).get(0);
                homeInitVO.setBaby(BabyVO.generateBy(baby));
            }catch (Exception e){
                homeInitVO.setBaby(null);
            }
        }
        //猜你喜欢，宝宝性别
        List<Selector> gender = Gender.toList();
        homeInitVO.setGender(gender);
        return homeInitVO;
    }

    /**
     * 首页商品模糊搜索（包含商品类型）
     * @param searchKey         关键字
     * @param goodsTypeId       商品类型id
     * @return                  商品
     */
    @RequestMapping(value = "/goodsSearch", method = RequestMethod.GET)
    public PageVO<GoodsVO> goodsSearch(Long goodsTypeId,String searchKey,int page,int pageSize) {

        Page<Goods> goodsList = this.goodsService.goodsSearch(goodsTypeId,searchKey,page,pageSize);
        PageVO<GoodsVO> voPage = new PageVO<>();
        voPage.toPage(goodsList);
        voPage.setItems(GoodsVO.generateBy(goodsList.getContent()));
        return voPage;
    }

    /**
     * （首页猜你喜欢）
     * @param page              页码
     * @param pageSize          一页大小
     * @return                  商品集合，分页
     */
    @RequestMapping(value = "/goodsGuess",method = RequestMethod.GET)
    public PageVO<GoodsVO> goodsListGuess(Baby baby,int page,int pageSize) {
        Page<Goods> goodsPage = this.goodsService.goodsListGuess(baby,page,pageSize);
        PageVO<GoodsVO> voPage = new PageVO<>();
        voPage.toPage(goodsPage);
        voPage.setItems(GoodsVO.generateBy(goodsPage.getContent()));
        return voPage;
    }

    /**
     * 猜你喜欢表单提交
     * @param baby  baby对象
     * @return      babyVO对象
     */
    @RequestMapping(value = "/babySubmit",method = RequestMethod.GET)
    public BabyVO saveBaby(Baby baby) {
        User user=UserManager.getUser();
        if(user!=null){
            baby.setUser(user);
            Baby b=this.babyService.saveOne(baby);
            return BabyVO.generateBy(b);
        }
        else{
            BabyVO vo=new BabyVO();
            vo.setBirthday(baby.getBirthday());
            vo.setGender(baby.getGender());
            vo.setHobby(baby.getHobby());
            vo.setName(baby.getName());
            vo.setId(-1L);
            return vo;
        }
    }
}
