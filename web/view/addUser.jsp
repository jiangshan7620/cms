<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta charset="utf-8"/>
    <link rel="icon" type="image/png" href="view/images/favicon.ico">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>

    <title>添加用户</title>

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport'/>
    <meta name="viewport" content="width=device-width"/>


    <!-- Bootstrap core CSS     -->
    <link href="view/css/bootstrap.min.css" rel="stylesheet"/>

    <!-- Animation library for notifications   -->
    <link href="view/css/animate.min.css" rel="stylesheet"/>

    <!--  Light Bootstrap Table core CSS    -->
    <link href="view/css/light-bootstrap-dashboard.css" rel="stylesheet"/>


    <!--  CSS for Demo Purpose, don't include it in your project     -->
    <link href="view/css/demo.css" rel="stylesheet"/>


    <!--     Fonts and icons     -->
    <link href="view/css/pe-icon-7-stroke.css" rel="stylesheet"/>

    <script type="text/javascript" src="js/jquery-1.10.2.js"></script>


</head>
<body>

<div class="wrapper">


    <div class="sidebar" data-color="grow" data-image="images/sidebar-5.jpg">
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
                            <a href="http://localhost:8080/cms/NewsController?flag=toAddNews" >
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
                            <a href="http://localhost:8080/cms/ajax?flag=addDep" >
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
                            <a href="http://localhost:8080/cms/ajax?flag=addType" >
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
                    <div class="col-md-8">
                        <div class="card">
                            <div class="header">
                                <h4 class="title">添加用户</h4>
                            </div>
                            <div class="content">
                                <form action="UserController?flag=addUser"
                                      method="post"
                                onsubmit="return add()">
                                    <div class="row">
                                        <div class="col-md-5">
                                            <div class="form-group">
                                                <label>用户ID(不可更改)</label>
                                                <input type="text" class="form-control" name="id" readonly=true
                                                       value="" placeholder="用户id">
                                            </div>
                                        </div>
                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label>权限</label>
                                                <select name="userpower" class="form-control">
                                                    <option value=1 >超级管理员</option>
                                                    <option value=0>普通管理员</option>
                                                </select>

                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <label for="exampleInputEmail1">部门</label>
                                                <select name="depID" class="form-control">

                                                    <option class="form-control" value="1">爱尚教质部</option>

                                                    <option class="form-control" value="2">爱尚网络部</option>

                                                    <option class="form-control" value="3">爱尚卫生部</option>
                                                    <option class="form-control" selected="selected" value="4">爱尚学习部
                                                    </option>

                                                    <option class="form-control" value="5">爱尚市场部</option>
                                                    <option class="form-control" value="6">爱尚纪律部</option>


                                                </select>
                                                <!-- <input type="email" class="form-control" placeholder="Email"> -->
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label>用户名</label>
                                                <input type="text" class="form-control" id="username" placeholder="真实姓名"
                                                       name="username" value="">
                                                <span id="recMsg" style="color: red"></span>
                                                <label>用户编号</label>
                                                <input type="text" class="form-control" id="usercode" placeholder="用户编号"
                                                       name="usercode" value="">
                                                <span id="recMsg" style="color: red"></span>



                                            </div>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label>密码</label>
                                                <input type="password" class="form-control" placeholder="不能为汉字"
                                                       name="password" value="" id="password"><span
                                                    id="errorpass" style="color: red"></span>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <label>性别</label><br>
                                                <input type="radio" checked="checked" name="usersex" value="男">男&nbsp&nbsp&nbsp&nbsp
                                                <input type="radio" name="usersex" value="女">女
                                            </div>
                                        </div>

                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <label>年龄</label>
                                                <input type="number" name="userage" class="form-control" value=""
                                                       id="userage"><span id="errorage" style="color: red"></span>
                                            </div>
                                        </div>
                                    </div>


                                    <button type="submit" class="btn btn-info btn-fill pull-right" id="add1">添加</button>
                                    <div class="clearfix"></div>
                                </form>
                            </div>
                        </div>
                    </div>


                    <div class="col-md-4">
                        <div class="card card-user">
                            <div class="image">
                                <img src="view/images/userleft.bg.jpg" alt="/newsSystem."/>
                            </div>
                            <div class="content">
                                <div class="author">
                                    <a href="#">

                                        <img class="avatar border-gray" src="view/images\faces\face-3.jpg" alt=""/>


                                        <h4 class="title">admin<br/>
                                            <small>爱尚教育部</small>
                                        </h4>
                                    </a>
                                </div>
                                <p class="description text-center"> admin是一位 <br>
                                    18岁的女孩, 在<br>
                                    爱尚教育部努力工作
                                </p>
                            </div>
                            <hr>
                            <div class="text-center">
                                <button href="#" class="btn btn-simple"><i class="fa fa-facebook-square"></i></button>
                                <button href="#" class="btn btn-simple"><i class="fa fa-twitter"></i></button>
                                <button href="#" class="btn btn-simple"><i class="fa fa-google-plus-square"></i>
                                </button>

                            </div>
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
                    &copy; 2022  当前累计登陆访问次数 ：<span style="color: red ;font-size:30px">${totalTimes}</span> <a href="#" target="_blank" title="联系我们"> </a>  统计来自 <a href="#" title="爱尚实训" target="_blank">爱尚教育</a>
                </p>
            </div>
        </footer>

    </div>
