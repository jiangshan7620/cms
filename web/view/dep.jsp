


<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
	<meta charset="utf-8" />
	<link rel="icon" type="image/png" href="img/favicon.ico">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

	<title>部门列表</title>

	<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />


    <!-- Bootstrap core CSS     -->
    <link href="view/css/bootstrap.min.css" rel="stylesheet" />

    <!-- Animation library for notifications   -->
    <link href="view/css/animate.min.css" rel="stylesheet"/>

    <!--  Light Bootstrap Table core CSS    -->
    <link href="view/css/light-bootstrap-dashboard.css" rel="stylesheet"/>


    <!--  CSS for Demo Purpose, don't include it in your project     -->
    <link href="view/css/demo.css" rel="stylesheet" />


    <!--     Fonts and icons     -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="view/css/pe-icon-7-stroke.css" rel="stylesheet" />


	
	<script type="text/javascript" src="view/js/XMLhttpRequest.js"></script>
	<script type="text/javascript" src="view/js/jquery-1.10.2.js"></script>
	<script type="text/javascript">
	
	$(function(){
		$("[name='del']").click(function(){
			var trid = "tr"+this.value;
			$.ajax({
				  url:"manage/NewsAction?flag=delNewsType&typeID="+this.value,
				  success:function(data){
					  
					  if(data == "true" ){
						  var deltr = document.getElementById(trid);
						  $(("#"+trid)).remove();
						  demo.initChartist();

				        	$.notify({
				            	icon: 'pe-7s-gift',
				            	message: " <b>删除成功</b>"

				            },{
				                type: 'info',
				                timer: 4000
				            

				    	});
					  }else{
						  demo.initChartist();

				        	$.notify({
				            	icon: 'pe-7s-gift',
				            	message: " <b>删除失败</b>"

				            },{
				                type: 'danger',
				                timer: 4000
				            

				    	});
						  
					  }
				  }			   
			   });
		   });
			
			
		});
				   
			
	
	
	</script>
	
	
	
	
	
	
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
                    <a href="#">
                        <i class="pe-7s-rocket"></i>
                        <p onclick="depjson()">json测试</p>
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
                	<div class="col-md-6" style="width: 800px;">
                        <div class="card ">
                            <div class="header">
                                <h4 class="title">部门管理</h4>
                                <p class="category">Backend development</p>
                            </div>
                            <div style="float:right; width: 150px; height:50px;  margin-right: 10px; margin-top: -30px;">
                          	
		                           
		                          
		                          <!--  </div> -->
                          
                           </div>
                            <div class="content" id="depInfo">
                                <div class="table-full-width">
                                    <table class="table" id="table">
                                        <tbody>
                                           <tr>
                                            <td>部门ID</td>
                                            <td>部门名称</td>
                                            <td>部门排序</td>
                                            <td colspan=2 align="center">操作</td>
                                           </tr>


                                            
                                            
<%--                                           <c:forEach items="${dep}" var="item">--%>
<%--                                               <tr id="tr${item.id}">--%>

<%--                                                   <td>--%>
<%--                                                       <input type="text" class="form-control" readonly=true name="id${item.id}" id="id${item.id}" value="${item.id}">--%>
<%--                                                   </td>--%>

<%--                                                   <td>--%>
<%--                                                       <input type="text" class="form-control" name="type${item.id}" id="type${item.id}" placeholder="类别名称" value="${item.depName}"   name="" onfocus="">--%>
<%--&lt;%&ndash;                                                              onblur="if (this.value == '') {this.value = '国家';}">&ndash;%&gt;--%>
<%--                                                   </td>--%>
<%--                                                   <td>--%>
<%--                                                       <input type="number" class="form-control" name="sort${item.id}" id="sort${item.id}" placeholder="部门排序" value="${item.sort}"   name="" onfocus="">--%>
<%--&lt;%&ndash;                                                              onblur="if (this.value == '') {this.value = '国家';}">&ndash;%&gt;--%>
<%--                                                   </td>--%>



<%--                                                   <td class="td-actions text-right">--%>
<%--                                                       <button type="submit" rel="tooltip" title="修改" onclick="modDep(${item.id})"  class="btn btn-info btn-simple btn-xs" >--%>
<%--                                                           <i class="fa fa-edit"></i>--%>
<%--                                                       </button>--%>
<%--                                                       <button type="button" rel="tooltip" title="删除" name="del${item.id}" id="del${item.id}" value="" class="btn btn-danger btn-simple btn-xs" onclick=delDep(${item.id}) >--%>
<%--                                                           <i class="fa fa-times"></i>--%>
<%--                                                       </button>--%>


<%--                                                   </td>--%>


<%--                                               </tr>--%>

