package com.mabao.service;

import com.mabao.pojo.Order;

import java.util.HashMap;

public interface OrderService {
    /**
     * 生成订单
     * @param buyerId                   买家ID
     * @param sellerId                  买家ID
     * @param goodsAndNum               map<商品ID,数量>
     * @param addressId                 地址ID
     * @param message                   买家留言
     * @return                          订单对象
     */
    Order addOrder(Long buyerId,Long sellerId, HashMap<Long, Integer> goodsAndNum, Long addressId, String message);
}
