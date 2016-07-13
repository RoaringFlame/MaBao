package com.mabao.controller;

import com.mabao.pojo.Goods;
import com.mabao.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;


@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    /**
     * 商品详情
     * @param goodsId           商品ID
     * @param model             商品类
     * @return                  商品详情页
     */
    @RequestMapping(value = "/goodsDetail", method = GET)
    public String goodsDetail(Long goodsId, Model model) {
        Goods goods = this.goodsService.get(goodsId);
        model.addAttribute("goodsDetail", goods);
        return "goods_detail";
    }

}

