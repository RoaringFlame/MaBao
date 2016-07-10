package com.mabao.service.impl;

import com.mabao.pojo.Area;
import com.mabao.repository.AreaRepository;
import com.mabao.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 行政区域业务
 * Created by jackie on 2016/07/10.
 */
@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaRepository areaRepository;

    /**
     * 依据ID获取行政区域
     * @param areaId            id
     * @return                  area对象
     */
    @Override
    public Area get(Long areaId) {
        return this.areaRepository.findOne(areaId);
    }
}
