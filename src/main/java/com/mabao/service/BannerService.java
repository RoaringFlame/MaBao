package com.mabao.service;

import com.mabao.pojo.Banner;

import java.util.List;

/**
 * 首页广告业务
 * Created by jackie on 2016/07/09.
 */
public interface BannerService {
    /**
     * sort倒序查找启用的广告
     * @param status            是否启用
     * @return                  广告对象list
     */
    List<Banner> findByStatusOrderBySortDesc(boolean status);
}
