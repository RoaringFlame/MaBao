package com.mabao.controller.vo;

import com.mabao.pojo.Banner;
import com.mabao.pojo.Goods;
import com.mabao.util.VoUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 首页广宝条
 * Created by jackie on 2016/07/09.
 */
public class BannerVO {
    private Long id;                         //广告的id
    private Long goodsId;                    //商品的id
    private String picture;                  //图片
    private String alt;                      //提示
    private Integer sort;                    //排序

    public static BannerVO generateBy(Banner banner){
        BannerVO bannerVO = VoUtil.copyBasic(BannerVO.class, banner);
        assert bannerVO != null;
        bannerVO.setGoodsId(banner.getGoods().getId());
        return bannerVO;
    }
    public static List<BannerVO> generateBy(List<Banner> bannerList){
        List<BannerVO> list=new ArrayList<>();
        for (Banner g : bannerList){
            list.add(generateBy(g));
        }
        return list;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
