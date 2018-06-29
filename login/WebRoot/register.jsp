<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'register.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
<%@ include file="header.jsp" %></br>
<% Object o= request.getAttribute("error");
	if(o!=null){
		out.print("<font color='red'>"+o.toString()+"</font>");
	}
%>
	<form action="Register.do" method="post">
		用户名： <input name="username" type="text" placeholder="请输入用户名"></br>
		密码：<input name="password" type="text" placeholder="请输入密码"></br>
		确认密码：<input name="repassword" type="text" placeholder="请输入确认密码"></br>
		年齡：<input name="age" type="text" placeholder="请输入年齡"></br>
		个人简介：<textarea name="jianjie" cols="10" rows="10"></textarea></br>
		<button type="submit">注册</button>
		<button type="reset">重置</button>
	</form>
</body>
</html>
