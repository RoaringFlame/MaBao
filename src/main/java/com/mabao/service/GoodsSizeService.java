package com.mabao.service;

import com.mabao.pojo.GoodsSize;
import com.mabao.util.Selector;

import java.util.List;

/**
 * 宝物尺码
 * Created by jackie on 2016/07/09.
 */
public interface GoodsSizeService {
    /**
     * 宝物尺码下拉菜单
     */
    List<Selector> findGoodsSizeForSelector();

    /**
     * ID获取商品
     * @param id            尺寸ID
     * @return              尺寸对象
     */
    GoodsSize get(Long id);
}
