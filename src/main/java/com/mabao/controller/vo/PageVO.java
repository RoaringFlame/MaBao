package com.mabao.controller.vo;

import java.util.List;

/**
 * 分页通用VO
 * Created by liuming on 2016/6/30.
 */
public class PageVO<T> {
    private Integer currentPage;
    private Integer pageSize;
    private Long totalCount;
    private List<T> items;

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

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}
