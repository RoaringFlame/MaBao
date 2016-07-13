package com.mabao.service.impl;

import com.mabao.controller.vo.JsonResultVO;
import com.mabao.pojo.User;
import com.mabao.repository.UserRepository;
import com.mabao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

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

    /**
     * 用户注册
     * @param userName              用户名
     * @param password              密码
     * @param email                 邮箱
     * @return                      收货地址页
     */
    @Override
    public JsonResultVO userRegister(String userName, String password, String email) {
        try {
            User user = new User();
            user.setName(userName);
            user.setPassword(password);
            user.setEmail(email);
            user.setCreateTime(new Date());
            this.userRepository.save(user);
            return new JsonResultVO(JsonResultVO.SUCCESS, "注册成功");
        }catch (Exception e){
            return new JsonResultVO(JsonResultVO.FAILURE, "注册失败");
        }
    }
}
