<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@	taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>首页</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<script type="text/javascript" src="js/jquery-1.8.1.min.js"></script>
	<script type="text/javascript" charset="utf-8" src="js/index.js"></script>
	<link rel="stylesheet" type="text/css" href="css/index.css">
  </head>
<body>
	<header>
		<span id="head_word">欢迎使用俱乐部积分系统</span>
		<span id="head_time"></span>
	</header>
	<section>
		<div id="main_left">
			<ul>
	  			<li><img src="images/dec.gif"><b><a href="player/show?current_page=1" target="main">客户管理</a></b></li>
	  			<li><img src="images/dec.gif"><b><a href="organization/show" target="main">组织管理</a></b></li>
	  			<li><img src="images/dec.gif"><b><a href="bill/show" target="main">流水导入</a></b></li>
	  			<li><img src="images/dec.gif"><b><a href="bill/end" target="main">主机结算</a></b></li>
	  			<li><img src="images/dec.gif"><b><a href="addScore" target="main">备用接口</a></b></li>
		  	</ul>
		</div>
		<div id="main_center">
			<iframe name="main" frameborder="0"></iframe>
		</div>
	</section>
</body>
</html>
