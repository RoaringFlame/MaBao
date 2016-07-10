package com.mabao.repository;

import com.mabao.pojo.Cart;
import com.mabao.pojo.Goods;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends BaseRepository<Cart> {

    /**
     * 用户购物车中商品列表
     * @return                  商品list
     */
    List<Goods> findByUserId(Long userId);
}
