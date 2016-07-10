package com.mabao.service;

import com.mabao.pojo.Area;

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
}
