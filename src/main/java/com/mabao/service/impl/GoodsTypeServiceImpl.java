package com.mabao.service.impl;

import com.mabao.service.GoodsTypeService;
import com.mabao.util.Selector;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuming on 2016/6/28.
 * 商品类别业务接口
 */
@Service
public class GoodsTypeServiceImpl implements GoodsTypeService {
    /**
     * 查询下拉框所用的商品类型列表
     * @return  Selector集合
     */
    public List<Selector> getAllGoodsTypeForSelector(){
        List<Selector> list=new ArrayList<>();
        list.add(new Selector("1","婴儿车1"));
        list.add(new Selector("2","婴儿车2"));
        list.add(new Selector("3","婴儿车3"));
        list.add(new Selector("4","婴儿车4"));
        return list;
    }
}
