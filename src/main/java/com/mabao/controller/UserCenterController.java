package com.mabao.controller;

import com.mabao.pojo.Address;
import com.mabao.service.AddressService;
import com.mabao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * 用户模块
 * Created by maxu on 2016/7/1.
 */
@Controller
@RequestMapping("/user")
public class UserCenterController {
    @Autowired
    private AddressService addressService;

    /**
     * 该用户所有收货地址
     * @param userId                用户ID
     * @param model                 地址list
     * @return                      收货地址页
     */
    @RequestMapping(value ="/address/allAddress",method = GET)
    public String allAddress(int userId,Model model){
        List<Address> addressList=this.addressService.findAllAddress(userId);
        model.addAttribute("addressList",addressList);
        return "address";
    }

    /**
     * 添加收货地址
     * @param address           地址对象
     * @return                  地址页
     */
    @RequestMapping(value ="/address/addAddress",method = POST)
    public String addAddress(Address address){
        Address result=this.addressService.addAddress(address);
        if (result != null){
            return "redirect:address/allAddress";
        }else {
            return "address-failure";
        }
    }
    /**
     * 修改收货地址
     * @param address           地址对象
     * @return                  用户地址页
     */
    @RequestMapping(value = "/address/updateAddress",method = POST)
    public String updateAddress(Address address,Model model){
        Address result=this.addressService.updateAddress(address);
        if (result != null){
            return "redirect:address/allAddress";
        }else {
            return "address-failure";
        }
    }
    /**
     * 删除收货地址
     * @param addressId         地址ID
     * @return                  地址页
     */
    @RequestMapping(value = "/address/deleteAddressSubmit",method = GET)
    public String removeAddress(int addressId){
        Address Address=this.addressService.deleteAddress(addressId);
        if (Address != null){
            return "redirect:address/allAddress";
        }else {
            return "address-failure";
        }
    }


}
