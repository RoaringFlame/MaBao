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
     * 用户的所有订单查询
     * @param userIdentity              用户身份；1查买家；2查卖家
     * @param orderStatus               订单状态
     * @return                          订单明细
     */
    List<OrderDetail> findUserAllOrder(Integer userIdentity, String orderStatus);
}
