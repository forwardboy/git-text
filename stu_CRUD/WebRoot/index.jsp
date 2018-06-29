<%@page import="com.dxf.model.Student"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt"  prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

	<head>

		<title>My JSP 'index.jsp' starting page</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

		<script type="text/javascript" src="js/jquery-1.3.2.min.js"></script>
		<script type="text/javascript" src="js/date.js"></script>
		<script type="text/javascript" src="js/jquery.datePicker.min-2.1.2.js"></script>
		<link rel="stylesheet" type="text/css" media="screen" href="js/datePicker.css">
		<script type="text/javascript">
			$(function() {
				$('.date-pick').datePicker({
					clickInput: true,
					createButton: false,
					startDate: '1950-01-01'
				}).val(new Date().asString()).trigger('change');
			});
		</script>

	</head>

	<body>
	
	<h2 style="color: red">${tishi }</h2>
		<form action="insert.do" method="post">
		<span>插入</span><br/>
			学 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 号: <input type="text" name="stu_number" placeholder="请在此输入学号"><br/> 
			姓 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 名: <input type="text" name="name" placeholder="请在此输入姓名"><br/> 
			性 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 别: <input type="text" name="sex" placeholder="请在此输入性别"><br/> 
			出生日期: <input type="text" name="birthdate" class="date-pick" size="10" width="80" /><br/>
			<input type="submit" value="确认添加">
		</form>
		
	---------------------------------------------------------------------------------------------------------------->
	<form action="select.do" method="post">
		<span>查询</span><br/>
			学 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 号: <input type="text" name="stu_number" placeholder="请在此输入学号"><br/> 
			<input type="submit" value="点击查询">
		</form>
		<table>
		<tr><td>您的ID是:</td><td><input value="${setudent_id}" type="text"></td></tr>
		<tr><td>您的学号是:</td><td>${setudent_stu_number }</td></tr>
		<tr><td>您的姓名是:</td><td>${setudent_name }</td></tr>
		<tr><td>您的性别是:</td><td>${setudentid_sex }</td></tr>
		<tr><td>您的出生日期是:</td><td>${setudentid_birthdate }</td></tr>
		</table>
	------------------------------------------------------------------------------------------------------------------>
		<form action="update.do" method="post">
		<span>修改</span><br/>
			
			学 &nbsp;&nbsp;&nbsp;&nbsp;号: <input type="text" name="stu_number" placeholder="请在此输入想要修改的学号"><br/> 
			姓 &nbsp;&nbsp;&nbsp;&nbsp;名: <input type="text" name="name" placeholder="请在此输入姓名"><br/> 
			性 &nbsp;&nbsp;&nbsp;&nbsp;别: <input type="text" name="sex" placeholder="请在此输入性别"><br/> 
			出生日期: <input type="text" name="birthdate" class="date-pick" size="10" width="80" /><br/>
			<input type="submit" value="确认修改">
		</form>
		--------------------------------------------------------------------------------------------->
		<form action="delect.do" method="get">
		<span>删除</span><br/>
			学 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 号: <input type="text" name="stu_number" placeholder="请在此输入学号"><br/> 
			<input type="submit" value="确认删除">
		</form>
	</body>
	
</html>