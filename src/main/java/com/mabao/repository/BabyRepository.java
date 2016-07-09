package com.mabao.repository;

import com.mabao.pojo.Baby;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BabyRepository extends BaseRepository<Baby> {
    /**
     * 查看某用户宝宝信息
     * @param userId                    用户ID
     * @return                          宝宝list
     */
    List<Baby> findByUserId(Long userId);
}
