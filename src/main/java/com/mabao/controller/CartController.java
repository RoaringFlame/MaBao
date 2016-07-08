package com.mabao.controller;

import com.mabao.pojo.Goods;
import com.mabao.service.GoodsService;
import com.mabao.service.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * 购物车模块
 * @author jackie
 */
@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private ShoppingService shoppingService;

    /**
     * 购物车添加商品
     * @param userId        用户ID
     * @param goodsId       商品ID
     * @param model         商品list
     * @return              购物车页
     */
    @RequestMapping(value = "/cartAddGoods",method = GET)
    public String shoppingCarGoodsAdd(int userId, int goodsId,Model model){
        List<Goods> goodsList=this.shoppingService.addCartGoods(userId,goodsId);
        model.addAttribute("cartGoodsList",goodsList);
        return "shopping";
    }
}

