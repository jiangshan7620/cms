<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<html>

<head>
    <meta charset="utf-8"/>
    <link rel="icon" type="image/png"
          href="img/favicon.ico">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>

    <title>管理页面</title>

    <meta
            content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0'
            name='viewport'/>
    <meta name="viewport" content="width=device-width"/>

    <!-- Bootstrap core CSS     -->
    <link href="view/css/bootstrap.min.css"
          rel="stylesheet"/>

    <!-- Animation library for notifications   -->
    <link href="view/css/animate.min.css"
          rel="stylesheet"/>

    <!--  Light Bootstrap Table core CSS    -->
    <link
            href="view/css/light-bootstrap-dashboard.css"
            rel="stylesheet"/>


    <!--  CSS for Demo Purpose, don't include it in your project     -->
    <link href="view/css/demo.css"
          rel="stylesheet"/>


    <!--     Fonts and icons     -->

    <link href="view/css/pe-icon-7-stroke.css"
          rel="stylesheet"/>

</head>
<body>



<div class="wrapper">


    <div class="sidebar" data-color="grow" data-image="view/images/sidebar-5.jpg">
        <div class="sidebar-wrapper">
            <div class="logo">
                <a href="#" class="simple-text">
                    <img src="view/images/logo.png">
                </a>
            </div>


            <ul class="nav">
                <li>
                    <a href="http://localhost:8080/cms/view/home.jsp">
                        <i class="pe-7s-graph"></i>
                        <p>管理员首页</p>
                    </a>
                </li>

                <li>
                    <a href="http://localhost:8080/cms/NewsController?flag=newsList">
                        <i class="pe-7s-news-paper"></i>
                        <p>新闻列表</p>
                    </a>
                </li>


                    <li>
                        <a href="http://localhost:8080/cms/UserController?flag=userList">
                            <i class="pe-7s-note2"></i>
                            <p>用户管理</p>
                        </a>
                    </li>
                    <li>
                        <a href="http://localhost:8080/cms/UserController?flag=toAddUser">
                            <i class="pe-7s-map-marker"></i>
                            <p>添加用户</p>
                        </a>
                    </li>



                <%--                <div>${user.userPower == '1'}</div>--%>
                <c:choose>
                    <c:when test="${user.userPower == 1}">
                        <%--                            123123123123123--%>
                        <li>
                            <a href="http://localhost:8080/cms/NewsController?flag=toAddNews" style="display: none">

                                <i class="pe-7s-science"></i>
                                <p>新闻上传</p>
                            </a>
                        </li>
                    </c:when>
                    <c:otherwise>

                        <li>
                            <a href="http://localhost:8080/cms/NewsController?flag=toAddNews">
                                <i class="pe-7s-science"></i>
                                <p>新闻上传</p>
                            </a>
                        </li>
                    </c:otherwise>
                </c:choose>


                <c:choose>
                    <c:when test="${user.userPower == 0}">
                        <%--                            123123123123123--%>
                        <li>
                            <a href="http://localhost:8080/cms/ajax?flag=addDep" style="display: none">

                                <i class="pe-7s-science"></i>
                                <p>部门列表</p>
                            </a>
                        </li>

                    </c:when>
                    <c:otherwise>

                        <li>
                            <a href="http://localhost:8080/cms/ajax?flag=addDep">
                                <i class="pe-7s-science"></i>
                                <p>部门列表</p>
                            </a>
                        </li>
                    </c:otherwise>
                </c:choose>


                <c:choose>
                    <c:when test="${user.userPower == 0}">
                        <%--                            123123123123123--%>
                        <li>
                            <a href="http://localhost:8080/cms/ajax?flag=addType" style="display: none">

                                <i class="pe-7s-science"></i>
                                <p>类别管理</p>
                            </a>
                        </li>

                    </c:when>
                    <c:otherwise>

                        <li>
                            <a href="http://localhost:8080/cms/ajax?flag=addType">
                                <i class="pe-7s-science"></i>
                                <p>类别管理</p>
                            </a>
                        </li>
                    </c:otherwise>
                </c:choose>


                <li class="active-pro">
                    <a href="manage/">
                        <i class="pe-7s-rocket"></i>
                        <p>购买专业版</p>
                    </a>
                </li>
            </ul>

        </div>
    </div>


    <div class="main-panel">

        <nav class="navbar navbar-default navbar-fixed">
            <div class="container-fluid">
                <div class="navbar-header">
                    <!-- <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navigation-example-2">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button> -->
                    <a class="navbar-brand" href="#">新闻管理系统</a>
                </div>
                <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav navbar-left">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <i class="pe-7s-graph">消息</i>
                                <b class="caret"></b>
                                <span class="notification">5</span>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="#">Notification 1</a></li>
                                <li><a href="#">Notification 2</a></li>
                                <li><a href="#">Notification 3</a></li>
                                <li><a href="#">Notification 4</a></li>
                                <li><a href="#">Another notification</a></li>
                            </ul>
                        </li>


                    </ul>

                    <ul class="nav navbar-nav navbar-right">

                        <li>
                            <a href="http://localhost:8080/cms/UserController?flag=loginout">
                                安全退出
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>


        <div class="content">
            <div class="container-fluid">
                <div class="row">

                    <div class="col-md-12">
                        <div class="card">
                            <div class="header">
                                <h4 class="title">用户管理</h4>
                                <p class="category">Here is a subtitle for this table</p>
                                <form action="UserController?flag=userList" method="post">
                                    <div style="float:left;  width: 130px;">

                                        <select name="depID" class="form-control" style="width: 130px;">
                                        <c:choose>
                                        <c:when test="${sessionScope.condition.depID==0}">

                                            <option value="-1" selected>请选择
                                            </option>
                                            <c:forEach items="${depMap}" var="item" varStatus="vs">
                                                <c:choose>

                                                    <c:when test="${item.key==condition.depID}">
                                                        <option selected value="${item.key}">${item.value}</option>
                                                    </c:when>


                                                    <c:otherwise>
                                                        <option value="${item.key}">${item.value}</option>

                                                    </c:otherwise>
                                                </c:choose>
                                            </c:forEach>



                                            </c:when>

                                            <c:otherwise>

                                                <c:forEach items="${depMap}" var="item" varStatus="vs">
                                                    <c:choose>

                                                        <c:when test="${item.key==condition.depID}">
                                                            <option selected value="${item.key}">${item.value}</option>
                                                        </c:when>


                                                        <c:otherwise>
                                                            <option value="${item.key}">${item.value}</option>

                                                        </c:otherwise>
                                                    </c:choose>
                                                </c:forEach>
                                                <option value="-1" >请选择</option>

                                            </c:otherwise>

                                            </c:choose>


                                        </select>
                                    </div>

                                    <div style="float:left; margin:0 2px; width: 130px;">
                                        <input type="text" class="form-control" placeholder="查询姓名" size=8
                                               name="searchName"
                                               value="${condition.userName}">
                                    </div>
                                    <div style="float:left; margin:0 2px; width: 65px;">
                                        <button type="submit" class="btn btn-info btn-fill pull-right">查询</button>
                                    </div>
                                </form>

                            </div>
                            <div class="content table-responsive table-full-width">
                                <table class="table table-hover table-striped">

                                    <form action="UserController?flag=pdelUser&searchName=${condition.userName}&depID=${condition.depID}&pageNow=${pageBean.pageNow}"
                                          method="post" onsubmit="return pdelUserPd()">


                                        <thead>

                                        <th>ID</th>
                                        <th>用户名</th>
