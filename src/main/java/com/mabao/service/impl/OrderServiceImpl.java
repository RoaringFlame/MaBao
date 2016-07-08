package com.mabao.service.impl;

import com.mabao.pojo.Order;
import com.mabao.pojo.OrderDetail;
import com.mabao.repository.OrderDetailRepository;
import com.mabao.repository.OrderRepository;
import com.mabao.service.AddressService;
import com.mabao.service.GoodsService;
import com.mabao.service.OrderService;
import com.mabao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private UserService userService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private OrderRepository orderRepository;

    /**
     * 生成订单
     * @param buyerId                   买家ID
     * @param sellerId                  买家ID
     * @param goodsAndNum               map<商品ID,数量>
     * @param addressId                 地址ID
     * @param message                   买家留言
     * @return                          订单对象
     */
    @Override
    public Order addOrder(Long buyerId,Long sellerId, HashMap<Long, Integer> goodsAndNum, Long addressId, String message) {
        Order order = new Order();
        order.setBuyerId(this.userService.get(buyerId));
        order.setSellerId(this.userService.get(sellerId));
        order.setAddress(this.addressService.get(addressId));
        order.setMessage(message);
        order.setCreateTime(new Date());

        for (Long id : goodsAndNum.keySet()){
            OrderDetail od = new OrderDetail();
            od.setGoods(this.goodsService.get(id));
            od.setQuantity(goodsAndNum.get(id));
            od.setOrder(order);
            od.setUnitCost(this.goodsService.get(id).getPrice());
            this.orderDetailRepository.save(od);
        }
        return this.orderRepository.save(order);
    }
}