</div>


</body>

<!--   Core JS Files   -->
<script src="view/js/jquery-1.10.2.js" type="text/javascript"></script>
<script src="view/js/bootstrap.min.js" type="text/javascript"></script>

<!--  Checkbox, Radio & Switch Plugins -->
<script src="view/js/bootstrap-checkbox-radio-switch.js"></script>

<!--  Charts Plugin -->
<script src="view/js/chartist.min.js"></script>

<!--  Notifications Plugin    -->
<script src="view/js/bootstrap-notify.js"></script>

<!-- Light Bootstrap Table Core javascript and methods for Demo purpose -->
<script src="view/js/light-bootstrap-dashboard.js"></script>

<!-- Light Bootstrap Table DEMO methods, don't include it in your project! -->
<script src="view/js/demo.js"></script>

<script src="${pageContext.request.contextPath}/view/js/jquery-1.10.2.js"></script>
<script>
    <%-- 1.用户名验证   --%>


    //    2.密码验证


    //3.年龄验证



    //4.用户添加提交按钮验证
    <%--$("#add1").click(function () {--%>
    <%--    $.ajax({--%>
    <%--        type: 'post',--%>
    <%--        url: '${pageContext.request.contextPath}/ajax',--%>
    <%--        data: {--%>
    <%--            'flag':'insertUserClick',--%>
    <%--            'username':$('#username').val(),--%>
    <%--            'password':$('#password').val(),--%>
    <%--            'age':$('#userage').val(),--%>
    <%--        },--%>
    <%--        dataType: 'text',--%>
    <%--        success: function (data) {--%>
    <%--            if (data == 'noname'){--%>
    <%--                alert('请输入用户名');--%>
    <%--            }else if (data == 'nopass'){--%>
    <%--                alert('请输入密码');--%>
    <%--            }else if (data == 'noage'){--%>
    <%--                alert('请输入正确的年龄')--%>
    <%--            }else if (data =='samename'){--%>
    <%--                alert('用户名已存在，重新输入')--%>
    <%--            }--%>

    <%--        }--%>
    <%--    })--%>
    <%--})--%>

    function add() {

        var b=true;

        $.ajax({
            type:'post',
            url:'${pageContext.request.contextPath}/ajax',
            data:{
                'flag':'checkUserName',
                'username':$("#username").val(),


            },
            async:false,
            dataType:'text',
            success:function (data) {
                if (data =='non'){
                    alert("用户名已存在");
                  b = false;

                }
            }
        })

        if (b ==false){
            return false;
        }

        if ($("#username").val().trim()==''){
            alert("请输入用户名");
            return false;

        }else if ($("#usercode").val().trim()==''){
            alert('请输入用户编号');
            return false;

        }

        else if ($("#password").val().trim()==''){
            alert("请输入密码");
            return false;

        }else if ($("#userage").val().trim()==''){
            alert('请输入年龄');
            return false;

        } else if ($("#userage").val()>120||$("#userage").val()<0){
            alert('请输入正确的年龄');
            return false;

        }
        return true;
    }





</script>

</html> 