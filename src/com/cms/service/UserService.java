package com.cms.service;

import com.cms.dao.UserDao;
import com.cms.po.PageBean;
import com.cms.po.User;

import java.util.Map;

/**
 * @author: Mr.shan
 * @date: 2022/8/3 9:04
 * @bz:
 */

public class UserService {
    UserDao userDao = new UserDao();
    public User checkUser(User user) {

        return userDao.checkUser(user);
    }


    public PageBean<User> getPageBean(User u, int pageNow, int pageSize) {
        PageBean<User> pageBean = new PageBean<>();


        pageBean.setPageSize(pageSize);
       pageBean.setRowCount(userDao.getRowCount(u));


       int total=pageBean.getPageCount();
//       ============================
       if (pageNow>total){
           pageNow=total;
       }
       if(pageNow<1){
           pageNow=1;
       }
//       ==========================
        pageBean.setPageNow(pageNow);
//      如果pageNow>pageCount,则pageNow=pageCount
       int pageNowsj=pageBean.getPageNow();
//===================
        pageBean.setUserList(userDao.getUserList(u,pageNowsj,pageSize));
       pageBean.setPageCount(total);
       return pageBean;

    }


    public boolean addUser(User user) {
        boolean b=false;
        UserDao userDao = new UserDao();
         b=userDao.addUser(user);
         return b;
    }

    public boolean findUserByName(String username) {
        boolean b=false;
        UserDao userDao = new UserDao();
      b=  userDao.findUserByName(username);
      return b;
    }


    public int delUserById(int uid) {

        UserDao userDao = new UserDao();
        return userDao.delUserById(uid);

    }

    public boolean modifyUser(User user) {
        UserDao userDao = new UserDao();
      return userDao.modifyUserByID(user);
    }

    public User findUserByID(int uid) {
        UserDao userDao = new UserDao();
       return userDao.findUserByID(uid);
    }

    public int getLastID() {
        UserDao userDao = new UserDao();
        return userDao.getLastID();
    }

    public boolean findUserByDid(int did) {
        UserDao userDao = new UserDao();
        return userDao.findUserByDid(did);
    }

    public Map getSexMap() {
        UserDao userDao = new UserDao();
        return userDao.getSexMap();
    }
}
