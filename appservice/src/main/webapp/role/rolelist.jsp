<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>Insert title here</title>
<style>
table {
	border-collapse:collapse;
	width:100%;
	text-align:center;
}
td {
	border:1px solid #ddd;
}
</style>
</head>
<body>
<div style="width:500px;">
	<h1>角色列表</h1>
	<div style="text-align:right">
		<a href="http://localhost:8082/appservice/role/addRoleUI.do">添加</a>
	</div><br/><br/>
	<table>
		<thead>
			<tr>
				<td>角色名称</td>
				<td>角色说明</td>
				<td>创建时间</td>
				<td>操作</td>
			</tr>
		</thead>
		<tbody>
			<!-- <tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr> -->
		</tbody>
	</table>
</div>
<div id="tips"></div>
<script type="text/javascript" src="../js/jquery-1.8.0.min.js"></script>
<script type="text/javascript">
window.onload=listShow();
//展示列表
function listShow(){
	$.ajax({
		url: "http://localhost:8082/appservice/role/queryRoleList.do",
		type: "post",
		dataype: "json",
		success: function(data){
			console.log(data);
			$("tbody").html("");
			for(var i = 0;i < data.list.length;i++){
				$("tbody").append("<tr><td id='name'>" + data.list[i].name 
						+ "</td><td id='commont'>" + data.list[i].commont 
						+ "</td><td id='createtime'>" + data.list[i].createtime 
						+ "</td><td><a href='http://localhost:8082/appservice/role/editRoleUI.do?id="+data.list[i].id+"'>修改</a> | <a onclick=\"deleteList('" + data.list[i].id + "')\" href='javascript:;'>删除</a></td><tr>");
			}
		},
		error: function(data){
			console.log("error");
		}
	})
} 

//修改--先获取修改用户信息
function editList(id){
	$.ajax({
		url: "http://localhost:8082/appservice/role/queryRoleList.do",
		type: "post",
		data: {"id":id},
		dataype: "json",
		success: function(data){
			console.log(data);
			//$("#name").val();
		},
		error: function(data){
			console.log("error");
		}
	})
}


//删除
function deleteList(id){
	$.ajax({
		url: "http://localhost:8082/appservice/role/deleteRoleByPK.do",
		type: "get",
		data: {"id":id},
		dataype: "json",
		success: function(data){
			console.log(data);
			$("#tips").text(data.message);
			listShow();
		},
		error: function(data){
			console.log("error");
		}
	})
}
</script>
</body>
</html>