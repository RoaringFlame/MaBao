package com.mabao.service.impl;

import com.mabao.pojo.GoodsBrand;
import com.mabao.repository.GoodsBrandRepository;
import com.mabao.service.GoodsBrandService;
import com.mabao.util.Selector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 品牌
 * Created by jackie on 2016/07/09.
 */
@Service
public class GoodsBrandServiceImpl implements GoodsBrandService {
    @Autowired
    private GoodsBrandRepository goodsBrandRepository;

    /**
     * 获取启用的品牌
     * @param status            是否启用
     * @return                  品牌list
     */
    @Override
    public List<GoodsBrand> findByStatus(Boolean status) {
        return this.goodsBrandRepository.findByStatus(status);
    }
    /**
     * 获取品牌下拉菜单
     * @return                  Selector
     */
    @Override
    public List<Selector> findBrandForSelector() {
        List<Selector> brandSelector = new ArrayList<>();
        List<GoodsBrand> brandList = this.goodsBrandRepository.findByStatus(Boolean.TRUE);
        for (GoodsBrand b : brandList){
            Selector selector = new Selector(b.getId().toString(),b.getBrandName());
            brandSelector.add(selector);
        }
        return brandSelector;
    }
}
