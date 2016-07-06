package com.mabao.service;

import com.mabao.pojo.Address;

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
}
