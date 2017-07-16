<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  用戶列表
  <table>
  <thead>
  	<th>编号</th>
  	<th>用户名</th>
  	<th>密码</th>
  	<th>手机号</th>
  	<th>状态</th>
  	<th>注册时间</th>
  	</thead>
  	<tbody>
  		<c:forEach items="${list }" var="user">
	  		<tr>
		  		<td>${user.id }</td>
		  		<td>${user.name }</td>
		  		<td>${user.password }</td>
		  		<td>${user.telphone }</td>
		  		<td>${user.statu }</td>
		  		<td>${user.create_time }</td>
	  		</tr>
  		</c:forEach>
  	</tbody>
  </table>
</body>
</html>