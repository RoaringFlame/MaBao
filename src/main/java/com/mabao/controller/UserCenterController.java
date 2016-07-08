package com.mabao.controller;

import com.mabao.pojo.Address;
import com.mabao.pojo.Baby;
import com.mabao.pojo.User;
import com.mabao.service.AddressService;
import com.mabao.service.BabyService;
import com.mabao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * 用户模块
 * Created by maxu on 2016/7/1.
 */
@Controller
@RequestMapping("/user")
@SessionAttributes("userId")
public class UserCenterController {
    @Autowired
    private AddressService addressService;
    @Autowired
    private BabyService babyService;
    @Autowired
    private UserService userService;

    /**
     * 用户登录
     * @param user              用户对象
     * @param model             用户ID
     * @return                  首页
     */
    @RequestMapping(value ="/login",method = POST)
    public String userLogin(@RequestParam User user, Model model){
        User result = this.userService.findByNameAndPassword(user.getName(),user.getPassword());
        if (result != null){
            model.addAttribute("userId",result.getId());
            return "index";
        }else {
            return "login_failure";
        }
    }


    /**
     * 该用户所有收货地址
     * @param userId                用户ID
     * @param model                 地址list
     * @return                      收货地址页
     */
    @RequestMapping(value ="/address/allAddress",method = GET)
    public String allAddress(Long userId,Model model){
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
    @RequestMapping(value = "/address/deleteAddress",method = GET)
    public String removeAddress(Long addressId){
        this.addressService.deleteAddress(addressId);
        return "redirect:address/allAddress";

    }

    /**
     * 查询某宝宝信息
     * @param babyId                宝宝ID
     * @param model                 宝宝对象
     * @return                      编辑宝宝信息页
     */
    @RequestMapping(value = "baby/showBabyInfo",method = GET)
    public String showBabyInfo(@RequestParam Long babyId,Model model){
        Baby baby =  this.babyService.getOne(babyId);
        if (baby != null){
            model.addAttribute("baby",baby);
            return "redirect:baby/changemsg";
        }else {
            return "baby_show_failure";
        }
    }


    /**
     * 查看某用户宝宝信息
     * @param userId                    用户ID
     * @param model                     宝宝LIST
     * @return                          宝宝信息页
     */
    @RequestMapping(value = "baby/allBabyInfo",method = GET)
    public String findAllBabyInfo(@RequestParam Long userId,Model model){
        List<Baby> babyList =  this.babyService.findBabyByUserId(userId);
        model.addAttribute("babyList",babyList);
        return "redirect:baby/permsg";

    }

    /**
     * 新增宝宝信息
     * @param babyInfo          宝宝对象
     * @param model             用户ID
     * @return                  宝宝列表接口
     */
    @RequestMapping(value = "baby/addBaby",method = POST)
    public String addBabyInfo(@RequestParam Baby babyInfo,Model model){
        Baby baby =  this.babyService.addBaby(babyInfo);
        if (baby != null){
            model.addAttribute("userId",baby.getUser().getId());
            return "redirect:baby/allBabyInfo";//转向查询所有宝宝接口(带用户ID)
        }else {
            return "baby_add_failure";
        }
    }

    /**
     * 编辑宝宝信息
     * @param babyInfo              宝宝对象
     * @return                      宝宝列表接口
     */
    @RequestMapping(value = "baby/updateBabyInfo",method = POST)
    public String updateBabyInfo(@RequestParam Baby babyInfo){
        Baby baby =  this.babyService.updateBabyInfo(babyInfo);
        if (baby != null){
            Long userId = baby.getUser().getId();
            return "redirect:baby/allBabyInfo";//转向查询所有宝宝接口(带用户ID)
        }else {
            return "baby_update_failure";
        }
    }
}
