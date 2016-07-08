package com.mabao.controller;

import com.mabao.controller.vo.GoodsVO;
import com.mabao.enums.Gender;
import com.mabao.pojo.Goods;
import com.mabao.service.GoodsService;
import com.mabao.service.GoodsTypeService;
import com.mabao.util.PageVO;
import com.mabao.util.Selector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    /**
     * jsp页面跳转控制器
     * @param jspPage  页面名
     * @return jspPage.jsp  页面名对应的jsp页面
     */
    @RequestMapping(value = "/jsp/{jspPage}", method = GET)
    public String defaultPage(@PathVariable("jspPage") String jspPage){
        return jspPage;
    }

    /**
     * 首页
     *（查询商品类别，轮播图片，新品列表）
     * @param page          页码
     * @param pageSize      页面大小
     * @param model         map集合
     * @return              index首页
     */
    @RequestMapping(method = GET)
    public String home(@RequestParam(required = false) Long userId,
                       @RequestParam(value = "page", defaultValue = "0") int page,
                       @RequestParam(value = "pageSize", defaultValue = "4") int pageSize,
                       Model model) {
        Map<String, Object> map = new HashMap<>();
        //商品类别
        List<Selector> goodsTypeList = this.goodsTypeService.getAllGoodsTypeForSelector();
        map.put("goodsTypeSelector", goodsTypeList);
        //轮播图片列表
        List<Goods> circleList = this.goodsService.getGoodsPictureCircle();
        map.put("circleList", circleList);
        //新品商品列表
        PageVO<GoodsVO> newGoods = this.goodsService.getNewGoods(page, pageSize);
        map.put("newGoods", newGoods);
        //猜你喜欢，宝宝性别
        List<Selector> gender = Gender.toList();
        map.put("babyGender", gender);
        model.addAllAttributes(map);
        return "index";
    }

/**
     * 首页商品模糊搜索
     * @param searchKey         关键字
     * @param model             商品list
     * @return                  商品列表页面
     *//*

    @RequestMapping(value = "/goods/search", method = GET)
    public String goodsSearch(@RequestParam(value = "searchKey") String searchKey,
                              @RequestParam(value = "page", defaultValue = "0") int page,
                              @RequestParam(value = "pageSize", defaultValue = "4") int pageSize,
                              Model model) {
        List<Goods> goodsList = this.goodsService.goodsSearch(searchKey,page,pageSize);
        model.addAttribute("goodsList", goodsList);
        return "index_list";
    }

    */
/**
     * 商品类型查询商品
     * @param goodsTypeId          商品类型ID
     * @param page              页码
     * @param pageSize          一页数量
     * @param model             商品list
     * @return                  index页
     *//*

    @RequestMapping(value = "/goods/goodsType", method = GET)
    public String goodsType(@RequestParam(value = "goodsTypeId") Long goodsTypeId,
                            @RequestParam(value = "page", defaultValue = "0") int page,
                            @RequestParam(value = "pageSize", defaultValue = "4") int pageSize,
                            Model model) {
        Page<Goods> goodsList = this.goodsService.getGoodsListByTypeName(goodsTypeId, page, pageSize);
        model.addAttribute("goodsList", goodsList);
        return "index";
    }
*/

}
