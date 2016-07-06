package com.mabao.repository;

import com.mabao.pojo.Address;
import com.mabao.repository.custom.AddressRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> ,AddressRepositoryCustom {
}
