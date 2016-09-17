<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>分页查询所有员工</title>
		<link rel="stylesheet" href="themes/icon.css" type="text/css"></link>
		<link rel="stylesheet" href="themes/default/easyui.css" type="text/css"></link>
		<script type="text/javascript" src="js/jquery-1.8.2.js"></script>
		<script type="text/javascript" src="js/jquery.min.js"></script>
		<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>
	</head>
	<body >
	  <table id="dg" style="width: 800px;"></table>  
	  
	  <script type="text/javascript">
		  $('#dg').datagrid({    
			    url:'${pageContext.request.contextPath}/EmpServlet?time='+new Date().getTime(),    
			    columns:[[    
			        {field:'empno',title:'编号',width:100},    
			        {field:'ename',title:'姓名',width:100},    
			        {field:'job',title:'工作',width:100,align:'right'},
			        {field:'mgr',title:'上级编号',width:100},    
			        {field:'hiredate',title:'入职时间',width:100,
			        	formatter:function(value){
			        		var year="19"+value.year;
			        		var month=value.month+1;
			        		var date=value.date;
			        		return year+"-"+month+"-"+date;
			          }
			        
			        },    
			        
			        {field:'sal',title:'月薪',width:100,align:'right'},  
			        {field:'comm',title:'佣金',width:100},    
			        {field:'deptno',title:'部门编号',width:100}  
			    ]],
			    fitColumns:true,
			    singleSelect:true,
			    pagination:true,
			    pageNumer:1,
			    pageSize:3,
			    pageList:[3,5,10]
			});  

	  </script>
       
	</body>
</html>