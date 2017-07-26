<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<script type="text/javascript" src="<%=path%>/web/js/technic.js"></script>
<script type="text/javascript" src="<%=path%>/web/js/slider.js"></script>

<!--[if IE 9]>
		<style type="text/css">@import url('css/ie9.css');</style>
	<![endif]-->
<!--[if IE 8]>
		<style type="text/css">@import url('css/ie8.css');</style>
	<![endif]-->
<!--[if lte IE 7]>
		<style type="text/css">@import url('css/ie7.css');</style>
	<![endif]-->

<!--登陆代码-->

<script type="text/javascript"
	src="<%=path%>/web/js/jquery.easing.1.3.js"></script>
<script type="text/javascript" src="<%=path%>/web/js/login.js"></script>
<link rel="stylesheet" type="text/css"
	href="<%=path%>/web/css/login.css" />
<!--[if lt IE 8]>
	<link rel="stylesheet" type="text/css" href="css/ie.css"/>
<![endif]-->
<!--登陆代码end-->

<!--分页代码-->
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						var show_per_page = 5;
						var number_of_items = $('#fenye').children().size();
						var number_of_pages = Math.ceil(number_of_items
								/ show_per_page);
						$('#current_page').val(0);
						$('#show_per_page').val(show_per_page);
						var navigation_html = '<a class="previous_link" href="javascript:previous();">上一页</a>';
						var current_link = 0;
						while (number_of_pages > current_link) {
							navigation_html += '<a class="page_link" href="javascript:go_to_page('
									+ current_link
									+ ')" longdesc="'
									+ current_link
									+ '">'
									+ (current_link + 1)
									+ '</a>';
							current_link++;
						}
						navigation_html += '<a class="next_link" href="javascript:next();">下一页</a>';
						$('#page_navigation').html(navigation_html);
						$('#page_navigation .page_link:first').addClass(
								'active_page');
						$('#fenye').children().css('display', 'none');
						$('#fenye').children().slice(0, show_per_page).css(
								'display', 'block');
					});
	function previous() {
		new_page = parseInt($('#current_page').val()) - 1;
		if ($('.active_page').prev('.page_link').length == true) {
			go_to_page(new_page);
		}
	}
	function next() {
		new_page = parseInt($('#current_page').val()) + 1;

		if ($('.active_page').next('.page_link').length == true) {
			go_to_page(new_page);
		}
	}
	function go_to_page(page_num) {
		var show_per_page = parseInt($('#show_per_page').val());
		start_from = page_num * show_per_page;
		end_on = start_from + show_per_page;
		$('#fenye').children().css('display', 'none').slice(start_from, end_on)
				.css('display', 'block');
		$('.page_link[longdesc=' + page_num + ']').addClass('active_page')
				.siblings('.active_page').removeClass('active_page');
		$('#current_page').val(page_num);
	}
