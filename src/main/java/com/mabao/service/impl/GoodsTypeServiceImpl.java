package com.mabao.service.impl;

import com.mabao.controller.vo.GoodsVO;
import com.mabao.pojo.GoodsType;
import com.mabao.repository.GoodsTypeRepository;
import com.mabao.util.PageVO;
import com.mabao.pojo.Goods;
import com.mabao.repository.GoodsRepository;
import com.mabao.service.GoodsTypeService;
import com.mabao.util.Selector;
import com.mabao.util.Goods2GoodVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

    /**
     * 查询商品列表
     * @return
     */
    public PageVO<GoodsVO> getPageVO(int page , int pageSize) {
        PageVO<GoodsVO> pageVO = new PageVO<GoodsVO>();
        Goods2GoodVO g2g = new Goods2GoodVO();
        Page<Goods> pageList = goodsRepository.findByState(true,new PageRequest(page,pageSize, new Sort(Sort.Direction.DESC,"upTime")));
        List<Goods> list = pageList.getContent();
        pageVO.setPageSize(pageList.getNumberOfElements());
        pageVO.setTotalRow(pageList.getTotalElements());
        pageVO.setCurrentPage(pageList.getNumber());
        for(Goods g: list) {
            pageVO.getItems().add(g2g.goodsToGoodsVO(g));
        }
        return pageVO;
    }
}
