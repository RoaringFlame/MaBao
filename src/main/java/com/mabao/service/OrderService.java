package com.mabao.service;

import com.mabao.pojo.Order;

import java.util.HashMap;

public interface OrderService {
    /**
     * 生成订单
     * @param cartAndNum                <商品ID,数量>,<商品ID,数量>
     * @param addressId                 地址ID
     * @param message                   买家留言
     * @return                          订单对象
     */
    Order addOrder(String cartAndNum, Long addressId, String message);
}
