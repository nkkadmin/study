<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="${ctx}/manager/Css/bootstrap-responsive.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/manager/Css/style.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/js/bootstrap/bootstrap-table/bootstrap-table.min.css" />
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">  

<script type="text/javascript" src="${ctx}/manager/Js/jquery.js"></script>
<script type="text/javascript" src="${ctx}/manager/Js/bootstrap.js"></script>
<script type="text/javascript" src="${ctx}/manager/Js/ckform.js"></script>
<script type="text/javascript" src="${ctx}/manager/Js/common.js"></script>
<script src='${ctx}/js/bootstrap/bootstrap-table/bootstrap-table.min.js' type='text/javascript'></script>

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
<form id="evaluationList" class="form-inline definewidth m20" action="index.html" method="get">  
    角色名称：
    <input type="text" name="rolename" id="rolename"class="abc input-default" placeholder="" value="">&nbsp;&nbsp;  
    <button type="submit" class="btn btn-primary">查询</button>&nbsp;&nbsp; <button type="button" class="btn btn-success" id="addnew">新增角色</button>
</form>
<table class="table table-bordered table-hover definewidth m10" id="roleList" 
		data-pagination="true" data-query-params-type="" data-side-pagination="server"
		data-page-list="[All]" data-url="${ctx}/role/queryRoleList" data-query-params="searchParams"
		data-response-handler="responseHandler">
	<thead>
		<tr>
			<th class="ao_line-in" data-field="name" data-align="center" data-visible="true" data-cell-style="idStyle">角色名称</th>
			<th class="ao_line-in" data-field="commont" data-align="center" data-visible="true" data-cell-style="idStyle">角色说明</th>
			<th class="ao_line-in" data-field="createtime" data-align="center" data-cell-style="resStyle">创建时间</th>
			<th class="ao_line-in" data-field="rowOption" data-align="center" data-cell-style="operStyle">操作</th>
			<th data-field="id" data-align="left" data-visible="false">id</th>
		</tr>
	</thead>
</table>
</body>
<script>
$(function () {
	//展示list
	$("#roleList").bootstrapTable({
		method: 'post'
	})
	
	$('#addnew').click(function(){
		window.location.href="add.html";
	});
});
/* 查询参数 */
function searchParams(params) {
	params.pageNo = params.pageNumber;// 当前页
	params.pageSize = params.pageSize;// 每页记录数
	return params;
}

function del(id){
	if(confirm("确定要删除吗？"))
	{
		var url = "index.html";
		window.location.href=url;		
	}
}
</script>
</html>

