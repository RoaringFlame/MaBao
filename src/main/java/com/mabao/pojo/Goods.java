package com.mabao.pojo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mabao.util.CustomDateSerializer;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "t_goods")
public class Goods {
    private Long id;                                //商品编号，自增
    private Integer userId;                         //商品归属者编号，后台用户编号为0
    private String articleNumber;                   //货号
    private String picture;                         //图片标签
    private String title;                           //标题
    private int oldPrice;                           //原价，用整型存储避免计算出错，存取时记得变位。
    private int price;                              //现价，用法同原价。
    private String typeName;                        //二级类型名称
    private Integer typeId;                         //一级类型编号
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
    @javax.persistence.Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @javax.persistence.Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
    public int getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(int oldPrice) {
        this.oldPrice = oldPrice;
    }

    @Basic
    @javax.persistence.Column(name = "price")
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Basic
    @javax.persistence.Column(name = "type_name")
    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Basic
    @javax.persistence.Column(name = "type_id")
    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Goods goods = (Goods) o;

        if (id != goods.id) return false;
        if (userId != goods.userId) return false;
        if (oldPrice != goods.oldPrice) return false;
        if (price != goods.price) return false;
        if (state != goods.state) return false;
        if (articleNumber != null ? !articleNumber.equals(goods.articleNumber) : goods.articleNumber != null)
            return false;
        if (picture != null ? !picture.equals(goods.picture) : goods.picture != null) return false;
        if (title != null ? !title.equals(goods.title) : goods.title != null) return false;
        if (typeName != null ? !typeName.equals(goods.typeName) : goods.typeName != null) return false;
        if (typeId != null ? !typeId.equals(goods.typeId) : goods.typeId != null) return false;
        if (brand != null ? !brand.equals(goods.brand) : goods.brand != null) return false;
        if (upTime != null ? !upTime.equals(goods.upTime) : goods.upTime != null) return false;
        if (newDegree != null ? !newDegree.equals(goods.newDegree) : goods.newDegree != null) return false;
        if (size != null ? !size.equals(goods.size) : goods.size != null) return false;
        if (pack != null ? !pack.equals(goods.pack) : goods.pack != null) return false;
        if (receipt != null ? !receipt.equals(goods.receipt) : goods.receipt != null) return false;
        if (message != null ? !message.equals(goods.message) : goods.message != null) return false;
        if (pictureList != null ? !pictureList.equals(goods.pictureList) : goods.pictureList != null) return false;
        if (stockNumber != null ? !stockNumber.equals(goods.stockNumber) : goods.stockNumber != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.intValue();
        result = 31 * result + userId;
        result = 31 * result + (articleNumber != null ? articleNumber.hashCode() : 0);
        result = 31 * result + (picture != null ? picture.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + oldPrice;
        result = 31 * result + price;
        result = 31 * result + (typeName != null ? typeName.hashCode() : 0);
        result = 31 * result + (typeId != null ? typeId.hashCode() : 0);
        result = 31 * result + (brand != null ? brand.hashCode() : 0);
        result = 31 * result + (upTime != null ? upTime.hashCode() : 0);
        result = 31 * result + (newDegree != null ? newDegree.hashCode() : 0);
        result = 31 * result + (size != null ? size.hashCode() : 0);
        result = 31 * result + (pack != null ? pack.hashCode() : 0);
        result = 31 * result + (receipt != null ? receipt.hashCode() : 0);
        result = 31 * result + (message != null ? message.hashCode() : 0);
        result = 31 * result + (pictureList != null ? pictureList.hashCode() : 0);
        result = 31 * result + (stockNumber != null ? stockNumber.hashCode() : 0);
        result = 31 * result + (state ? 1 : 0 );
        return result;
    }
}
