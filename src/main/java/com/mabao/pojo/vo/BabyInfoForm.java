package com.mabao.pojo.vo;

import java.util.Date;

/**
 * Created by lies on 2016/6/29.
 */
public class BabyInfoForm {
    private String sex;
    private Date babybirth;
    private  String name ;
    private  String hobby;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBabybirth() {
        return babybirth;
    }

    public void setBabybirth(Date babybirth) {
        this.babybirth = babybirth;
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
