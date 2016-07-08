package com.mabao.pojo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mabao.util.CustomDateSerializer;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_goods")
public class Goods {
    private Long id;                                //商品编号，自增
    private User user;                              //商品归属者编号，后台用户编号为0
    private String articleNumber;                   //货号
    private String picture;                         //图片标签
    private String title;                           //标题
    private int oldPrice;                           //原价，用整型存储避免计算出错，存取时记得变位。
    private int price;                              //现价，用法同原价。
    private String typeName;                        //二级类型名称
    private GoodsType type;                         //一级类型编号
    private String brand;                           //商品品牌
    private Date upTime;                            //上架时间
    private Integer newDegree;                      //新旧程度，0表示全新，95，80分别表示95成8成新
    private String size;                            //尺寸
    private Boolean pack;                           //是否有包装，1有0无
    private Boolean receipt;                        //是否有小票，1有0无
    private String message;                         //卖家分享
    private String pictureList;                     //附加图片，list元素用分号隔开存入数据库
    private Integer stockNumber;                    //库存数量
    private Boolean state;                          //商品状态，1为存在，0为下架或不存在。

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Basic
    @javax.persistence.Column(name = "article_number")
    public String getArticleNumber() {
        return articleNumber;
    }

    public void setArticleNumber(String articleNumber) {
        this.articleNumber = articleNumber;
    }

    @Basic
    @javax.persistence.Column(name = "picture")
    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Basic
    @javax.persistence.Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @javax.persistence.Column(name = "old_price")
    public Double getOldPrice() {
        return oldPrice*1.00/100;
    }

    public void setOldPrice(Double oldPrice) {
        this.oldPrice = (int)(oldPrice*100.00);
    }

    @Basic
    @javax.persistence.Column(name = "price")
    public Double getPrice() {
        return price*1.00/100;
    }

    public void setPrice(Double price) {
        this.price = (int)(price*100.00);
    }

    @Basic
    @javax.persistence.Column(name = "type_name")
    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "type_id")
    public GoodsType getType() {
        return type;
    }

    public void setType(GoodsType type) {
        this.type = type;
    }

    @Basic
    @javax.persistence.Column(name = "brand")
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Basic
    @javax.persistence.Column(name = "up_time")
    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getUpTime() {
        return upTime;
    }

    public void setUpTime(Date upTime) {
        this.upTime = upTime;
    }

    @Basic
    @javax.persistence.Column(name = "new_degree")
    public Integer getNewDegree() {
        return newDegree;
    }

    public void setNewDegree(Integer newDegree) {
        this.newDegree = newDegree;
    }

    @Basic
    @javax.persistence.Column(name = "size")
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Basic
    @javax.persistence.Column(name = "pack")
    public Boolean getPack() {
        return pack;
    }

    public void setPack(Boolean pack) {
        this.pack = pack;
    }

    @Basic
    @javax.persistence.Column(name = "receipt")
    public Boolean getReceipt() {
        return receipt;
    }

    public void setReceipt(Boolean receipt) {
        this.receipt = receipt;
    }

    @Basic
    @javax.persistence.Column(name = "message")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    @Basic
    @javax.persistence.Column(name = "picture_list")
    public String getPictureList() {
        return pictureList;
    }

    public void setPictureList(String pictureList) {
        this.pictureList = pictureList;
    }


    @Basic
    @javax.persistence.Column(name = "stock_number")
    public Integer getStockNumber() {
        return stockNumber;
    }

    public void setStockNumber(Integer stockNumber) {
        this.stockNumber = stockNumber;
    }


    @Basic
    @javax.persistence.Column(name = "state")
    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

}
