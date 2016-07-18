package com.mabao.controller.rest;

import com.mabao.controller.vo.JsonResultVO;
import com.mabao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户模块
 */
@RestController
@RequestMapping("/person")
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
    @RequestMapping(value ="/passwordChange",method = RequestMethod.POST)
    public JsonResultVO passwordChange(@RequestParam String password){
        return this.userService.changePassword(password);
    }
}
