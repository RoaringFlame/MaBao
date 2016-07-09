package com.mabao.service.impl;

import com.mabao.pojo.GoodsSize;
import com.mabao.repository.GoodsSizeRepository;
import com.mabao.service.GoodsSizeService;
import com.mabao.util.Selector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 宝物尺码
 * Created by jackie on 2016/07/09.
 */
@Service
public class GoodsSizeServiceImpl implements GoodsSizeService{
    @Autowired
    private GoodsSizeRepository goodsSizeRepository;
    /**
     * 宝物尺码下拉菜单
     */
    public List<Selector> findGoodsSizeForSelector(Long goodsTypeId){
        List<Selector> selectors = new ArrayList<>();
        List<GoodsSize> goodsSizeList = this.goodsSizeRepository.findByGoodsTypeId(goodsTypeId);
        for (GoodsSize gs : goodsSizeList){
            Selector selector = new Selector(gs.getId().toString(),gs.getName());
            selectors.add(selector);
        }
        return selectors;
    }

    @Override
    public List<Selector> findGoodsSizeForSelector() {
        return null;
    }
}
