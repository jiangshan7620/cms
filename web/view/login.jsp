<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>



<html>	
<head>
<title>Login</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<meta name="keywords" content="Flat Dark Web Login Form Responsive Templates, Iphone Widget Template, Smartphone login forms,Login form, Widget Template, Responsive Templates, a Ipad 404 Templates, Flat Responsive Templates" />
<link href="css/style.css" rel='stylesheet' type='text/css' />
</head>
<body>

<%--<%--%>
<%--	String password=null;--%>
<%--	String username=null;--%>

<%--	Cookie[] cookies = request.getCookies();--%>
<%--	if (cookies!=null){--%>
<%--		for (Cookie cookie:cookies){--%>
<%--			if ("username".equals(cookie.getName())){--%>
<%--				username=cookie.getValue();--%>
<%--			}--%>
<%--			if ("password".equals(cookie.getName())){--%>
<%--				password=cookie.getValue();--%>
<%--			}--%>
<%--		}--%>
<%--	}--%>
<%--%>--%>



<script src="${pageContext.request.contextPath}/view/js/jquery-1.10.2.js"></script>
<script>$(document).ready(function(c) {
	$('.close').on('click', function(c){
		$('.login-form').fadeOut('slow', function(c){
	  		$('.login-form').remove();
		});
	});	  
});
</script>


 <!--SIGN UP-->
 <h1 style="font-family:'方正华隶简体'; color: #0e4277;">管理员登陆</h1>
<div class="login-form">
	<div class="close"> </div>
		<div class="head-info">
			<label class="lbl-1"> </label>
			<label class="lbl-2"> </label>
			<label class="lbl-3"> </label>
		</div>
			<div class="clear"> </div>
	<div class="avtar">
		<img src="images/avtar.png" />
	</div>
			<form action="http://localhost:8080/cms/UserController?flag=loginok" method="post">
			<input type="text" class="text" name="username"  value="${cookie.username.value}" id="username">

			<div class="key">
					<input type="password"  name="password" value="${cookie.password.value}" id="password">

						</div>

					<c:if test="${param.pd==1}">
						<span style="color: red" id="pd" name="pd" >用户名或密码错误</span>
					</c:if>
<br>
					<input type="checkbox" class="text" name="remember"

							<c:if test="${cookie.username!=null}">
								checked
							</c:if>




						  /><i style="color:#9199aa;">一周内免登陆</i>
					<div class="signin">
						<input type="submit" value="Login" id="submit">


					</div>
			</form>

</div>

 <div class="copy-rights">

	 <p>Copyright &copy; 2015.Company name All rights reserved.More Templates <a href=# target="_blank" title="#">#</a> - Collect from <a href=# title=# target="_blank">#</a></p>


 </div>




























</body>
</html>