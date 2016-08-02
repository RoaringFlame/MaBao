package com.mabao.service;


import com.mabao.controller.vo.JsonResultVO;
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


//    /**
//     * 用户的所有订单查询
//     * @param userIdentity              用户身份；1查买家；2查卖家
//     * @param orderStatus               订单状态
//     * @return                          订单明细
//     */
//    List<OrderDetail> findUserAllOrder(Integer userIdentity, String orderStatus);


    /**
     * 保存订单明细
     * @param orderDetail               明细对象
     * @return                          插入的订单明细
     */
    OrderDetail saveOrderDetail(OrderDetail orderDetail);

    /**
     * 保存订单
     * @param order                     订单对象
     * @return                          插入的订单
     */
    Order saveOrder(Order order);
    /**
     * 修改订单状态
     * @param orderDetailIds            订单明细ID，使用逗号分割
     * @param orderStatus               新订单状态
     */
    JsonResultVO changeOrderStatus(String orderDetailIds, OrderStatus orderStatus);

    /**
     * 确认收货
     * @param orderDetailIds            订单明细ID，使用逗号分割
     * @return                          JsonResultVO
     */
    JsonResultVO confirmReceipt(String orderDetailIds);

    /**
     * 返回某物品的快照详情（寄售卖家理论一件物品只有一件详情）
     * @param goodsId                   物品id
     * @return                          所有详情
     */
    List<OrderDetail> findOrderDetail(Long goodsId);
}
