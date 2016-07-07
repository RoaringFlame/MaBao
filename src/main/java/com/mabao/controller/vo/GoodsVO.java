package com.mabao.controller.vo;

import com.mabao.pojo.Goods;
import com.mabao.util.VoUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lies on 2016/6/30.
 */
public class GoodsVO {

    private int id; //宝物的id
    private String title;//宝物的描述
    private String picture;//宝物图片
    private String price;//宝物价格
    private String newDegree;//宝物新旧程度
    private String brand;//宝物品牌

    public static GoodsVO generateBy(Goods goods){
        return VoUtil.copyBasic(GoodsVO.class, goods);
    }
    public static List<GoodsVO> generateBy(List<Goods> goodsList){
        List<GoodsVO> list=new ArrayList<>();
        for (Goods g : goodsList){
            list.add(generateBy(g));
        }
        return list;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
