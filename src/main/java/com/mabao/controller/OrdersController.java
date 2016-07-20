package com.mabao.controller;

import com.mabao.controller.vo.OrderVO;
import com.mabao.enums.OrderStatus;
import com.mabao.pojo.Order;
import com.mabao.pojo.OrderDetail;
import com.mabao.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping("/order")
public class OrdersController {
    @Autowired
    private OrderService orderService;

    /**
     * 订单确认页付款
     * @param cartIds                   购物车IDs
     * @param addressId                 收货地址
     * @param message                   留言
     * @param model                     订单
     * @return                          支付
     */
    @RequestMapping(value = "/payConfirm",method = GET)
    public String orderConfirm(@RequestParam String cartIds,
                               @RequestParam Long addressId,
                               @RequestParam(required = false) String message,
                               Model model){
        //生成订单
        Order order = this.orderService.addOrder(cartIds,addressId,message);
        //支付
        return "personal";
    }

    /**
     * 用户的所有订单查询
     * @param userIdentity              用户身份；1查买家；2查卖家
     * @param model                     买家OrderVO
     * @return                          purchase_order页
     */
    @RequestMapping(value = "/loadUserOrder",method = GET)
    public String userAllOrder(@RequestParam Integer userIdentity,
                               @RequestParam(required = false) String orderStatus,
                               Model model){
        List<OrderDetail> orderList = this.orderService.findUserAllOrder(userIdentity,orderStatus);
        List<OrderVO> orderVOs = OrderVO.generateBy(orderList);
        Double totalSum = 0.0;
        Integer goodsNum = 0;
        Double freight = 0.0;
        for (OrderVO vo :orderVOs) {
            goodsNum += vo.getQuantity();
            totalSum += vo.getTotalSum();
            freight += vo.getFreight();
        }
        model.addAttribute("allOrder", orderVOs);
        model.addAttribute("goodsNum", goodsNum);       //总数量
        model.addAttribute("totalSum", totalSum);       //总计
        model.addAttribute("totalFreight", freight);    //总运费
        if (orderStatus.equals("ToBePaid")){
            return "unpaid_order";
        }else if (orderStatus .equals("ToBeSend")) {
            return "nopackaged_order";
        }else if (orderStatus .equals("ToBeReceipt")) {
            return "ckeck_order";
        }else if (orderStatus .equals("ToBeRelease")) {
            return "unpublished_order";
        }else if (orderStatus .equals("Released")) {
            return "published_order";
        }else if (orderStatus .equals("Sold")) {
            return "finish_order";
        }else if (orderStatus.equals("") && userIdentity == 1) {
            return "purchase_order";
        }else if (orderStatus.equals("") && userIdentity == 2) {
            return "consignment_order";
        }else {
            return null;
        }
    }

}
