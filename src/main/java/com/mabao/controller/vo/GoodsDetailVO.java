package com.mabao.controller.vo;

import com.mabao.pojo.Goods;
import com.mabao.util.VoUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 商品详细信息VO
 */
public class GoodsDetailVO {
    private Long id;                                //宝物的id
    private String title;                           //宝物的描述
    private String picture;                         //宝物图片
    private String price;                           //宝物价格
    private String newDegree;                       //宝物新旧程度
    private String typeName;                        //类型名称
    private String brandName;                       //宝物品牌
    private String size;                            //宝物尺寸
    private String babyType;                        //适合宝宝类型
    private Boolean pack;                           //是否有包装，1有0无
    private Boolean receipt;                        //是否有小票，1有0无
    private String message;                         //卖家分享
    private List<String> pictureList;               //附加图片

    public static GoodsDetailVO generateBy(Goods goods){
        GoodsDetailVO vo = VoUtil.copyBasic(GoodsDetailVO.class, goods);
        //将数据库里用数据存储的新旧状态转换为对应string的描述语言
        assert vo != null;
        vo.setPrice(goods.getPrice().toString());
        vo.setNewDegree(goods.getNewDegree().getText());
        vo.setSize(goods.getSize().getName());
        vo.setBabyType(goods.getBabyType().getText());
        if (goods.getPictureList() != null) {
            List<String> pictures = new ArrayList<>();
            Collections.addAll(pictures, goods.getPictureList().split(","));
            vo.setPictureList(pictures);
        }
        return vo;
    }
    public static List<GoodsDetailVO> generateBy(List<Goods> goodsList){
        List<GoodsDetailVO> list=new ArrayList<>();
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

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getBabyType() {
        return babyType;
    }

    public void setBabyType(String babyType) {
        this.babyType = babyType;
    }

    public Boolean getPack() {
        return pack;
    }

    public void setPack(Boolean pack) {
        this.pack = pack;
    }

    public Boolean getReceipt() {
        return receipt;
    }

    public void setReceipt(Boolean receipt) {
        this.receipt = receipt;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getPictureList() {
        return pictureList;
    }

    public void setPictureList(List<String> pictureList) {
        this.pictureList = pictureList;
    }
}
