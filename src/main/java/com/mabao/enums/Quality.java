package com.mabao.enums;

import com.mabao.util.Selector;

import java.util.ArrayList;
import java.util.List;

/**
 * 新旧程度
 * Created by jackie on 2016/07/09.
 */
public enum Quality {
    NEW("全新"),
    NINE("9成新"),
    EIGHT("8成新"),
    SEVEN("7成新"),
    SIX("6成新"),
    FIVE("5成新及以下");

    private String text;

    Quality(String text){
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
        List<Selector>  list = new ArrayList<Selector>();
        for (Quality v: Quality.values()) {
            list.add(new Selector(v.name(), v.getText()));
        }
        return list;
    }
}
