<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<html>
<head>
    <script type="text/javascript"
            src="view/js/XMLHttpRequest.js">

    </script>


    <script type="text/javascript">
        window.onload = function () {
            var pends = document.getElementsByName("upPend");
            var states = document.getElementsByName("state");
            var skipBut = document.getElementById("skipBut");

            for (var i = 0; i < pends.length; i++) {

                pends[i].onchange = function () {

                    var xhq = getXMLHttpRequest();

                    xhq.open("get",
                        "manage/NewsAction?flag=flagNews&uppend="
                        + this.value + "&flagId=" + this.id);
                    xhq.send(null);
                    xhq.onreadystatechange = function () {
                        if (xhq.readyState == 4 && xhq.status == 200) {
                            demo.initChartist();

                            $.notify({
                                icon: 'pe-7s-gift',
                                message: " <b>修改成功</b>"

                            }, {
                                type: 'info',
                                timer: 4000

                            });

                        }
                        ;
                    };
                };
            }
            ;
        };
    </script>
    <meta charset="utf-8"/>
    <link rel="icon" type="image/png"
          href="view/img/favicon.ico">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>

    <title>新闻审核</title>

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
    <link
            href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"
            rel="stylesheet">
    <link href="view/css/pe-icon-7-stroke.css"
          rel="stylesheet"/>

</head>
<body>

