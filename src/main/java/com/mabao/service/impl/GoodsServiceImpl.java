package com.mabao.service.impl;

import com.mabao.controller.vo.GoodsVO;
import com.mabao.util.PageVO;
import com.mabao.pojo.Goods;
import com.mabao.repository.GoodsRepository;
import com.mabao.service.GoodsService;
import com.mabao.util.Goods2GoodVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by liuming on 2016/6/28.
 * 商品业务接口
 */
@Service
public class GoodsServiceImpl implements GoodsService {


    @Autowired
    private GoodsRepository goodsRepository;

    /**
     * 新品
     *
     * @param page
     * @param pageSize
     * @return
     */
    public List<Goods> getNewGoods(int page, int pageSize) {
        return goodsRepository.findByState(true, new PageRequest(page, pageSize,
                new Sort(Sort.Direction.DESC, "upTime"))).getContent();
    }

    @Override
    public List<Goods> getGoodsListByTime(int page, int size) {
        return goodsRepository.findByState(true, new PageRequest(page, size,
                new Sort(Sort.Direction.DESC, "upTime"))).getContent();
    }

    @Override
    public List<Goods> getGoodsListLikeTitle(String title, int page, int size) {
        return goodsRepository.findLikeTitle(title, new PageRequest(page, size,
                new Sort(Sort.Direction.DESC, "upTime"))).getContent();
    }

    @Override
    public List<Goods> getGoodsListByTypeName(String typeName, int page, int size) {
        return goodsRepository.findByTypeName(typeName, new PageRequest(page, size,
                new Sort(Sort.Direction.DESC, "upTime"))).getContent();
    }

    @Override
    public Goods getGoodsListById(int id) {
        return goodsRepository.findOne((long) id);
    }

    @Override
    public List<Goods> getGoodsListByCircle() {
        List<Goods> list = new ArrayList();
        list.add(goodsRepository.findOne((long) 30));
        list.add(goodsRepository.findOne((long) 31));
        list.add(goodsRepository.findOne((long) 32));
        list.add(goodsRepository.findOne((long) 33));
        return list;
    }

    @Override

    /**
     * 查询商品列表
     * @return
     */

    public PageVO<GoodsVO> getPageVO(int page, int pageSize) {
        PageVO<GoodsVO> pageVO = new PageVO<>();
        Goods2GoodVO g2g = new Goods2GoodVO();
        Page<Goods> pageList = goodsRepository.findByState(true, new PageRequest(page, pageSize, new Sort(Sort.Direction.DESC, "upTime")));
        List<Goods> list = pageList.getContent();
        pageVO.setPageSize(pageList.getNumberOfElements());
        pageVO.setTotalCount(pageList.getTotalElements());
        pageVO.setCurrentPage(pageList.getNumber());
        List<GoodsVO> list1 = new ArrayList<>();
        for (Goods g : list) {
            list1.add(g2g.goodsToGoodsVO(g));
        }
        pageVO.setItems(list1);
        return pageVO;
    }

    @Override
    public List<Goods> getGoodsListByTable(Map babyInfoMap, int page, int size) {
        return null;
    }


    @Override
    public List<Goods> addshoppingCarGoods(int id) {
        return null;
    }

    @Override
    public List<Goods> getSelectedGoods(int[] ids) {
        return null;
    }

    @Override
    public List<Goods> deleteShoppingCarGoods(int id) {
        return null;
    }

    /*@Override
    public List<Goods> getGoodsListByTable(Map<String, String> babyInfoMap, int page, int size) {
        String babyHobby = babyInfoMap.get("babyHobby");
        System.out.println("--------babyHobby："+babyHobby);
        return this.getGoodsListLikeTitle(babyHobby, page, size);
    }*/
}
