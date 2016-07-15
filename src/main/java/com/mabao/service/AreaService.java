package com.mabao.service;

import com.mabao.pojo.Area;
import com.mabao.util.Selector;

import java.util.List;

/**
 * 行政区域业务接口
 * Created by jackie on 2016/07/06.
 */
public interface AreaService {

    /**
     * 依据ID获取行政区域
     * @param areaId            id
     * @return                  area对象
     */
    Area get(Long areaId);

    /**
     * 获取省
     */
    List<Selector> findProvinceForSelector();

    /**
     * 获取某省下的市
     */
    List<Selector> findCityForSelector(Long provinceId);
    /**
     * 获取市下的区县
     */
    List<Selector> findCountyForSelector(Long cityId);
}
