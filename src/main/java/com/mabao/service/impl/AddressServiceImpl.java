package com.mabao.service.impl;

import com.mabao.pojo.Address;
import com.mabao.repository.AddressRepository;
import com.mabao.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
