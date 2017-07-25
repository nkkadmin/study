<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ include file="../../common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${ctx }/manager/Css/bootstrap.css" />
    <link rel="stylesheet" href="${ctx }/manager/Css/bootstrap-responsive.css" />
    <link rel="stylesheet" href="${ctx }/manager/Css/style.css" />
    <script src="${ctx }/manager/Js/jquery.js"></script>
    <script src="${ctx }/manager/Js/bootstrap.js"></script>
    <script src="${ctx }/manager/Js/ckform.js"></script>
    <script src="${ctx }/manager/Js/common.js"></script>

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
<form action="#" method="post" class="definewidth m20" >
<input type="hidden" name="id" value="${role.id}" />
<table class="table table-bordered table-hover definewidth m10">
    <tr>
        <td width="10%" class="tableleft">角色名称</td>
        <td><input type="text" name="name" value="${role.name }"/></td>
    </tr>
    <tr>
        <td class="tableleft">角色说明</td>
        <td><input type="text" name="commont"value="${role.commont }" /></td>
    </tr>
    <tr>
        <td class="tableleft"></td>
        <td>
        	<c:if test="${role == null }">
				<button class="btn btn-primary" type="button" onclick="addList()">保存</button>        	
        	</c:if>
        	<c:if test="${role != null }">
        		<button class="btn btn-primary" type="button" onclick="editListadd()">保存</button>
        	</c:if>
        	&nbsp;&nbsp;
        	<button type="button" class="btn btn-success" name="backid" id="backid">返回列表</button>
        </td>
    </tr>
    <tr>
    	<td><div id="tips"></div></td>	
    </tr>
</table>
</form>
</body>
</html>
<script src="${ctx}/manager/Js/global.js"></script>
<script>
    $(function () {
		$('#backid').click(function(){
				window.location.href="${ctx}/role/listUI";
		 });
    });
   
    //添加
    function addList(){
    	showForm('${basepath}/role/addRole');
    }
    //修改
    function editListadd(){
    	showForm('${basepath}/role/updateRoleByPK');
    }
    
</script>