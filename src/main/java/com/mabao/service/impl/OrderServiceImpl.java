package com.mabao.service.impl;

import com.mabao.enums.OrderStatus;
import com.mabao.pojo.Goods;
import com.mabao.pojo.Order;
import com.mabao.pojo.OrderDetail;
import com.mabao.pojo.User;
import com.mabao.repository.OrderDetailRepository;
import com.mabao.repository.OrderRepository;
import com.mabao.service.AddressService;
import com.mabao.service.CartService;
import com.mabao.service.GoodsService;
import com.mabao.service.OrderService;
import com.mabao.util.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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
     * 购买,生成订单
     * @param cartIds                   <商品ID,商品ID...>
     * @param addressId                 地址ID
     * @param message                   买家留言
     * @return                          订单对象
     */
    @Override
    public Order addOrder(String cartIds, Long addressId, String message) {
        String[] cartIdArray = cartIds.trim().split(",");
        Order order = new Order();
        order.setBuyer(UserManager.getUser());
        order.setSellerId(0L);
        order.setQuantity(cartIdArray.length);
        order.setAddress(this.addressService.get(addressId));
        order.setMessage(message);
        order.setCreateTime(new Date());
        order.setState(OrderStatus.ToBePaid);
        order.setFreight(10.00);                    //运费
        order.setTotalSum(0.00);                    //初始化总价
        for (String one : cartIdArray){
            Long cartId =Long.valueOf(one);
            Goods goods = this.cartService.get(cartId).getGoods();
            OrderDetail od = new OrderDetail();
            od.setGoods(goods);
            od.setOrder(order);
            od.setUnitCost(goods.getPrice());
            od.setSize(goods.getSize().getName());
            od.setNewDegree(goods.getNewDegree().getText());
            od.setTitle(goods.getTitle());
            od.setTypeName(goods.getType().getTypeName());
            od.setUpTime(goods.getUpTime());
            od.setBrand(goods.getBrand().getBrandName());
            //计算总价
            order.setTotalSum(order.getTotalSum()+goods.getPrice());

            this.orderDetailRepository.save(od);
        }

        return this.orderRepository.save(order);
    }

    /**
     * 查购买者所有订单
     */
    @Override
    public List<OrderDetail> findBuyerAllOrder() {
        User user = UserManager.getUser();
        if (user != null){
            return this.orderDetailRepository.findByOrderBuyerId(user.getId());
        }else {
            throw new NullPointerException();
        }
    }
}
