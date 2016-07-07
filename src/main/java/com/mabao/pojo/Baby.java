package com.mabao.pojo;

import com.mabao.enums.Gender;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "t_baby")
public class Baby {
    private Integer id;                         //编号
    @Column(name = "user_id")
    private Integer userId;                     //用户ID
    private String name;                        //宝宝名字
    private Date birthday;                      //宝宝出生日期
    private Gender gender;                      //宝宝性别


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
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
