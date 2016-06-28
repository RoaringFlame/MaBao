package com.mabao.pojo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mabao.util.CustomDateSerializer;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Goods {
    private Long id;

    @Id
    @javax.persistence.Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private int userId;

    @Basic
    @javax.persistence.Column(name = "userId")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    private String articleNumber;

    @Basic
    @javax.persistence.Column(name = "articleNumber")
    public String getArticleNumber() {
        return articleNumber;
    }

    public void setArticleNumber(String articleNumber) {
        this.articleNumber = articleNumber;
    }

    private String picture;

    @Basic
    @javax.persistence.Column(name = "picture")
    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    private String title;

    @Basic
    @javax.persistence.Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private int oldPrice;

    @Basic
    @javax.persistence.Column(name = "oldPrice")
    public int getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(int oldPrice) {
        this.oldPrice = oldPrice;
    }

    private int price;

    @Basic
    @javax.persistence.Column(name = "price")
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    private String typeName;

    @Basic
    @javax.persistence.Column(name = "typeName")
    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    private Integer typeId;

    @Basic
    @javax.persistence.Column(name = "typeId")
    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    private String brand;

    @Basic
    @javax.persistence.Column(name = "brand")
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    private Date upTime;

    @Basic
    @javax.persistence.Column(name = "upTime")
    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getUpTime() {
        return upTime;
    }

    public void setUpTime(Date upTime) {
        this.upTime = upTime;
    }

    private Integer newDegree;

    @Basic
    @javax.persistence.Column(name = "newDegree")
    public Integer getNewDegree() {
        return newDegree;
    }

    public void setNewDegree(Integer newDegree) {
        this.newDegree = newDegree;
    }

    private String size;

    @Basic
    @javax.persistence.Column(name = "size")
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    private Boolean pack;

    @Basic
    @javax.persistence.Column(name = "pack")
    public Boolean getPack() {
        return pack;
    }

    public void setPack(Boolean pack) {
        this.pack = pack;
    }

    private Boolean receipt;

    @Basic
    @javax.persistence.Column(name = "receipt")
    public Boolean getReceipt() {
        return receipt;
    }

    public void setReceipt(Boolean receipt) {
        this.receipt = receipt;
    }

    private String message;

    @Basic
    @javax.persistence.Column(name = "message")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String pictureList;

    @Basic
    @javax.persistence.Column(name = "pictureList")
    public String getPictureList() {
        return pictureList;
    }

    public void setPictureList(String pictureList) {
        this.pictureList = pictureList;
    }

    private Integer stockNumber;

    @Basic
    @javax.persistence.Column(name = "stockNumber")
    public Integer getStockNumber() {
        return stockNumber;
    }

    public void setStockNumber(Integer stockNumber) {
        this.stockNumber = stockNumber;
    }

    private Boolean state;

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
