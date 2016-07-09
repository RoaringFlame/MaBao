package com.mabao.pojo;

import javax.persistence.*;

/**
 * 商品尺码表
 * Created by jackie on 2016/07/09.
 */
@Entity
@Table(name = "t_goods_size_table")
public class GoodsSize {
    private Long id;                         //编号
    private GoodsType goodsType;             //商品类别
    private String name;                     //名称

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "goods_type_id")
    public GoodsType getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(GoodsType goodsType) {
        this.goodsType = goodsType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
