<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<form action="##">
	<div>用户名：<input id="loginName" type="text" name="loginName"></div>
	<div>密码：<input id="password" type="password" name="password"></div>
	<div>确认密码：<input id="confirmPassword" type="password" name="confirmPassword"></div>
	<div>真实姓名：<input id="username" type="text" name="username"></div>
	<div>性别：<input id="sex" type="text" name="sex"></div>
	<div>年龄：<input id="age" type="text" name="age"></div>
	<button onclick="register()">注册</button>
</form>
<iframe id="rfFrame" name="rfFrame" src="about:blank" style="display:none;"></iframe>   
<p id="tips"></p>

<script src="../js/jquery-1.8.0.min.js"></script>
<script>
function register(){
	console.log($("form").serialize());
	document.forms[0].target="rfFrame";
	$.ajax({
		url:'http://localhost:8082/appservice/user/addUser.do',  //接口地址
		type:'post', //调用方法
		data:$("form").serialize(),  //调用的数据
		dataType:'json', //返回数据类型
		success:function(data){
			console.log(data);
			$("#tips").text(data.message);
		},
		error:function(data){
			console.log("error");
		}
		
	})
}

</script>
</body>
</html>