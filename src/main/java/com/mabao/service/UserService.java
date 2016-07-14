package com.mabao.service;


import com.mabao.controller.vo.JsonResultVO;
import com.mabao.pojo.User;

public interface UserService {
    /**
     * 用户名密码获取用户信息
     * @param name              用户名
     * @param password          密码
     * @return                  用户对象
     */
    User findByNameAndPassword(String name, String password);

    /**
     * 根据ID获取用户对象
     * @param userId            用户ID
     * @return                  用户对象
     */
    User get(Long userId);

    /**
     * 用户注册
     * @param userName              用户名
     * @param password              密码
     * @param email                 邮箱
     * @return                      收货地址页
     */
    JsonResultVO userRegister(String userName, String password, String email);

    /**
     * 修改用户信息
     * @param user                  用户
     * @return                      修改的用户
     */
    User updateUser(User user);
    /**
     * 修改密码
     * @param password              新密码
     * @return                      登录页
     */
    JsonResultVO changePassword(String password);
}