<%--                                        <th>密码</th>--%>
                                        <th>用户编号</th>
                                        <th>性别</th>
                                        <th>年龄</th>
<%--                                        <th>部门</th>--%>
                                        <th>部门名称</th>
                                        <th>管理等级</th>
                                        <th>操作</th>
                                        <th>操作</th>
                                        <th><input type="submit" value="批量删除"></th>


                                        </thead>
                                        <tbody>

                                        <c:forEach items="${pageBean.userList}" var="u">

                                            <tr height="35px">
                                                <td>${u.id}</td>
                                                <td>${u.userName}</td>
<%--                                                <td>${u.userPwd}</td>--%>
                                                <td>${u.userCode}</td>

                                                <td>${u.userSex}</td>
                                                <td>${u.userAge}</td>
<%--                                                <td>${u.depID}</td>--%>
                                                <td>${depMap[u.depID]}</td>
                                                <td>${u.userPower eq 0?"普通管理员":"超级管理员"}</td>
                                                <td style="font-size: 12px"><a
                                                        href="UserController?flag=toModifyUser&id=${u.id}&searchName=${condition.userName}&depID=${condition.depID}&pageNow=${pageBean.pageNow}"
                                                        onclick="return powerpd()"

                                                >修改</a>
                                                </td>
                                                <td style="font-size: 12px">

                                                    <a href="UserController?flag=delUser&id=${u.id}&searchName=${condition.userName}&depID=${condition.depID}&pageNow=${pageBean.pageNow}"


                                                        <c:choose>
                                                            <c:when test="${sessionScope.user.userPower==0}">
                                                                onclick="return powerpdsc()">

                                                            </c:when>
                                                            <c:otherwise>
                                                                onclick="return delUserPd(${u.id})">
                                                            </c:otherwise>
                                                        </c:choose>
                                                        删除 </a>
                                                </td>

                                                <td><input type="checkbox" name="pdel" value="${u.id}"></td>

                                            </tr>

                                        </c:forEach>

                                        </tbody>

                                    </form>
                                </table>

                            </div>
                            <div style=" margin: 0 0 0px 50px;padding:0 0 20px 0; width: 70%;">

                                <%--                              首页--%>
                                <c:if test="${requestScope.pageBean.pageCount!=0}">

                                <a href="UserController?flag=userList&searchName=${condition.userName}&depID=${condition.depID}& pageNow = 1">[首页] </a>

                                </c:if>




                                <%--								上一页--%>
                                <c:if test="${pageBean.pageNow>1}">
                                    <a href="UserController?flag=userList&searchName=${condition.userName}&depID=${condition.depID}&pageNow=${pageBean.pageNow-1}">[上一页] </a>
                                </c:if>
                                <%--当前页--%>

                                <c:forEach begin="0" end="${fn:length(pageBean.pages)}" step="1" var="i">
                                    <a href="UserController?flag=userList&searchName=${condition.userName}&depID=${condition.depID}&pageNow=${pageBean.pages[i]}">

                                        <c:choose>
                                            <c:when test="${pageBean.pages[i]==pageBean.pageNow}">
                                                <span style="background-color: red">${pageBean.pages[i]}</span>
                                            </c:when>

                                            <c:otherwise>
                                                ${pageBean.pages[i]}
                                            </c:otherwise>
                                        </c:choose>
                                    </a>
                                </c:forEach>


                                <%--                                    ============================--%>


                                <%--	下一页--%>
                                <c:if test="${pageBean.pageNow<pageBean.pageCount}">
                                    <a href="UserController?flag=userList&searchName=${condition.userName}&depID=${condition.depID}&pageNow=${pageBean.pageNow+1}">[下一页]</a>
                                </c:if>


                                <%--    尾页--%>

                                 <c:if test="${requestScope.pageBean.pageCount!=0}">
                                     <a href="UserController?flag=userList&searchName=${condition.userName}&depID=${condition.depID}&pageNow=${pageBean.pageCount}">[尾页] </a>

                                     共${pageBean.pageCount}页


                                 </c:if>



                            </div>
                            <c:if test="${requestScope.pageBean.pageCount!=0}">

                                <form action="UserController?flag=userList&searchName=${condition.userName}&depID=${condition.depID}"
                                      method="post" >
                                    <div style=" float: right; margin:-50px 80px 0 0; width: 60px; height: 40px">
                                        <input type="number" id="skipNum" class="form-control" placeholder="页面" size=2
                                               max="${pageBean.pageCount}" min="1"
                                               name="pageNow">
                                    </div>
                                    <div style="float: right; margin:-50px 10px 0 0; width: 60px; height: 40px">
                                        <button type="submit" id="skipBut" class="btn btn-info btn-fill pull-right">跳转
                                        </button>
                                    </div>
                                </form>

                            </c:if>



                        </div>
                    </div>


                </div>

                <footer class="footer">
                    <div class="container-fluid">
                        <nav class="pull-left">
                            <ul>
                                <li>
                                    <a href="http://localhost:8080/cms/newstype?flag=newstypelist">
                                        浏览效果界面
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        Company
                                    </a>
                                </li>
                                <li>
                                    <a href="http://localhost:8080/">
                                        Tomcat管理页
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        微博
                                    </a>
                                </li>
                            </ul>
                        </nav>
                        <p class="copyright pull-right">
                            &copy; 2022 当前累计登陆访问次数 ：<span style="color: red ;font-size:30px">${totalTimes}</span> <a
                                href="#" target="_blank" title="联系我们"> </a> 统计来自 <a href="#" title="爱尚实训"
                                                                                    target="_blank">爱尚教育</a>
                        </p>
                    </div>
                </footer>
            </div>
        </div>
    </div>
