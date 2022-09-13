<%--
  Created by IntelliJ IDEA.
  User: hello
  Date: 2022/8/16
  Time: 11:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="view/css/d4.css">
</head>

<body>
<!-- 框架 -->


<div class="whole">
    <!--顶栏 header -->

    <div class="header">
        <div class="logo"><img src="view/images/logo.png" alt=""></div>
        <div class="text">做品质教育 用事实说话</div>
        <div class="tel"><img src="view/images/tel.jpg" alt=""></div>
    </div>

    <!--11个链接 lj -->

    <div class="lj">


        <c:forEach items="${sessionScope.tl}" var="tl">
            <div class="ljy"><a href="newstype?flag=title&typeid=${tl.id}">${tl.typeName}</a></div>
        </c:forEach>


    </div>

</div>
</body>
</html>