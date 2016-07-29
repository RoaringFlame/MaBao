package com.mabao.controller.rest;

import com.mabao.controller.vo.JsonResultVO;
import com.mabao.pojo.Address;
import com.mabao.pojo.User;
import com.mabao.service.AddressService;
import com.mabao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户模块
 */
@RestController
@RequestMapping("/person")
public class UserCenterRESTController {
    @Autowired
    private UserService userService;
    @Autowired
    private AddressService addressService;
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

    /**
     * 修改收货地址默认状态
     * @param addressId           地址对象
     * @return                  用户地址页
     */
    @RequestMapping(value = "/address/updateAddressStatus",method = RequestMethod.GET)
    public JsonResultVO updateAddressStatus(Long addressId, Model model){
        Address result=this.addressService.updateAddressStatus(addressId);
        return new JsonResultVO(JsonResultVO.SUCCESS);
    }

    /**
     * 个人中心，修改头像
     */
    @RequestMapping(value = "/headerPic",method = RequestMethod.POST)
    public User updateUserPicture(@RequestParam MultipartFile headerPic,
                                  HttpServletRequest request) throws Exception {
        return this.userService.updateUserPicture(headerPic,request);


    }
}
