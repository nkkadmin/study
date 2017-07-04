<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div style="width:500px;">
	<h1>
		<c:if test="${role == null}">添加</c:if><c:if test="${role != null}">修改</c:if>角色
	</h1>
	<div style="text-align:center;width:200px;">
	  <form>
	    <input name="id" id="id" type="hidden" value="${role.id }">
		<input name="name" id="name" type="text" placeholder="角色名称" value="${role.name }"><br/><br/>
		<input name="commont" id="commont" type="text" placeholder="角色说明" value="${role.commont }"><br/><br/>
		<c:if test="${role == null}"><button onclick="addList()">添加</button></c:if>
		<c:if test="${role !=null}"><button onclick="editListadd()">修改</button></c:if>
      </form>
	</div>
	<iframe id="rfFrame" name="rfFrame" src="about:blank"
		style="display: none;"></iframe>
	<div id="tips"></div>
</div>
<script src="../js/jquery-1.8.0.min.js"></script>
<script>
//添加
function addList(){
	document.forms[0].target = "rfFrame";
	$.ajax({
		url: "http://localhost:8082/appservice/role/addRole.do",
		type: "post",
		data : $("form").serialize(),
		dataType: "json",
		success: function(data){
			console.log(data);
			$("#tips").text(data.message);
			if(data.success){
				window.location.href = "http://localhost:8082/appservice/role/roleListUI.do";
			}
			
		},
		error: function(data){
			console.log("error");
		}
	})
}

//修改--再修改
function editListadd(){
	document.forms[0].target = "rfFrame";
	$.ajax({
		url: "http://localhost:8082/appservice/role/updateRoleByPK.do",
		type: "post",
		data: $("form").serialize(),
		dataype: "json",
		success: function(data){
			console.log(data);
			$("#tips").text(data.mesage);
			if(data.success){
				window.location.href="http://localhost:8082/appservice/role/roleListUI.do";
			}
		},
		error: function(data){
			console.log("error");
		}
	})
}
</script>
</body>
</html>