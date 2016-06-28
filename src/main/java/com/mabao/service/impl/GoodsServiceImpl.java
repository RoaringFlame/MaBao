package com.mabao.service.impl;

import com.mabao.pojo.Goods;
import com.mabao.repository.service.GoodsRepository;
import com.mabao.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by liuming on 2016/6/28.
 * 商品业务接口
 */
@Service
public class GoodsServiceImpl implements GoodsService{
    @Autowired
    private GoodsRepository goodsRepository;
    /**
     * 新品
     * @param page
     * @param pageSize
     * @return
     */
    public List<Goods> getNewGoods(int page, int pageSize){
        return goodsRepository.findByState(true,new PageRequest(page,pageSize,
                new Sort(Sort.Direction.DESC,"upTime"))).getContent();
    }
}
