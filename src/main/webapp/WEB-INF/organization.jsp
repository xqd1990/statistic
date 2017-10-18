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
    
    <title>organization</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<script type="text/javascript" src="js/jquery-1.8.1.min.js"></script>
	<script type="text/javascript" src="js/organization.js"></script>
	<link rel="stylesheet" type="text/css" href="css/organization.css">
  </head>
<body>
	<c:if test="${not empty message}"><script>alert("${message}");</script></c:if>
	<div id="add_div">
		<form action="organization/add" method="post">
			<span>组织编号：</span><input type="text" name="id" readonly><span>组织名称：</span><input type="text" name="name"><span>组织保险：</span><input type="text" name="insurance"><br>
			<span>组织赢水：</span><input type="text" name="win_interest"><span>组织输水：</span><input type="text" name="lose_interest"><span>组织备注：</span><input type="text" name="mark"><br>
			<span>组织责任：</span><input type="text" name="manager">
			<input type="submit" value="确认"><input type="reset" value="取消">
		</form>
	</div>
	<div id="modify_div" style="display:none">
		<form action="organization/modify" method="post">
			<span>组织编号：</span><input type="text" name="id" id="id" readonly><span>组织名称：</span><input type="text" name="name" id="name"><span>组织保险：</span><input type="text" name="insurance" id="insurance"><br>
			<span>组织赢水：</span><input type="text" name="win_interest" id="win_interest"><span>组织输水：</span><input type="text" name="lose_interest" id="lose_interest"><span>组织备注：</span><input type="text" name="mark" id="mark"><br>
			<span>组织责任：</span><input type="text" name="manager" id="manager">
			<input type="submit" value="确认"><input type="button" id="cancel" value="取消">
		</form>
	</div>
	<table cellspacing="1" style="width:100%">
		<tr><th>ID</th><th>组织名称</th><th>组织责任</th><th>组织保险</th><th>组织赢水</th><th>组织输水</th><th>组织备注</th><th>操作</th></tr>
		<c:forEach items="${organizations}" var="organization" varStatus="i">
			<tr class="row${i.count%2}"><td>${organization.id}</td><td>${organization.name}</td><td>${organization.manager}</td><td>${organization.insurance}</td><td>${organization.win_interest}</td><td>${organization.lose_interest}</td><td>${organization.mark}</td><td><span class="delete">删除</span>&nbsp;<span class="modify">修改</span></td></tr>
		</c:forEach>
	</table>
</body>
</html>