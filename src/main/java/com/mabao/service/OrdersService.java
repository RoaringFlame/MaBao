package com.mabao.service;

import com.mabao.pojo.Address;
import com.mabao.pojo.Goods;

import java.util.List;

/*
 * Created by maxu on 2016/6/30.
 */
public interface OrdersService {
    /**
     * 订单商品列表
     * @param ids
     * @return
     */
    public List<Goods> getSelectedGoods(int[] ids);
    /**
     *默认收货地址
     * @param userId
     * @return
     */
    public Address getDefaultAddress(int userId);
//    /**
//     * 显示总价
//     * @return
//     */
//    public double showMoneyTotal();

}
