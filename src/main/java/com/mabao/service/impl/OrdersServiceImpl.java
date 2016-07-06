package com.mabao.service.impl;

import com.mabao.pojo.Address;
import com.mabao.pojo.Goods;
import com.mabao.service.OrdersService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrdersServiceImpl implements OrdersService {


    @Override
    public List<Goods> getSelectedGoods(int[] ids) {
        return null;
    }

    @Override
    public Address getDefaultAddress(int userId) {
        return null;
    }
}
