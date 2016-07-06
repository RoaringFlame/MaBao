package com.mabao.repository;

import com.mabao.pojo.Order;
import com.mabao.repository.custom.OrderRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long>,OrderRepositoryCustom {

}
