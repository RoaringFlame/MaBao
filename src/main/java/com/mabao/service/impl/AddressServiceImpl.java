package com.mabao.service.impl;

import com.mabao.pojo.Address;
import com.mabao.repository.AddressRepository;
import com.mabao.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 地址业务
 * Created by jackie on 2016/07/06.
 */
@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepository addressRepository;

    /**
     * 寄售
     * (添加售货地址)
     * @param address               地址对象，需包含用户ID
     * @return                      收货地址
     */
    public Address addReceiptPlace(Address address){
        address.setState(false);
        return this.addressRepository.save(address);
    }
    /**
     * 查默认收货地址
     * @param userId          用户ID
     * @return                地址对象
     */
    @Override
    public Address getDefaultAddress(int userId) {
        return null;
    }

    /**
     * 显示当前用户的所有收货地址
     * @return                  地址list
     */
    public List<Address> findAllAddress(int userId){
        return null;
    }
    /**
     * 新增收货地址
     * @param address           地址对象
     * @return                  新增地址对象
     */
    public Address addAddress(Address address){
        return null;
    }
    /**
     * 显示选中收货地址
     * @param addressId         地址ID
     * @return                  地址对象
     */
    public Address getOne(int addressId){
        return null;
    }
    /**
     * 更改选中收货地址
     * @param address           地址对象
     * @return                  修改的地址对象
     */
    public Address updateAddress(Address address){
        return null;
    }

    /**
     * 删除收货地址
     * @param addressId         地址ID
     * @return                  地址对象
     */
    public Address deleteAddress(int addressId){
        return null;
    }
}
