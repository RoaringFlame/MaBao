package com.mabao.repository;

import com.mabao.pojo.GoodsBrand;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 品牌
 */
@Repository
public interface GoodsBrandRepository extends BaseRepository<GoodsBrand> {
    /**
     * 获取启用的品牌
     * @param status            是否启用
     * @return                  品牌list
     */
    List<GoodsBrand> findByStatus(Boolean status);
}
