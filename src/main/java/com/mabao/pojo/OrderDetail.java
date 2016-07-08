package com.mabao.pojo;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_order_details")
public class OrderDetail {
    private Long id;                 //id
    private Order order;              //订单ID
    private Goods goods;              //商品ID
    private Integer quantity;           //商品数量
    private int unitCost;               //单价

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "goods_id")
    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getUnitCost() {
        return unitCost /(100*1.0);
    }

    public void setUnitCost(Double unitCost) {
        this.unitCost = (int)(unitCost*100);
    }

}
