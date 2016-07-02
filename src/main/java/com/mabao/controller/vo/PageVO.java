package com.mabao.controller.vo;

import java.util.List;

/**
 * Created by lies on 2016/6/30.
 */
public class PageVO<GoodsVO> {
    private Integer currentPage;//当前页面
    private Integer pageSize;//页面总数
    private Long totalCount;//总条数
    private List<GoodsVO> items;

    public Integer getCurrentPage() {
        return currentPage;
    }
    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }
    public Integer getPageSize() {
        return pageSize;
    }
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
    public Integer getTotalPage() {
        //得到总页数
        if(this.totalCount%this.pageSize==0){
            return Long.valueOf(this.totalCount / this.pageSize).intValue();
        }
        else{
            return Long.valueOf(this.totalCount/this.pageSize).intValue()+1;
        }
    }
    public Long getTotalCount() {
        return totalCount;
    }
    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }
    public List<GoodsVO> getItems() {
        return items;
    }
    public void setItems(List<GoodsVO> items) {
        this.items = items;
    }
}
