


<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta charset="utf-8" />
<link rel="icon" type="image/png"
	href="img/favicon.ico">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

<title>管理页面</title>

<meta
	content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0'
	name='viewport' />
<meta name="viewport" content="width=device-width" />


<!-- Bootstrap core CSS     -->
<link href="css/bootstrap.min.css"
	rel="stylesheet" />

<!-- Animation library for notifications   -->
<link href="css/animate.min.css"
	rel="stylesheet" />

<!--  Light Bootstrap Table core CSS    -->
<link
	href="css/light-bootstrap-dashboard.css"
	rel="stylesheet" />


<!--  CSS for Demo Purpose, don't include it in your project     -->
<link href="css/demo.css"
	rel="stylesheet" />


<!--     Fonts and icons     -->

<link href="css/pe-icon-7-stroke.css"
	rel="stylesheet" />



</head>
<body>

<%--adsfasdfasdfas--%>
<%--${user.userPower}--%>
${user.userPower}

	<div class="wrapper">
		


	
    <div class="sidebar" data-color="grow" data-image="images/sidebar-5.jpg">
    	<div class="sidebar-wrapper">
            <div class="logo">
                <a href="#" class="simple-text">
                    <img src="images/logo.png">
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
						<div class="card">
							<div class="header">
								<h4 class="title">主页</h4>
								<p class="category">====================</p>
                                <p style="color: red;font-size: 20px " >欢迎您！！！
                                <c:choose>
                                    <c:when test="${sessionScope.user.userPower==0}">
                                        普通管理员 ${sessionScope.user.userName}
                                    </c:when>
                                    <c:otherwise>
                                        超级管理员 ${sessionScope.user.userName}
                                    </c:otherwise>
                                </c:choose>


                                </p>
                                <img src="${pageContext.request.contextPath}/view/images/bug.jpg">

							</div>
							<div style="width: 800px; height: 400px;">
								
									
								
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
<script src="js/jquery-1.10.2.js"
	type="text/javascript"></script>
<script src="js/bootstrap.min.js"
	type="text/javascript"></script>

<!--  Checkbox, Radio & Switch Plugins -->
<script
	src="js/bootstrap-checkbox-radio-switch.js"></script>

<!--  Charts Plugin -->
<script src="js/chartist.min.js"></script>

<!--  Notifications Plugin    -->
<script src="js/bootstrap-notify.js"></script>


<!-- Light Bootstrap Table Core javascript and methods for Demo purpose -->
<script
	src="js/light-bootstrap-dashboard.js"></script>

<!-- Light Bootstrap Table DEMO methods, don't include it in your project! -->
<script src="js/demo.js"></script>

<script type="text/javascript">
	$(document).ready(function() {

		demo.initChartist();

		$.notify({
			icon : 'pe-7s-gift',
			message : "欢迎您 <b>${user.userName}</b>"

		}, {
			type : 'info',
			timer : 4000
		});

	});
</script>

</html>