${user.userPower}

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
                                <h4 class="title">新闻管理</h4>
                                <p class="category">Here is a subtitle for this table</p>

                                <form action="NewsController?flag=newsList" method="post">

                                    <div style="float:left; margin:0 2px; width: 130px;">
                                        <select name="selclass" class="form-control" style="width: 130px;">

                                            <option value="-1" selected>所有类别</option>

                                            <c:forEach items="${classMap}" var="i">
                                                <c:choose>
                                                    <c:when test="${i.key==sel.typeid}">
                                                        <option selected value="${i.key}">${i.value}</option>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <option value="${i.key}">${i.value}</option>
                                                    </c:otherwise>
                                                </c:choose>
                                            </c:forEach>


                                        </select>
                                    </div>

                                    <div style="float:left; margin:0 2px; width: 100px;">
                                        <select name="selstate" class="form-control">
                                            <option selected="selected" value="-1">全部</option>
                                            <c:forEach items="${stateMap}" var="i">
                                                <c:choose>

                                                    <c:when test="${i.key==sel.flag}">
                                                        <option value="${i.key}" selected>${i.value}</option>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <option value="${i.key}">${i.value}</option>
                                                    </c:otherwise>
                                                </c:choose>

                                            </c:forEach>


                                        </select>
                                    </div>

                                    <div style="float:left; margin:0 2px; width: 130px;">
                                        <input type="text" class="form-control" placeholder="新闻名称" size=8
                                               name="seltitle" value="${sel.title}">
                                    </div>
                                    <div style="float:left; margin:0 2px; width: 65px;">
                                        <button type="submit" class="btn btn-info btn-fill pull-right">查询</button>
                                    </div>
                                </form>


                            </div>


                            <div class="content table-responsive table-full-width">
                                <form
                                        action="NewsController?flag=delNews"
                                        method="post" onsubmit="delNewsPd()" >
                                    <input type="hidden" name="selclass" value="${sel.typeid}">
                                    <input type="hidden" name="selstate" value="${sel.flag}">
                                    <input type="hidden" name="seltitle" value="${sel.title}">

                                    <%--										<c:choose>--%>
                                    <%--											<c:when test="${pageBean.rowCount%10==1&&pageBean.pageNow>1}">--%>
                                    <%--												<input type="hidden" name="pageNow" value="${pageBean.pageNow-1}">--%>
                                    <%--											</c:when>--%>
                                    <%--											<c:otherwise>--%>
                                    <%--												<input type="hidden" name="pageNow" value="${pageBean.pageNow}">--%>
                                    <%--											</c:otherwise>--%>
                                    <%--										</c:choose>--%>
                                    <input type="hidden" name="pageNow" value="${pageBean.pageNow}">


                                    <table class="table table-hover table-striped">
                                        <thead>
                                        <th>ID</th>
                                        <th>标题</th>
                                        <th>类别</th>
                                        <th>日期</th>
                                        <th>上传人</th>

                                        <th>审核</th>
                                        <c:if test="${user.userPower!=1}">
                                            <th>操作</th>
                                        </c:if>
                                        <c:if test="${user.userPower!=1}">
                                            <th>
                                                <button class="btn btn-info btn-fill pull-left"
                                                        id="delNewsClick"  >删除
                                                </button>
                                            </th>
                                        </c:if>


                                        </thead>
                                        <tbody>
                                        <c:forEach var="n" items="${pageBean.newsList}">
                                            <tr>
                                                <td>${n.id}</td>
                                                <td>

                                                    <a href="NewsController?flag=toModifyNews&id=${n.id}&selclass=${sel.typeid}&selstate=${sel.flag}&seltitle=${sel.title}&pageNow=${requestScope.pageBean.pageNow}  "

                                                            <c:if test="${sessionScope.user.userPower == 0}">
                                                                onclick="return modpd(${n.id})"
                                                            </c:if>
                                                    >

                                                            ${n.title}

                                                    </a>

                                                </td>
                                                <td>${classMap[n.typeid]}</td>

                                                <td>${n.createtime}</td>
                                                <td>${n.userName}</td>
                                                    <%--														<td>${stateMap[n.flag]}</td>--%>
                                                <td>
                                                    <select name="state"  ${user.userPower==1?'':'disabled'} id="state"
                                                            onchange="stateChange(${n.id})">

                                                        <c:forEach items="${stateMap}" var="item">
                                                            <c:choose>
                                                                <c:when test="${item.key==n.flag}">
                                                                    <option selected
                                                                            value="${item.key}"> ${item.value}</option>

                                                                </c:when>
                                                                <c:otherwise>
                                                                    <option value="${item.key}">${item.value}</option>
                                                                </c:otherwise>
                                                            </c:choose>

                                                        </c:forEach>
                                                    </select>


                                                        <%--														${stateMap[n.flag]}--%>
                                                </td>


                                                <td>
                                                    <c:if test="${user.userPower!=1}">
                                                        <%--																<button type="button" rel="tooltip" title="修改"--%>
                                                        <%--																		class="btn btn-info btn-simple btn-xs"--%>

                                                        <%--																		onclick="return function modpd(${n.id});window.location.href='NewsController?flag=toModifyNews&id=${n.id}&selclass=${sel.typeid}&selstate=${sel.flag}&seltitle=${sel.title}&pageNow=${requestScope.pageBean.pageNow}&uid=${sessionScope.user.id}'">--%>
                                                        <%--																	<i class="fa fa-edit"></i>--%>
                                                        <%--																</button>--%>
                                                        <a href="NewsController?flag=toModifyNews&id=${n.id}&selclass=${sel.typeid}&selstate=${sel.flag}&seltitle=${sel.title}&pageNow=${requestScope.pageBean.pageNow}&uid=${sessionScope.user.id}"
                                                           onclick="return modpd(${n.id})">修改</a>

                                                    </c:if>


                                                        <%--															<button type="button" rel="tooltip" title="修改"--%>
                                                        <%--																	class="btn btn-info btn-simple btn-xs"--%>
                                                        <%--																	onclick="window.location.href='NewsController?flag=toModifyNews&id=${n.id}&selclass=${sel.typeid}&selstate=${sel.flag}&seltitle=${sel.title}'">--%>
                                                        <%--															<i class="fa fa-edit"></i>--%>
                                                        <%--														</button>--%>


                                                </td>

                                                <c:if test="${user.userPower!=1}">
                                                    <td><label class="checkbox"> <input
                                                            type="checkbox" value="${n.id}" name="checkbox"
                                                            data-toggle="checkbox">
                                                    </label></td>
                                                </c:if>


                                            </tr>


                                        </c:forEach>

                                        </tbody>
                                    </table>
                                </form>
                            </div>
                            <div style=" margin: 0 0 0px 50px;padding:0 0 20px 0; width: 70%;">

                                <c:if test="${requestScope.pageBean.pageCount!=0}">


                                <a href="NewsController?flag=newsList&selclass=${sel.typeid}&selstate=${sel.flag}&seltitle=${sel.title}&pageNow=1">[首页]</a>

                                <c:if test="${pageBean.pageNow>1}">
                                    <a href="NewsController?flag=newsList&selclass=${sel.typeid}&selstate=${sel.flag}&seltitle=${sel.title}&pageNow=${pageBean.pageNow-1}">[上一页]</a>

                                </c:if>


                                <c:forEach begin="0" end="${fn:length(pageBean.pages)}" step="1" var="i">
                                    <a href="NewsController?flag=newsList&selclass=${sel.typeid}&selstate=${sel.flag}&seltitle=${sel.title}&pageNow=${pageBean.pages[i]}">

                                        <c:choose>
                                            <c:when test="${pageBean.pageNow==pageBean.pages[i]}">
                                                <span style="background-color: red">${pageBean.pages[i]}</span>
                                            </c:when>
                                            <c:otherwise>
                                                ${pageBean.pages[i]}
                                            </c:otherwise>
                                        </c:choose>
                                    </a>
                                </c:forEach>


                                <c:if test="${pageBean.pageNow<pageBean.pageCount}">
                                    <a href="NewsController?flag=newsList&selclass=${sel.typeid}&selstate=${sel.flag}&seltitle=${sel.title}&pageNow=${pageBean.pageNow+1}">[下一页]</a>
                                </c:if>
                                <a href="NewsController?flag=newsList&selclass=${sel.typeid}&selstate=${sel.flag}&seltitle=${sel.title}&pageNow=${pageBean.pageCount}">[尾页]</a>


                            </div>
                            <form
                                    action="NewsController?flag=newsList&selclass=${sel.typeid}&selstate=${sel.flag}&seltitle=${sel.title}"
                                    method="post"  >
                                <div
                                        style="float: right; margin:-50px 10px 0 0; width: 60px; height: 40px">
                                    <button type="submit" id="skipBut"
                                            class="btn btn-info btn-fill pull-right">跳转
                                    </button>
                                </div>
                                <div
                                        style="float: right; margin:-50px 80px 0 0; width: 60px; height: 40px">
                                    <input type="number" id="skipnewsNum" class="form-control"
                                           placeholder="页面" size=2 name="pageNow" max="${pageBean.pageCount}" min="1"
                                           value="${pageBean.pageNow}">
                                </div>

                            </form>

                            </c:if>

                        </div>
                    </div>


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
                    &copy; 2022 当前累计登陆访问次数 ：<span style="color: red ;font-size:30px">${totalTimes}</span> <a href="#"
                                                                                                             target="_blank"
                                                                                                             title="联系我们"> </a>
                    统计来自 <a href="#" title="爱尚实训" target="_blank">爱尚教育</a>
                </p>
            </div>
        </footer>
    </div>
