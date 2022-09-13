package com.cms.controller;

import com.cms.po.News;
import com.cms.po.NewsType;
import com.cms.po.PageBean;
import com.cms.po.User;
import com.cms.service.NewsService;
import com.cms.service.NewsTypeService;
import com.cms.service.UserService;
import jdk.nashorn.internal.ir.CallNode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet( "/newstype")
public class NewsTypeController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        String flag = request.getParameter("flag");
        if ("newstypelist".equals(flag)){
           newstypelist(request,response);
        }else if("title".equals(flag)){
            titlelist(request,response);
        }else if("newsContent".equals(flag)){
            newsContent(request,response);
        }

    }

    private void newsContent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id=request.getParameter("id");
        int i=0;
        if (id!=null&&!"".equals(id)){
            i=Integer.parseInt(id);
        }
        NewsService newsService = new NewsService();
        News news=newsService.getNewsById(i);
        int uid = news.getUid();
        int typeid = news.getTypeid();

        UserService userService = new UserService();
        User user = userService.findUserByID(uid);

        NewsTypeService newsTypeService = new NewsTypeService();
     String name=  newsTypeService.getTypeNameByid(typeid);

     request.getSession().setAttribute("tn",name);

        request.getSession().setAttribute("uu",user);

        request.getSession().setAttribute("n",news);
        request.getRequestDispatcher("view/third.jsp").forward(request,response);
    }

    private void titlelist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String typeid = request.getParameter("typeid");
        //i是typeid，通过审核的新闻flag=3
        int i=0;
        if (typeid!=null&&!"".equals(typeid)){
            i=Integer.parseInt(typeid);
        }
        NewsService newsService = new NewsService();

        //根据新闻类型id找到通过审核的所有新闻
        List<News> list = newsService.getNewsByTypeid(i);
//        request.getSession().setAttribute("tl2",list);
        NewsTypeService newsTypeService = new NewsTypeService();

        //========================
        //分页
        //1.判断pageNow
        int pageNow=1;
        if (request.getParameter("pageNow")!=null&&!"".equals(request.getParameter("pageNow").trim())){
            try {
                pageNow=Integer.parseInt(request.getParameter("pageNow"));


            } catch (NumberFormatException e) {
                pageNow=1;
            }
        } else{
            pageNow=1;
        }

        //2.得到pageBean
        int pageSize=10;
       PageBean<News> pageBean = NewsTypeService.getPageBean(pageNow,pageSize,i);
       request.getSession().setAttribute("pb",pageBean);

//=========================================
        //根据新闻类型id找类名
        String name=  newsTypeService.getTypeNameByid(i);

        request.getSession().setAttribute("tin",name);
        request.getSession().setAttribute("i",i);



        request.getRequestDispatcher("view/erjiye.jsp").forward(request,response);

    }

    private void newstypelist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ceshishsishis");
        NewsTypeService newsTypeService = new NewsTypeService();
        List<NewsType> list=newsTypeService.getTypeList();


        System.out.println("========list=========");
        request.getSession().setAttribute("tl",list);


        List<News> list1=NewsTypeService.getList1();  //5个新闻的集合
       List<News> list2=NewsTypeService.getList2();
       List<News> list3=NewsTypeService.getList3();
       List<News> list4=NewsTypeService.getList4();
       List<News> list5=NewsTypeService.getList5();
       List<News> list6=NewsTypeService.getList6();
       List<News> list7=NewsTypeService.getList7();


        HashMap<Integer,List> map = new HashMap<>();
        map.put(1,list1);
        map.put(2,list2);
        map.put(3,list3);
        map.put(4,list4);
        map.put(5,list5);
        map.put(15,list6);
        map.put(12,list7);
        request.getSession().setAttribute("titlemap",map);





        request.getRequestDispatcher("view/view.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
