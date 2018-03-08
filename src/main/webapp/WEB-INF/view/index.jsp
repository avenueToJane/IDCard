<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<html>
<% String contextPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath(); %>

<head>
	<meta charset="utf-8"> 
	<title>首页</title>
	<link href="<%=contextPath%>/static/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	
	<script src="<%=contextPath%>/static/js/jquery.min.js"></script>
	<script src="<%=contextPath%>/static/js/bootstrap.min.js"></script>
</head>
<body style="text-align:center;">
<div style="width:600px;margin-left:auto;margin-right:auto;">
<form role="form" action="/query" method="post">
	<div class="form-group">
		<label for="name">身份证号码</label>
		<input type="text" class="form-control" id="name"  name="IDCard"
			   placeholder="请输入身份证号码">
	</div>
	
	<button type="submit" class="btn btn-default" onclick="login();">查询</button>
	${error}
</form>
</div>
</body>
</html>