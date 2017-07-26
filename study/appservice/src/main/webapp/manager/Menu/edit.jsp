<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="${ctx }/manager/Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="${ctx }/manager/Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="${ctx }/manager/Css/style.css" />
    <script type="text/javascript" src="${ctx }/manager/Js/jquery.js"></script>
    <script type="text/javascript" src="${ctx }/manager/Js/bootstrap.js"></script>
    <script type="text/javascript" src="${ctx }/manager/Js/ckform.js"></script>
    <script type="text/javascript" src="${ctx }/manager/Js/common.js"></script>

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
<form class="definewidth m20">
<input type="hidden" name="id" value="${menu.id}" />
<table class="table table-bordered table-hover m10">
    <tr>
        <td width="10%" class="tableleft">菜单名称</td>
        <td>
        	<input name="name" id="name" type="text" value="${menu.name }">
        </td>
    </tr>
    <tr>
        <td class="tableleft">菜单地址</td>
        <td><input name="url" id="url" type="text" value="${menu.url }"></td>
    </tr>
     <tr>
        <td class="tableleft">菜单说明</td>
        <td><input name="commont" id="url" type="text" value="${menu.commont }"></td>
    </tr>
    <tr>
        <td class="tableleft"></td>
        <td>
            <c:if test="${menu == null }">
            	<button class="btn btn-primary" type="button" onclick="addList()">保存</button>
            </c:if>
            <c:if test="${menu != null }">
            	<button class="btn btn-primary" type="button" onclick="releditList()">修改</button>
            </c:if>
             &nbsp;&nbsp;<button type="button" class="btn btn-success" name="backid" id="backid">返回列表</button>
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
				window.location.href="${ctx}/menu/menuUI";
		 });
    });
    //添加
    function addList(){
    	showForm('${basepath}/menu/addMenu');
    }
    //修改
    function releditList(){
    	showForm('${basepath}/menu/updateMenuByPK');
    }
</script>