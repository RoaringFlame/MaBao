package com.mabao.service.impl;

import com.mabao.controller.vo.JsonResultVO;
import com.mabao.pojo.Goods;
import com.mabao.service.ShoppingService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 购物车业务
 * Created by jackie on 2016/07/06.
 */
@Service
public class ShoppingServiceImpl implements ShoppingService {
    /**
     * 购物车添加商品
     * @param userId        用户ID
     * @param goodsId       商品ID
     * @return              商品list
     */
    @Override
    public List<Goods> addCartGoods(int userId, int goodsId) {
        return null;
    }
    /**
     * 删除购物车内商品
     * @param goodsId           商品ID
     * @return                  结果VO
     */
    @Override
    public JsonResultVO deleteCartGoods(Integer goodsId) {
        return null;
    }
    /**
     * 用户购物车中商品列表
     * @return                  商品list
     */
    @Override
    public Page<Goods> findAllGoodsByUser() {
        return null;
    }
}
