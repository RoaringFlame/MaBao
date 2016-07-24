package com.mabao.controller.rest;

import com.mabao.service.AreaService;
import com.mabao.util.Selector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 寄售模块
 * @author jackie
 */
@RestController
public class SellRESTController {
    @Autowired
    private AreaService areaService;

    /**
     * 获取省
     */
    @RequestMapping(value = "/provinces",method = RequestMethod.GET)
    public List<Selector> findProvinces(){
        return this.areaService.findProvinceForSelector();
    }

    /**
     * 获取某省下的市
     */
    @RequestMapping(value = "/province/{provinceId}/allCity",method = RequestMethod.GET)
    public List<Selector> findCityFromProvince(@PathVariable Long provinceId){
        return this.areaService.findCityForSelector(provinceId);
    }

    /**
     * 获取市下的区县
     */
    @RequestMapping(value = "/city/{cityId}/allCounty",method = RequestMethod.GET)
    public List<Selector> findCountyFromCity(@PathVariable Long cityId){
        return this.areaService.findCountyForSelector(cityId);
    }

}

