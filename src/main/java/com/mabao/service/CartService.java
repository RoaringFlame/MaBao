package com.mabao.service;

import com.mabao.controller.vo.JsonResultVO;
import com.mabao.pojo.Cart;
import com.mabao.pojo.Goods;

import java.util.List;

/**
 * 购物车业务接口
 * Created by jackie on 2016/07/06.
 */
public interface CartService {

    /**
     * 购物车添加商品
     * @param goodsId       商品ID
     * @return              商品list
     */
    Cart addCart(Long goodsId);

    /**
     * 删除购物车内商品
     * @param cartId           购物车ID
     * @return                  结果VO
     */
    JsonResultVO deleteCartGoods(Long cartId);
    /**
     * 用户购物车中商品列表
     * @return                  商品list
     */
    List<Goods> findAllGoodsByUser(Long userId);

    /**
     * get一条购物车信息
     * @param cartId            购物车ID
     * @return                  购物车对象
     */
    Cart get(Long cartId);


}
