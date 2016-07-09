package com.mabao.service.impl;

import com.mabao.pojo.Banner;
import com.mabao.repository.BannerRepository;
import com.mabao.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 首页广告业务
 * Created by jackie on 2016/07/09.
 */
@Service
public class BannerServiceImpl implements BannerService{
    @Autowired
    private BannerRepository bannerRepository;

    /**
     * sort倒序查找启用的广告
     * @param status            是否启用
     * @return                  广告对象list
     */
   public List<Banner> findByStatusOrderBySortDesc(boolean status){
       return this.bannerRepository.findByStatusOrderBySortDesc(status);
   }
}
