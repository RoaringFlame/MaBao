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
    @Query("from Goods g where g.state = 1")
    Page<Goods> findByTime(Pageable pageable);

    Page<Goods> findByState(Boolean state, Pageable pageable);

    @Query("from Goods g where g.state = 1 and g.title like %?1%")
    Page<Goods> findLikeTitle(String title, Pageable pageable);

    @Query("from Goods g where g.state = 1 and g.typeName = ?1")
    Page<Goods> findByTypeName(String typeName, Pageable pageable);


}
