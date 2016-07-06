package com.mabao.controller;

import com.mabao.pojo.Goods;
import com.mabao.service.GoodsService;
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
@RequestMapping("/shoppingCar")
public class ShoppingCarController {
    @Autowired
    private GoodsService goodsService;

    /**
     * 添加商品
     * @param id            商品ID
     * @param model
     * @return              购物车页
     */
    @RequestMapping(value = "/goodsAdd",method = GET)
    public String shoppingCarGoodsAdd(int id,Model model){
        Map<String,Object> map=new HashMap<>();
        List<Goods> goodsList=this.goodsService.addshoppingCarGoods(id);
        return "shoppingCar";
    }
    /**
     * 购物车展示页面
     * @param userId            用户ID
     * @param model
     * @return                  购物车页
     */
    @RequestMapping(value = "/shoppingCar", method = GET)
    public String getShoppingCar(Integer userId, Model model) {
        Map<String, Object> map = new HashMap<>();
        //购物车商品列表
       /* List<Goods> selectedGoodsList = this.goodsService.getSelectedGoods(userId);
        map.put("selectedGoodsList", selectedGoodsList);*/
        model.addAllAttributes(map);
        return "shoppingCar";
    }
}

