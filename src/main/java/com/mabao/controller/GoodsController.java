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


@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsTypeService goodsTypeService;
    @Autowired
    private GoodsService goodsService;

<<<<<<< Updated upstream
    @RequestMapping(value = "/goodsDetail", method = GET)
    public String goodsDetail(int id, Model model) {
        Map<String, Object> map = new HashMap<String, Object>();
        //商品详情
=======


    @RequestMapping(value = "/goodsDetail", method = GET)
    public String goodsDetail(int id, Model model) {
        Map<String, Object> map = new HashMap<String, Object>();
        //商品列表
>>>>>>> Stashed changes
        Goods goods = this.goodsService.getGoodsListById(id);
        map.put("goods", goods);
        model.addAllAttributes(map);
        return "detail";
    }
<<<<<<< Updated upstream
    @RequestMapping(value = "shoppingCarGoodsAdd",method = GET)
    public String shoppingCarGoodsAdd(int id,Model model){
        Map<String,Object> map=new HashMap<>();
        List<Goods> goodsList=this.goodsService.addshoppingCarGoods(id);
        return "shopping";
    }
    /**
     * 购物车页面
     * @param ids
     * @param model
     * @return
     */
    @RequestMapping(value = "/shoppingCar", method = GET)
    public String getShoppingCar(int[] ids, Model model) {
        Map<String, Object> map = new HashMap<>();
        //购物车商品列表
        List<Goods> selectedGoodsList = this.goodsService.getSelectedGoods(ids);
        map.put("selectedGoodsList", selectedGoodsList);
=======
    @RequestMapping(value = "/goodsList",method = GET)
    public String goodsList(HttpServletRequest request, int searchTypeId, int page, int size, Model model){
        String keyText=request.getParameter("search");
        Map typeMap = request.getParameterMap();
        Map<String,Object> map=new HashMap<>();
        //商品列表
        List<Goods> goodsList=this.goodsService.getGoodsList(keyText,typeMap,searchTypeId,page,size);
        map.put("goodsList",goodsList);
>>>>>>> Stashed changes
        model.addAllAttributes(map);
        return "shopping";
    }
<<<<<<< Updated upstream
    /**
     * 删除购物车商品
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/deleteShoppingCarGoods", method = GET)
    public String deleteShoppingCarGoods(int id,Model model) {
        Map<String, Object> map = new HashMap<>();
        //删除是商品后购物车列表
        List<Goods> goodsList =this.goodsService.deleteShoppingCarGoods(id);
        map.put("goodsList",goodsList);
=======
    @RequestMapping(value = "/shoppingCar",method = GET)
    public String getShoppingCar(int[] ids, Model model) {
        Map<String, Object> map = new HashMap<>();
        //购物车商品列表
        List<Goods> selectedGoodsList = this.goodsService.getSelectedGoods(ids);
        map.put("selectedGoodsList", selectedGoodsList);
>>>>>>> Stashed changes
        model.addAllAttributes(map);
        return "shopping";
    }
}

}

