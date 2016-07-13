package com.mabao.controller.vo;

import com.mabao.pojo.Cart;
import com.mabao.pojo.Goods;
import com.mabao.util.VoUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 购物车商品信息VO
 */
public class CartGoodsVO {
    private Long id;                        //购物车的id
    private Long goodsId;                   //商品ID
    private String title;                   //商品的描述
    private String picture;                 //商品图片
    private Double price;                   //商品价格
    private String newDegree;               //商品新旧程度
    private String brandName;               //商品品牌
    private String size;                    //商品尺寸
    private Integer num;                    //购买数量

    public static CartGoodsVO generateBy(Cart cart){
        CartGoodsVO vo = VoUtil.copyBasic(CartGoodsVO.class, cart);
        assert vo != null;
        Goods goods = cart.getGoods();
        if (goods !=null){
            vo.setGoodsId(goods.getId());
            vo.setTitle(goods.getTitle());
            vo.setPicture(goods.getPicture());
            vo.setPrice(goods.getPrice());
            vo.setNewDegree(goods.getNewDegree().getText());
            vo.setBrandName(goods.getBrandName());
            vo.setSize(goods.getSize().getName());
        }
        return vo;
    }
    public static List<CartGoodsVO> generateBy(List<Cart> cartList){
        List<CartGoodsVO> list=new ArrayList<>();
        for (Cart g : cartList){
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

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
