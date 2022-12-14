package com.cms.controller;

import com.cms.po.News;
import com.cms.po.PageBean;
import com.cms.po.User;
import com.cms.service.DepService;
import com.cms.service.NewsService;
import com.cms.service.UserService;
import com.cms.util.VisitedUtil;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.org.apache.xpath.internal.functions.FuncId;
import jdk.nashorn.internal.ir.CallNode;
import org.apache.commons.codec.Encoder;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import java.util.function.DoubleToIntFunction;

@WebServlet("/UserController")
public class UserController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();


        String flag = request.getParameter("flag");
        System.out.println(flag);
        if ("loginok".equals(flag)){
            loginok(request, response);
        }else if ("loginout".equals(flag)){
            loginout(request,response);
        }


        else if ("userList".equals(flag)){
            userList(request,response);
        }else if("toAddUser".equals(flag)){
            toAddUser(request,response);
        }else if ("addUser".equals(flag)){
            addUser(request,response);
        }else if("delUser".equals(flag)){
            delUser(request,response);
        }else if ("pdelUser".equals(flag)){
            pdelUser(request,response);
        }else if("toModifyUser".equals(flag)){
            toModifyUser(request,response);
        }else if("modifyUser".equals(flag)){
            ModifyUser(request,response);
        }


    }

    private void loginout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //??????
        HttpSession session = request.getSession();
        session.invalidate();
        response.sendRedirect("view/login.jsp");
    }

    private void ModifyUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //????????????

        String searchName = request.getParameter("searchName");


        String pageNow = request.getParameter("pageNow");

        String username = request.getParameter("username");


        String password = request.getParameter("password");
        String md5=DigestUtils.md5Hex(password);//md5??????

        String repassword = request.getParameter("repassword");


        String userpower = request.getParameter("userpower");
        String usersex = request.getParameter("usersex");
        String depid = request.getParameter("depid");


        String userCode = request.getParameter("usercode");
        String userage= request.getParameter("userage");
        String id = request.getParameter("id");

        UserService userService = new UserService();

        boolean flag=true;
        if (username==null||"".equals(username.trim())){
            flag=false;

        }


        if (password==null||"".equals(password.trim())){
            flag=false;

        }
        if (userage==null||"".equals(userage.trim())){
            flag=false;
        }

        if (!repassword.equals(password)){
            flag=false;
        }

        if (!flag){
            request.getRequestDispatcher("UserController?flag=toModifyUser").forward(request,response);
            return; //?????????????????????????????????
        }

        User user = new User();
        user.setUserName(username);
        user.setUserPwd(md5);
        user.setUserAge(Integer.parseInt(userage));
        user.setUserCode(userCode);

        user.setUserPower(Integer.parseInt(userpower));
        user.setDepID(Integer.parseInt(depid));
        user.setUserSex(usersex);
        user.setId(Integer.parseInt(id));



        boolean b=userService.modifyUser(user);

        if (b==true){
            request.getRequestDispatcher("UserController?flag=userList&searchName="+ URLEncoder.encode(searchName,"utf-8")+"&depid="+depid+"&pageNow="+pageNow).forward(request,response);
        }else{
            response.sendRedirect("UserController?flag=toModifyUser");
        }



    }

    private void toModifyUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String id = request.getParameter("id");
        String pageNow = request.getParameter("pageNow");
        request.setAttribute("mpageNow",pageNow);

        System.out.println(id);
       int uid=0;
        if (id!=null&&!"".equals(id.trim())) {
            uid = Integer.parseInt(id);
        }
        System.out.println(uid);
        UserService userService = new UserService();

        User user =null;
        //??????id????????????????????????
       user= userService.findUserByID(uid);


       request.setAttribute("u2",user);




        DepService depService = new DepService();
        Map depMap = depService.getDepMap();
        request.setAttribute("depMap",depMap);
        request.getRequestDispatcher("view/modifyUser.jsp").forward(request,response);
    }



    private void loginok(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String remember = request.getParameter("remember");

       String pss= DigestUtils.md5Hex(password);

        User user = new User();
        user.setUserName(username);
        user.setUserPwd(pss);
        UserService userService = new UserService();

        User checkUser=userService.checkUser(user);
//        System.out.println(checkUser+"============");

        if (checkUser!=null){
//            out.print("success");
            //???????????????
            ServletContext application = this.getServletContext();
            int totalTimes= Integer.parseInt(application.getAttribute("totalTimes").toString());
            totalTimes++;
            //?????????
            application.setAttribute("totalTimes",totalTimes);


            //cookie
            Cookie coolie1 = new Cookie("username",username);
            Cookie coolie2 = new Cookie("password",password);
            String contextPath = request.getContextPath();
            coolie1.setPath(contextPath);
            coolie2.setPath(contextPath);


            if (remember!=null){
                coolie1.setMaxAge(7*24*60*60);
                coolie2.setMaxAge(7*24*60*60);

            }else{
                //??????cookie
                coolie1.setMaxAge(0);
                coolie2.setMaxAge(0);
            }

            response.addCookie(coolie1);
            response.addCookie(coolie2);

            //1.??????session
            HttpSession session = request.getSession();
            //2.???session???????????????
            session.setAttribute("user",checkUser);

            request.setAttribute("user",checkUser);
            response.sendRedirect("view/home.jsp");//??????????????????

        }else{
            response.sendRedirect("view/login.jsp?pd=1");
        }
    }

    private void userList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.??????pageNow
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


      //u????????????????????????
        User u = new User();
        String searchName = request.getParameter("searchName");


        if (request.getParameter("searchName")!=null&&!"".equals(request.getParameter("searchName").trim())) {
            u.setUserName(searchName);
        }
        String depID = request.getParameter("depID");

        System.out.println(depID);

