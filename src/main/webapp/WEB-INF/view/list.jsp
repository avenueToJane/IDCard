<!DOCTYPE HTML>
<%@ page isELIgnored="false"%><!--解决部署到tomcat中页面无法获取EL表达式的问题  -->
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<%
	String contextPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath();
%>

<head>
<meta charset="UTF-8">
<title>全国省市县信息</title>
<link rel="stylesheet" type="text/css"
	href="<%=contextPath%>/static/easyui/easyui.css">
<link rel="stylesheet" type="text/css"
	href="<%=contextPath%>/static/easyui/icon.css">
<link rel="stylesheet" type="text/css"
	href="<%=contextPath%>/static/easyui/demo.css">
<script type="text/javascript"
	src="<%=contextPath%>/static/easyui/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=contextPath%>/static/easyui/jquery.easyui.min.js"></script>

</head>
<body style="text-align: center;">

	<h2>全国省市县信息</h2>
	<div style="margin: 20px 0;" id="p" class="easyui-progressbar"
		style="width:400px;"></div>
	<div>
		<table id="dg" title="全国各省市县信息" style="width: 100%; height: 600px"
			data-options="
    				rownumbers:true,
    				singleSelect:true,
    				autoRowHeight:false,
    				pagination:true,
    				pageSize:100">
			<thead>
				<tr>

					<th field="provinceid" width="14%">省份编码</th>
					<th field="province" width="14%">省份名称</th>
					<th field="cityid" width="14%">城市编码</th>
					<th field="city" width="14%">城市名称</th>
					<th field="areaid" width="14%">县区编码</th>
					<th field="area" width="14%">县区名称</th>
					<th field="describe" width="16%">描述</th>
				</tr>
			</thead>
		</table>
	</div>
	<script>
		function getData() {
			var rows = [];

			<c:forEach items="${idCardList}" var="IDCard" varStatus="s">
			rows.push({
						provinceid : "${IDCard.provinceid}",
						province : "${IDCard.province}",
						cityid : "${IDCard.cityid}",
						city : "${IDCard.city}",
						areaid : "${IDCard.areaid}",
						area : "${IDCard.area}",
						describe : "${IDCard.province}${IDCard.city=='市辖区' ? '':IDCard.city}${IDCard.area}"

					});

			</c:forEach>
            /* alert(rows.length) 总共数据的个数*/
			return rows;
		}

		function pagerFilter(data) {
			if (typeof data.length == 'number'
					&& typeof data.splice == 'function') { // is array
				data = {
					total : data.length,
					rows : data
				}
			}
			var dg = $(this);
			var opts = dg.datagrid('options');
			var pager = dg.datagrid('getPager');
			pager.pagination({
				onSelectPage : function(pageNum, pageSize) {
					opts.pageNumber = pageNum;
					opts.pageSize = pageSize;
					pager.pagination('refresh', {
						pageNumber : pageNum,
						pageSize : pageSize
					});
					dg.datagrid('loadData', data);
				}
			});
			if (!data.originalRows) {
				data.originalRows = (data.rows);
			}
			var start = (opts.pageNumber - 1) * parseInt(opts.pageSize);/* 开始的序号 */
			var end = start + parseInt(opts.pageSize);/* 结束的序号 */
			
			var num =getData().length;/* 数据总数 */
			var a=(end/num);  /* 保留两位小数 */
			var b=parseFloat(a);
			var c=b*100;
			
			var d=Math.round(c*100)/100;
			
			$('#p').progressbar('setValue',d);//进度条展示
			data.rows = (data.originalRows.slice(start, end));
			return data;
		}

		$(function() {
			$('#dg').datagrid({
				loadFilter : pagerFilter
			}).datagrid('loadData', getData());
		});
	</script>
</body>
</html>