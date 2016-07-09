package com.mabao.service.impl;

import com.mabao.pojo.GoodsType;
import com.mabao.repository.GoodsTypeRepository;
import com.mabao.repository.GoodsRepository;
import com.mabao.service.GoodsTypeService;
import com.mabao.util.Selector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuming on 2016/6/28.
 * 商品类别业务接口
 */
@Service
public class GoodsTypeServiceImpl implements GoodsTypeService {

    @Autowired
    private GoodsRepository goodsRepository;
    @Autowired
    private GoodsTypeRepository goodsTypeRepository;

    /**
     * 查询下拉框所用的商品类型列表
     * @return Selector集合
     */
    public List<Selector> getAllGoodsTypeForSelector() {
        List<Selector> list = new ArrayList<>();
        List<GoodsType> goodsTypes= this.goodsTypeRepository.findAll();
        for (GoodsType g :goodsTypes){
            Selector s = new Selector(g.getId().toString(),g.getTypeName());
            list.add(s);
        }
        return list;
    }

}
