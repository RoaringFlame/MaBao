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
     * 查某级别下级所有
     * @param i                             级别
     * @param parentsId                    父级ID
     * @return
     */
    List<Area> findByLevelTypeAndParentsAreaId(int i, Long parentsId);
}
