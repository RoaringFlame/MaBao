package com.mabao.controller.rest;

import com.mabao.controller.vo.JsonResultVO;
import com.mabao.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/cart")
public class CartRESTController {
    @Autowired
    private CartService cartService;

    /**
     * 删除购物车内商品
     * @param cartId            购物车ID
     * @return                  结果VO
     */
    @RequestMapping(value = "/deleteGoods/{cartId}", method = RequestMethod.DELETE)
    public JsonResultVO deleteShoppingCartGoods(@PathVariable Long cartId) {
        return this.cartService.deleteCartGoods(cartId);
    }
}
