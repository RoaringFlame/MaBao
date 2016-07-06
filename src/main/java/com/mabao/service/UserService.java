package com.mabao.service;

import com.mabao.pojo.Address;

import java.util.List;

/**
 * Created by maxu on 2016/7/1.
 */
public interface UserService {
    /**
     * 显示当前用户的所有收货地址
     * @return
     */
    public List<Address> getAllAddress(int userId);
    /**
     * 新增收货地址
     * @param address
     * @return
     */
    public List<Address> addAddress(Address address);
    /**
     * 显示选中收货地址
     * @param addressId
     * @return
     */
    public Address showAddress(int addressId);
    /**
     * 更改选中收货地址
     * @param address
     * @return
     */
    public List<Address> updateAddress(Address address);
    /**
     * 删除收货地址
     * @param addressId
     * @return
     */
    public List<Address> deleteAddress(int addressId);
}
