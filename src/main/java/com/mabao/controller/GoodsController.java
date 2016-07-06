package com.mabao.controller;

import com.mabao.pojo.Goods;
import com.mabao.service.GoodsService;
import com.mabao.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;


@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsTypeService goodsTypeService;
    @Autowired
    private GoodsService goodsService;

    @RequestMapping(value = "/goodsDetail", method = GET)
    public String goodsDetail(int id, Model model) {
        Map<String, Object> map = new HashMap<String, Object>();
        //商品详情
        Goods goods = this.goodsService.getGoodsListById(id);
        map.put("goods", goods);
        model.addAllAttributes(map);
        return "detail";
    }

}

