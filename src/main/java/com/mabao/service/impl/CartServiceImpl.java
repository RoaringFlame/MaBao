package com.mabao.service.impl;

import com.mabao.controller.vo.JsonResultVO;
import com.mabao.pojo.Cart;
import com.mabao.pojo.Goods;
import com.mabao.repository.CartRepository;
import com.mabao.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 购物车业务
 * Created by jackie on 2016/07/06.
 */
@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;

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
     * 删除购物车内商品
     * @param userId            用户ID
     * @param goodsId           商品ID
     * @return                  结果VO
     */
    @Override
    public JsonResultVO deleteCartGoods(Long userId,Integer goodsId) {
        return null;
    }
    /**
     * 用户购物车中商品列表
     * @return                  商品list
     */
    @Override
    public Page<Goods> findAllGoodsByUser(Long userId) {
        return null;
    }

    /**
     * get一条购物车信息
     * @param cartId            购物车ID
     * @return                  购物车对象
     */
    @Override
    public Cart get(Long cartId) {
        return this.cartRepository.findOne(cartId);
    }
}
