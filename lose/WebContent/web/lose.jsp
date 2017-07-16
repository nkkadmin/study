<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我丢东西啦</title>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
<title></title>
<link rel="stylesheet" type="text/css"
	href="<%=path%>/web/css/style.css" />
<link rel="stylesheet" type="text/css"
	href="<%=path%>/web/css/next1.css" />
<script type="text/javascript" src="<%=path%>/web/js/jquery.js"></script>
<!--登陆代码-->
<script type="text/javascript"
	src="<%=path%>/web/js/jquery.easing.1.3.js"></script>
<script type="text/javascript" src="<%=path%>/web/js/login.js"></script>
<link rel="stylesheet" type="text/css"
	href="<%=path%>/web/css/login.css" />
<!--登陆代码end-->
</head>
<body>
	<!-- Genel -->
	<div id="genel">
		<!-- Header -->
		<div id="header">

			<!-- Logo -->
			<div id="logo">
				<a href="#"><img src="<%=path%>/web/img/logo1.png" alt="" /></a>
			</div>
			<!-- #Logo -->

			<div class="temizle"></div>

		</div>
		<!-- Header -->

		<!-- Menü -->
		<%@ include file="base/menu.jspf"%>
		<!-- #Menü -->

		<%@ include file="base/login.jspf"%>

		<!-- İçerik -->
		<div id="icerik">
			<!-- İçerik Üst -->
			<div id="icerikust">
				<%@ include file="base/loseMenu.jspf"%>
				<!-- Arama -->
				<div id="arama">
					<form action="#" method="POST">
						<input type="text" />
						<button type="Submit"></button>
					</form>
				</div>
			</div>
			<!-- İçerik Üst -->
		</div>
		<!-- #content-->
		<div id="content">
			<div class="content-title">
				<h4>填写失物信息 <span style="color:red">${addMsg}</span></h4>
				<div
					style="border-bottom: 1px solid #ececec; margin: 10px 0px 20px 0px;"></div>
			</div>
			<form action="shop_addLose.action" method="post" enctype="multipart/form-data">
				<table cellspacing="0" cellpadding="0" border="1px" >
					<input type="hidden" name="shop.type" value="lose"/>
					<tr>
						<td height="50px">
							<label for="note-title" class="">标题：</label>
						</td>
						<td colspan="3">
							<input type="text" id="note-title"
							name="shop.title" size="90" style="height: 40px;" />
						</td>
					</tr>
					<tr>
						<td height="40px">
							<label for="note-info-goods">物品种类：</label>
						</td>
						<td><select name="shop.shop_type" id="search-goods-type"
							style="height: 25px;">
								<option value="卡类证件" selected="selected">卡类证件</option>
								<option value="随身物品">随身物品</option>
								<option value="电子数码">电子数码</option>
								<option value="书籍资料">书籍资料</option>
								<option value="其他物品">其他物品</option>
							</select>
						</td>
					</tr>
					<tr>
						<td height="40px">
							<label for="note-info-goods">物品名称：</label>
						</td>
						<td>
							<input type="text" id="note-info-goods" name="shop.shop_name"
								placeholder="钱包、一卡通、U盘？" size="30" style="height: 25px;" />
						</td>
						<td><label for="note-info-extra">备注：</label></td>
						<td>
							<input type="text" id="note-info-extra"
							name="shop.comment" placeholder="颜色、品牌、卡号、特点？" size="30"
							style="height: 25px;" />
						</td>
					</tr>
					<tr>
						<td height="40px"><label for="datepicker">丢失时间：</label></td>
						<td>
							<input type="text" class="input-icon" id="datepicker"
								name="shop.shop_time" placeholder="yyyy-mm-dd" size="30"
								style="height: 25px;" />
						</td>
						<td><label for="note-info-address">丢失地点：</label></td>
						<td>
							<input type="text" class="input-icon"
							id="note-info-address" name="shop.address" placeholder="明实楼、北配楼、图书馆？"
							size="30" style="height: 25px;" />
						</td>
					</tr>
					<tr>
						<td height="40px"><label for="note-contact-phone">您的手机：</label></td>
						<td>
							<input type="text" id="note-contact-phone"
								name="shop.telphone" placeholder="请填写手机号码" size="30"
								style="height: 25px;" />
						</td>
					</tr>
					<tr>
						<td height="40px"><label for="note-content">详情描述：</label></td>
						<td><textarea id="note-content" name="shop.detail"
								class="fr"></textarea>
						</td>
					</tr>
					<tr>
						<td height="40px"><label for="note-content">上传图片：</label></td>
						<td><input type="file" name="file"/>
						</td>
					</tr>
					<tr>
						<td height="40px"><br />
							<p>
								<button name="submit" class="btn" id="">发布文章</button>
							</p>
						</td>
					</tr>
				</table>
			</form>
		</div>
		<!-- #content 结束-->
	</div>

	<!-- Footer -->
	<%@ include file="base/footer.jspf"%>
	<!-- #Footer -->
</body>
</html>