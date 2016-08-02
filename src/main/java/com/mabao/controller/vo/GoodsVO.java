package com.mabao.controller.vo;

import com.mabao.pojo.Goods;
import com.mabao.pojo.OrderDetail;
import com.mabao.util.VoUtil;

import java.util.ArrayList;
import java.util.List;

public class GoodsVO {

    private Long id;                        //宝物的id
    private String title;                   //宝物的描述
    private String picture;                 //宝物图片
    private Double price;                   //宝物价格
    private String newDegree;               //宝物新旧程度
    private String brandName;               //宝物品牌
    private String size;                    //宝物尺寸
    private Integer quantity;               //数量
    private String state;                   //宝物状态

    public static GoodsVO generateBy(Goods goods){
        GoodsVO vo = VoUtil.copyBasic(GoodsVO.class, goods);
        assert vo != null;
        vo.setQuantity(1);
        vo.setNewDegree(goods.getNewDegree().getText());
        vo.setSize(goods.getSize().getName());
        vo.setState(goods.getState()?"已发布":(goods.getSellEnd()?"已售罄":"发布审核中"));
        return vo;
    }
    public static List<GoodsVO> generateBy(List<Goods> goodsList){
        List<GoodsVO> list=new ArrayList<>();
        for (Goods g : goodsList){
            list.add(generateBy(g));
        }
        return list;
    }
    public static GoodsVO generateByOrderDetail(OrderDetail goods){
        GoodsVO vo = VoUtil.copyBasic(GoodsVO.class, goods);
        assert vo != null;
        vo.setId(goods.getGoods().getId());
        vo.setPicture(goods.getGoods().getPicture());
        vo.setPrice(goods.getUnitCost());
        vo.setBrandName(goods.getBrand());
        vo.setState("交易中");
        return vo;
    }
    public static List<GoodsVO> generateByOrderDetail(List<OrderDetail> goodsList){
        List<GoodsVO> list=new ArrayList<>();
        for (OrderDetail g : goodsList){
            list.add(generateByOrderDetail(g));
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getState() {return state;}

    public void setState(String state) {this.state = state;}
}
