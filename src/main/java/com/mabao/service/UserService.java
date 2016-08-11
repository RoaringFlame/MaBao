package com.mabao.service;


import com.mabao.controller.vo.JsonResultVO;
import com.mabao.pojo.User;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

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

    /**
     * 个人中心，修改头像
     */
    User updateUserPicture(MultipartFile headerPic, HttpServletRequest request);

    /**
     * 发送短信验证
     * @param state                 短信类型 1为绑定手机 2为修改密码
     * @param phoneNum              绑定手机号
     * @return                      短信发送结果
     */
    JsonResultVO sendMessage(Integer state,String phoneNum) throws IOException;

    /**
     * 验证校验码
     * @param state                 验证类型 1为绑定手机 2为修改密码 3修改密码回显
     * @param code                  校验码
     * @param phoneNum              手机号（绑定手机用）
     * @return                      校验结果
     */
    JsonResultVO submitCode(Integer state, String code, String phoneNum);
}
