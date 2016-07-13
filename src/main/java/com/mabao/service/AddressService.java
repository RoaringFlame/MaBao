package com.mabao.service;

import com.mabao.pojo.Address;

import java.util.List;

/**
 * 地址业务接口
 * Created by jackie on 2016/07/06.
 */
public interface AddressService {
    /**
     * 查默认收货地址
     * @param userId          用户ID
     * @return                地址对象
     */
    Address getDefaultAddress(Long userId);

    /**
     * 显示当前用户的所有收货地址
     * @return                地址对象List
     */
    List<Address> findAllAddress(Long userId);
    /**
     * 新增收货地址
     * @param address           地址对象
     * @return                  新增的地址对象
     */
    Address addAddress(Address address);
    /**
     * 更改选中收货地址
     * @param address           地址对象
     * @return                  地址对象
     */
    Address updateAddress(Address address);
    /**
     * 删除收货地址
     * @param addressId         地址id
     */
    void deleteAddress(Long addressId);

    /**
     * 依据ID获取地址
     * @param addressId         地址id
     * @return                  地址对象
     */
    Address get(Long addressId);
}
