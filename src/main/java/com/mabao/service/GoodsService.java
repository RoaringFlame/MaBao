package com.mabao.service;

import com.mabao.controller.vo.GoodsDetailVO;
import com.mabao.pojo.Baby;
import com.mabao.pojo.Goods;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

;

/**
 * Created by liuming on 2016/6/28.
 * 商品业务接口
 */
public interface GoodsService {
    /**
     * 新品
     */
    Page<Goods> getNewGoods(int page, int pageSize);

    /**
    * 首页商品模糊搜索
    */
    Page<Goods> goodsSearch(Long goodsTypeId,String title, int page, int pageSize);

    /**
     * 查询商品详细信息
     * @param goodsId           商品ID
    */
    Goods get(Long goodsId);

    /**
     * （首页猜你喜欢）
     * @param baby          宝宝
     * @param page              页码
     * @param pageSize          一页大小
     * @return                  商品集合，分页
     */
    Page<Goods> goodsListGuess(Baby baby,int page, int pageSize);

    /**
     * 保存商品
     * @param newGoods        商品对象，需包含用户ID
     * @return                保存的商品对象
     */
    Goods saveOne(Goods newGoods);

    /**
     * 根据商品ID查商品list
     * @param goodsIdList           商品ID集合
     * @return                      商品list
     */
    List<Goods> findGoodsByIdIn(List<Long> goodsIdList);


    /**
     * 自助发布宝物
     * 添加商品
     * @param goodsVO             商品对象
     * @param goodsPic
     * @param request
     * */
    Goods releaseGoods(GoodsDetailVO goodsVO, MultipartFile[] goodsPic, HttpServletRequest request) throws Exception;

    /**
     * 查询卖家所有商品
     * @param goodsState               商品状态：1已发布，2待发布，3已出售，4所有
     * @return                         商品集合，分页
     */
    Page<Goods> findSellerGoods(Integer goodsState,int page, int pageSize);
}
