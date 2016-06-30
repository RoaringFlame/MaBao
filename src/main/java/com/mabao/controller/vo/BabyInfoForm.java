package com.mabao.controller.vo;

import java.util.Date;

/**
 * 宝宝信息VO
 * Created by makaiqin on 2016/6/30.
 */
public class BabyInfoForm {
    private String sex;//宝宝性别
    private Date babyBirth;//宝宝生日
    private String name;//宝宝姓名
    private String hobby;//宝宝爱好

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBabyBirth() {
        return babyBirth;
    }

    public void setBabyBirth(Date babyBirth) {
        this.babyBirth = babyBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
}


