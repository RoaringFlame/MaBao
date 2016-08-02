package com.mabao.enums;

import com.mabao.util.Selector;

import java.util.ArrayList;
import java.util.List;

/**
 * 订单状态
 * 0待支付，1待发货，2待收货，3已完成，4已取消
 */
public enum OrderStatus {
    ToBePaid("等待付款"),
    ToBeSend("等待出库"),
    ToBeReceipt("已出库"),
    Completed("交易完成"),
    Canceled("已取消") ;

    private String text;
    OrderStatus(String text){
        this.text=text;
    }

    public String getText() {
        return text;
    }

    /**
     * 获取枚举的值
     * @return 返回性别下拉列表中的值的集合
     */
    public static List<Selector> toList() {
        List<Selector>  list = new ArrayList<>();
        for (OrderStatus v: OrderStatus.values()) {
            list.add(new Selector(v.name(), v.getText()));
        }
        return list;
    }
}
