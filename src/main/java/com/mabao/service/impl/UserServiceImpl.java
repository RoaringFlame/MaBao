package com.mabao.service.impl;

import com.mabao.pojo.User;
import com.mabao.repository.UserRepository;
import com.mabao.service.UserService;
import com.sun.org.apache.xpath.internal.operations.String;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    /**
     * 用户登录验证
     * @param name              用户名
     * @param password          密码
     * @return                  用户对象
     */
    @Override
    public User findByNameAndPassword(String name, String password) {
        return userRepository.findByNameAndPassword(name,password);
    }
    /**
     * 根据ID获取用户对象
     * @param userId            用户ID
     * @return                  用户对象
     */
    @Override
    public User get(Long userId) {
        return this.userRepository.findOne(userId);
    }
}
