package com.mabao.controller.rest;

import com.mabao.controller.vo.JsonResultVO;
import com.mabao.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单模块
 * @author jackie
 */
@RestController
public class OrderRESTController {
    @Autowired
    private OrderService orderService;

    /**
     * 修改订单状态
     * @param orderDetailIds            订单明细ID，使用逗号分割
     * @return                          JsonResultVO
     */
   /* @RequestMapping(value = "/changeStatus",method = RequestMethod.GET)
    public JsonResultVO changeOrderStatus(@RequestParam String orderDetailIds,
                                           @RequestParam OrderStatus orderStatus){
        return this.orderService.changeOrderStatus(orderDetailIds,orderStatus);
    }*/

    /**
     * 确认收货
     * @param orderDetailIds            订单明细ID，使用逗号分割
     * @return                          JsonResultVO
     */
    @RequestMapping(value = "/order/confirmReceipt",method = RequestMethod.GET)
    public JsonResultVO confirmReceipt(@RequestParam String orderDetailIds){
        return this.orderService.confirmReceipt(orderDetailIds);
    }

}

