<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style type="text/css">
.form_content {
	width: 250px;
	height: 400px;
	background-color: #fff;
	position: absolute;
	top: 100px;
	left: 600px;
	box-shadow: 1px 1px 32px #888881;
}

input {
	width: 198px;
	height: 30px;
	background-color: #e1e1e1;
	border-radius:4px;
	border: 1px;
	overflow: hidden;
}
button{
	width: 100px;
	height: 30px;
	margin-top: 15px;
	background-color: #fff;
    border: none;
    box-shadow: 0px 1px 3px #888881;
}
.form_content img{
    width: 152px;
    position: absolute;
    top: -6px;
    left: -6px;
}
.form_content form {
	position: absolute;
	top: 75px;
	text-align: center;
}

.form_content input {
	margin-top: 8px;
	text-align: center;
}
</style>
</head>
<body>
	<div class="content">
		<div class="form_content">
			<img alt="" src="../img/addUser.png">
			<form action="##">
				<input id="loginName" type="text" name="loginname" placeholder="用户名">
				<input id="password" type="password" name="password"
					placeholder="密码"> 
				<input id="confirmPassword"
					type="password" name="confirmPassword" placeholder="确认密码">
				<input id="username" type="text" name="username" placeholder="真实姓名">
				<input id="sex" type="text" name="sex" placeholder="性别"> 
				<input id="age" type="text" name="age" placeholder="年龄"><br/>
				<button type="reset">重置</button>
				<button onclick="register()">注册</button>
			</form>
		</div>
	</div>

	<iframe id="rfFrame" name="rfFrame" src="about:blank"
		style="display: none;"></iframe>
	<p id="tips"></p>

	<script src="../js/jquery-1.8.0.min.js"></script>
	<script>
		function register() {
			console.log($("form").serialize());
			document.forms[0].target = "rfFrame";
			$.ajax({
				url : 'http://localhost:8082/appservice/user/addUser.do', //接口地址
				type : 'post', //调用方法
				data : $("form").serialize(), //调用的数据
				dataType : 'json', //返回数据类型
				success : function(data) {
					console.log(data);
					$("#tips").text(data.message);
				},
				error : function(data) {
					console.log("error");
				}

			})
		}
	</script>
</body>
</html>