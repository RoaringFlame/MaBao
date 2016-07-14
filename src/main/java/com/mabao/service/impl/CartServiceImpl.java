package com.mabao.service.impl;

import com.mabao.controller.vo.JsonResultVO;
import com.mabao.pojo.Cart;
import com.mabao.pojo.Goods;
import com.mabao.pojo.User;
import com.mabao.repository.CartRepository;
import com.mabao.service.CartService;
import com.mabao.service.GoodsService;
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
    public List<Cart> findAllGoodsByUser(Long userId) {
        return this.cartRepository.findByUserId(userId);
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

    /**
     * 商品ID查购物车信息
     * @param goodsId           商品ID
     * @return                  购物车
     */
    @Override
    public Cart findByGoodsId(Long goodsId) {
        return this.cartRepository.findByGoodsId(goodsId);
    }
    /**
     * 更新购物车信息
     * @param cart              购物车
     * @return                  更新的购物车
     */
    @Override
    public Cart updateCart(Cart cart) {
        return this.cartRepository.saveAndFlush(cart);
    }

    /**
     * 购物车添加商品
     * @param goodsId       商品ID
     * @param user          用户
     * @return              结果String
     */
    @Override
    public String addCartGoods(Long goodsId, User user) {
        //判断是否已经添加
        Cart cart = this.findByGoodsId(goodsId);
        if (cart != null){
            cart.setQuantity(cart.getQuantity()+1);
            this.updateCart(cart);
            return "添加成功";
        }else {
            //新添加
            Cart newCart = new Cart();
            newCart.setGoods(this.goodService.get(goodsId));
            newCart.setCreateTime(new Date());
            newCart.setQuantity(1);
            newCart.setUser(user);
            this.cartRepository.save(newCart);
            return "添加成功";
        }
    }
}
