package com.mabao.repository;

import com.mabao.enums.OrderStatus;
import com.mabao.pojo.OrderDetail;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailRepository extends BaseRepository<OrderDetail> {
    /**
     * 查购买者所有订单
     */
    List<OrderDetail> findByOrderBuyerId(Long id);

    /**
     * 查询某物品所有状态
     */
    List<OrderDetail> findByGoodsId(Long GoodsId);

    /**
     * 查买家某状态订单
     * @param id                        买家ID
     * @param orderStatus               订单状态
     */
    List<OrderDetail> findByOrderBuyerIdAndOrderState(Long id, OrderStatus orderStatus);

//    /**
//     * 查购卖者所有订单
//     */
//    List<OrderDetail> findByOrderSellerId(Long id);
//
//    /**
//     * 查卖家某状态订单
//     * @param id                        卖家ID
//     * @param orderStatus               订单状态
//     */
//    List<OrderDetail> findByOrderSellerIdAndOrderState(Long id, OrderStatus orderStatus);
}
