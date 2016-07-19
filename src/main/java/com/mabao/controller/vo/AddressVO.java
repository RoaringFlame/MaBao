package com.mabao.controller.vo;

import com.mabao.pojo.Address;
import com.mabao.pojo.Cart;
import com.mabao.util.VoUtil;

import java.util.ArrayList;
import java.util.List;

public class AddressVO {
    private Long id;                                //地址编号
    private Long userId;                            //用户编号
    private String recipients;                      //收件人
    private String tel;                             //手机号
    private Long areaId;                            //所在行政区域ID
    private String mergerName;                      //区域全称
    private String location;                        //详细地址
    private boolean state;                          //地址状态，是否为默认收货地址，0为否、1为是。


    public static AddressVO generateBy(Address address){
        AddressVO vo = VoUtil.copyBasic(AddressVO.class, address);
        assert vo != null;
        if (address.getUser() != null){vo.setUserId(address.getUser().getId());}
        if (address.getArea() != null) {
            vo.setAreaId(address.getArea().getId());
            vo.setMergerName(address.getArea().getMergerName());
        }
        return vo;
    }
    public static List<AddressVO> generateBy(List<Address> addressList){
        List<AddressVO> list=new ArrayList<>();
        for (Address g : addressList){
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

    public String getMergerName() {
        return mergerName;
    }

    public void setMergerName(String mergerName) {
        this.mergerName = mergerName;
    }
}
