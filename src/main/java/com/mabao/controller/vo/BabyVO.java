package com.mabao.controller.vo;

import com.mabao.enums.Gender;
import com.mabao.pojo.Baby;
import com.mabao.pojo.User;
import com.mabao.util.VoUtil;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * 宝宝信息
 * Created by jackie on 2016/07/09.
 */
public class BabyVO {
    private Long id;                            //编号
    private Long userId;                        //用户ID
    private String name;                        //宝宝名字
    private Date birthday;                      //宝宝出生日期
    private Gender gender;                      //宝宝性别

    public static BabyVO generateBy(Baby baby){
        BabyVO vo = VoUtil.copyBasic(BabyVO.class, baby);
        assert vo != null;
        vo.setUserId(baby.getUser().getId());
        return vo;
    }
    public static List<BabyVO> generateBy(List<Baby> babyList){
        List<BabyVO> list=new ArrayList<>();
        for (Baby g : babyList){
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
