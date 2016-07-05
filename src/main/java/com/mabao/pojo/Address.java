package com.mabao.pojo;

import javax.persistence.*;

@Entity
@Table(name = "t_address")
public class Address {
    private Integer id;                             //地址编号
    private Integer userId;                         //用户编号
    private String recipients;                      //收件人
    private String tel;                             //手机号
    private String location;                        //地址详情
    private boolean state;                          //地址状态，是否为默认收货地址，0为否、1为是。

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "recipients")
    public String getRecipients() {
        return recipients;
    }

    public void setRecipients(String recipients) {
        this.recipients = recipients;
    }

    @Basic
    @Column(name = "tel")
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Basic
    @Column(name = "location")
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Basic
    @Column(name = "state")
    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (id != address.id) return false;
        if (userId != address.userId) return false;
        if (state != address.state) return false;
        if (recipients != null ? !recipients.equals(address.recipients) : address.recipients != null) return false;
        if (tel != null ? !tel.equals(address.tel) : address.tel != null) return false;
        if (location != null ? !location.equals(address.location) : address.location != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + userId;
        result = 31 * result + (recipients != null ? recipients.hashCode() : 0);
        result = 31 * result + (tel != null ? tel.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (state ? 1 : 0);
        return result;
    }
}
