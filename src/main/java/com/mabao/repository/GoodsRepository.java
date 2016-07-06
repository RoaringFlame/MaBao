package com.mabao.repository;

import com.mabao.pojo.Goods;
import com.mabao.repository.custom.GoodsRepositoryCustom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsRepository extends JpaRepository<Goods,Long>,GoodsRepositoryCustom {
    Page<Goods> findByState(Boolean state, Pageable pageable);
}
