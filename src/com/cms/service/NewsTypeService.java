package com.cms.service;

import com.cms.dao.NewsDao;
import com.cms.dao.NewsTypeDao;
import com.cms.po.News;
import com.cms.po.NewsType;
import com.cms.po.PageBean;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.org.apache.bcel.internal.generic.RETURN;

import java.util.List;

/**
 * @author: Mr.shan
 * @date: 2022/8/12 16:36
 * @bz:
 */

public class NewsTypeService {
    public static List<News> getList1() {
        NewsTypeDao newsTypeDao = new NewsTypeDao();
        return newsTypeDao.getList1();
    }

    public static List<News> getList2() {
        NewsTypeDao newsTypeDao = new NewsTypeDao();
        return newsTypeDao.getList2();
    }
    public static List<News> getList3() {
        NewsTypeDao newsTypeDao = new NewsTypeDao();
        return newsTypeDao.getList3();
    }
    public static List<News> getList4() {
        NewsTypeDao newsTypeDao = new NewsTypeDao();
        return newsTypeDao.getList4();
    }
    public static List<News> getList5() {
        NewsTypeDao newsTypeDao = new NewsTypeDao();
        return newsTypeDao.getList5();
    }

    public static List<News> getList6() {
        NewsTypeDao newsTypeDao = new NewsTypeDao();
        return newsTypeDao.getList6();
    }

    public static List<News> getList7() {
        NewsTypeDao newsTypeDao = new NewsTypeDao();
        return newsTypeDao.getList7();
    }


    public static PageBean<News> getPageBean(int pageNow, int pageSize, int i) {
        PageBean<News> pageBean = new PageBean<>();
        NewsTypeDao newsTypeDao = new NewsTypeDao();
        //总记录数
        int rowCount=newsTypeDao.getRowCount(i);
        pageBean.setRowCount(rowCount);
        //一页的记录数
        pageBean.setPageSize(pageSize);
        //总页数
        int total=pageBean.getPageCount();
        pageBean.setPageCount(total);
        //当前页
        if (pageNow>total){
            pageNow=total;
        }else if(pageNow<1){
            pageNow=1;
        }

        pageBean.setPageNow(pageNow);
        //违规改正后的当前页
        int pageNowsj=pageBean.getPageNow();
        //新闻列表
        List<News> list = newsTypeDao.getNewsList(pageNowsj,pageSize,i);
        pageBean.setNewsList(list);

        return pageBean;



    }


    public int getTypeLastId() {
        NewsTypeDao newsTypeDao = new NewsTypeDao();
        return newsTypeDao.getTypeLastId();
    }

    public List<NewsType> getAllType() {
        NewsTypeDao newsTypeDao = new NewsTypeDao();
        return newsTypeDao.getAllType();
    }

    public int modType(int tid, String typeName, int tsort) {
        NewsTypeDao newsTypeDao = new NewsTypeDao();
        return newsTypeDao.modType(tid,typeName,tsort);
    }

    public int delTypeById(int tid) {
        NewsTypeDao newsTypeDao = new NewsTypeDao();
        return newsTypeDao.delTypeById(tid);
    }

    public int insertType(String typeName, int tsort) {
        NewsTypeDao newsTypeDao = new NewsTypeDao();
        return newsTypeDao.insertType(typeName,tsort);
    }

    public int findTypeByName(String typeName) {
        NewsTypeDao newsTypeDao = new NewsTypeDao();
        return newsTypeDao.findTypeByName(typeName);
    }

    public List<NewsType> getTypeList() {
        NewsTypeDao newsTypeDao = new NewsTypeDao();
        return newsTypeDao.getTypeList();
    }

    public String getTypeNameByid(int typeid) {
        NewsTypeDao newsTypeDao = new NewsTypeDao();
        return newsTypeDao.getTypeNameByid( typeid);
    }

    public boolean findTypeSort(int tsort) {
        NewsTypeDao newsTypeDao = new NewsTypeDao();
        return newsTypeDao.findTypeSort(tsort);
    }

    public boolean findTypeSortpl(int tsort, int tid) {
        NewsTypeDao newsTypeDao = new NewsTypeDao();
        return newsTypeDao.findTypeSortpl(tsort,tid);
    }

    public boolean findTypeByNamepl(String typeName, int tid) {
        NewsTypeDao newsTypeDao = new NewsTypeDao();
        return newsTypeDao.findTypeByNamepl(typeName,tid);

    }

    public boolean modPd(String typeName, int tsort) {
        NewsTypeDao newsTypeDao = new NewsTypeDao();
        return newsTypeDao.modPd(typeName, tsort);

    }
}
