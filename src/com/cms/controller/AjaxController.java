package com.cms.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cms.po.Department;
import com.cms.po.News;
import com.cms.po.NewsType;
import com.cms.service.DepService;
import com.cms.service.NewsService;
import com.cms.service.NewsTypeService;
import com.cms.service.UserService;
import com.sun.org.apache.xpath.internal.functions.FuncId;
import jdk.nashorn.internal.ir.CallNode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet( "/ajax")
public class AjaxController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        String flag = request.getParameter("flag");
        System.out.println("===========ajaxflag=======");
        System.out.println(flag);

        if ("checkUserName".equals(flag)){
            checkUserName(request,response);
        }else if ("checkPassword".equals(flag)){
            checkPassword(request,response);
        }else if ("checkAge".equals(flag)){
            checkAge(request,response);
        }else if ("checkmodpass".equals(flag)){
            checkmodpass(request,response);
        }else if ("checkmodrepass".equals(flag)){
            checkmodrepass(request,response);
        }else if ("checkmoduser".equals(flag)){
            checkmoduser(request,response);
        }else if("insertUserClick".equals(flag)){
            insertUserClick(request,response);
        }

        else if ("checkTitle".equals(flag)){
            checkTitle(request,response);
        }else if ("checkState".equals(flag)){
            checkState(request,response);
        }else if ("checkDepName".equals(flag)){
            checkDepName(request,response);
        }else if("addDep".equals(flag)){   //???????????????
            addDep(request,response);
        } else if("delDep".equals(flag)){   //???
            delDep(request,response);
        }else if("depList".equals(flag)){   //??????
            depList(request,response);
        }else if ("modDep".equals(flag)){  //???
            modDep(request,response);
        }else if("insertDep".equals(flag)){  //???
            insertDep(request,response);
        }else if("addType".equals(flag)){  //???????????????
            addType(request,response);
        }else if ("typeList".equals(flag)){  //??????
            typeList(request,response);
        }else if("modType".equals(flag)){   //???
            modType(request,response);
        }else if ("delType".equals(flag)){  //??????
            delType(request,response);
        }else if ("insertType".equals(flag)){
            insertType(request,response);
        }else if("fchange".equals(flag)){
            fchange(request,response);
        }else if("checkNewsTitle".equals(flag)){
            checkNewsTitle(request,response);
        }else if("checkNewsMod".equals(flag)){
            checkNewsMod(request,response);
        }else if("findFlagByNewsid".equals(flag)){
            findFlagByNewsid(request,response);
        }else if("pdelUserPd".equals(flag)){
            pdelUserPd(request,response);
        }else if("pdelNewsPd".equals(flag)){
            pdelNewsPd(request,response);
        }else if("delUserPd".equals(flag)){
            delUserPd(request,response);
        }else if("depjson".equals(flag)){
            depjson(request,response);
        }


    }

    private void depjson(HttpServletRequest request, HttpServletResponse response) throws IOException {
        DepService depService = new DepService();
        List<Department> depList = depService.getAllDep();
        String s=JSON.toJSONString(depList);
        response.getWriter().print(s);
    }

    private void delUserPd(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String id = request.getParameter("id");
        NewsService newsService = new NewsService();
        int uid=0;
        if (id!=null){
            uid=Integer.parseInt(id);
        }
        int i = newsService.findNewsByUid(uid);
        if (i==1){
            response.getWriter().print("ok");
        }else{
            response.getWriter().print("no");
        }

    }

    private void pdelNewsPd(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String[] ids = request.getParameterValues("ids");
        NewsService newsService = new NewsService();
        int i=0;
        if(ids==null){
            System.out.println("????????????null");
        }else{
            for (String s:ids){
                if(s!=null){
                    i=Integer.parseInt(s);
                }
                //??????????????????????????????????????????flag?????????3?????????3???????????????????????????i?????????id
                int j = newsService.findFlagByNewsid(i);
                if (j==3){
                    response.getWriter().print("no");
                    return;
                }
            }
        }
    }

    private void pdelUserPd(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String[] ids = request.getParameterValues("ids");
        String uid = request.getParameter("uid");
        int idd=0;
        if (uid!=null){
            idd = Integer.parseInt(uid);
        }
        NewsService newsService = new NewsService();
        int i=0;
        if(ids==null){
            System.out.println("????????????null");
            response.getWriter().print("none");
            return;
        }else{
            for(String s:ids){
                if(s!=null){
                    i=Integer.parseInt(s);
                }
                //??????????????????????????????????????????????????????
                int j = newsService.findNewsByUid(i);
                if (j==1){
                    response.getWriter().print("no");
                    return;
                }
                //????????????????????????
                else if(idd==i){
                    response.getWriter().print("self");
                    return;
                }

            }
        }
    }


    private void findFlagByNewsid(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id=request.getParameter("id");
        int mid=0;
        if(id!=null){
            mid=Integer.parseInt(id);
        }
        NewsService newsService = new NewsService();
       int i= newsService.findFlagByNewsid(mid);
       if (i==3){
           response.getWriter().print("ok");
       }
    }

    private void checkNewsMod(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String title = request.getParameter("title");
        System.out.println("=============title==========");
        System.out.println(title);

        String content = request.getParameter("content");
        String typeid = request.getParameter("typeid");
        String uid = request.getParameter("uid");
        int tid=0;
        int muid=0;
        if (typeid!=null){
            tid=Integer.parseInt(typeid);
        }
        if(uid!=null){
            muid=Integer.parseInt(uid);
        }
        NewsService newsService = new NewsService();
        News news = new News();

        news.setContent(content);
        news.setTitle(title);
        news.setTypeid(tid);
        news.setUid(muid);

        int i =newsService.checkNewsMod(news);
        System.out.println("====================ajax i========");
        System.out.println(i);

        if(i>=1){
            response.getWriter().print("same");
        }
    }

    private void checkNewsTitle(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String title=request.getParameter("title");
        String uid = request.getParameter("uid");
        int j=0;
        if (uid!=null){
            j=Integer.parseInt(uid);
        }
        NewsService newsService = new NewsService();
        int i=newsService.findNewsByTitle(j,title);
        if (i==1){
            response.getWriter().print("sametitle");
        }
    }

    private void fchange(HttpServletRequest request, HttpServletResponse response) {
        String state = request.getParameter("state");
        String id = request.getParameter("id");
        int fid=0;
        int fstate=0;
        if (id!=null&&!"".equals(id)){
            fid=Integer.parseInt(id);
        }
        if (state!=null&&!"".equals(state)){
            fstate=Integer.parseInt(state);
        }
        NewsService newsService = new NewsService();
        int i = newsService.setState(fstate, fid);
        System.out.println(i);

        if (i>=1){
            System.out.println("fstate???????????????????????????");
        }
    }

    private void insertUserClick(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");



        String age = request.getParameter("age");

        UserService userService = new UserService();
        boolean b=userService.findUserByName(username);


        if (username==null||"".equals(username.trim())){
            response.getWriter().print("noname");
        }else if(password==null||"".equals(password.trim())){
            response.getWriter().print("nopass");
        }else if (age==null||"".equals(age.trim())){
            response.getWriter().print("noage");
        }else if ( b==true){
            response.getWriter().print("samename");
        }

    }

    private void checkmoduser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String repass = request.getParameter("repass");
        String password = request.getParameter("password");
        String username = request.getParameter("username");
        String age = request.getParameter("userage");
        if (repass==null||"".equals(repass)||password==null||"".equals(password)){
            response.getWriter().print("no");
        }else if (!repass.equals(password)){
            response.getWriter().print("non");
        }else if(username==null||"".equals(username)){
            response.getWriter().print("noname");
        }else if (age==null||"".equals(age.trim())){
            response.getWriter().print("noage");
        }
    }



    private void checkmodrepass(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String repass = request.getParameter("repass");
        String password = request.getParameter("password");

        if (repass==null||"".equals(repass)){
            response.getWriter().print("no");
        }else if (!repass.equals(password)){
            response.getWriter().print("non");
        }else{
            response.getWriter().print("ok");
        }
    }

    private void checkmodpass(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String password = request.getParameter("password");
        if (password==null||"".equals(password)){
            response.getWriter().print("no");
        }else{
            response.getWriter().print("ok");
        }
    }

    private void insertType(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


        String typeName = request.getParameter("typeName");
        System.out.println("==========typeName");
        System.out.println(typeName);
        String sort = request.getParameter("sort");
        System.out.println("===============sort");
        System.out.println(sort);


        NewsTypeService newsTypeService = new NewsTypeService();
        int tsort=0;

        //?????????????????????
        boolean pd=true;
        if (typeName==null||"".equals(typeName.trim())){
            pd=false;
            response.getWriter().print("no1");
            return;

        }



        int i = newsTypeService.findTypeByName(typeName);
        if (i>=1){
            pd=false;
            response.getWriter().print("non");
            System.out.println("ceshishishishsihsi");
            return;

        }
        if (sort==null||"".equals(sort)){
            pd=false;
            response.getWriter().print("no2");
            return;

        }
//        if (!pd){
//            request.getRequestDispatcher("ajax?flag=addType").forward(request,response);
//
//            return;
//        }

        if (sort!=null){
            tsort=Integer.parseInt(sort);
        }
       boolean b= newsTypeService.findTypeSort(tsort);
        System.out.println("===================b==============");
        System.out.println(b);

        if (b==true){
            response.getWriter().print("samesort");
            return;
        }


        int j=newsTypeService.insertType(typeName,tsort);
        if (j>=1){
            response.getWriter().print("ok");
        }else {
            response.getWriter().print("no");
        }

    }

    private void delType(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String id=request.getParameter("id");//????????????id
        int tid=-1;
        if (id!=null){
            tid=Integer.parseInt(id);
        }
//        DepService depService = new DepService();
//        UserService userService = new UserService();
        NewsTypeService newsTypeService = new NewsTypeService();
        NewsService newsService = new NewsService();

        boolean b=newsService.findNewsByTypeid(tid);//??????????????????????????????
        System.out.println(b);
        if (!b){
            response.getWriter().print("ok");
            newsTypeService.delTypeById(tid);
        }else{
            response.getWriter().print("no");
        }

    }


    private void modType(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String id = request.getParameter("id");


        String typeName = request.getParameter("typeName");


        String sort = request.getParameter("sort");


        if("".equals(sort.trim())){
            response.getWriter().print("nosort");
            return;
        }

        int tid=0;
        int tsort=0;
        if (id!=null){
            tid=Integer.parseInt(id);
        }
        if (sort!=null){

            tsort=Integer.parseInt(sort);
        }



        boolean flag=true;
        if (typeName==null||"".equals(typeName.trim())){
            flag=false;
            response.getWriter().print("notypename");//??????????????????
            return;
        }else if(sort==null||"".equals(sort.trim())||tsort<0){ //????????????
            flag=false;
            response.getWriter().print("nosort");
            return;
        }

        if (!flag){
            response.getWriter().print("no"); //????????????
            return;
        }




        NewsTypeService newsTypeService = new NewsTypeService();

        boolean b=newsTypeService.findTypeSortpl(tsort,tid);
        if (b==true){
            response.getWriter().print("samesort");
            return;
        }

        boolean c=newsTypeService.findTypeByNamepl(typeName,tid);
        if (c==true){
            response.getWriter().print("samename");
            return;
        }

        boolean e=newsTypeService.modPd(typeName,tsort);
        if (e==true){
            response.getWriter().print("modPd");
            return;
        }



        int i=newsTypeService.modType(tid,typeName,tsort);
        if (i>=1){
            response.getWriter().print("ok");
        }else{
            response.getWriter().print("no");
        }


    }

    private void typeList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("===========typelist?????????=========");


        NewsTypeService newsTypeService = new NewsTypeService();
        List<NewsType> typeList=newsTypeService.getAllType();
        request.setAttribute("type",typeList);
        request.getRequestDispatcher("view/type.jsp").forward(request,response);

    }

    private void addType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        NewsTypeService newsTypeService = new NewsTypeService();
        int typeLastId = newsTypeService.getTypeLastId();

        System.out.println("===========tlid===");
        System.out.println(typeLastId);

        request.setAttribute("tlid",typeLastId);
        request.getRequestDispatcher("ajax?flag=typeList").forward(request,response);
    }


    private void addDep(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DepService depService = new DepService();
        int lastId = depService.getLastId();
        request.setAttribute("lid",lastId);
        request.getRequestDispatcher("ajax?flag=depList").forward(request,response);
    }

    private void insertDep(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String depName = request.getParameter("depName");
        System.out.println("==========depName");
        System.out.println(depName);
        String sort = request.getParameter("sort");
        System.out.println("===============sort");
        System.out.println(sort);

        DepService depService = new DepService();
        int dsort=0;

        //??????????????????????????????

        if (depName==null||"".equals(depName.trim())){

            response.getWriter().print("no1");
            return;

        }
        //??????????????????????????????
        int i = depService.findDepByName(depName);
        if (i>=1){

            response.getWriter().print("non");

            return;

        }

        //??????sort????????????
        if (sort==null||"".equals(sort)){

            response.getWriter().print("no2");
            return;

        }
        if (sort!=null){
            dsort=Integer.parseInt(sort);
        }

        System.out.println("============dsort======");
        System.out.println(dsort);
        //???????????????sort??????
        int m=depService.findDepBySort(dsort);
        if (m==1){
            response.getWriter().print("samesort");
            return;
        }



        if (sort!=null){
            dsort=Integer.parseInt(sort);
        }


        //?????????????????????
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern("yyyy-MM-dd");
        Date date = new Date();
        String time=sdf.format(date);


        int j=depService.insertDep(depName,dsort,time);
        if (j>=1){
            response.getWriter().print("ok");
        }else {
            response.getWriter().print("no");
        }


    }

    private void modDep(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String depName = request.getParameter("depName");
        String sort = request.getParameter("sort");

        System.out.println("id==============");
        System.out.println(id);

        System.out.println("depName==============");
        System.out.println(depName);



        System.out.println("sort===============");
        if (sort==null){
            System.out.println("sort???null");
        }else if ("".equals(sort.trim())){
            response.getWriter().print("nosort");
            return;
        }


        int did=0;
        int dsort=0;
        if (id!=null){
            did=Integer.parseInt(id);
        }
        if (sort!=null){
            dsort=Integer.parseInt(sort);
        }
        //??????????????????????????????
        if(depName==null||"".equals(depName.trim())){
            response.getWriter().print("noname");
            return;
        }
        //??????????????????????????????????????????
        if (dsort<0||"".equals(sort.trim())){
            response.getWriter().print("nosort");
            return;
        }


//     ?????????????????????????????????????????????????????????????????????
        DepService depService = new DepService();
        int j = depService.findDepByNameAndID(depName,did);
        if (j==1){
            response.getWriter().print("samename");
            return;
        }


        //???????????????????????????????????????????????????
       int k=depService.findDepBySortAndID(dsort,did);
        if (k==1){
            response.getWriter().print("samesort");
            return;
        }

        //??????????????????
        int e=depService.modPd(dsort,depName);
        if (e==1){
            response.getWriter().print("modPd");
            return;
        }


        //????????????
        int i= depService.modDep(did,depName,dsort);//i>=1??????????????????
       if (i>=1){
           response.getWriter().print("ok");
       }else{
           response.getWriter().print("no");
       }



    }

    private void depList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       
        System.out.println("===========?????????=========");
        DepService depService = new DepService();
        List<Department> depList = depService.getAllDep();
        request.setAttribute("dep",depList);

        request.getRequestDispatcher("view/dep.jsp").forward(request,response);

    }

    private void delDep(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id=request.getParameter("id");//????????????id
        int did=-1;
        if (id!=null){
            did=Integer.parseInt(id);
        }
        DepService depService = new DepService();
        UserService userService = new UserService();
        boolean b=userService.findUserByDid(did);//??????????????????????????????
        System.out.println(b);
        if (!b){
            response.getWriter().print("ok");
            depService.delDepById(did);
        }else{
            response.getWriter().print("no");
        }


    }

    private void checkDepName(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String depname = request.getParameter("depname");
        DepService depService = new DepService();
        int i = depService.findDepByName(depname);

        if (depname==null||"".equals(depname)){
            response.getWriter().print("no");
        }else if (i>=1){
            response.getWriter().print("non");
        }else{
            response.getWriter().print("ok");
        }


    }

    private void checkState(HttpServletRequest request, HttpServletResponse response) {
        String state = request.getParameter("state");
        String id = request.getParameter("id");
        int i=0,k=0;
        //????????????
        if (state!=null&&!"".equals(state)){
            i=Integer.parseInt(state);
        }
        //??????state???id
        if (id!=null&&!"".equals(id)){
            k=Integer.parseInt(id);
        }
        NewsService newsService = new NewsService();
        int j=newsService.setState(i,k);
        System.out.println("==========j?????????1?????????");
        System.out.println(j);
    }

