package com.mabao.service.impl;

import com.mabao.pojo.Area;
import com.mabao.repository.AreaRepository;
import com.mabao.service.AreaService;
import com.mabao.util.Selector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    /**
     * 获取省
     */
    @Override
    public List<Selector> findProvinceForSelector() {
        List<Area> areas = this.areaRepository.findByLevelType(1);
        List<Selector> selectors = new ArrayList<>();
        for (Area area : areas){
            selectors.add(new Selector(area.getId().toString(),area.getShortName()));
        }
        return selectors;
    }

    /**
     * 获取某省下的市
     */
    @Override
    public List<Selector> findCityForSelector(Long provinceId) {
        List<Area> areas = this.areaRepository.findByLevelTypeAndParentId(2,provinceId);
        List<Selector> selectors = new ArrayList<>();
        for (Area area : areas){
            selectors.add(new Selector(area.getId().toString(),area.getShortName()));
        }
        return selectors;
    }
    /**
     * 获取市下的区县
     */
    @Override
    public List<Selector> findCountyForSelector(Long cityId) {
        List<Area> areas = this.areaRepository.findByLevelTypeAndParentId(3,cityId);
        List<Selector> selectors = new ArrayList<>();
        for (Area area : areas){
            selectors.add(new Selector(area.getId().toString(),area.getShortName()));
        }
        return selectors;
    }
}
