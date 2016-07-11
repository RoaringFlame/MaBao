package com.mabao.service.impl;

import com.mabao.controller.vo.JsonResultVO;
import com.mabao.pojo.Cart;
import com.mabao.pojo.Goods;
import com.mabao.repository.CartRepository;
import com.mabao.service.CartService;
import com.mabao.service.GoodsService;
import com.mabao.util.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 购物车业务
 * Created by jackie on 2016/07/06.
 */
@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private GoodsService goodService;

    /**
     * 购物车添加商品
     * @param goodsId       商品ID
     * @return              商品list
     */
    @Override
    public Cart addCart(Long goodsId) {
        Cart cart = new Cart();
        cart.setGoods(this.goodService.get(goodsId));
        cart.setCreateTime(new Date());
        cart.setQuantity(1);
        cart.setUser(UserManager.getUser());
        return this.cartRepository.save(cart);
    }

    /**
     * 删除购物车内商品
     * @param cartId           购物车ID
     * @return                  结果VO
     */
    @Override
    public JsonResultVO deleteCartGoods(Long cartId) {
        try{
            this.cartRepository.delete(cartId);
        }catch (Exception e){
            return new JsonResultVO(JsonResultVO.FAILURE,e.getMessage());
        }
        return new JsonResultVO(JsonResultVO.SUCCESS,"成功删除！");
    }
    /**
     * 用户购物车中商品列表
     * @return                  商品list
     */
    @Override
    public List<Goods> findAllGoodsByUser(Long userId) {
        List<Cart> cartList = this.cartRepository.findByUserId(userId);
        List<Goods> goodsList = new ArrayList<>();
        for (Cart cart : cartList){
            goodsList.add(cart.getGoods());
        }
        return goodsList;
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
