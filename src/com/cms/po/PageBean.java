package com.cms.po;

import java.util.Arrays;
import java.util.List;

/**
 * @author: Mr.shan
 * @date: 2022/8/3 8:39
 * @bz:
 */

public class PageBean<T> {
    //当前页码
    private int pageNow;
    //每页显示记录数
    private int pageSize;
    //总记录数
    private int rowCount;
    //总页数
    private int pageCount;
    //列表
    private List<T> userList;

    private List<T> newsList;


    //分页
    private int[] pages;


    public int getPageNow() {
        return pageNow;
    }

    public void setPageNow(int pageNow) {

        this.pageNow = pageNow;

    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    public int getPageCount() {
        if (rowCount % pageSize == 0) {
            pageCount = rowCount / pageSize;
        } else {
            pageCount = rowCount / pageSize + 1;

        }
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public List<T> getUserList() {
        return userList;
    }


    public void setUserList(List<T> userList) {
        this.userList = userList;
    }


    public List<T> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<T> newsList) {
        this.newsList = newsList;
    }

    //分页算法

    public int[] getPages() {
        int pageNow = Math.min(getPageNow(), getPageCount());
        int pageCount = getPageCount();

        int begin = 1;
        int end = 1;

        if (pageNow < 6) {

            end = Math.min(pageCount, 10);
        } else {
            begin = Math.min(pageNow - 5, pageCount - 9);
            end = Math.min(pageNow + 4, pageCount);
        }
        begin = Math.max(1, begin);

        int y = 0;
        int[] pages = new int[end - begin + 1];
        for (int i = begin; i <= end; i++) {
            pages[y] = i;
            y++;
        }
        return pages;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "pageNow=" + pageNow +
                ", pageSize=" + pageSize +
                ", rowCount=" + rowCount +
                ", pageCount=" + pageCount +
                ", userList=" + userList +
                ", newsList=" + newsList +

                '}';
    }
}
