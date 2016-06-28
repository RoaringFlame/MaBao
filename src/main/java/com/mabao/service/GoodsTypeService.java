package com.mabao.service;

import com.mabao.util.Selector;

import java.util.List;

/**
 * Created by liuming on 2016/6/28.
 * 商品类别业务接口
 */
public interface GoodsTypeService {
    /**
     * 查询下拉框所用的商品类型列表
     * @return  Selector集合
     */
    public List<Selector> getAllGoodsTypeForSelector();
}
