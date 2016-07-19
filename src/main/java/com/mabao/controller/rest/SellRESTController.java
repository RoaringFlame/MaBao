package com.mabao.controller.rest;

import com.mabao.controller.vo.AreaIdValue;
import com.mabao.service.AreaService;
import com.mabao.util.Selector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


    /**
     * 通过areaID获取对应省市区
     * @param areaId                            区级areaId
     */
    @RequestMapping(value = "/getProvinceCityCounty",method = RequestMethod.GET)
    public AreaIdValue findEachAreaValueByAreaId(@RequestParam Long areaId){
        return this.areaService.findEachAreaValueByAreaId(areaId);
    }

}

