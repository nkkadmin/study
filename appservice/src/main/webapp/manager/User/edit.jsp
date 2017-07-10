<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ include file="../../common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="${ctx}/manager/Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/manager/Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/manager/Css/style.css" />
    <script type="text/javascript" src="${ctx}/manager/Js/jquery.js"></script>
    <script type="text/javascript" src="${ctx}/manager/Js/bootstrap.js"></script>
    <script type="text/javascript" src="${ctx}/manager/Js/ckform.js"></script>
    <script type="text/javascript" src="${ctx}/manager/Js/common.js"></script>

    <style type="text/css">
        body {
            padding-bottom: 40px;
        }
        .sidebar-nav {
            padding: 9px 0;
        }

        @media (max-width: 980px) {
            /* Enable use of floated navbar text */
            .navbar-text.pull-right {
                float: none;
                padding-left: 5px;
                padding-right: 5px;
            }
        }
    </style>
</head>
<body>
<form action="##" method="post" class="definewidth m20">
<input type="hidden" name="id" value="${user.id }" />
    <table class="table table-bordered table-hover definewidth m10">
        <tr>
            <td width="10%" class="tableleft">登录名</td>
            <td><input type="text" name="loginname" value="${user.loginname}"/></td>
        </tr>
        <c:if test="${user == null }"><tr>
            <td class="tableleft">密码</td>
            <td><input type="password" name="password"/></td>
        </tr></c:if>
        <c:if test="${user == null }"><tr>
            <td class="tableleft">确认密码</td>
            <td><input id="confirmPassword"
					type="password" name="confirmPassword" ></td>
        </tr></c:if>
        <tr>
            <td class="tableleft">真实姓名</td>
            <td><input type="text" name="username" value="${user.username }"/></td>
        </tr>
        <tr>
            <td class="tableleft">性別</td>
            <td><input type="text" name="sex" value="${user.sex }"/></td>
        </tr>
        <tr>
            <td class="tableleft">年齡</td>
            <td><input type="text" name="age" value="${user.age }"/></td>
        </tr>
        <tr>
            <td class="tableleft">角色</td>
            <td>
            	<select class="roleselect" name="roleid"></select>
            </td>
        </tr>
        <tr>
            <td class="tableleft"></td>
            <td>
                
                <c:if test="${user == null}"><button type="button" class="btn btn-primary" type="button" onclick="register()">保存</button></c:if>
                <c:if test="${user != null}"><button type="button" class="btn btn-primary" type="button" onclick="edit()">保存</button></c:if>
                &nbsp;&nbsp;
                <button type="button" class="btn btn-success" name="backid" id="backid">返回列表</button>
            </td>
        </tr>
        <tr>
        	<td class="tableleft"></td><td id="tips"></td>
        </tr>
    </table>
</form>
</body>
<script>
$(function () {       
$('#backid').click(function(){
		window.location.href="${ctx}/user/userListUI";
 });
});
function register() {
	console.log($("form").serialize());
	$.ajax({
		url : '${ctx}/user/addUser.do', //接口地址
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
    
$.ajax({
	url: '${basepath}/role/queryRoleList.do',
	type: 'post',
	dataType: 'json',
	success: function(data){
		console.log(data);
		for(var i = 0;i < data.rows.length;i++){
			if(parseInt('${user.roleid}') == data.rows[i].id){
				$(".roleselect").append("<option value='"+ data.rows[i].id +"' selected='selected'>"+ data.rows[i].name +"</option>");
			}else{
				$(".roleselect").append("<option value='"+ data.rows[i].id +"'>"+ data.rows[i].name +"</option>");
			}
		}
	},
	error: function(data){
		console.log("error");
	}
})

function edit(){
	$.ajax({
		url: '${basepath}/user/updateUserByUserId.do',
		type: 'post',
		data: $(".definewidth").serialize(),
		dataType: 'json',
		success: function(data){
			console.log(data);
			$("#tips").text(data.message);
		},
		error: function(data){
			console.log("error");
		}
	})
}
</script>
</html>
