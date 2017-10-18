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
    
    <title>query</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" charset="utf-8" src="js/query2.js"></script>
	<link rel="stylesheet" type="text/css" href="css/query1.css">
  </head>
<body>
	<span id="detail">
		详细查询：&nbsp;&nbsp;
		开始时间&nbsp;<input id="detail_start" type="text" name="detailstart" readonly><a href="javascript:void(0)" onClick="gfPop.fPopCalendar(document.all.detailstart);return false;"><img src="images/search.gif"/></a>&nbsp;
		结束时间&nbsp;<input id="detail_end" type="text" name="detailend" readonly><a href="javascript:void(0)" onClick="gfPop.fPopCalendar(document.all.detailend);return false;"><img src="images/search.gif"/></a>&nbsp;
		<input type="button" value="查询" id="detail_query_button"/>
	</span>
	<br>
	<span id="general">
		整体查询：&nbsp;&nbsp;
		开始时间&nbsp;<input id="general_start" type="text" name="generalstart" readonly><a href="javascript:void(0)" onClick="gfPop.fPopCalendar(document.all.generalstart);return false;"><img src="images/search.gif"/></a>&nbsp;
		结束时间&nbsp;<input id="general_end" type="text" name="generalend" readonly><a href="javascript:void(0)" onClick="gfPop.fPopCalendar(document.all.generalend);return false;"><img src="images/search.gif"/></a>&nbsp; 
		<input type="button" value="查询" id="general_query_button">
	</span>
	<br>
	<span id="day_result">
		<input type="button" value="结算概况" id="query">&nbsp;&nbsp;已结算桌数：<input type="text" id="paid_num" readonly>&nbsp;&nbsp;已结算金额：<input type="text" id="paid" readonly>&nbsp;&nbsp;未结算桌数：<input type="text" id="unpaid_num" readonly>&nbsp;&nbsp;未结算金额：<input type="text" id="unpaid" readonly>
	</span>
	<br>
	<table id="result">
	</table>
	<div id="detail_div" style="position:absolute;display:none;border:1px solid silver;background:#FFFFE1;"></div>
	<iframe width=174 height=189 name="gToday:normal:agenda.js" id="gToday:normal:agenda.js" src="common/calendar/ipopeng.htm" scrolling="no" frameborder="0" style="visibility:visible; z-index:999; position:absolute; left:-500px; top:0px;"></iframe>
</body>
</html>