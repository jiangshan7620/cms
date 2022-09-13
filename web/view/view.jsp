<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="view/css/d4.css">
    <%@ include file="/view/header.jsp" %>
</head>

<body style="background-color: #f1f1f1">


<!-- 四张图片 fpic -->


<!-- 通知公告和招生问答 tz -->


<!-- 3月28日软件开发零基础培训班火热招生中！
3月21日Java一SS2实训班火热招生中！
2月28日软件开发零基础培训班名额己满！
2月23日Java一SS2实训班名额己满！
1月10日零基础+JAVA-2EE实训脱.
12月27日零基础+JAVA-J2EE实训 -->


<div class="whole">
    <div class="box1">

        <c:forEach var="tl" items="${sessionScope.tl}">
            <div class="box2">
                <div class="box3">
                    <div class="dbt">${tl.typeName}</div>
                    <div class="gd"><a href="newstype?flag=title&typeid=${tl.id}">更多</a></div>
                </div>


                <div class="li">
                    <ul>

                        <c:forEach items="${sessionScope.titlemap.keySet()}" var="it">
                            <c:choose>
                                <c:when test="${it==tl.id}">

                                    <c:forEach items="${sessionScope.titlemap[it]}" var="i">

                                        <li>
                                            <a href="newstype?flag=newsContent&typeid=${tl.id}&id=${i.id}">

                                                <c:choose>
                                                    <c:when test="${fn:length(i.title)>5}">
                                                        ${fn:substring(i.title,0 ,5 )}***
                                                    </c:when>
                                                    <c:otherwise>
                                                        ${i.title}
                                                    </c:otherwise>
                                                </c:choose>


<%--                                                    ${i.title}--%>
                                            </a>

                                        </li>
                                    </c:forEach>

                                    <%--                                            ${sessionScope.titlemap[it]}--%>


                                </c:when>
                            </c:choose>
                        </c:forEach>


                    </ul>


                </div>


            </div>


        </c:forEach>


    </div>
</div>


<%--    <div class="bian"></div>--%>
<%--    <div class="txt">--%>
<%--        <p>爱尚教育：软件开发、软件测试、安卓开发、T日语专业培训机构！爱尚教育做的不仅仅是就业</p>--%>
<%--        <p>版权所有@爱尚教育〔辽1CP备11019651-1号)咨询电话：0411-62276977/88</p>--%>
<%--        <p> 开发与技术支持：大连华企智源科技有限公司</p>--%>
<%--    </div>--%>


</body>
<%@ include file="/view/foot.jsp" %>

</html>