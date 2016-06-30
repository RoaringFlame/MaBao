package com.mabao.controller;

import com.mabao.pojo.Goods;
import com.mabao.service.GoodsService;
import com.mabao.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping(value = "/goodsTime",method = GET)
    public String goodsTime(int page, int size,Model model) {
        Map<String, Object> map = new HashMap<String, Object>();
        //商品列表
        List<Goods> goodsList = this.goodsService.getGoodsListByTime(page, size);
        map.put("goodsList", goodsList);
        model.addAllAttributes(map);
        return "index_list";
    }

        @RequestMapping(value ="/goodsTitle",method = GET)
        public String goodsTitle(String title,int page,int size,Model model){
            Map<String,Object> map=new HashMap<String, Object>();
            //商品列表
            List<Goods> goodsList=this.goodsService.getGoodsListLikeTitle(title,page,size);
            map.put("goodsList",goodsList);
            model.addAllAttributes(map);
            return "index_list";
        }

    @RequestMapping(value ="/goodsType",method = GET)
    public String goodsType(String typeName,int page, int size,Model model){
        Map<String,Object> map=new HashMap<String, Object>();
        //商品列表
        List<Goods> goodsList=this.goodsService.getGoodsListByTypeName(typeName,page,size);
        map.put("goodsList",goodsList);
        model.addAllAttributes(map);
        return "index_list";
    }
    }

