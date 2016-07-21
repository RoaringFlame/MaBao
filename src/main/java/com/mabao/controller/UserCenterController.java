package com.mabao.controller;

import com.mabao.controller.vo.AddressVO;
import com.mabao.controller.vo.BabyVO;
import com.mabao.controller.vo.UserInfoVO;
import com.mabao.pojo.Address;
import com.mabao.pojo.Baby;
import com.mabao.pojo.User;
import com.mabao.service.AddressService;
import com.mabao.service.BabyService;
import com.mabao.service.UserService;
import com.mabao.util.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * 用户模块
 */
@Controller
@RequestMapping("/user")
public class UserCenterController {
    @Autowired
    private AddressService addressService;
    @Autowired
    private BabyService babyService;
    @Autowired
    private UserService userService;

    /**
     * 个人中心，获取登录用户的基本信息
     * @param model               UserInfoVO
     * @return                    personal页
     */
    @RequestMapping(method = GET)
    public String userCenter(Model model){
        User user = UserManager.getUser();
        if (user != null) {
            UserInfoVO vo = new UserInfoVO();
            vo.setBabyId(null);
            vo.setBabyName(null);
            List<Baby> babyList = this.babyService.findBabyByUserId(user.getId());
            if (babyList !=null){
               Baby baby = babyList.get(0);
                vo.setBabyId(baby.getId());
                vo.setBabyName(baby.getName());
            }
            vo.setUserId(user.getId());
            vo.setUserName(user.getName());
            vo.setUserPicture(user.getPicture());
            model.addAttribute("userInfo", vo);
            return "personal";
        }else {
            return "login";
        }
    }

    /**
     * 该用户所有收货地址
     * @param model                 地址list
     * @return                      收货地址页
     */
    @RequestMapping(value ="/address/userAllAddress",method = GET)
    public String userAllAddress(Model model){
        User user = UserManager.getUser();
        if (user != null) {
            List<Address> addressList = this.addressService.findUserAllAddress(user.getId());
            model.addAttribute("addressList", addressList);
            return "address";
        }else {
            return "login";
        }
    }

    /**
     * 查某个收货地址详情
     * @param addressId             收货地址ID
     * @param model                 地址对象
     * @return                      收货地址页
     */
    @RequestMapping(value ="/address/getAddress",method = GET)
    public String getAddress(Long addressId,Model model){
        Address address=this.addressService.get(addressId);
        model.addAttribute("addressList",address);
        return "address";
    }

    /**
     * 添加收货地址
     * @param addressVO             地址VO
     * @return                      地址页
     */
    @RequestMapping(value ="/address/addAddress",method = POST)
    public String addAddress(AddressVO addressVO){
        Address result = this.addressService.addAddress(addressVO);
        if (result != null){
            return "redirect:userAllAddress";
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
    public String updateAddress(Address address, Model model){
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
    /*@RequestMapping(value = "baby/showBabyInfo",method = GET)
    public String showBabyInfo(@RequestParam Long babyId,Model model){
        Baby baby =  this.babyService.get(babyId);
        if (baby != null){
            model.addAttribute("baby",baby);
            return "redirect:baby/changemsg";
        }else {
            return "baby_show_failure";
        }
    }*/

    /**
     * 查看某用户宝宝信息
     * @param model                     宝宝
     * @return                          无宝宝，到新增页；有宝宝，到修改页
     */
    @RequestMapping(value = "baby/allBabyInfo",method = GET)
    public String findAllBabyInfo(Model model){
        User user = UserManager.getUser();
        if (user != null) {
            List<Baby> babyList = this.babyService.findBabyByUserId(user.getId());
            if (babyList !=null){
                Baby baby = babyList.get(0);
                model.addAttribute("baby", baby);
                return "changemsg";
            }else {
                return "permsg";
            }
        }else {
            return "login";
        }
    }

    /**
     * 新增宝宝信息
     * @param babyInfo          宝宝对象
     * @param model             用户ID
     * @return                  宝宝列表接口
     */
    @RequestMapping(value = "baby/addBaby",method = POST)
    public String addBabyInfo(BabyVO babyInfo, Model model){
        Baby baby =  this.babyService.addBaby(babyInfo);
        if (baby != null){
            return "redirect:user";     //转向个人中心
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
    public String updateBabyInfo(Baby babyInfo){
        Baby baby =  this.babyService.updateBabyInfo(babyInfo);
        if (baby != null){
            return "redirect:user";     //转向个人中心
        }else {
            return "baby_update_failure";
        }
    }

}
