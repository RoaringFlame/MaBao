package com.mabao.service;

import com.mabao.pojo.Goods;

import java.util.List;

/**
 * 购物车
 * Created by jackie on 2016/07/06.
 */
public interface ShoppingService {
    /**
     * 移除购物车内商品，查询该用户购物车剩余商品
     * @param userId            用户id
     * @param ids               商品ids
     * @return                  商品集合
     */
    List<Goods> deleteShoppingCartGoods(Integer userId, String ids);
}
