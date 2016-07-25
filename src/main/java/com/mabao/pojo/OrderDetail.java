package com.mabao.pojo;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_order_details")
public class OrderDetail {
    private Long id;                                //id
    private Order order;                            //订单ID
    private Goods goods;                            //商品ID
    private String size;                            //尺寸
    private String title;                           //标题
    private String typeName;                        //一级类型名称
    private Double unitCost;                        //单价
    private String brand;                           //商品品牌
    private Date upTime;                            //上架时间
    private String newDegree;                       //新旧程度


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "order_id")
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "goods_id")
    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    @Column(name = "unit_cost")
    public Double getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(Double unitCost) {
        this.unitCost = unitCost;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    @Column(name = "type_name")
    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
    @Column(name = "up_time")
    public Date getUpTime() {
        return upTime;
    }

    public void setUpTime(Date upTime) {
        this.upTime = upTime;
    }
    @Column(name = "new_degree")
    public String getNewDegree() {
        return newDegree;
    }

    public void setNewDegree(String newDegree) {
        this.newDegree = newDegree;
    }

}
