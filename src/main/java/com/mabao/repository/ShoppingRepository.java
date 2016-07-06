package com.mabao.repository;

import com.mabao.pojo.Shopping;
import com.mabao.repository.custom.ShoppingRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingRepository extends JpaRepository<Shopping,Long>,ShoppingRepositoryCustom {

}
