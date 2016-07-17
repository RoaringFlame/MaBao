package com.mabao.service;

import com.mabao.enums.OrderStatus;
import com.mabao.pojo.Order;
import com.mabao.pojo.OrderDetail;

import java.util.List;

public interface OrderService {
    /**
     * 生成订单
     * @param cartIds                   <商品ID,商品ID...>
     * @param addressId                 地址ID
     * @param message                   买家留言
     * @return                          订单对象
     */
    Order addOrder(String cartIds, Long addressId, String message);


    /**
     * 查买家所有订单
     * @return                          订单list
     * @param orderStatus
     */
    List<OrderDetail> findBuyerAllOrder(OrderStatus orderStatus);
}
