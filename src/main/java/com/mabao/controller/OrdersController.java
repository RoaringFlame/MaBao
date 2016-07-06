package com.mabao.controller;

import com.mabao.pojo.Address;
import com.mabao.pojo.Goods;
import com.mabao.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * 订单模块
 * Created by maxu on 2016/6/30.
 */
@Controller
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;
    /**
     * 购物车页面提交后跳转订单确认页面
     * @param userId
     * @param ids
     * @param model
     * @return
     */
    @RequestMapping(value = "/orderConfirm",method = GET)
    public String getOrderConfirmService(int userId,int[] ids,Model model){
        Map<String,Object> map=new HashMap<>();
        Address address=this.ordersService.getDefaultAddress(userId);
        map.put("address",address);
        List<Goods> selecetedGoods=this.ordersService.getSelectedGoods(ids);
        map.put("selectedGoods",selecetedGoods);
        model.addAllAttributes(map);
        return "pay";
    }

}
