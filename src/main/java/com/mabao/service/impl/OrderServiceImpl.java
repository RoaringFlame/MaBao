package com.mabao.service.impl;

import com.mabao.controller.vo.JsonResultVO;
import com.mabao.enums.OrderStatus;
import com.mabao.pojo.Goods;
import com.mabao.pojo.Order;
import com.mabao.pojo.OrderDetail;
import com.mabao.pojo.User;
import com.mabao.repository.GoodsRepository;
import com.mabao.repository.OrderDetailRepository;
import com.mabao.repository.OrderRepository;
import com.mabao.service.AddressService;
import com.mabao.service.CartService;
import com.mabao.service.OrderService;
import com.mabao.util.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private AddressService addressService;
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private GoodsRepository goodsRepository;
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
        order.setOperatorId(1L);                   //设置操作员id
        order.setQuantity(cartIdArray.length);     //初始化数量
        order.setAddress(this.addressService.get(addressId));
        order.setMessage(message);
        order.setCreateTime(new Date());
        order.setState(OrderStatus.ToBePaid);
        //运费计算后期调取接口，后期接入
        order.setFreight(10.00);                    //运费
        order.setTotalSum(order.getFreight());      //初始化总价
        this.orderRepository.save(order);
        for (String one : cartIdArray){
            Long cartId =Long.valueOf(one);
            Goods goods = this.cartService.get(cartId).getGoods();
            OrderDetail od = new OrderDetail();
            od.setGoods(goods);
            od.setOrder(order);
            od.setUnitCost(goods.getPrice());
            Integer quantity = this.cartService.get(cartId).getQuantity();
            //此处要对比库存数量，此处做简单处理(售罄后商品首页不可见消失)，后期整改
            if(goods.getStockNumber()<=quantity){
                quantity = goods.getStockNumber(); //剩余量赋值给买家
                //设置商品状态
                goods.setStockNumber(0);
                goods.setState(false);
                goods.setSellEnd(true);
            }else{
                //库存减少
                goods.setStockNumber(goods.getStockNumber()-quantity);
            }
            this.goodsRepository.saveAndFlush(goods);

            od.setQuantity(quantity);
            od.setSize(goods.getSize().getName());
            od.setNewDegree(goods.getNewDegree().getText());
            od.setTitle(goods.getTitle());
            od.setTypeName(goods.getType().getTypeName());
            od.setUpTime(goods.getUpTime());
            od.setBrand(goods.getBrand().getBrandName());
            //计算总价与数量
            order.setQuantity(order.getQuantity()+quantity-1);
            order.setTotalSum(order.getTotalSum()+goods.getPrice());
            this.orderDetailRepository.save(od);
        }
        return this.orderRepository.saveAndFlush(order);    //更新总价与总数量
    }

//    /**
//     * 用户的所有订单查询
//     * @param userIdentity              用户身份；1查买家；2查卖家
//     * @param orderStatus               订单状态
//     * @return                          订单明细
//     */
//    @Override
//    public List<OrderDetail> findUserAllOrder(Integer userIdentity, String orderStatus) {
//        User user = UserManager.getUser();
//        if (user != null){
//            if (userIdentity ==1){
//                if (orderStatus != null && !orderStatus.equals("")){
//                    return this.orderDetailRepository.findByOrderBuyerIdAndOrderState(user.getId(),OrderStatus.valueOf(orderStatus));
//                }else {
//                    return this.orderDetailRepository.findByOrderBuyerId(user.getId());
//                }
//            }else if (userIdentity == 2){
//                if (orderStatus != null && !orderStatus.equals("")){
//                    return this.orderDetailRepository.findByOrderSellerIdAndOrderState(user.getId(),OrderStatus.valueOf(orderStatus));
//                }else {
//                    return this.orderDetailRepository.findByOrderSellerId(user.getId());
//                }
//            }else {
//                return null;
//            }
//        }else {
//            throw new NullPointerException();
//        }
//    }

    /**
     * 保存订单明细
     * @param orderDetail               明细对象
     * @return                          插入的订单明细
     */
    @Override
    public OrderDetail saveOrderDetail(OrderDetail orderDetail) {
        return this.orderDetailRepository.save(orderDetail);
    }

    /**
     * 保存订单
     * @param order                     订单对象
     * @return                          插入的订单
     */
    @Override
    public Order saveOrder(Order order) {
        return this.orderRepository.save(order);
    }
    /**
     * 修改订单状态
     * @param orderDetailIds            订单明细ID，使用逗号分割
     * @param orderStatus               新订单状态
     */
    @Override
    public JsonResultVO changeOrderStatus(String orderDetailIds, OrderStatus orderStatus) {
        return null;
    }

    /**
     * 确认收货
     * @param orderDetailIds            订单明细ID，使用逗号分割
     * @return                          JsonResultVO
     */
    @Override
    public JsonResultVO confirmReceipt(String orderDetailIds) {
        try {
            for(String s : orderDetailIds.trim().split(",")){
                Order o = this.orderDetailRepository.findOne(Long.valueOf(s)).getOrder();
                if (o.getState().equals(OrderStatus.ToBeReceipt)){
                    o.setState(OrderStatus.Completed);
                    this.orderRepository.saveAndFlush(o);
                }else {
                    return new JsonResultVO(JsonResultVO.FAILURE,"订单不是待收货状态！");
                }
            }
            return new JsonResultVO(JsonResultVO.SUCCESS,"确认收货！");
        }catch (Exception e){
            e.getStackTrace();
            return  new JsonResultVO(JsonResultVO.FAILURE,"系统错误！");
        }
    }

    /**
     * 返回某物品的快照详情
     * @param goodsId                   物品id
     * @return                          物品所有详情
     */
    @Override
    public List<OrderDetail> findOrderDetail(Long goodsId) {
        return this.orderDetailRepository.findByGoodsId(goodsId);
    }
}
