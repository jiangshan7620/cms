package com.cms.service;

import com.cms.dao.NewsDao;
import com.cms.dao.UserDao;
import com.cms.po.News;
import com.cms.po.NewsType;
import com.cms.po.PageBean;
import com.cms.po.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: Mr.shan
 * @date: 2022/8/6 10:33
 * @bz:
 */

public class NewsService {

    public Map<Integer, String> getClassmap() {
        NewsDao newsDao = new NewsDao();
        List<NewsType>newsTypes=newsDao.getNewsType();
        HashMap<Integer, String> map = new HashMap<>();
       for (NewsType n:newsTypes){
           map.put(n.getId(),n.getTypeName());
       }
       return map;

    }

    public Map<Integer,String> getStatemap(){
        HashMap<Integer, String> map = new HashMap<>();

        map.put(1,"未审核");
        map.put(2,"未通过");
        map.put(3,"已通过");
        return map;

    }

    public PageBean<News> getPageBean(News news, int pageNow, int pageSize, User user) {

        NewsDao newsDao = new NewsDao();

        PageBean<News> pageBean = new PageBean<>();
        pageBean.setPageSize(pageSize);
//        pageBean.setPageNow(pageNow);
        int rowCount=newsDao.getRowCount(news,pageNow,pageSize,user);
        pageBean.setRowCount(rowCount);
        int total=pageBean.getPageCount();
        if (pageNow>total){
            pageNow = total;
        }
        if (pageNow<1){
            pageNow=1;
        }

        pageBean.setPageNow(pageNow);
        int pageNowsj=pageBean.getPageNow();

        pageBean.setPageCount(total);

       List<News> list = newsDao.getNewsList(news,pageNowsj,pageSize,user);
        System.out.println("==================newslist 带username的list");
        System.out.println(list);

        pageBean.setNewsList(list);

        return pageBean;


    }

//    public Map<Integer, String> getAllName() {
//        UserDao userDao = new UserDao();
//       return userDao.getAllName();
//    }

    public int getLastID() {
        NewsDao newsDao = new NewsDao();
        return newsDao.getLastID();
    }


    public int addNews(News news) {

        NewsDao newsDao = new NewsDao();
        return newsDao.addNews(news);
    }

    public News getNewsById(int nid) {
        NewsDao newsDao = new NewsDao();
        return newsDao.getNewsById(nid);
    }

    public int modNews(News news) {
        NewsDao newsDao = new NewsDao();
        return newsDao.modNews(news);
    }

    public int delNewsById(int id) {
        NewsDao newsDao = new NewsDao();
     return newsDao.delNewsById(id);
    }

    public int findNewsByUid(int uid) {
        NewsDao newsDao = new NewsDao();
        return newsDao.findNewsByUid(uid);
    }

    public int setState(int state,int id) {
        NewsDao newsDao = new NewsDao();
       return newsDao.setState(state,id);
    }

    public int getStateById(int id) {
        NewsDao newsDao = new NewsDao();
       return newsDao.getStateById(id);
    }

    public boolean findNewsByTypeid(int tid) {
        NewsDao newsDao = new NewsDao();
        return newsDao.findNewsByTypeid( tid);
    }

    public List<News> getNewsByTypeid(int i) {
        NewsDao newsDao = new NewsDao();
      return   newsDao.getNewsByTypeId(i);
    }


    public int findNewsByTitle(int uid, String title) {
        NewsDao newsDao = new NewsDao();
        return newsDao.findNewsByTitle(uid,title);
    }

    public int checkNewsMod(News news) {
        NewsDao newsDao = new NewsDao();
        return newsDao.checkModNews(news);
    }

    public int findFlagByNewsid(int mid) {
        NewsDao newsDao = new NewsDao();
      return   newsDao.findFlagByNewsid( mid);
    }
}
