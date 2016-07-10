package com.mabao.controller.rest;

import com.mabao.controller.vo.GoodsVO;
import com.mabao.controller.vo.JsonResultVO;
import com.mabao.pojo.Goods;
import com.mabao.service.CartService;
import com.mabao.util.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;


@RestController
@RequestMapping(value = "/cart")
public class CartRESTController {
    @Autowired
    private CartService cartService;

    public static final Long userId = 1L;
    /**
     * 用户购物车中商品列表
     * @return                  商品list
     */
    @RequestMapping( method = RequestMethod.GET)
    public List<GoodsVO> findUserCartGoods() {
        //查询该用户购物车剩余商品
        List<Goods> goodsList = this.cartService.findAllGoodsByUser(userId);
        return GoodsVO.generateBy(goodsList);
    }

    /**
     * 删除购物车内商品
     * @param cartId            购物车ID
     * @return                  结果VO
     */
    @RequestMapping(value = "/cart/{cartId}", method = RequestMethod.DELETE)
    public JsonResultVO deleteShoppingCartGoods(@PathVariable Long cartId) {
        //移除购物车内商品，查询该用户购物车剩余商品
        return this.cartService.deleteCartGoods(cartId);
    }
}
