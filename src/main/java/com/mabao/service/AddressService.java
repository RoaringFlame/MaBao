package com.mabao.service;

import com.mabao.pojo.Address;

import java.util.List;

/**
 * 地址业务接口
 * Created by jackie on 2016/07/06.
 */
public interface AddressService {
    /**
     * 寄售
     * (添加售货地址)
     * @param address               地址对象，需包含用户ID
     * @return                      收货地址
     */
    Address addReceiptPlace(Address address);
    /**
     * 查默认收货地址
     * @param userId          用户ID
     * @return                地址对象
     */
    Address getDefaultAddress(int userId);

    /**
     * 显示当前用户的所有收货地址
     * @return
     */
    List<Address> findAllAddress(int userId);
    /**
     * 新增收货地址
     * @param address       地址对象
     * @return              新增的地址对象
     */
    Address addAddress(Address address);
    /**
     * 更改选中收货地址
     * @param address
     * @return
     */
    Address updateAddress(Address address);
    /**
     * 删除收货地址
     * @param addressId
     * @return
     */
    Address deleteAddress(int addressId);
}
