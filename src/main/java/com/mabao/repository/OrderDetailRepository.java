package com.mabao.repository;

import com.mabao.pojo.OrderDetail;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailRepository extends BaseRepository<OrderDetail> {
    /**
     * 查购买者所有订单
     */
    List<OrderDetail> findByOrderBuyerId(Long id);
}
