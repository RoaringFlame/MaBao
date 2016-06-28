package com.mabao.service;

import com.mabao.pojo.Goods;

import java.util.List;

/**
 * Created by liuming on 2016/6/28.
 * 商品业务接口
 */
public interface GoodsService {
    /**
     * 新品
     * @param page
     * @param pageSize
     * @return
     */
    public List<Goods> getNewGoods(int page, int pageSize);
}
