package com.mabao.controller.vo;

/**
 * 用户基本信息VO
 * Created by jackie on 2016/07/15.
 */
public class UserInfoVO {
    private Long userId;                        //用户ID
    private String userName;                    //用户名称
    private String userPicture;                 //用户图片
    private Long babyId;                        //宝宝ID
    private String babyName;                    //宝宝名字

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPicture() {
        return userPicture;
    }

    public void setUserPicture(String userPicture) {
        this.userPicture = userPicture;
    }

    public Long getBabyId() {
        return babyId;
    }

    public void setBabyId(Long babyId) {
        this.babyId = babyId;
    }

    public String getBabyName() {
        return babyName;
    }

    public void setBabyName(String babyName) {
        this.babyName = babyName;
    }
}
