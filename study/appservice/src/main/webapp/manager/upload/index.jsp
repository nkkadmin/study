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
<button type="button" class="btn btn-success" id="addFile">新增角色</button>
<table class="table table-bordered table-hover definewidth m10" id="roleList" 
		data-pagination="true" data-query-params-type="" data-side-pagination="server"
		data-page-list="[All]" data-url="${ctx}/role/queryRoleList" data-query-params="searchParams"
		data-response-handler="responseHandler">
	<thead>
		<tr>
			<th class="ao_line-in" data-field="name" data-align="center" data-visible="true" data-cell-style="idStyle">文件名称</th>
			<th class="ao_line-in" data-field="commont" data-align="center" data-visible="true" data-cell-style="idStyle">文件说明</th>
			<th class="ao_line-in" data-field="operUser" data-align="center" data-visible="true" data-cell-style="idStyle">操作人</th>
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
	
	$('#addFile').click(function(){
		window.location.href="${ctx}/upload/uploadUI";
	});
});
/* 查询参数 */
function searchParams(params) {
	params.pageNo = params.pageNumber;// 当前页
	params.pageSize = params.pageSize;// 每页记录数
	return params;
}

/* 构建操作按钮 */
 function responseHandler(res){
	$.each(res.rows,function(i,row){
		row.rowOption="";
		//审核状态为1，则有申请初评
		row.rowOption += "<a href=\"${ctx}/role/editRoleUI?id="+row.id+"\" style='margin-right:10px;'>修改</a>";
		row.rowOption += "<a onclick='del("+row.id+")' href=\"javascript:;\">删除</a>";
	});
	return res;
}

function del(id){
	if(confirm("确定要删除吗？"))
	{
		$.ajax({
			url: '${ctx}/role/deleteRoleByPK',
			type: 'get',
			data: {'id':id},
			dataType: 'json',
			success: function(data){
				console.log(data);
				if(data.success){
					$("#roleList").bootstrapTable('refresh',{url:'${ctx}/role/listUI'});
				}
			},
			error: function(data){
				console.log("error");
			}
		})		
	}
}
</script>
</html>

