package com.mabao.util.alibaba.message;

import com.mabao.util.alibaba.message.smsBean.TextMessage;

public class ChangePasswordMes extends TextMessage{

    public ChangePasswordMes(){
        super.setTemplate("changePassword");
    }

    private Integer code;
    private String name;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getContent() {
        return "{code:\'"+ this.getCode()+"+\',name:\'"+ this.getName()+"\'}";
    }
}
