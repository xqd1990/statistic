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
    
    <title>player</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<script type="text/javascript" src="js/jquery-1.8.1.min.js"></script>
	<script type="text/javascript" src="js/player.js"></script>
	<link rel="stylesheet" type="text/css" href="css/player.css">
  </head>
<body>
	<c:if test="${not empty message}"><script>alert("${message}");</script></c:if>
	<div id="add_div">
		<form action="player/add?current_page=1" method="post">
			<span>玩家编号：</span><input type="text" name="id"><span>游戏账号：</span><input type="text" name="account"><span>玩家组织：</span><input type="text" value="默认" name="organization.name"><br>
			<span>玩家赢水：</span><input type="text" value="0" name="win_interest"><span>玩家输水：</span><input type="text" value="0" name="lose_interest"><span>玩家备注：</span><input type="text" name="mark"><br>
			<input type="submit" value="确认"><input type="reset" value="取消">
		</form>
	</div>
	<div id="modify_div" style="display:none">
		<form action="player/modify?current_page=1" method="post">
			<span>玩家编号：</span><input type="text" name="id" id="id"><span>游戏账号：</span><input type="text" name="account" id="account"><span>玩家组织：</span><input type="text" name="organization.name" id="organization"><br>
			<span>玩家赢水：</span><input type="text" name="win_interest" id="win_interest"><span>玩家输水：</span><input type="text" name="lose_interest" id="lose_interest"><span>玩家备注：</span><input type="text" name="mark" id="mark"><br>
			<input type="submit" value="确认"><input type="button" id="cancel" value="取消">
		</form>
	</div>
	<span>按ID查找&nbsp;<input type="text" id="search_by_id">&nbsp<input type="button" value="搜索" id="sbi">&nbsp;按账号查找&nbsp;<input type="text" id="search_by_account">&nbsp;<input type="button" value="搜索" id="sba"></span>
	<table cellspacing="1" style="width:100%">
		<tr><th>ID</th><th>游戏账号</th><th>组织</th><th>赢水</th><th>输水</th><th>备注</th><th>操作</th></tr>
		<c:forEach items="${players}" var="player" varStatus="i">
			<tr class="row${i.count%2}"><td>${player.id}</td><td>${player.account}</td><td>${player.organization.name}</td><td>${player.win_interest}</td><td>${player.lose_interest}</td><td>${player.mark}</td><td><span class="de">删除</span>&nbsp;<span class="mo">修改</span></td></tr>
		</c:forEach>
	</table>
	<span id="page_span">第${current_page}/共${total_page}页&nbsp;
		<a href="player/show?current_page=1"><input type="button" value="首页"></a>
		<c:if test="${current_page==1}">
			<input type="button" value="上一页" disabled="true">
		</c:if>
		<c:if test="${current_page>1}">
			<a href="player/show?current_page=${current_page-1}"><input type="button" value="上一页"></a>
		</c:if>
		<c:if test="${current_page==total_page}">
			<input type="button" value="下一页" disabled="true">
		</c:if>
		<c:if test="${current_page<total_page}">
			<a href="player/show?current_page=${current_page+1}"><input type="button" value="下一页"></a>
		</c:if>
		<a href="player/show?current_page=${total_page}"><input type="button" value="末页"></a>
		<input type="text" id="page"><input type="button" value="GO" id="go_button">
	</span>
</body>
</html>