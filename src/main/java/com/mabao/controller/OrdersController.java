package com.mabao.controller;

import com.mabao.pojo.Address;
import com.mabao.pojo.Goods;
import com.mabao.pojo.Order;
import com.mabao.service.AddressService;
import com.mabao.service.GoodsService;
import com.mabao.service.OrderService;
import org.apache.commons.collections.list.AbstractLinkedList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/payConfirm",method = GET)
    public String orderConfirm(@RequestParam Long buyerId,
                               @RequestParam Long sellerId,
                               @ModelAttribute HashMap<Long,Integer> goodsAndNum,
                               @RequestParam Long addressId,
                               @RequestParam(required = false) String message,
                               Model model){
        //生成订单
        Order order = this.orderService.addOrder(buyerId,sellerId,goodsAndNum,addressId,message);
        //支付
        return "pay";
    }
}
