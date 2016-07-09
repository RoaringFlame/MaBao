package com.mabao.service.impl;

import com.mabao.pojo.Cart;
import com.mabao.pojo.Order;
import com.mabao.pojo.OrderDetail;
import com.mabao.repository.OrderDetailRepository;
import com.mabao.repository.OrderRepository;
import com.mabao.service.*;
import com.mabao.util.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CartService cartService;

    /**
     * 生成订单
     * @param cartAndNum                <购物车ID,数量>
     * @param addressId                 地址ID
     * @param message                   买家留言
     * @return                          订单对象
     */
    @Override
    public Order addOrder(String cartAndNum, Long addressId, String message) {
        String[] cartAndNumArray = cartAndNum.trim().split(",");

        Order order = new Order();
        order.setBuyer(UserManager.getUser());
        order.setAddress(this.addressService.get(addressId));
        order.setMessage(message);
        order.setCreateTime(new Date());

        for (String one : cartAndNumArray){
            Long cartId =Long.valueOf(one.trim().split("-")[0]);
            Long goodsId = this.cartService.get(cartId).getGoods().getId();
            Integer num =Integer.valueOf(one.trim().split("-")[1]);

            OrderDetail od = new OrderDetail();
            od.setGoods(this.goodsService.get(goodsId));
            od.setQuantity(num);
            od.setOrder(order);
            od.setUnitCost((double)(this.goodsService.get(goodsId).getPrice()/100));
            this.orderDetailRepository.save(od);
        }

        return this.orderRepository.save(order);
    }
}
