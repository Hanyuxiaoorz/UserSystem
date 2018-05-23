package com.mis.user.backstagemanagement.model;

import java.util.List;

/*
* 分页实体类
* @author:Dengsiyuan
* @Date2018年04月25日
* */

public class PageBean<T> {

    private int currPage;//当前页数
    private int PageSize;//每页显示的页数
    private int totalCount;//总记录数
    private int totalPage;//总页数
    private List<T>lists;//每页显示的数据

    public PageBean(){
        super();
    }

    public int getCurrPage(){
        return currPage;
    }

    public void setCurrPage(int currPage) {
        this.currPage = currPage;
    }

    public int getPageSize() {
        return PageSize;
    }

    public void setPageSize(int pageSize) {
        PageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getLists() {
        return lists;
    }

    public void setLists(List<T> lists) {
        this.lists = lists;
    }
}
