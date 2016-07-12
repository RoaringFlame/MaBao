package com.mabao.util;

import com.mabao.pojo.User;
import com.mabao.repository.UserRepository;
import com.mabao.util.security.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;

public class UserManager {

    /**
     * 获取当前用户，目前用作测试使用
     *
     * @return User
     */
    /*public static User getUser() {
        User user = new User();
        user.setId(1L);
        user.setName("test");
        user.setPassword("test");
        user.setPhone("12346897");
        user.setCreateTime(new Date());
        user.setEmail("123456@qq.com");
        return user;
    }*/

    public static User getUser() {
        UserInfo userInfo = (UserInfo) SecurityContextHolder
                .getContext().getAuthentication().getPrincipal();
        User user = new User();
        user.setId(userInfo.getUserId());
        user.setName(userInfo.getUsername());
        user.setPassword(userInfo.getPassword());
        user.setPhone(userInfo.getPhone());
        user.setPicture(userInfo.getPicture());
        user.setEmail(userInfo.getEmail());
        user.setCreateTime(userInfo.getCreateTime());
        return user;
    }
}
