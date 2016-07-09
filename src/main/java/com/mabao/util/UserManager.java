package com.mabao.util;

import com.mabao.pojo.User;
import com.mabao.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class UserManager {

    /**
     * 获取当前用户，目前用作测试使用
     * @return User
     */
    public static User getUser(){
        User user = new User();
        user.setId(1L);
        user.setName("test");
        user.setPassword("test");
        user.setPhone("12346897");
        user.setCreateTime(new Date());
        user.setEmail("123456@qq.com");
        return user;
    }
}