</div>


</body>

<!--   Core JS Files   -->
<script src="view/js/jquery-1.10.2.js"
        type="text/javascript"></script>
<script src="view/js/bootstrap.min.js"
        type="text/javascript"></script>

<%--获取checkbox选中个数--%>
<script>$("input[type='checkbox']:checked").length</script>


<!--  Checkbox, Radio & Switch Plugins -->
<script
        src="view/js/bootstrap-checkbox-radio-switch.js"></script>

<!--  Charts Plugin -->
<script src="view/js/chartist.min.js"></script>

<!--  Notifications Plugin    -->
<script src="view/js/bootstrap-notify.js"></script>


<!-- Light Bootstrap Table Core javascript and methods for Demo purpose -->
<script
        src="view/js/light-bootstrap-dashboard.js"></script>

<!-- Light Bootstrap Table DEMO methods, don't include it in your project! -->
<script src="view/js/demo.js"></script>

<script src="${pageContext.request.contextPath}/view/js/jquery-1.10.2.js"></script>
<script>

    var users = [];
   function pdelUserPd() {
       var b=true;

      //普通管理员不能删除用户
      var c=${sessionScope.user.userPower};
      if (c ==0){
          alert("普通管理员不能删除用户");
          return false;
      }



        //获取选中信息
       $("input[name='pdel']:checked").each(function (index) {
           users[index]=$(this).val();

       });
       console.log(users);
       $.ajax({
           type:'post',
           url:'${pageContext.request.contextPath}/ajax',
           data:{
               'ids':users,
               'flag':'pdelUserPd',
               'uid':${sessionScope.user.id},
           },
           dataType:'text',
           async:false,
           traditional: true,   //深层序列化，保证后台拿到信息
           success:function (data) {
                if (data == 'no'){
                    alert("已发布新闻的用户无法删除");
                    b = false;
                }else if (data =='none'){
                    alert("您并没有选中要删除的用户");
                    b = false;
                }else if (data =="self"){
                    alert("您不能删除自己");
                    b = false;
                }
           }

       })
       return b;
   }

   function delUserPd(id) {
        var b=true;

       var uid=${sessionScope.user.id};
       if (id == uid){
           alert("您不能删除你自己");
           return false;
       }


       $.ajax({
           type:'post',
           url:'${pageContext.request.contextPath}/ajax',
           data: {
               'flag':'delUserPd',
               'id':id,
           },
           dataType:'text',
           async:false,
           success:function (data) {
                if (data =='ok'){
                    alert("已经发布新闻的用户无法删除！！！");
                    b = false;
                }else if (data =='no'){
                    alert("删除成功！！！");
                }
           }
       })
       return b;

   }

   function powerpd(){
       <c:if test="${sessionScope.user.userPower==0}">
       alert("普通管理员不能修改用户！！！")
       return false;
       </c:if>
   }

    function powerpdsc(){
        <c:if test="${sessionScope.user.userPower==0}">
        alert("普通管理员不能删除用户！！！")
        return false;
        </c:if>
    }




</script>

</html>