//        System.out.println(searchName+"wwwwww");
        if (!"-1".equals(depID) && depID!=null){
//            System.out.println("0000000000000000000000000");
            u.setDepID(Integer.parseInt(depID));
        }

//        System.out.println(u);


        //2.??????pageBean
        UserService userService = new UserService();
        int pageSize=10;
       PageBean<User>pageBean= userService.getPageBean(u,pageNow,pageSize);
       Map sexMap=userService.getSexMap();



        DepService depService = new DepService();
        Map depMap = depService.getDepMap();



        //3.???????????????
        request.getSession().setAttribute("condition",u);
        request.setAttribute("pageBean",pageBean);
        request.setAttribute("depMap",depMap);


        request.getRequestDispatcher("/view/users.jsp").forward(request,response);

    }

    private void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //????????????
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String md5=DigestUtils.md5Hex(password);//md5??????

        String userpower = request.getParameter("userpower");
        String usersex = request.getParameter("usersex");
        String depID = request.getParameter("depID");

        String userCode = request.getParameter("usercode");
        System.out.println(userCode);
        String userage= request.getParameter("userage");
        UserService userService = new UserService();
        boolean fname = userService.findUserByName(username);


        //1.????????????username???password???userage??????????????????????????????????????????toAddUser.jsp
        boolean flag=true;


        if (username==null||"".equals(username.trim())){
            flag=false;
        }

        if (fname==true){
            flag=false;
        }
        if (password==null||"".equals(password.trim())){
            flag=false;
        }
        if (userage==null||"".equals(userage.trim())){
            flag=false;
        }
        System.out.println("==============");
        System.out.println(flag);
        if (!flag){
            request.getRequestDispatcher("UserController?flag=toAddUser").forward(request,response);
            return; //?????????????????????????????????
        }

        //2.????????????
        User user = new User();

        user.setUserName(username);
        user.setUserPwd(md5);
        user.setUserAge(Integer.parseInt(userage));
        user.setUserCode(userCode);

        user.setUserPower(Integer.parseInt(userpower));
        user.setDepID(Integer.parseInt(depID));
        user.setUserSex(usersex);





        boolean b=userService.addUser(user);
        if (b==true){
            response.sendRedirect("UserController?flag=userList");
        }else{
            response.sendRedirect("UserController?flag=toAddUser");
        }



    }

    private void toAddUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserService userService = new UserService();
        int lid=userService.getLastID();//?????????id

        System.out.println("============lid==========");
        System.out.println(lid);

        DepService depService = new DepService();
        Map depMap = depService.getDepMap();
        request.setAttribute("depMap",depMap);
        request.setAttribute("lid",lid);
        request.getRequestDispatcher("view/addUser.jsp").forward(request,response);
    }

    private void delUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");
        if (id==null||"".equals(id.trim())){
            return;
        }
        String searchName = request.getParameter("searchName");
        String depID = request.getParameter("depID");
        String pageNow = request.getParameter("pageNow");

        int uid =Integer.parseInt(id);
        UserService userService = new UserService();
        NewsService newsService = new NewsService();

//===================

//===========================

        int i=0;
        int j = newsService.findNewsByUid(uid);
        //??????j=1???????????????????????????????????????????????????


        if (j!=1){
             i=userService.delUserById(uid);
        }


        if (i==1){
            System.out.println("????????????");




            //=====================
        }else{
            System.out.println("????????????");
        }

            request.getRequestDispatcher("UserController?flag=userList&searchName="+ URLEncoder.encode(searchName,"utf-8")  +"&depID="+  depID+"&pageNow="+pageNow).forward(request,response);

    }

    private void pdelUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //?????????????????????id??????
        String[] pdels = request.getParameterValues("pdel");
        String searchName = request.getParameter("searchName");
        String depID = request.getParameter("depID");
        String pageNow = request.getParameter("pageNow");


        UserService userService = new UserService();
        NewsService newsService = new NewsService();

        //??????????????????
        int id=0;

        if (pdels!=null) {
            for (String s:pdels){

                id=Integer.parseInt(s);

                int i=0;
                int j = newsService.findNewsByUid(id);
                //??????j=1???????????????????????????????????????????????????


                if (j!=1){
                    userService.delUserById(id);
                }



            }
        }
        request.getRequestDispatcher("UserController?flag=userList&searchName="+URLEncoder.encode(searchName,"UTF-8")+"&depID="+depID+"&pageNow="+pageNow).forward(request,response);


    }

    @Override
    public void destroy() {
        //???????????????????????????????????????????????????????????????????????????????????????????????????
        ServletContext application = getServletContext();
        int totalTimes = Integer.parseInt(application.getAttribute("totalTimes").toString());
        VisitedUtil.writeVisited(totalTimes);
    }

    //??????????????????????????????????????????????????????????????????????????????
//???????????????visited?????????????????????????????????????????????ServletContext??????
    @Override
    public void init() throws ServletException {
        int lasttimes = VisitedUtil.readVisited();
        //???????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????
        //?????????
        //1.HttpServletRequest,????????????????????????????????????????????????????????????
        //2. HttpSession??????????????????????????????????????????
        //3. ServletContext:????????????????????????????????????????????????????????????????????????
        ServletContext application = getServletContext();
        application.setAttribute("totalTimes", lasttimes);
    }




    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
