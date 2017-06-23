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
				<td>操作</td>
			</tr>
		</thead>
		<tbody>
		</tbody>
	</table>

	<br />
	<div id="showDiv"></div><br/>
	<div id="editDiv" style="display:none;">
	  <form>
		<p>真实姓名:<input id="userName" name="userName" type="text" ></p>
	    <!--  <p>用户名:<input id="loginname" name="loginName" type="text" value="" ></p>-->
		<p>用户名:<span id="loginname" name="loginName"></span></p>
		<p>性别:<input id="sex" name="sex" type="text" value="" ></p>
		<p>年龄:<input id="age" name="age" type="text" value="" ></p>
		<input type="hidden" name="userId" id="userId">
		<a href="javascript:;" onclick="editNewsadd();">提交</a>
	  </form>	
	  
	</div>
<!--  <iframe id="rfFrame" name="rfFrame" src="about:blank"
		style="display: none;"></iframe>-->
	  <p id="text"></p>
	<script src="../js/jquery-1.8.0.min.js"></script>
	<script>
	window.onload = list();
	function list(){
		$.ajax({
			url : 'http://localhost:8082/appservice/user/userList.do', //调用的地址
			type : 'post', //请求方式
			dataType : 'json', //请求的数据格式
			success : function(data) {
				console.log(data);
				$("tbody").html("");
				for (var i = 0; i < data.list.length; i++) {
<<<<<<< HEAD
					$("tbody").append("<tr><td>" + data.list[i].username + "</td><td>" + data.list[i].sex + "</td><td>" + data.list[i].age + "</td><td><a class='clickk' href='javascript:;' onclick=\"show('" + data.list[i].id + "');\">查询</a></td></tr>");
=======
					$("tbody").append("<tr><td>" + data.list[i].userName + "</td><td>" 
							+ data.list[i].sex + "</td><td>" + data.list[i].age 
							+ "</td><td><a class='clickk' href='javascript:;' onclick=\"show('" + data.list[i].userId 
									+ "');\">查询</a></td><td><a href='javascript:;' onclick=\"editNews('" + data.list[i].userId + "')\">修改</a></td></tr>");
					
					
>>>>>>> 256f8115b94fc8e6d7684d31dd14c7a0a40ceb6d
				}
			},
			error : function(data) {

			}
		})

	}
		
		//查询详细信息
		function show(userId) {
			$.ajax({
				url : 'http://localhost:8082/appservice/user/getUserInfoByUserId.do', //url
				type : 'get', //请求方式
				data : {
<<<<<<< HEAD
					"userId" : userId
=======
					"userId" : loginName
>>>>>>> 256f8115b94fc8e6d7684d31dd14c7a0a40ceb6d
				}, //请求参数
				dataType : 'json',
				success : function(data) {
					console.log(data);
					$("#showDiv").html(" ");
					if (data.data != null) {
<<<<<<< HEAD
						$("#showDiv").append("<p>真实姓名:<span>" + data.data.username + "</span></p><p>性别:<span>" + data.data.sex + "</span></p><p>年龄:<span>" + data.data.age + "</span></p><p>用户名:<span>" + data.data.loginname + "</span></p>");
					} 
=======
						$("#showDiv").append("<p>真实姓名:<span>" + data.data.userName + "</span></p><p>性别:<span>" + data.data.sex + "</span></p><p>年龄:<span>" + data.data.age + "</span></p><p>用户名:<span>" + data.data.loginName + "</span></p>");
					} else {
						console.log("null");
					}
>>>>>>> 256f8115b94fc8e6d7684d31dd14c7a0a40ceb6d

				},
				error : function(data) {

				}
			})
		}
		
		function editNews(userId){
			$("#editDiv").css("display","block");
			$.ajax({
				url: 'http://localhost:8082/appservice/user/getUserInfoByUserId.do',
				type: 'get',
				data: {"userId": userId},
				dataType: 'json',
				success: function(data){
					console.log(data);
					$("#userName").val(data.data.userName);
					$("#loginname").text(data.data.loginName);
					$("#sex").val(data.data.sex);
					$("#age").val(data.data.age);
					$("#userId").val(data.data.userId);
				},
				error: function(data){
					
				}
				
			})
		}
		
		//修改用户信息
		function editNewsadd(){
			//document.forms[0].target = "rfFrame";
			$.ajax({
				url: "http://localhost:8082/appservice/user/updateUserByUserId.do",
				type: "post",
				data: $("#editDiv form").serialize(),
				dataType: "json",
				success: function(data){
					console.log(data);
					$("#text").text(data.message);
					
					list();
				},
				error: function(data){
					
				}
			})
		}
	</script>
</body>
</html>