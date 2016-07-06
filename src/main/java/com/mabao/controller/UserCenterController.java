package com.mabao.controller;

import com.mabao.pojo.Address;
import com.mabao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * 用户模块
 * Created by maxu on 2016/7/1.
 */
@Controller
@RequestMapping("/user")
public class UserCenterController {
    @Autowired
    private UserService userService;

    @RequestMapping(value ="/allAddress",method = GET)
    public String allAddress(int userId,Model model){
        Map<String,Object> map=new HashMap<>();
        List<Address> addressList=this.userService.getAllAddress(userId);
        map.put("addressList",addressList);
        model.addAllAttributes(map);
        return "address";
    }
    @RequestMapping(value = "/addAddressRedirect",method = GET)
    public String addAddressRedirect(){
        return "newAddress";
    }
    @RequestMapping(value ="/addAddressSubmit",method = GET)
    public String addAddressSubmit(Address address,Model model){
        Map<String,Object> map=new HashMap<>();
        List<Address> addressList=this.userService.addAddress(address);
        map.put("addressList",addressList);
        model.addAllAttributes(map);
        return "address";
    }
    @RequestMapping(value = "/updateAddressRedirect",method = GET)
    public String updateAddressRedirect(int addressId,Model model){
        Map<String,Object> map=new HashMap<>();
        Address address=this.userService.showAddress(addressId);
        map.put("address",address);
        return "chadd";
    }
    @RequestMapping(value = "/updateAddressSubmit",method = GET)
    public String updateAddressSubmit(Address address,Model model){
        Map<String,Object> map=new HashMap<>();
        List<Address> addressList=this.userService.updateAddress(address);
        map.put("addressList",addressList);
        model.addAllAttributes(map);
        return "address";
    }
    @RequestMapping(value = "/deleteAddressSubmit",method = GET)
    public String removeAddressSubmit(int addressId,Model model){
        Map<String,Object> map=new HashMap<>();
        List<Address> addressList=this.userService.deleteAddress(addressId);
        map.put("addressList",addressList);
        model.addAllAttributes(map);
        return "address";
    }


}
