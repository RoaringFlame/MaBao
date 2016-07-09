package com.mabao.controller.vo;

import com.mabao.pojo.Goods;
import com.mabao.util.VoUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品简要信息VO
 * Created by lies on 2016/6/30.
 */
public class GoodsVO {

    private Long id;                         //宝物的id
    private String title;                   //宝物的描述
    private String picture;                 //宝物图片
    private String price;                   //宝物价格
    private String newDegree;               //宝物新旧程度
    private String brandName;               //宝物品牌
    private String size;                    //宝物尺寸

    public static GoodsVO generateBy(Goods goods){
        GoodsVO vo = VoUtil.copyBasic(GoodsVO.class, goods);
        //将数据库里用数据存储的新旧状态转换为对应string的描述语言
        assert vo != null;
        vo.setPrice(goods.getPrice().toString());
        vo.setNewDegree(goods.getNewDegree().getText());
        vo.setSize(goods.getSize().getName());
        return vo;
    }
    public static List<GoodsVO> generateBy(List<Goods> goodsList){
        List<GoodsVO> list=new ArrayList<>();
        for (Goods g : goodsList){
            list.add(generateBy(g));
        }
        return list;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getNewDegree() {
        return newDegree;
    }

    public void setNewDegree(String newDegree) {
        this.newDegree = newDegree;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
