package com.mabao.controller.vo;

import com.mabao.enums.OrderStatus;
import com.mabao.pojo.Goods;
import com.mabao.pojo.OrderDetail;
import com.mabao.util.VoUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 订单简要信息VO
 * Created by lies on 2016/6/30.
 */
public class OrderVO {
    private Long id;                                //订单明细的id
    private String size;                            //尺寸
    private String title;                           //标题
    private String picture;                         //图片
    private Double unitCost;                        //单价
    private String brand;                           //商品品牌
    private Integer quantity;                       //数量
    private Double totalSum;                        //总价
    private Double freight;                         //运费
    private OrderStatus state;                      //订单状态

    public static OrderVO generateBy(OrderDetail o){
        OrderVO vo = VoUtil.copyBasic(OrderVO.class, o);
        assert vo != null;
        vo.setQuantity(o.getOrder().getQuantity());
        vo.setTotalSum(o.getOrder().getTotalSum());
        vo.setState(o.getOrder().getState());
        return vo;
    }
    public static List<OrderVO> generateBy(List<OrderDetail> orderList){
        List<OrderVO> list=new ArrayList<>();
        for (OrderDetail g : orderList){
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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Double getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(Double unitCost) {
        this.unitCost = unitCost;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(Double totalSum) {
        this.totalSum = totalSum;
    }

    public Double getFreight() {
        return freight;
    }

    public void setFreight(Double freight) {
        this.freight = freight;
    }

    public OrderStatus getState() {
        return state;
    }

    public void setState(OrderStatus state) {
        this.state = state;
    }
}
