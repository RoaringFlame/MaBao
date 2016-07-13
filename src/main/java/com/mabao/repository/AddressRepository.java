package com.mabao.repository;

import com.mabao.pojo.Address;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends BaseRepository<Address>  {
    /**
     * 查默认收货地址
     */
    Address findByUserIdAndState(Long userId, boolean b);
}
