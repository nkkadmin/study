<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<meta charset="UTF-8">
<%--  <link rel="stylesheet" type="text/css" href="${ctx}/manager/Css/bootstrap.css" />
 --%>
<link rel="stylesheet" type="text/css" href="${ctx}/js/bootstrap/bootstrap-table/bootstrap-table.min.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/manager/Css/bootstrap-responsive.css" />
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">  
<link rel="stylesheet" type="text/css" href="${ctx}/manager/Css/style.css" />
<script type="text/javascript" src="${ctx}/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="${ctx}/manager/Js/bootstrap.js"></script>
<script type="text/javascript" src="${ctx}/manager/Js/ckform.js"></script>
<script src='${ctx}/js/bootstrap/bootstrap-table/bootstrap-table.min.js' type='text/javascript'></script>
<script type="text/javascript" src="${ctx}/manager/Js/common.js"></script>



<style type="text/css">
body {
	padding-bottom: 40px;
}

.sidebar-nav {
	padding: 9px 0;
}

@media ( max-width : 980px) {
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
	<form class="form-inline definewidth m20" action="index.html" method="get">
		用户名称： <input type="text" name="username" id="username" class="abc input-default" placeholder="" value="">&nbsp;&nbsp;
		<button type="submit" class="btn btn-primary">查询</button>
		&nbsp;&nbsp;
		<button type="button" class="btn btn-success" id="addnew">新增用户</button>
	</form>
	<table class="table table-bordered table-hover definewidth m10" id="evaluationList" 
		data-pagination="true" data-query-params-type="" data-side-pagination="server"
		data-page-list="[All]" data-url="${ctx}/user/userList.do" data-query-params="searchParams"
		data-response-handler="responseHandler">
		<thead>
			<tr>
				<th class="ao_line-in" data-field="loginname" data-align="center" data-visible="true" data-cell-style="idStyle">登录名称</th>
				<th class="ao_line-in" data-field="username" data-align="center" data-visible="true" data-cell-style="idStyle">真实姓名</th>
				<th class="ao_line-in" data-field="sex" data-align="center" data-cell-style="dateStyle">性别
				</th>
				<th class="ao_line-in" data-field="age" data-align="center" data-cell-style="resStyle">年齡</th>
				<th class="ao_line-in" data-field="createtime" data-align="center" data-cell-style="resStyle">创建时间</th>
				<th class="ao_line-in" data-field="rowOption" data-align="center" data-cell-style="operStyle">操作</th>
				<th data-field="id" data-align="left" data-visible="false">id</th>
			</tr>
		</thead>
	</table>
</body>
<script>
	$(function() {
		$('#evaluationList').bootstrapTable({
			method : 'post'
		});
		$('#addnew').click(function() {
			window.location.href = "${ctx}/user/addUserUI";
		});
		

	});
	var updateUser = function(id){
		window.location.href="${ctx}/user/editUserUI?id="+id
	}
	/* 查询参数 */
	function searchParams(params) {
		params.pageNo = params.pageNumber;// 当前页
		params.pageSize = params.pageSize;// 每页记录数
		return params;
	}
	
	/*构建操作按钮*/
	function responseHandler(res) {
		$.each(res.rows,function(i, row) {
			row.rowOption="";
			//审核状态为1，则有申请初评   																												
			row.rowOption+="<a href=\"${ctx}/user/editUserUI?id="+row.id+"\" style='margin-right:10px;'>修改</a>";
			row.rowOption+="<a style='margin-right:10px;' href='##' onclick='del("+ row.id +")'>刪除</a>";
		});

		return res;
	}

	function del(id) {

		if (confirm("确定要删除吗？")) {
			
			$.ajax({
				url: '${ctx}/user/deleteUserByUserId',
				type: 'get',
				data: {'userId':id},
				dataType: 'json',
				success: function(data){
					console.log(data);
					
					$("#evaluationList").bootstrapTable('refresh',{url:'${ctx}/user/userList'});
				},
				error: function(data){
					console.log("error");
				}
			})
			
		}

	}
</script>
</html>
