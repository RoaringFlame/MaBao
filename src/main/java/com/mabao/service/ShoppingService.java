package com.mabao.service;

import com.mabao.pojo.Goods;

import java.util.List;

/**
 * 购物车业务接口
 * Created by jackie on 2016/07/06.
 */
public interface ShoppingService {
    /**
     * 移除购物车内商品，查询该用户购物车剩余商品
     * @param userId            用户id
     * @param goodsIds               商品ids
     * @return                  商品集合
     */
    List<Goods> deleteShoppingCartGoods(Integer userId, String goodsIds);
    /**
     * 购物车添加商品
     * @param userId        用户ID
     * @param goodsId       商品ID
     * @return              商品list
     */
    List<Goods> addCartGoods(int userId, int goodsId);

    /**
     * 用户购物车中商品列表
     * @param userId            用户ID
     * @return                  商品list
     */
    List<Goods> findShoppingCartGoods(Integer userId);
}
