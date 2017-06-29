<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
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
#page li{list-style:none;display:inline-block;padding:3px 5px;border:1px solid #ddd;}
#page li.active {color:f00;}
</style>
</head>
<body>
<div style="width:500px;">
	<h1>角色列表</h1>
	<div style="text-align:right">
		<a href="http://localhost:8082/appservice/menu/addMenuUI.do">添加</a>
	</div><br/><br/>
	<table>
		<thead>
			<tr>
				<td>菜单名称</td>
				<td>菜单地址</td>
				<td>角色说明</td>
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
<ul id="page"></ul>
<div id="tips"></div>
<script type="text/javascript" src="../js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="../js/page.js"></script>
<script>
window.onload = list(1);
//展示信息
function list(pageNo){
	$.ajax({
		url: "http://localhost:8082/appservice/menu/queryMenuList.do",
		type: "post",
		data: {"pageNo":pageNo},
		dataType: "json",
		success: function(data){
			console.log(data);
			$("tbody").html("");
			for(var i = 0;i < data.rows.length;i++){
				$("tbody").append("<tr><td>"+ data.rows[i].name 
						+"</td><td>"+ data.rows[i].url 
						+"</td><td>"+ data.rows[i].commont 
						+"</td><td><a href='http://localhost:8082/appservice/menu/editMenuUI.do?id="+ data.rows[i].id +"'>修改</a> | <a href='javascript:;' onclick=\"deleteList('"+ data.rows[i].id +"')\">删除</a></td></tr>");
			}
			
			pageShow("list",data);
		},
		error: function(data){
			console.log("error");
		}
	})
}

//删除
function deleteList(id){
	$.ajax({
		url: "http://localhost:8082/appservice/menu/deleteMenuByPK.do",
		type: "get",
		data: {"id":id},
		dataType: "json",
		success: function(data){
			console.log(data);
			
			list(data.pageNo);
		},
		error: function(data){
			console.log("error");
		}
	})
}
</script>
</body>
</html>