//    private void checkTypeid(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        String typeid = request.getParameter("typeid");
//        if (typeid==null||"-1".equals("title")){
//            response.getWriter().print("no");
//
//        }else {
//            response.getWriter().print("ok");
//        }
//    }

    private void checkTitle(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String title=request.getParameter("title");
        if (title==null||"".equals(title.trim())){
            response.getWriter().print("no");
        }else{
            response.getWriter().print("ok");
        }

    }

    private void checkAge(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String age = request.getParameter("userage");
        System.out.println(age);
        if (age==null||"".equals(age.trim())){
            response.getWriter().print("no");
        }
        else if (Integer.parseInt(age)>120||Integer.parseInt(age)<0){
            response.getWriter().print("nage");
        }else{
            response.getWriter().print("ok");
        }
    }

    private void checkPassword(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String password = request.getParameter("password");
        if (password==null||"".equals(password.trim())){
            response.getWriter().print("no");
        }else{
            response.getWriter().print("ok");
        }
    }

    private void checkUserName(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UserService userService = new UserService();
        String username=request.getParameter("username");
        boolean b=userService.findUserByName(username);


        if(username==null||"".equals(username.trim())){
            response.getWriter().print("no");
        }else if (b==true){
            response.getWriter().print("non");
        }else{
            response.getWriter().print("ok");
        }

    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
