package com.mabao.enums;

import com.mabao.util.Selector;
import java.util.ArrayList;
import java.util.List;

public enum Gender {

    MEN("男"),WOMEN("女"),UNLIMITED("中性") ;
    private String text;
    Gender(String text){
        this.text=text;
    }

    public String getText() {
        return text;
    }

    /**
     * 获取枚举的值(性别)
     * @return 返回性别下拉列表中的值的集合
     */
    public static List<Selector> toList() {
        List<Selector>  list = new ArrayList<Selector>();
        for (Gender v: Gender.values()) {
            list.add(new Selector(v.name(), v.getText()));
        }
        return list;
    }
}
