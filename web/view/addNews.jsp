<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<html>
<head>
    <meta charset="utf-8"/>
    <link rel="icon" type="image/png"
          href="view/img/favicon.ico">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>

    <title>新闻添加</title>

<%--  富文本编辑器  引入css和样式--%>
    <link href="https://unpkg.com/@wangeditor/editor@latest/dist/css/style.css" rel="stylesheet">

    <style>
        #editor—wrapper {
            border: 1px solid #ccc;
            z-index: 100; /* 按需定义 */
        }
        #toolbar-container { border-bottom: 1px solid #ccc; }
        #editor-container { height: 500px; }
    </style>






    <meta
            content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0'
            name='viewport'/>
    <meta name="viewport" content="width=device-width"/>


    <!-- Bootstrap core CSS     -->
    <link
            href="view/css/bootstrap.min.css"
            rel="stylesheet"/>

    <!-- Animation library for notifications   -->
    <link
            href="view/css/animate.min.css"
            rel="stylesheet"/>

    <!--  Light Bootstrap Table core CSS    -->
    <link
            href="view/css/light-bootstrap-dashboard.css"
            rel="stylesheet"/>


    <!--  CSS for Demo Purpose, don't include it in your project     -->
    <link
            href="view/css/demo.css"
            rel="stylesheet"/>


    <!--     Fonts and icons     -->
    <style type="text/css">
        .new-contentarea {
            width: 100%;
            overflow: hidden;
            margin: 0 auto;
            position: relative;
        }

        .new-contentarea label {
            width: 100%;
            height: 100%;
            display: block;
        }

        .new-contentarea input[type=file] {
            width: 188px;
            height: 60px;
            background: #333;
            margin: 0 auto;
            position: absolute;
            right: 50%;
            margin-right: -94px;
            top: 0;
            right /*\**/: 0px \9;
            margin-right /*\**/: 0px \9;
            width /*\**/: 10px \9;
            opacity: 0;
            filter: alpha(opacity=0);
            z-index: 2;
        }

        a.upload-img {
            width: 165px;
            display: inline-block;
            margin-bottom: 10px;
            height: 57px;
            line-height: 57px;
            font-size: 20px;
            color: #FFFFFF;
            background-color: #f38e81;
            border-radius: 3px;
            text-decoration: none;
            cursor: pointer;
        }

        a.upload-img:hover {
            background-color: #ec7e70;
        }

        .tc {
            text-align: center;
        }
    </style>
    <link
            href="view/css/pe-icon-7-stroke.css"
            rel="stylesheet"/>
    <script type="text/javascript"
            src="view/js/XMLHttpRequest.js"></script>
    <script type="text/javascript"
            src="view/js/jquery-1.10.2.js"></script>


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
                                <h4 class="title">新闻添加</h4>
                            </div>
                            <div class="content">


                                <form   name="form1"
                                        action="NewsController?flag=addNews"
                                        method="post" onsubmit="return myCheck()">

                                    <div>


                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label for="exampleInputEmail1">新闻类别</label>
                                                <select
                                                    class="form-control" name="typeid" id="typeid">
                                                <option value="-1" selected>请选择</option>
                                                <c:forEach items="${classMap}" var="item">
                                                    <option value="${item.key}">${item.value}</option>
                                                </c:forEach>


                                            </select><span id="errortypeid" style="color: red"></span>

                                            </div>
                                        </div>
                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label>新闻ID(默认)</label> <input type="text" name="newsid"
                                                                               class="form-control" readonly="Company"
                                                                               value="" placeholder="新闻id">
                                            </div>
                                        </div>
                                    </div>


                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <label>标题</label> <input type="text" name="title"
                                                                         id="title" class="form-control"
                                                                         placeholder="新闻标题"
                                                                         value=""><span style="color: red" id="errortitle"></span>

                                            </div>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <label>内容</label>
                                                <div id="editor—wrapper">
                                                    <div id="toolbar-container"><!-- 工具栏 --></div>
                                                    <div id="editor-container"><!-- 编辑器 --></div>
                                                </div>
                                                <textarea rows="15" name="content" id="content"
                                                          class="form-control"  style="display: none"></textarea>

                                            </div>
                                        </div>
                                    </div>

                                    <button type="submit" id="submit"
                                            class="btn btn-info btn-fill pull-right" >提交
                                    </button>
                                    <div class="clearfix"></div>
                                </form>
                            </div>
                        </div>
                    </div>


                    <div class="col-md-4">
                        <div class="card card-user">
                            <div class="image">
                                <img src="view/images/userleft.bg.jpg" alt="#"/>
                            </div>
                            <div class="content">
                                <div class="author">
                                    <a href="#">

                                        <img class="avatar border-gray" src="view/images\faces\face-3.jpg" alt="#"/>


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
                    &copy; 2022  当前累计登陆访问次数 ：<span style="color: red ;font-size:30px">${totalTimes}</span> <a href="#" target="_blank" title="联系我们"> </a>
                </p>
            </div>
        </footer>
    </div>
