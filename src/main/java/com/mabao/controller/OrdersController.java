package com.mabao.controller;

import com.mabao.pojo.Address;
import com.mabao.pojo.Goods;
import com.mabao.service.AddressService;
import com.mabao.service.GoodsService;
import com.mabao.service.OrdersService;
import org.apache.commons.collections.list.AbstractLinkedList;
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

@Controller
@RequestMapping("/order")
public class OrdersController {
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private AddressService addressService;

    /**
     * 购物车页面提交后跳转订单确认页面
     * @param userId            用户ID
     * @param goodsIds          商品ID字符串，以,（逗号）分割
     * @param model             map(默认地址，选中支付的商品list)
     * @return                  支付页
     */
    @RequestMapping(value = "/orderConfirm",method = GET)
    public String orderConfirm(@RequestParam int userId,
                               @RequestParam String goodsIds,
                               Model model){
        Map<String,Object> map=new HashMap<>();
        //查默认地址
        Address address=this.addressService.getDefaultAddress(userId);
        map.put("address",address);
        //根据ID查商品列表
        List<Integer> goodsIdList = new ArrayList<>();
        for (String id :goodsIds.trim().split(",")){
            goodsIdList.add(Integer.valueOf(id));
        }
        List<Goods> Goods = this.goodsService.findGoodsByIdIn(goodsIdList);
        map.put("checkedGoods",Goods);
        model.addAllAttributes(map);
        return "pay";
    }

}
