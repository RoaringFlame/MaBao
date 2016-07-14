package com.mabao.service.impl;

import com.mabao.pojo.Brand;
import com.mabao.repository.BrandRepository;
import com.mabao.service.BrandService;
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
public class BrandServiceImpl implements BrandService{
    @Autowired
    private BrandRepository brandRepository;

    /**
     * 获取启用的品牌
     * @param status            是否启用
     * @return                  品牌list
     */
    @Override
    public List<Brand> findByStatus(Boolean status) {
        return this.brandRepository.findByStatus(status);
    }
    /**
     * 获取品牌下拉菜单
     * @return                  Selector
     */
    @Override
    public List<Selector> findBrandForSelector() {
        List<Selector> brandSelector = new ArrayList<>();
        List<Brand> brandList = this.brandRepository.findByStatus(Boolean.TRUE);
        for (Brand b : brandList){
            Selector selector = new Selector(b.getId().toString(),b.getBrandName());
            brandSelector.add(selector);
        }
        return brandSelector;
    }
}
