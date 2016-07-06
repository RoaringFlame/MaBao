package com.mabao.service.impl;

import com.mabao.pojo.Address;
import com.mabao.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by maxu on 2016/7/1.
 */
@Service
public class UserServiceImpl implements UserService{
    /**
     * 显示当前用户的所有收货地址
     * @return
     */
    public List<Address> getAllAddress(int userId){
        return null;
    }
    /**
     * 新增收货地址
     * @param address
     * @return
     */
    public List<Address> addAddress(Address address){
        return null;
    }
    /**
     * 显示选中收货地址
     * @param addressId
     * @return
     */
    public Address showAddress(int addressId){
        return null;
    }
    /**
     * 更改选中收货地址
     * @param address
     * @return
     */
    public List<Address> updateAddress(Address address){
        return null;
    }

    /**
     * 删除收货地址
     * @param addressId
     * @return
     */
    public List<Address> deleteAddress(int addressId){
        return null;
    }
}
