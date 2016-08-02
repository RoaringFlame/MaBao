package com.mabao.controller.vo;

import com.mabao.pojo.Order;
import com.mabao.util.VoUtil;

import java.util.List;


public class OrderVO {
    private Long id;                                //订单的id
    private List<GoodsVO> goodsVOList;              //订单中的商品
    private Integer quantity;                       //总数量
    private Double totalSum;                        //总价
    private Double freight;                         //总运费
    private Integer flag;                           //状态标记
    private String state;                      //订单状态

//    public static List<OrderVO> generateBy(List<OrderDetail> orderList) {
//        List<OrderVO> list = new ArrayList<>();
//        for (OrderDetail g : orderList) {
//            list.add(generateBy(g));
//        }
//        return list;
//    }

    public static OrderVO generateBy(Order o,List<GoodsVO> goodsVOList){
        OrderVO vo = VoUtil.copyBasic(OrderVO.class, o);
        assert vo != null;
        vo.setFlag(o.getState().ordinal());
        vo.setGoodsVOList(goodsVOList);
        vo.setState(o.getState().getText());
        return vo;
    }

    public Double getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(Double totalSum) {
        this.totalSum = totalSum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<GoodsVO> getGoodsVOList() {
        return goodsVOList;
    }

    public void setGoodsVOList(List<GoodsVO> goodsVOList) {
        this.goodsVOList = goodsVOList;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getFreight() {
        return freight;
    }

    public void setFreight(Double freight) {
        this.freight = freight;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getState() {return state;}

    public void setState(String state) {
        this.state = state;
    }
}
