package com.mabao.pojo;

import javax.persistence.*;

/**
 * 商品品牌
 * Created by jackie on 2016/07/09.
 */
@Entity
@Table(name = "t_brand")
public class Brand {
    private Long id;                         //编号
    private String brandName;                //品牌名称
    private String picture;                  //图片
    private Integer sort;                    //排序
    private String remark;                   //备注
    private Boolean status;                  //禁用or启用

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
}
