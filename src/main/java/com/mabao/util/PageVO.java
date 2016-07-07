package com.mabao.util;

import java.util.ArrayList;
import java.util.List;

public class PageVO<T> {
    private final static int DEFAULT_CURRENT_PAGE=1;
    private final static int DEFAULT_PAGE_SIZE=5;

    private Integer currentPage;            //当前页面
    private Integer pageSize;               //页面总数
    private Long totalRow;                  //总条数
    private List<T> items;
    public PageVO(){
        this.currentPage=DEFAULT_CURRENT_PAGE;
        this.pageSize=DEFAULT_PAGE_SIZE;
        this.items=new ArrayList<>();
    }
    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Long getTotalRow() {
        return totalRow;
    }

    public void setTotalRow(Long totalRow) {
        this.totalRow = totalRow;
    }
    //计算总页数
    public Integer getTotalPage() {
        if(this.totalRow%this.pageSize==0){
            return Long.valueOf(totalRow/pageSize).intValue();
        }
        else{
            return Long.valueOf(totalRow/pageSize).intValue()+1;
        }
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        if(items!=null) {
            this.items = items;
        }
    }
}
