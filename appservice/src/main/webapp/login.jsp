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
	height: 260px;
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
.form_content .form {
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
			<img alt="" src="../img/login.png">
			<div class="form">
				<input id="loginName" type="text" name="loginName" placeholder="用户名">
				<input id="password" type="password" name="password"
					placeholder="密码"> <br/>
				<button type="reset">重置</button>
				<button onclick="login()">登陆</button>
				<p id="tips" style="color: red;"></p>
			</div>
		</div>
	</div>
	
</body>
<script src="../js/jquery-1.8.0.min.js"></script>
<script type="text/javascript">
function login(){
	$.ajax({
		url:'http://localhost:8082/appservice/user/login.do',  //请求地址
		type:'POST',  //请求方式
		data:{"loginName":$("#loginName").val(),"password":$("#password").val()}, //请求参数
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