</div>


</body>



<!--   Core JS Files   -->
<script
        src="view/js/jquery-1.10.2.js"
        type="text/javascript"></script>
<script
        src="view/js/bootstrap.min.js"
        type="text/javascript"></script>

<!--  Checkbox, Radio & Switch Plugins -->
<script
        src="view/js/bootstrap-checkbox-radio-switch.js"></script>

<!--  Charts Plugin -->
<script
        src="view/js/chartist.min.js"></script>

<!--  Notifications Plugin    -->
<script
        src="view/js/bootstrap-notify.js"></script>


<!-- Light Bootstrap Table Core javascript and methods for Demo purpose -->
<script
        src="view/js/light-bootstrap-dashboard.js"></script>

<!-- Light Bootstrap Table DEMO methods, don't include it in your project! -->
<script
        src="view/js/demo.js"></script>



<%--富文本编辑器js--%>

<script src="https://unpkg.com/@wangeditor/editor@latest/dist/index.js"></script>
<script>
    const { createEditor, createToolbar } = window.wangEditor

    const editorConfig = {
        placeholder: 'Type here...',
        onChange(editor) {
            const html = editor.getHtml()
          $("#content").val(html)
            // 也可以同步到 <textarea>
        }
    }

    const editor = createEditor({
        selector: '#editor-container',
        html: '<p><br></p>',
        config: editorConfig,
        mode: 'default', // or 'simple'
    })

    const toolbarConfig = {}

    const toolbar = createToolbar({
        editor,
        selector: '#toolbar-container',
        config: toolbarConfig,
        mode: 'default', // or 'simple'
    })




</script>









<%--js--%>
<script>

</script>


<%--Ajax--%>
<script src="${pageContext.request.contextPath}/view/js/jquery-1.10.2.js"></script>
<script >


    <%--$("#typeid").change(function () {--%>
    <%--    $.ajax({--%>
    <%--        type:'get',--%>
    <%--        url:"${pageContext.request.contextPath}/ajax?flag=checkTypeid&title="+$("#typeid").val(),--%>
    <%--        dataType:"text",--%>
    <%--        success:function (data) {--%>
    <%--            if (data =="no"){--%>
    <%--                $("#errortypeid").html("请选择一个种类");--%>
    <%--            }else{--%>
    <%--                $("#errortypeid").html("成功")--%>
    <%--            }--%>

    <%--        }--%>
    <%--    })--%>
    <%--})--%>

    // $("#submit").click(function () {
    //     if ($("#typeid").val()==-1){
    //         alert("请选择一种新闻类型！");
    //         $("#typeid").focus();
    //
    //     }
    //     if ($("#title")==null||$("#title").val().trim()==0){
    //         alert("请填写新闻标题");
    //         $("#title").focus();
    //         return;
    //     }
    // })



    //表单所有项目不能为空
    // function myCheck()
    // {
    //     if($("#typeid").val()==-1||$("#title")==null||$("#content").val()=="<p><br></p>"||$("#title").val().trim()==0||$("#content").val().trim()==0){
    //         alert("当前表单不能有空项");
    //         return false;
    //     }
    //
    //     return true;
    //
    // }


    //表单所有项目不能为空
    function myCheck()
    {
        var b =true;
        //ajax查询新闻标题是否重复
        $.ajax({
            type: 'post',
            url:'${pageContext.request.contextPath}/ajax',
            data: {
                'flag':'checkNewsTitle',
                'title':$('#title').val(),
                'uid':${sessionScope.user.id}
            },
            async: false,
            dataType: 'text',
            success:function(data){
                if (data == 'sametitle'){
                    alert('新闻标题已存在');
                    b = false;

                }
            }
        })

        if (b ==false){
            return false;
        }


        let str1=$("#content").val();

        let  str2=str1.replace(/ &nbsp;/gi, "");
        // alert(str2)



        if (str2=='<p></p>'||str2=='<p> </p>'){
            alert("不要只打空格！！！");
            return false;
        }else if ($("#title")==null){
            alert("标题没有标题！！！");
            return false;
        }else if ($("#title").val().trim()==""){
            alert("请输入标题？");
            return false;
        }else if ($("#typeid").val()==-1){
            alert("请填写新闻类别");
            return false;
        }else if($("#content").val()=='<p><br></p>'){
            alert("新闻内容为空就提交！！！")
            return false;
        }


        if($("#typeid").val()==-1||$("#title")==null||$("#title").val().trim()==""||$("#content").val()=='<p><br></p>'){
            alert("请将选项填写完整");

            return false;
        }

        return true;

    }

</script>





</html>