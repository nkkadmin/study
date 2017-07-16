<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
<title></title>
<link rel="stylesheet" type="text/css"
	href="<%=path%>/web/css/style.css" />
<script type="text/javascript" src="<%=path%>/web/js/jquery.js"></script>
<link rel="stylesheet" type="text/css"
	href="<%=path%>/web/css/next1.css" />

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
				<ul>
					<li><a class="aktif" href="show.html">我<b>丢东西啦</b></a></li>
					<li><a href="show1.html">我是<b>好人</b></a></li>
				</ul>
				<!-- Arama -->
				<div id="arama">
					<form action="#" method="post">
						<input type="text" />
						<button type="submit"></button>
					</form>
				</div>
			</div>
			<!-- İçerik Üst -->
		</div>
		<!-- #İçerik -->

		<!---->
		<div class="note-page">
			<div class="">
				<div class="">
					<img class="avatar" src="<%=path%>/web/img/b1.png" tppabs=""
						alt="ey_flyp" title="ey_flyp" width="50px" height="50px" />
				</div>
				<div id="note-detail">
					<div class='note-detail-title-wrap'>
						<h2 class="note-detail-title ">
							<span id='note-detail-title-pre'> <c:if
									test="${info.type == 'lose' }">[失物信息]</c:if> <c:if
									test="${info.type == 'take' }">[拾物信息]</c:if>
							</span>${info.title }
						</h2>
						<span class="fr note-detail-author"> ${info.extraInfo["user"].name} 发表于： ${info.create_time }</span>
					</div>
					<div class="note-detial-goods">
						<table class="goods-detail" border="0" cellspacing="0"
							cellpadding="0">
							<tr>
								<td width="80px">捡到物品</td>
								<td width="240px">${info.shop_name}</td>
								<td rowspan="5" width="200px" style="overflow: auto;"><p>图片详情</p>
									<img src="<%=path%>/${info.pic}" /></td>
							</tr>
							<tr>
								<td>物品备注</td>
								<td>${info.comment }</td>
							</tr>
							<tr>
								<td><c:if test="${info.type == 'lose' }">失物时间</c:if> <c:if
										test="${info.type == 'take' }">拾物时间</c:if></td>
								<td>${info.shop_time }</td>
							</tr>
							<tr>
								<td>信息详情</td>
								<td>${info.detail }</td>
							</tr>
							<tr>
								<td>联系方式</td>
								<td><p>
										<!-- <a href="#">点此</a>获取楼主联系方式。// -->${info.telphone }
									</p></td>
							</tr>
						</table>
					</div>
					<div id="contact-lz" class="">
						<p id="contact-lz-close" class="pa">收起>></p>
						<p class="">楼主联系方式已过期，如您找到了他（她）的物品，请填写以下表单联系管理员。</p>
						<div id="connact-admin">
							<form action="" method="post">
								<input type="hidden" name="tid" id="contact-admin-tid"
									value="291" />
								<ul>
									<li><label for="contact-admin-name">昵称：</label> <input
										type="text" id="contact-admin-name" placeholder="请输入您的称呼"
										name="username" /></li>
									<li><label for="contact-admin-phone">手机：</label> <input
										type="text" id="contact-admin-phone" name="phone"
										placeholder="您的手机号码" /></li>
									<li><label for="contact-admin-content" class="">正文：</label>
										<textarea id="contact-admin-content" name="content"
											placeholder="告诉管理员，这个一卡通是你的，并向管理员询问楼主联系方式。"></textarea></li>
									<li id="">
										<p>
											<input type="submit" value="提交" class="btn" id="" />
										</p>
									</li>
								</ul>
							</form>
						</div>
						</tbody>
						</table>
					</div>
				</div>
			</div>
			<!--评论部分开始-->
			<div id="">
				<!--如果用户没有登录，提供以下登录选项-->
				<div id="snsLogin-wrap">
					<p>登录后可直接评论，也可匿名评论（需要填写昵称和邮箱）。</p>
					<br />
				</div>
				<div class="">
					<div class="">
						<img src="<%=path%>/web/img/b1.png" tppabs="" alt="" title=""
							class="avatar" />
					</div>

					<form action="" method="post" class="pinglun">
						<textarea name="comment" class="comment-textarea J_cmt-content"
							placeholder="请输入评论内容"></textarea>
						<input type="hidden" name="tid" value="291" /><br />
						<p>
							<input type="submit" value="发表评论" class="btn cmt-btn" />
						</p>
						</ul>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- #Genel -->
	<!-- Footer -->
	<div id="footer">
		<div class="footer">
			<ul id="fmenu">
				<li><a href="#">友情链接：&nbsp;&nbsp;北方民族大学</a></li>
				<li><a href="#">联系我们</a></li>
			</ul>
			<div id="footerlogo"></div>
		</div>
	</div>
	<!-- #Footer -->
</body>
</html>