</script>
<!--分页代码end-->

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
		<%@ include file="base/menu.jspf" %>
		<!-- #Menü -->

		<div id="login">
			<a href="#" id="link" class="signin">登陆</a>
			<form class="drop">
				<label for="name">用户名:</label> <input type="text" name=""
					class="required" /> <label for="password">密码:</label> <input
					type="password" name="password" class="required" />
				<!-- <p class="remember"><input type="checkbox" class="checkbox"/></p>-->
				<input type="submit" class="submit" value="登陆" />
				<!-- <p><a href="#" class="tooltip">Forgot Password?<span>Click To Reset Your Password</span></a></p>-->
			</form>
		</div>



		<div id="icerik">

			<div id="icerikust">
				<%@ include file="base/loseMenu.jspf" %>

				<div id="arama">
					<form action="#" method="POST">
						<input type="text" />
						<button type="Submit"></button>
					</form>
				</div>
			</div>

			<div id="isol">

				<div id="smenu">
					<span class="smb">感谢信</span>
					<div class="smliste">
						<ul>
							<c:forEach items="${letterList }" var="letter">
								<li><a href="#">${letter.title }</a></li>
							</c:forEach>
						</ul>
					</div>
				</div>

			</div>

			<div id="isag">

				<div id="manset">
					<ul class="mansetresim">
						<li><a href="#"><img src="<%=path%>/web/img/banner1.png"
								alt="" /></a></li>
						<li><a href="#"><img src="<%=path%>/web/img/banner2.jpg"
								alt="" /></a></li>
						<li><a href="#"><img src="<%=path%>/web/img/banner3.png"
								alt="" /></a></li>
						<li><a href="#"><img src="<%=path%>/web/img/banner1.png"
								alt="" /></a></li>
						<li><a href="#"><img src="<%=path%>/web/img/banner4.png"
								alt="" /></a></li>
					</ul>
					<div class="mansetalt">
						<ul class="mansetnav">
							<li><a href="#"></a></li>
							<li><a href="#"></a></li>
							<li><a href="#"></a></li>
							<li><a href="#"></a></li>
							<li><a href="#"></a></li>
						</ul>
					</div>
				</div>

				<div id="gf">
					<ul>
						<c:forEach items="${notices }" var="notice">
							<li><a href="#">${notice.title }</a></li>
						</c:forEach>
					</ul>
				</div>

				<div id="urunliste">
					<div class="urunliste">
						<div class="urun-left">
							<h4>失物信息</h4>
							<div style="border-bottom: 1px solid #ececec;"></div>
							<ul class="info-list">
								<li class="text-center"><span class='event-goods-type'>物品类别</span>
									<span class='event-goods'>物品名称</span> <span class='event-time'>丢失时间</span>
									<span class='event-address'>丢失地点</span> <span
									class='event-title'>标题</span></li>
								<!--分页代码-->
								<input type='hidden' id='current_page' />
								<input type='hidden' id='show_per_page' />
								<div id='fenye'>
									<!--分页代码end-->
									<c:forEach items="${loses }" var="lose"> 
									
										<li class="clearfix"><span class='event-goods-type'>
										<a href="shop_info.action?id=${lose.id }" tppabs="">${lose.shop_type }</a></span> <span class='event-goods'>${lose.shop_name }</span>
											<span class='event-time'>${lose.shop_time }</span> <span
											class='event-address'>${lose.address }</span> <span class='event-title'><a
												href="shop_info.action?id=${lose.id }" tppabs="">学生证丢失 [详情...]</a></span></li>
									
									</c:forEach>
									<!--分页代码-->
								</div>
								<div id='page_navigation'></div>
								<br />
								<br />
								<!--分页代码end-->
							</ul>
						</div>
						<p>&nbsp;</p>
						<div class="urun-right">
							<h4>招领信息</h4>
							<div style="border-bottom: 1px solid #ececec;"></div>
							<ul class="info-list">
								<li class="text-center"><span class='event-goods-type'>物品类别</span>
									<span class='event-goods'>物品名称</span> <span class='event-time'>捡到时间</span>
									<span class='event-address'>捡到地点</span> <span
									class='event-title'>标题</span></li>
								<!--分页代码-->
								<input type='hidden' id='current_page' />
								<input type='hidden' id='show_per_page' />
								<div id='fenye'>
									<!--分页代码end-->
									<c:forEach items="${takes }" var="take">
										<li class="clearfix"><span class='event-goods-type'><a
												href="shop_info.action?id=${take.id }" tppabs="">${take.shop_type }</a></span> <span class='event-goods'>${take.shop_name }</span>
											<span class='event-time'>${take.shop_time }</span> <span
											class='event-address'>${take.address }</span> <span class='event-title'><a
												href="shop_info.action?id=${take.id }" tppabs="">学生证丢失 [详情...]</a></span></li>
									 </c:forEach>
									<!--分页代码-->
								</div>
								<div id='page_navigation'></div>
								<br />
								<br />
								<!--分页代码end-->
							</ul>
						</div>
					</div>
				</div>

			</div>

		</div>

	</div>


	<!-- Footer -->
	<%@ include file="base/footer.jspf" %>
	<!-- #Footer -->
</body>
</html>