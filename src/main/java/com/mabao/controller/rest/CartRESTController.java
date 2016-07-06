package com.mabao.controller.rest;

import com.mabao.pojo.Goods;
import com.mabao.service.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;


@RestController
@RequestMapping(value = "/goods")
public class CartRESTController {
    @Autowired
    private ShoppingService shoppingService;

    /**
     * 删除购物车内商品
     * @param userId            用户ID
     * @param ids               商品ID
     * @return                  商品集合
     */
    @RequestMapping(value = "/user/{userId}/shoppingCart/goodsDelete", method = GET)
    public List<Goods> deleteShoppingCartGoods(@PathVariable Integer userId,
                                              @RequestParam String ids) {
        //移除购物车内商品，查询该用户购物车剩余商品
        return this.shoppingService.deleteShoppingCartGoods(userId,ids);
    }
}
