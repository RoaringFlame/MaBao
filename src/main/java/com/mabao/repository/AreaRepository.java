package com.mabao.repository;

import com.mabao.pojo.Area;
import com.mabao.util.Selector;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AreaRepository extends BaseRepository<Area>  {
    /**
     * 获取省
     */
    List<Area> findByLevelType(Integer levelType);
    /**
     * 获取某省下的市
     */
    List<Area> findByLevelTypeAndParentId(int i, Long provinceId);
}
