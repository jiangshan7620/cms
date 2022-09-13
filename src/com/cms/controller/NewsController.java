package com.cms.controller;

import com.cms.po.News;
import com.cms.po.PageBean;
import com.cms.po.User;
import com.cms.service.NewsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.beans.Encoder;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@WebServlet( "/NewsController")
public class NewsController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String flag = request.getParameter("flag");

        System.out.println("===========flag============");
        System.out.println(flag);
        if ("newsList".equals(flag)){
            newsList(request,response);
        }else if ("toAddNews".equals(flag)){
            toAddNews(request,response);
        }else if("addNews".equals(flag)){
            addNews(request,response);
        }else if("toModifyNews".equals(flag)){
            toModifyNews(request,response);
        }else if("modNews".equals(flag)){
            modNews(request,response);
        }else if("delNews".equals(flag)){
            delNews(request,response);
        }

    }

    private void delNews(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String selclass = request.getParameter("selclass");

        System.out.println("del    selclass---------");
        System.out.println(selclass);
        String selstate = request.getParameter("selstate");
        String seltitle = request.getParameter("seltitle");
        String[] boxes = request.getParameterValues("checkbox");
        String pageNow = request.getParameter("pageNow");
//        String state = request.getParameter("state");
//        System.out.println("==========打印state");
//        System.out.println(state);

        NewsService newsService = new NewsService();
        int sum=0;
        int id=0;

        if (boxes!=null){
            for (String s:boxes){
                id=Integer.parseInt(s);

                //根据id找state状态
                int m=newsService.getStateById(id);
                System.out.println("===========m的值======");
                System.out.println(m);



                if (m!=3){
                    newsService.delNewsById(id);
                }
            }
        }

        response.sendRedirect("NewsController?flag=newsList&seltitle="+URLEncoder.encode(seltitle,"utf-8")+"&selclass="+ selclass +"&selstate="+selstate+"&pageNow="+pageNow);






    }

    private void modNews(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接收参数4个（title,content,typeid,flag）剩余3个（id,uid,createtime）
        String title = request.getParameter("title");

        String content = request.getParameter("content");



        String typeid = request.getParameter("typeid");

        String f = request.getParameter("f");


        String id = request.getParameter("id");




        boolean b=true;
//        if (f==null||"-1".equals(f)){
//            b=false;
//        }
//
//        System.out.println("1"+b);
        //===================冻结状态肯定是空，所以不需要判断f
        if (title==null||"".equals(title.trim())){
            b=false;
        }

        if (typeid==null||"".equals(typeid.trim())||"-1".equals(typeid)){
            b=false;
        }
        if (content==null||"".equals(content.trim())){
            b=false;
        }
        System.out.println("==========b");
        System.out.println(b);



        if (!b){
            request.getRequestDispatcher("NewsController?flag=toModifyNews").forward(request,response);
            return;
        }


        NewsService newsService = new NewsService();

        HttpSession session = request.getSession();
        User user=(User)session.getAttribute("user");

        News news = new News();

        if (id!=null){
            news.setId(Integer.parseInt(id));
        }

       news.setContent(content);
        if (f!=null){
            news.setFlag(Integer.parseInt(f));
        }

        news.setTitle(title);

        if (typeid!=null){
            news.setTypeid(Integer.parseInt(typeid));//list超级管理员审核状态怎么传参存数据到数据库

        }
        System.out.println("==============news===========");
        System.out.println(news);




          int i=newsService.modNews(news);



        System.out.println("=============i==========");
        System.out.println(i);
        if (i>=1){
            request.getRequestDispatcher("NewsController?flag=newsList").forward(request,response);
        }else{
            request.getRequestDispatcher("NewsController?flag=toModifyNews").forward(request,response);
        }


    }


    private void toModifyNews(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        HttpSession session = request.getSession();
        User user=(User)session.getAttribute("user");


        //接收url上的参数
        String id = request.getParameter("id");
        String selclass = request.getParameter("selclass");
        String selstate = request.getParameter("selstate");
        String seltitle = request.getParameter("seltitle");

        int uid=0;
        if (id!=null&&!"".equals(id)){
            uid=Integer.parseInt(id);
        }



        News news=null;
        NewsService newsService = new NewsService();

            //通过id找数据库
             news=newsService.getNewsById(uid);





        System.out.println("==========news========");
        System.out.println(news);



        request.setAttribute("news",news);
        Map<Integer, String> classmap = newsService.getClassmap();
        Map<Integer, String> statemap = newsService.getStatemap();
        request.setAttribute("classMap",classmap);
        request.setAttribute("stateMap",statemap);

        request.getRequestDispatcher("view/modNews.jsp").forward(request,response);



    }


    private void addNews(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接收参数（类别，标题，内容）
        String typeid = request.getParameter("typeid");
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        boolean flag=true;
        if (title==null||"".equals(title.trim())){
            flag=false;
        }
        if (typeid==null||"-1".equals(typeid.trim())){
            flag=false;
        }

        if (!flag){
            request.getRequestDispatcher("NewsController?flag=toAddNews").forward(request,response);
            return;
        }


        //封装news(id,title,content,typeid,flag,createtime,uid)
        News news = new News();
        if (!"-1".equals(typeid)&&typeid!=null){
            news.setTypeid(Integer.parseInt(typeid));
        }
        if (title!=null&&!"".equals(title.trim())){
            news.setTitle(title);
        }
        if (content!=null&&!"".equals(content.trim())){
            news.setContent(content);
        }
        news.setFlag(1);//默认第一次上传是未审核
        //获取实时时间
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();

        System.out.println("Current time"+sdf.format(date));
        news.setCreatetime(sdf.format(date));

        //获取uid
        HttpSession session = request.getSession();
       User user= (User)session.getAttribute("user");
        System.out.println("===========uid=========");
        System.out.println(user.getId());

       news.setUid(user.getId());


        NewsService newsService = new NewsService();
        int i=newsService.addNews(news);

        if (i>=1){
            request.getRequestDispatcher("NewsController?flag=newsList").forward(request,response);
        }else{
            request.getRequestDispatcher("NewsController?flag=toAddNews").forward(request,response);
        }


    }

    private void toAddNews(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        HttpSession session = request.getSession();
        User user= (User)session.getAttribute("user");

        NewsService newsService = new NewsService();

        int lid=newsService.getLastID();
        Map<Integer, String> map = newsService.getClassmap();
        request.setAttribute("lid",lid);
        request.setAttribute("classMap",map);
        request.getRequestDispatcher("view/addNews.jsp").forward(request,response);

    }

    private void newsList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //1.接收参数
        String selclass = request.getParameter("selclass");



        System.out.println("====selclass========");
        System.out.println(selclass);

        String selstate = request.getParameter("selstate");

        System.out.println("=============selstate=========");
        System.out.println(selstate);

        String seltitle = request.getParameter("seltitle");
        System.out.println("============seltitle===========");
        System.out.println(seltitle);

        //2.封装参数
        News news = new News();
        if (selclass!=null&&!"".equals(selclass)&&!"-1".equals(selclass)){
            news.setTypeid(Integer.parseInt(selclass));
        }
        if (selstate!=null&&!"".equals(selstate)&&!"-1".equals(selstate)){
            news.setFlag(Integer.parseInt(selstate));
        }
        if (seltitle!=null&&!"".equals(seltitle)){
            news.setTitle(seltitle);
        }

        System.out.println("============news数组===");
        System.out.println(news);

        //3.得到pageBean
        //判断pageNow
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

        int pageSize=10;
        NewsService newsService = new NewsService();
        HttpSession session = request.getSession();
        User user=(User)session.getAttribute("user");
        System.out.println("========user======");
        System.out.println(user);

        PageBean<News>pageBean= newsService.getPageBean(news,pageNow,pageSize,user);

        System.out.println(pageBean);

        Map<Integer,String>classMap=newsService.getClassmap();


        Map<Integer,String>stateMap=newsService.getStatemap();
        System.out.println("=========statemap=======");
        System.out.println(stateMap);

//        Map<Integer,String> map= newsService.getAllName();


//        request.setAttribute("nameMap",map);
        request.setAttribute("classMap",classMap);//map对应
        request.setAttribute("stateMap",stateMap);//map对应
        request.setAttribute("sel",news);//将搜索的三项存到请求域
        request.setAttribute("pageBean",pageBean);


        request.getRequestDispatcher("view/news.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           doPost(request, response);
    }
}
