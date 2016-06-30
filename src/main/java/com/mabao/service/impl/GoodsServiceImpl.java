package com.mabao.service.impl;

import com.mabao.pojo.Goods;
import com.mabao.repository.service.GoodsRepository;
import com.mabao.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Override
    public List<Goods> getGoodsListByTime(int page, int size) {
        return goodsRepository.findByState(true,new PageRequest(page,size, new Sort(Sort.Direction.DESC,"upTime"))).getContent();
    }

    @Override
    public List<Goods> getGoodsListLikeTitle(String title, int page, int size) {
        return goodsRepository.findLikeTitle(title,new PageRequest(page,size, new Sort(Sort.Direction.DESC,"upTime"))).getContent();
    }

    @Override
    public List<Goods> getGoodsListByTypeName(String typeName, int page, int size) {
        return goodsRepository.findByTypeName(typeName,new PageRequest(page,size, new Sort(Sort.Direction.DESC,"upTime"))).getContent();
    }

    @Override
    public List<Goods> getGoodsListByTable(BabyInfoForm formint ,int page, int size) {
        return goodsRepository.findLikeTitle(formint.getHobby(),new PageRequest(page,size, new Sort(Sort.Direction.DESC,"upTime"))).getContent();
    }

    @Override
    public Goods getGoodsListById(int id) {
        return goodsRepository.findOne((long)id);
    }

    @Override
    public List<Goods> getGoodsListByCircle() {
        List<Goods> list = new ArrayList();
        list.add(goodsRepository.findOne((long)1));
        list.add(goodsRepository.findOne((long)2));
        list.add(goodsRepository.findOne((long)3));
        list.add(goodsRepository.findOne((long)4));
        return list;
    }
}
