package com.mabao.controller.rest;

import com.mabao.controller.vo.JsonResultVO;
import com.mabao.pojo.Address;
import com.mabao.pojo.Baby;
import com.mabao.pojo.User;
import com.mabao.service.AddressService;
import com.mabao.service.BabyService;
import com.mabao.service.UserService;
import com.mabao.util.MD5;
import com.mabao.util.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * 用户模块
 */
@RestController
@RequestMapping("/user")
public class UserCenterRESTController {
    @Autowired
    private UserService userService;

    /**
     * 用户注册
     * @param userName              用户名
     * @param password              密码
     * @param email                 邮箱
     * @return                      收货地址页
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public JsonResultVO userRegister(@RequestParam String userName,
                                                @RequestParam String password,
                                                @RequestParam String email) {
        return this.userService.userRegister(userName,password,email);
    }

    /**
     * 修改密码
     * @param password              新密码
     * @return                      登录页
     */
    @RequestMapping(value ="/passwordChange",method = RequestMethod.GET)
    public JsonResultVO passwordChange(@RequestParam String password){
        return this.userService.changePassword(password);
    }
}
