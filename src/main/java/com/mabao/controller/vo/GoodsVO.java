package com.mabao.controller.vo;

/**
 * 商品部分信息VO
 * Created by makaiqin 2016/6/30.
 */
public class GoodsVO {
    private int id;//商品id
    private String title;//商品标题
    private String picture;//宝物图片
    private double price;//宝物价格
    private String newDegree;//宝物新旧程度
    private String brand;//宝物品牌

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }
    public String getPicture() {
        return picture;
    }
    public void setPicture(String picture) {
        this.picture = picture;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(int price) {
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
