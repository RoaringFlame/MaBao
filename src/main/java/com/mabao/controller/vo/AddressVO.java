package com.mabao.controller.vo;

public class AddressVO {
    private Long id;                                //地址编号
    private Long userId;                            //用户编号
    private String recipients;                      //收件人
    private String tel;                             //手机号
    private Long areaId;                            //所在行政区域
    private String location;                        //详细地址
    private boolean state;                          //地址状态，是否为默认收货地址，0为否、1为是。

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getRecipients() {
        return recipients;
    }

    public void setRecipients(String recipients) {
        this.recipients = recipients;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