</div>


</body>

<!--   Core JS Files   -->
<script src="view/js/jquery-1.10.2.js"
        type="text/javascript"></script>
<script src="view/js/bootstrap.min.js"
        type="text/javascript"></script>

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

<%--Ajax 状态栏--%>
<script src="${pageContext.request.contextPath}/view/js/jquery-1.10.2.js"></script>
<script>
    function stateChange(id) {
        $.ajax({
            type: 'post',
            url: '${pageContext.request.contextPath}/ajax',
            data: {
                "flag": "checkState",
                "id": id,
                "state": $("#state").val(),
            },
            dataType: 'text',
            success: function (data) {
                console.log("success!!!")

            }
        })
    }

    function modpd(id) {

        // alert("哈哈哈哈")
        var b = true;
        $.ajax({
            type: 'post',
            url: '${pageContext.request.contextPath}/ajax',
            data: {
                'flag': 'findFlagByNewsid',
                'id': id,
            },
            async: false,
            dataType: 'text',
            success: function (data) {
                if (data == 'ok') {
                    alert("新闻已通过，不可以再更改新闻！")
                    b = false;
                }

            }
        })
        return b;

    }


    var news =[];
    function delNewsPd() {

        alert("hahahhahah")
        //获取选中信息
        $("input[name='checkbox']:checked").each(function (index) {
            news[index]=$(this).val();

        });

        $.ajax({
            type:'post',
            url:'${pageContext.request.contextPath}/ajax',
            data:{
                'ids':news,
                'flag':'pdelNewsPd'
            },
            dataType:'text',
            traditional: true,   //深层序列化，保证后台拿到信息
            success:function (data) {
                if (data == 'no'){
                    alert("已通过的新闻无法删除！！");
                }
            }

        })



    }




</script>


</html>