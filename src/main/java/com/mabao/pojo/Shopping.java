package com.mabao.pojo;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_shopping")
public class Shopping {
    private Integer id;                         //编号
    private String goodsAndNumList;             //商品和数量列表，以goodsId,num;形式存储
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
    @Column(name = "goods_and_num_list")
    public String getGoodsAndNumList() {
        return goodsAndNumList;
    }

    public void setGoodsAndNumList(String goodsAndNumList) {
        this.goodsAndNumList = goodsAndNumList;
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
