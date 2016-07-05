package com.mabao.controller;

import com.mabao.pojo.Goods;
import com.mabao.service.GoodsService;
import com.mabao.service.GoodsTypeService;
import com.mabao.util.Selector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    private GoodsTypeService goodsTypeService;
    @Autowired
    private GoodsService goodsService;

    public HomeController() {
    }

    @RequestMapping(method = GET)
    public String home(@RequestParam(value = "page", defaultValue = "0") int page,
                       @RequestParam(value = "size", defaultValue = "4") int pageSize,
                       Model model) {
        Map<String, Object> map = new HashMap<>();
        //商品类别
        List<Selector> goodsTypeList = this.goodsTypeService.getAllGoodsTypeForSelector();
        map.put("goodsTypeSelector", goodsTypeList);
        //轮播图片列表
        List<Goods> circleList = this.goodsService.getGoodsListByCircle();
        map.put("circleList", circleList);
        //新品商品列表
        List<Goods> newGoods = this.goodsService.getNewGoods(page, pageSize);
        map.put("newGoods", newGoods);
        model.addAllAttributes(map);
        return "index";
    }

    @RequestMapping(value = "/goodsTitle", method = POST)
    public String goodsTitle(HttpServletRequest request, Model model) {
        Map<String, Object> map = new HashMap<>();
        //获取搜索框的内容
        String title = request.getParameter("search");
        //根据搜索框查询商品列表
        List<Goods> goodsList = this.goodsService.getGoodsListLikeTitle(title,0,4);
        map.put("goodsList", goodsList);
        model.addAllAttributes(map);
        return "index_list";
    }

    @RequestMapping(value = "/goodsTime", method = GET)
    public String goodsTime(int page, int size, Model model) {
        Map<String, Object> map = new HashMap<String, Object>();
        //新品商品列表
        List<Goods> goodsList = this.goodsService.getGoodsListByTime(page, size);
        map.put("goodsList", goodsList);
        model.addAllAttributes(map);
        return "index_list";
    }

    @RequestMapping(value = "/goodsType", method = GET)
    public String goodsType(String typeName, int page, int size, Model model) {
        Map<String, Object> map = new HashMap<String, Object>();
        //商品列表
        List<Goods> goodsList = this.goodsService.getGoodsListByTypeName(typeName, page, size);
        map.put("goodsList", goodsList);
        model.addAllAttributes(map);
        return "index_list";
    }
    @RequestMapping(value = "/goodsTable",method = POST)
    public String goodsTable(HttpServletRequest request, Model model){
        Map<String,Object> map= new HashMap<>();
        //获取表单的内容
        Map babyInfoMap=request.getParameterMap();
        //跟根据表单查询商品列表
        List<Goods> goodsList=this.goodsService.getGoodsListByTable(babyInfoMap,0,4);
        map.put("goodsList",goodsList);
        model.addAllAttributes(map);
        return "index_list";
    }


}
