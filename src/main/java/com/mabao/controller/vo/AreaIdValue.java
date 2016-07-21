package com.mabao.controller.vo;

/**
 * 一个区级ID对应的省市区的id
 * Created by jackie on 2016/07/19.
 */
public class AreaIdValue {
    private Long provinceId;                     //省级areaID
    private Long cityId;                         //市级areaID
    private Long countyId;                       //区级areaID

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public Long getCountyId() {
        return countyId;
    }

    public void setCountyId(Long countyId) {
        this.countyId = countyId;
    }
}
