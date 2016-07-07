package com.mabao.repository;

import com.mabao.pojo.Goods;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsRepository extends BaseRepository<Goods> {
    Page<Goods> findByState(Boolean state, Pageable pageable);
}
