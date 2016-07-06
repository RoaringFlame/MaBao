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
 * 寄售模块
 * @author jackie
 */
@Controller
@RequestMapping("/sell")
public class SellController {
    @Autowired
    private GoodsService goodsService;

    /**
     * 自助发布宝物
     * 添加商品
     * @param newGoods          商品属性，需包含用户ID
     * @param model
     * @return                  寄售成功页
     */
    @RequestMapping(value = "/release",method = GET)
    public String shoppingCarGoodsAdd(Goods newGoods,Model model){
        //添加商品
        Goods result =  this.goodsService.saveOne(newGoods);
        return "consignment-success";
    }

}

