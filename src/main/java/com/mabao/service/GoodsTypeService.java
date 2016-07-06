package com.mabao.service;

import com.mabao.util.Selector;

import java.util.List;

public interface GoodsTypeService {
    /**
     * 查询下拉框所用的商品类型列表
     * @return  Selector集合
     */
    List<Selector> getAllGoodsTypeForSelector();
}
