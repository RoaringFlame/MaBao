package com.mabao.enums;

import com.mabao.util.Selector;

import java.util.ArrayList;
import java.util.List;

/**
 * 订单状态
 * 0待支付（买家），1待发货（卖家），2待收货（买家），3已完成（卖家），4已取消（买家）
 */
public enum OrderStatus {
    ToBePaid("待支付"),ToBeSend("待发货"),ToBeReceipt("待收货"),completed("已完成"),canceled("已取消") ;

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
