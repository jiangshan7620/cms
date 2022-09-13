<%--
  Created by IntelliJ IDEA.
  User: hello
  Date: 2022/8/15
  Time: 23:05
  To change this template use File | Settings | File Templates.
--%>


<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="view/css/d4.css">
    <link rel="stylesheet" href="view/css/frame.css">

    <%@ include file="/view/header.jsp" %>
</head>
<body style="background-color: #f1f1f1">
<div class="whole">

    <div class="box">
        <div class="frame1">
            <div class="zs">
                <div class="zsz">推荐新闻</div>
                <div class="zsy">更多</div>
            </div>
            <div class="zx">
                <ul>
                    <c:forEach var="item" items="${sessionScope.pb.newsList}">
                        <div class="ljy">
                            <li>
                                <a href="newstype?flag=newsContent&typeid=${item.typeid}&id=${item.id}" target="right">${item.title}</a>
                            </li>
                        </div>
                    </c:forEach>
                </ul>
            </div>

        </div>
        <div class="frame2">
            <div class="ys">
                <div class="ysz"><a href="http://localhost:8080/cms/newstype?flag=newstypelist">首页 > </a>
                ${sessionScope.tn}
                </div>
            </div>
            <div class="yx" name="right">
                <h2 rel="" align="center"> ${sessionScope.n.title}</h2>
                <p align="center">[${sessionScope.tn}] 时间：${sessionScope.n.createtime} 发布人：${sessionScope.uu.userName}</p>
                <br>
                <p align="left"> ${sessionScope.n.content}</p>

            </div>
        </div>


    </div>


</div>

</body>
<%@ include file="/view/foot.jsp" %>

</html>
