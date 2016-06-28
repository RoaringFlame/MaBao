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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    private GoodsTypeService goodsTypeService;
    @Autowired
    private GoodsService goodsService;

    public HomeController() {
    }

  //private GoodsRepository goodsRepository;

  /*@Autowired
  public HomeController(GoodsRepository goodsRepository) {
    this.goodsRepository = goodsRepository;
  }*/

  @RequestMapping(method = GET)
  public String home(@RequestParam(value="page", defaultValue="0") int page,
                     @RequestParam(value="size", defaultValue="4") int pageSize,
                     Model model) {
      Map<String,Object> map=new HashMap<>();
      //商品类别
      List<Selector> goodsTypeList=this.goodsTypeService.getAllGoodsTypeForSelector();
      map.put("goodsTypeSelector",goodsTypeList);
      //轮播图片列表
      //新品商品列表
      List<Goods> newGoods=this.goodsService.getNewGoods(page,pageSize);
      map.put("newGoods",newGoods);
      model.addAllAttributes(map);
    return "index";
  }

  /*@RequestMapping(value="/findById/{id}", method= RequestMethod.GET)
  public String getGoodsDetail(
          @PathVariable("id") long id,
          Model model) {
    model.addAttribute(goodsRepository.findOne(id));
    return "detail";
  }*/
}
