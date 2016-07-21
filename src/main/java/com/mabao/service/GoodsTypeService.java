package com.mabao.service;

import com.mabao.pojo.GoodsType;
import com.mabao.util.Selector;

import java.util.List;

public interface GoodsTypeService {
    /**
     * 查询下拉框所用的商品类型列表
     * @return  Selector集合
     */
    List<Selector> getAllGoodsTypeForSelector();

    /**
     * 获取商品类型
     * @param typeId            id
     * @return                  商品类型
     */
    GoodsType get(Long typeId);
}