<%--                                           </c:forEach>--%>
                                           <span id="errDel" style="color: red" align="right"></span>

                                        </tbody>

                                    </table>

                                </div>

                                <div class="footer">
                                    <hr>
                                    <div class="stats">
                                        <i class="fa fa-history"></i>添加部门
                                        <table class="table">
                                            <tr>
                                                <td>      
					                            <input type="text" class="form-control" readonly=true name="typeID" value="" placeholder="id">
					                            </td>
                                                <td>      
					                            <input type="text" class="form-control" name="typeName" placeholder="部门名称" id="depName">
					                            </td>
					                            <td>
					                            <div style=" width:130px;">
												<input type="text" class="form-control" placeholder="部门优先级"   name="sort"  id="sort">
												</div>
					                         	</td>
					                         	
                                                <td class="td-actions text-right">
                                                
		                          				<button type="submit"  class="btn btn-info btn-fill pull-right" id="insert" >添加部门</button>
                                                   
                                                </td>
                                                <span id="errAdd" style="color: red"></span>

                                            </tr>
                                            </table>
                                    </div>
                                </div>
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
    <script src="js/jquery-1.10.2.js" type="text/javascript"></script>
	<script src="js/bootstrap.min.js" type="text/javascript"></script>

	<!--  Checkbox, Radio & Switch Plugins -->
	<script src="js/bootstrap-checkbox-radio-switch.js"></script>

	<!--  Charts Plugin -->
	<script src="js/chartist.min.js"></script>

    <!--  Notifications Plugin    -->
    <script src="js/bootstrap-notify.js"></script>


    <!-- Light Bootstrap Table Core javascript and methods for Demo purpose -->
	<script src="js/light-bootstrap-dashboard.js"></script>

	<!-- Light Bootstrap Table DEMO methods, don't include it in your project! -->
	<script src="js/demo.js"></script>

<script src="${pageContext.request.contextPath}/view/js/jquery-1.10.2.js"></script>
<script type="text/javascript">


    function modDep(id) {
        alert("已进入")
        $.ajax({
            type:'post',
            url:'${pageContext.request.contextPath}/ajax',
            data:{
                "flag":"modDep",
                "id":id,
                "depName":$("#name"+id).val(),
                "sort":$("#sort"+id).val(),
            },
            dataType:'text',
            success:function (data) {
                if (data=="ok"){
                    alert("修改成功");
                    location.reload();//如果修改成功，则刷新页面
                }else if (data=="samename"){
                   alert("部门名称已存在，请修改！");

                }else if (data =="noname"){
                    alert("请输入部门名称");

                }else if (data =="nosort"){
                    alert("部门排序有误，请重新输入");
                    location.reload();

                }else if (data =="samesort"){
                    alert("部门排序已存在，请重新输入");
                }else if (data =="modPd"){
                    alert("您并没有进行修改操作，请进行修改")
                }
                else{
                    alert("修改失败");
                    location.reload();
                }


            }

        })
    }

    $("#insert").click(function () {
        $.ajax({
            type:'post',
            url:'${pageContext.request.contextPath}/ajax',
            data: {
                'flag':'insertDep',
                'depName':$("#depName").val(),
                'sort':$("#sort").val(),
            },
            dataType:'text',
            success: function (data) {
                if (data=="ok"){
                    alert("添加成功");
                    location.reload();

                }else if(data =="non"){
                   alert("部门名重复")
                }else if(data=="no1"){
                    alert("未填写部门名称")
                }else if(data=="no2"){
                   alert("未填写排序字段")
                }else if (data =="samesort"){
                    alert("排序字段重复，请重新填写")
                }

                else{
                    alert("添加失败");

                }
            }
        })
    })

    function delDep(id) {
        $.ajax({
            type:'post',
            url:'${pageContext.request.contextPath}/ajax',
            data:{
                "flag":"delDep",
                "id":id,
            },
            dataType:"text",
            success:function (data) {
                if (data =="ok"){
                    alert("删除成功");
                    location.reload();

                }else{
                    alert("该部门存在用户，不能删除")

                }
            }
        })

    }



           $.ajax({
               type:'get',
               url:'${pageContext.request.contextPath}/ajax?flag=depjson&fresh='+Math.random(),
               dataType:"json",


               success:function (data) {
                   alert("成功");


                   $.each(data, function(key,val){

                       var depName=val.depName;
                       var id=val.id;
                       var sort=val.sort;
                       $("#table").append("<tr><td ><input type='text' class='form-control' readonly value= "+id+"     ></td><td><input type='text' class='form-control' value= "+depName+" id='name"+id+"'></td><td><input type='text' class='form-control' value= "+sort+" id='sort"+id+"' ></td><td class='td-actions text-right' ><button type='submit' rel='tooltip' title='修改' class='btn btn-info btn-simple btn-xs' onclick='modDep("+id+")'><i class='fa fa-edit'></i></button>  " +
                           "<button type='button' rel='tooltip' title='删除' class='btn btn-danger btn-simple btn-xs' onclick='delDep("+id+")'><i class='fa fa-times'></i></button> "  + "</td></tr>");
                   })

               },
               error:function (XMLHttpRequest, textStatus, errorThrown) {
                   alert("失败");
                   // 状态码
                   console.log(XMLHttpRequest.status);
// 状态
                   console.log(XMLHttpRequest.readyState);

// 错误信息

                   console.log(textStatus);

               }
           })









</script>


	

</html>