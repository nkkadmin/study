<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<div>用户名：<input id="user" type="text"></div>
<div>密码：<input id="password" type="password"></div>
<button onclick="login()">登录</button>
<p id="tips"></p>
</body>
<script src="../js/jquery-1.8.0.min.js"></script>
<script type="text/javascript">
function login(){
	$.ajax({
		url:'http://localhost:8082/appservice/user/login.do',  //请求地址
		type:'POST',  //请求方式
		data:{"loginName":$("#user").val(),"password":$("#password").val()}, //请求参数
		dataType:'json', //返回数据类型
		success:function(data){  //成功回调函数
			console.log(data);
			$("#tips").text(data.message);
		},
		error:function(data){   //失败回调函数
			
		}
	});
}
</script>
</html>