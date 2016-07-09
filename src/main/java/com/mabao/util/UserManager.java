package com.mabao.util;

import com.mabao.pojo.User;
import com.mabao.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserManager {

    @Autowired
    private UserRepository userRepository;

    /**
     * 获取当前用户，目前用作测试使用
     * @return User
     */
    public User getUser(){
        return userRepository.findByNameAndPassword("test","test");
    }
}
