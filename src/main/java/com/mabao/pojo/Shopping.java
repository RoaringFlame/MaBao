package com.mabao.pojo;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_shopping")
public class Shopping {
    private Integer id;                         //编号
    private Integer userId;                     //用户ID
    private String goodsList;                   //商品列表，以goodsId,goodsId;形式存储
    private Integer totalNumber;                //商品总数量
    private Integer totalPay;                   //购物车商品总价

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @Column(name = "user_id")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    @Column(name = "goods_and_num_list")
    public String getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(String goodsList) {
        this.goodsList = goodsList;
    }

    @Column(name = "total_number")
    public Integer getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(Integer totalNumber) {
        this.totalNumber = totalNumber;
    }
    @Column(name = "total_pay")
    public Integer getTotalPay() {
        return totalPay;
    }

    public void setTotalPay(Integer totalPay) {
        this.totalPay = totalPay;
    }

   }
