<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<div style="width:500px;">
	<h1>
		<c:if test="${menu == null}">添加</c:if><c:if test="${menu != null}">修改</c:if>角色
	</h1>
	<div style="text-align:center;width:200px;">
	  <form>
	    <input name="id" id="id" type="hidden" value="${menu.id }">
		*<input name="name" id="name" type="text" placeholder="菜单名称" value="${menu.name }"><br/><br/>
		*<input name="url" id="url" type="text" placeholder="菜单地址" value="${menu.url }"><br/><br/>
		<input name="commont" id="commont" type="text" placeholder="菜单说明" value="${menu.commont }"><br/><br/>
		<c:if test="${menu == null }">
			<button onclick="addList()">添加</button>
		</c:if>
		<c:if test="${menu != null }">
			<button onclick="releditList()">修改</button>
		</c:if>
      </form>
	</div>
	<iframe id="rfFrame" name="rfFrame" src="about:blank"
		style="display: none;"></iframe>
	<div id="tips"></div>
</div>
<script src="../js/jquery-1.8.0.min.js"></script>
<script>
function addList(){
	document.forms[0].target = "rfFrame";
	$.ajax({
		url: "http://localhost:8082/appservice/menu/addMenu.do",
		type: "post",
		data: $("form").serialize(),
		dataType: "json",
		success: function(data){
			console.log(data);
			$("#tips").text(data.message);
			
			window.location.href = "http://localhost:8082/appservice/menu/menuUI.do";
		},
		error: function(data){
			console.log("error");
		}
		
	})
}

//修改
function releditList(){
	$.ajax({
		url: "http://localhost:8082/appservice/menu/updateMenuByPK.do",
		type: "post",
		data: $("form").serialize(),
		dataType: "json",
		success: function(data){
			console.log(data);
			$("#tips").text(data.message);
			
			window.location.href = "http://localhost:8082/appservice/menu/menuUI.do";
		},
		error: function(data){
			console.log("error");
		}
	})
}
</script>
</body>
</html>