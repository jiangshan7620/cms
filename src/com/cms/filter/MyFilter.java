//package com.cms.filter;
//
//import com.cms.po.User;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * @author: Mr.shan
// * @date: 2022/8/13 21:03
// * @bz:
// */
//
//@WebFilter("/*")
//public class MyFilter implements Filter {
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        System.out.println("过滤器init");
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//
//        System.out.println("过滤器开始");
//
//        HttpServletRequest req= (HttpServletRequest) request;
//        HttpServletResponse resp = (HttpServletResponse) response;
//
//        req.setCharacterEncoding("utf-8");//设置request编码
//
//        resp.setContentType("text/html;charset=utf-8");//设置response编码
//
//
//        System.out.println("==============过滤器flag==========");
//        String flag = req.getParameter("flag"); //获取到的flag
//        System.out.println(flag);
//        System.out.println(req.getRequestURI());
//        int uri = req.getRequestURI().indexOf("login.jsp"); //url中有login.jsp
//        System.out.println("=================uri=========");
//        System.out.println(uri);
//
//        int css = req.getRequestURI().indexOf("css");
//        int image = req.getRequestURI().indexOf("images");
//        int js = req.getRequestURI().indexOf("js");
//        // System.out.println(uri);
//
//        if (!(uri!=-1||"loginok".equals(flag)||css>0||image>0||js>0)){
//
//            System.out.println("haaaaaaaaaaaa");
//
//            //非法登录
//            User user=(User)req.getSession().getAttribute("user");
//
//            System.out.println("==============user==============");
//            System.out.println(user);
//
//            if (user==null){
//                req.getRequestDispatcher("/view/login.jsp").forward(request, response);
//                return;
//            }
//
//
//        }
//        //放行
//       chain.doFilter(req, resp);
//
//        System.out.println("过滤器结束");
//
//
//
//    }
//
//    @Override
//    public void destroy() {
//        System.out.println("过滤器销毁");
//    }
//}
