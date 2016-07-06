package com.mabao.service.impl;

import com.mabao.pojo.Goods;
import com.mabao.service.ShoppingService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 购物车业务
 * Created by jackie on 2016/07/06.
 */
@Service
public class ShoppingServiceImpl implements ShoppingService {
    /**
     * 移除购物车内商品，查询该用户购物车剩余商品
     * @param userId            用户id
     * @param ids               商品ids
     * @return                  商品集合
     */
    public List<Goods> deleteShoppingCartGoods(Integer userId, String ids){
        return null;
    }
    /**
     * 购物车添加商品
     * @param userId        用户ID
     * @param goodsId       商品ID
     * @return              商品list
     */
    @Override
    public List<Goods> addCartGoods(int userId, int goodsId) {
        return null;
    }
    /**
     * 用户购物车中商品列表
     * @param userId            用户ID
     * @return                  商品list
     */
    @Override
    public List<Goods> findShoppingCartGoods(Integer userId) {
        return null;
    }
}
