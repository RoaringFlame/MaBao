package com.mabao.controller;

import com.mabao.controller.vo.GoodsVO;
import com.mabao.pojo.Goods;
import com.mabao.service.AddressService;
import com.mabao.service.CartService;
import com.mabao.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * 购物车模块
 * @author jackie
 */
@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;
    @Autowired
    private GoodsService goodsService;

    /**
     * 购物车添加商品
     * @param userId        用户ID
     * @param goodsId       商品ID
     * @param model         商品list
     * @return              购物车页
     */
    @RequestMapping(value = "/cartAddGoods",method = GET)
    public String shoppingCarGoodsAdd(int userId, int goodsId,Model model){
        List<Goods> goodsList=this.cartService.addCartGoods(userId,goodsId);
        model.addAttribute("cartGoodsList",goodsList);
        return "shopping";
    }

    /**
     * 购物车页面提交后跳转订单确认页面
     * @param cartAndNum        <购物车ID-数量,购物车ID-数量...>格式 String
     * @param model             map(默认地址，选中支付的商品list)
     * @return                  支付页
     */
    @RequestMapping(value = "/orderConfirm",method = GET)
    public String orderConfirm(@RequestParam String cartAndNum,
                               Model model){
        Map<String,Object> map = new HashMap<>();
        String[] cartAndNumArray = cartAndNum.trim().split(",");
        List<Long> goodsIdList = new ArrayList<>();
        for (String one : cartAndNumArray){
            Long cartId =Long.valueOf(one.trim().split("-")[0]);
            Long goodsId = this.cartService.get(cartId).getGoods().getId();
            goodsIdList.add(goodsId);
        }
        //根据ID查商品列表
        List<GoodsVO> goodsList = GoodsVO.generateBy(this.goodsService.findGoodsByIdIn(goodsIdList));
        map.put("checkedGoods",goodsList);
        map.put("cartAndNum",cartAndNum);
        map.put("freight",10);              //运费
        model.addAllAttributes(map);
        return "pay";
    }

}

