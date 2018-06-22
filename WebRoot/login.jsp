<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
	<title>登录系统</title>
	<link rel="stylesheet" href="css/style.css">

	<!--<link href='//fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
-->
	<!-- For-Mobile-Apps-and-Meta-Tags -->
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="keywords" content="Simple Login Form Widget Responsive, Login Form Web Template, Flat Pricing Tables, Flat Drop-Downs, Sign-Up Web Templates, Flat Web Templates, Login Sign-up Responsive Web Template, Smartphone Compatible Web Template, Free Web Designs for Nokia, Samsung, LG, Sony Ericsson, Motorola Web Design" />
		<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
	<!-- //For-Mobile-Apps-and-Meta-Tags -->

</head>

<body>
    <h1>系统登陆</h1>
    <div class="container w3">
        <h2>${msg }</h2>
		<form action="${basePath }login" method="post">
			<div class="username">
				<span class="username" style="height:19px">用户:</span>
				<input type="text" name="username" class="name" placeholder="" required="">
				<div class="clear"></div>
			</div>
			<div class="password-agileits">
				<span class="username"style="height:19px">密码:</span>
				<input type="password" name="password" class="password" placeholder="" required="">
				<div class="clear"></div>
			</div>
			<div class="rem-for-agile">
				<a href="${basePath }reg.jsp">注册</a><br>
			</div>
			<div class="login-w3">
					<input type="submit" class="login" value="登陆账户">
			</div>
			<div class="clear"></div>
		</form>
	</div>
</body>
</html>