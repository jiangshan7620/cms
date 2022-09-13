<%--
  Created by IntelliJ IDEA.
  User: hello
  Date: 2022/8/15
  Time: 16:48
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
                <div class="zsz"> ${sessionScope.tin}</div>
                <div class="zsy"><a href="newstype?flag=title&typeid=${sessionScope.i}">更多</a></div>
            </div>
            <div class="zx">
                <ul>
                    <c:forEach var="item" items="${sessionScope.pb.newsList}">
                        <div class="ljy">
                            <li>
                                <a href="newstype?flag=newsContent&typeid=${item.typeid}&id=${item.id}">${item.title}</a>
                            </li>
                        </div>
                    </c:forEach>
                </ul>
            </div>

        </div>
        <div class="frame2">
            <div class="ys">
                <div class="ysz"><a href="http://localhost:8080/cms/newstype?flag=newstypelist">首页 > </a>
                    ${sessionScope.tin}

                </div>
            </div>
            <div class="yx">
                <ul>
                    <c:forEach var="item" items="${sessionScope.pb.newsList}">
                        <div class="ljy">
                            <li>
                                <a href="newstype?flag=newsContent&typeid=${item.typeid}&id=${item.id}">${item.title}</a>
                            </li>
                        </div>
                    </c:forEach>
                </ul>


<%--                分页--%>

                <c:if test="${sessionScope.pb.pageNow>1}">
                    <a href="newstype?flag=title&pageNow=${sessionScope.pb.pageNow-1}&typeid=${sessionScope.pb.newsList.get(0).typeid}">上一页</a>&nbsp &nbsp &nbsp
                </c:if>


<%--       end<0报错，所以三元运算符判断，如果end<0，则等于0--%>
                <c:forEach begin="0" end="${fn:length(sessionScope.pb.pages)-1<0?0:fn:length(sessionScope.pb.pages)-1}" step="1" var="i">
                    <a href="newstype?flag=title&pageNow=${sessionScope.pb.pages[i]}&typeid=${sessionScope.pb.newsList.get(0).typeid}">
                        <c:choose>
                            <c:when test="${sessionScope.pb.pageNow==sessionScope.pb.pages[i]}">
                                <span style="background-color: yellowgreen">
                                    ${sessionScope.pb.pages[i]}
                                </span> &nbsp  &nbsp  &nbsp

                            </c:when>

                            <c:otherwise>
                                ${sessionScope.pb.pages[i]}&nbsp  &nbsp  &nbsp
                            </c:otherwise>
                        </c:choose>

                    </a>


                </c:forEach>

                <c:if test="${sessionScope.pb.pageNow<sessionScope.pb.pageCount}">
                    <a href="newstype?flag=title&pageNow=${sessionScope.pb.pageNow+1}&typeid=${sessionScope.pb.newsList.get(0).typeid}">下一页</a>
                </c:if>

<%--                分页--%>

            </div>
        </div>


    </div>


</div>

</body>
<%@ include file="/view/foot.jsp" %>

</html>
