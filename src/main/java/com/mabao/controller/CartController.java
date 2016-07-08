package com.mabao.controller;

import com.mabao.pojo.Address;
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
    @Autowired
    private AddressService addressService;

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
     * @param userId            用户ID
     * @param goodsAndNum       map<商品ID,数量>
     * @param totalSum          总价格
     * @param model             map(默认地址，选中支付的商品list)
     * @return                  支付页
     */
    @RequestMapping(value = "/orderConfirm",method = GET)
    public String orderConfirm(@RequestParam Long userId,
                               @RequestParam HashMap<Long,Integer> goodsAndNum,
                               @RequestParam(required = false) Long addressId,
                               @RequestParam Double totalSum,
                               Model model){
        Map<String,Object> map=new HashMap<>();
        //根据ID查商品列表
        List<Long> goodsIdList = new ArrayList<>(goodsAndNum.keySet());
        List<Goods> goodsList = this.goodsService.findGoodsByIdIn(goodsIdList);
        map.put("checkedGoods",goodsList);
        //查地址
        if (addressId == null) {
            Address address = this.addressService.getDefaultAddress(userId);//查默认地址
            map.put("address",address);
        }else {
            Address address = this.addressService.get(addressId);
            map.put("address",address);
        }
        //总价格
        map.put("totalSum",totalSum);

        //查运费

        model.addAllAttributes(map);
        return "pay";
    }

}

