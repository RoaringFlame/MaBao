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
        model.addAttribute("allOrder", OrderVO.generateBy(orderList));
        return "purchase_order";
    }


}
