package com.mabao.util;

import com.mabao.controller.vo.GoodsVO;
import com.mabao.pojo.Goods;

import java.text.DecimalFormat;


/**
 * Created by lies on 2016/6/30.
 */
public class Goods2GoodVO {

    /**
     * 一个转换器：
     * 在查询商品列表时就复杂的goods转换成简单的页面显示的goodsvo
     *
     * @param goods
     * @return
     */
    public GoodsVO goodsToGoodsVO(Goods goods) {

        //将数据库里用数据存储的新旧状态转换为对应string的描述语言
        String NewDegree = goods.getNewDegree()>0?goods.getNewDegree()+"成":"全新";

        //讲数据库中取出的long型的id转换为GoodsVO id的int型
        int i = new Long(goods.getId()).intValue();

        //数据的封装转换
        GoodsVO gv =   new GoodsVO();
        gv.setNewDegree(NewDegree);
        gv.setId(i);
        gv.setTitle(goods.getTitle());
        gv.setBrand(goods.getBrand());
        gv.setPrice(new DecimalFormat("#.00").format(((double)goods.getPrice()/100)));
        gv.setPicture(goods.getPicture());

        return gv;
    }

}
