package com.mabao.util.security;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.Date;
public class UserInfo extends User {
    private Long userId;                            //用户编号
    private String phone;                           //手机号
    private String email;                           //邮箱
    private Date createTime;                        //创建时间
    private String picture;                         //头像

    public UserInfo(String username, String password,Collection<GrantedAuthority> authorities)
            throws IllegalArgumentException {
        super(username,password,authorities);
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}