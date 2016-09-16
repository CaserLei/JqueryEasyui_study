<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>省份-城市-区域三级联动</title>
		<script type="text/javascript" src="js/jquery-1.8.2.js"></script>
	</head>
	<body>
	    <select id="province">
	       <option>选择省份</option>
	       <option>湖南</option>
	       <option>广东</option>
	    </select>
	    <select id="city">
	       <option>选择城市</option>
	       <option></option>
	    </select>
	    <select id="area">
	       <option>选择区域</option>
	    </select>
	    
	    <!--省份--城市 -->
	    <script type="text/javascript">
	        //定位省份下啦框，同时提交change事件
	        $("#province").change(function(){
	        
		          //清空城市下拉框中的内容，除第一项外
				$("#city option:gt(0)").remove();
				//清空区域下拉框中的内容，除第一项外
				$("#area option:gt(0)").remove();
			
	           //获取选中的省份
	           var province=$("#province option:selected").text();
	           //alert(province);
	           //如果不是"选择省份"的话
	           if("选择省份" !=province){
	              //异步发送请求到服务器端
	              //参数一：url表示请求的路径
	              var url="${pageContext.request.contextPath}/findCityRequest?time="+new Date().getTime();
	              //参数二：senddata表示以JSON格式发送的数据。
	              var sendData={"bean.province":province};
	              
	              $.post(url,sendData,function(backData,textStatus,ajax){
	                  //测试
	                  //alert(backData);
	                  //alert(textStatus);
	                  //alert(ajax.responseText);
	                  //测试，backData是一个js对象，cityList是属性
	                  var array=backData.cityList;
	                  
	                  var size=array.length;
	                  for(var i=0;i<size;i++){
	                      //获取数组中的每个元素
	                      var city=array[i];
	                      //创建option元素
	                      var $option=$("<option>"+city+"</option>");
	                      $("#city").append($option);
	                  }
	              });
	              
	           }
	        });
	    </script>
	    
	      <!----城市-----区域 -->
	    <script type="text/javascript">
	        //定位省份下啦框，同时提交change事件
	        $("#city").change(function(){
	           //获取选中的省份
	           var city=$("#city option:selected").text();
	           //alert(province);
	           //如果不是"选择省份"的话
	           if("选择城市" !=city){
	              //异步发送请求到服务器端
	              //参数一：url表示请求的路径
	              var url="${pageContext.request.contextPath}/findAreaRequest?time="+new Date().getTime();
	              //参数二：senddata表示以JSON格式发送的数据。
	              var sendData={"bean.city":city};
	              
	              $.post(url,sendData,function(backData,textStatus,ajax){
	                  //测试
	                  //alert(backData);
	                  //alert(textStatus);
	                  //alert(ajax.responseText);
	                  //测试，backData是一个js对象，cityList是属性
	                  var array=backData.areaList;
	                  
	                  var size=array.length;
	                  for(var i=0;i<size;i++){
	                      //获取数组中的每个元素
	                      var area=array[i];
	                      //创建option元素
	                      var $option=$("<option>"+area+"</option>");
	                      $("#area").append($option);
	                  }
	              });
	              
	           }
	        });
	    </script>
	</body>
</html>