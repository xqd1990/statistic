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
    
    <title>bill</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="js/bill.js"></script>
	<link rel="stylesheet" type="text/css" href="css/bill.css">
  </head>
<body>
	<c:if test="${not empty message}"><script>alert("${message}");</script></c:if>
	<br><br><br>
	<span id="file_upload_frame">导入流水:&nbsp<input type="file" id="file"">&nbsp<input type="button" value="上传" id="upload_button"></span>
	<br><br><br><br>
</body>
</html>