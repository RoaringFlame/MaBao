package com.mabao.pojo;

import com.mabao.enums.Gender;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "t_baby")
public class Baby {
    private Long id;                            //编号
    private User user;                          //用户ID
    private String name;                        //宝宝名字
    private Date birthday;                      //宝宝出生日期
    private Gender gender;                      //宝宝性别
    private String hobby;                       //宝宝爱好


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
}
