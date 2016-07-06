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
import static org.springframework.web.bind.annotation.RequestMethod.POST;

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
     * @param newGoods          商品对象，需包含用户ID
     * @param model             success or false
     * @return                  寄售成功页
     */
    @RequestMapping(value = "/release",method = POST)
    public String shoppingCarGoodsAdd(Goods newGoods,Model model){
//      Goods result =  this.goodsService.saveOne(newGoods);
        String  result = this.goodsService.saveOne(newGoods) != null ? "success" : "false";
        model.addAttribute("result",result);
        return "consignment-success";
    }

}

