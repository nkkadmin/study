<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<table>
<thead>
	<tr>
		<td>真实姓名</td>
		<td>性别</td>
		<td>年龄</td>
	</tr>
	</thead>
	<tbody>
	</tbody>
</table>

<p id="tips"></p>

<script src="../js/jquery-1.8.0.min.js"></script>
<script>
$.ajax({
	url:'http://localhost:8082/appservice/user/userList.do',   //调用的地址
	type:'post', //请求方式
	dataType:'json', //请求的数据格式
	success:function(data){
		console.log(data);
		$("tbody").html("");
		for(var i =0;i < data.list.length;i++){
			$("tbody").append("<tr><td>" + data.list[i].username + "</td><td>" + data.list[i].sex + "</td><td>" + data.list[i].age + "</td><td></tr>");
		}
	},
	error:function(data){
		
	}
	
})
</script>
</body>
</html>