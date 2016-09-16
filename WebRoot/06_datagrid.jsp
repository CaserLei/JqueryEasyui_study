<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>用Servlet返回JSON文本动态创建DataGrid</title>
		<link rel="stylesheet" href="themes/icon.css" type="text/css"></link>
		<link rel="stylesheet" href="themes/default/easyui.css" type="text/css"></link>
		<!-- 引入easyui的js文件，先引入jquery，再引入easyui -->  
		<script type="text/javascript" src="js/jquery-1.8.2.js"></script>
		<script type="text/javascript" src="js/jquery.min.js"></script>
		<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>
	</head>
	<body>
		<table id="dg"></table>
		<script type="text/javascript">
			$('#dg').datagrid({    
	                url:"${pageContext.request.contextPath}/UserServlet?time="+new Date().getTime(),    
					columns:[[    
					    {field:'id',title:'编号',width:100},    
					    {field:'name',title:'姓名',width:100},    
					    {field:'sal',title:'薪水',width:100},
					    {field:'sex',title:'性别',width:100}    
					]],
					fitColumns:true,
					singleSelect:true,
					pagination:true,
					pageSize:2,
					pageList:[2,4,6]
	          });  
		</script>
	</body>
</html>