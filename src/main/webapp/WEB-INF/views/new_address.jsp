<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/" + "MaBao/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
	<base href="<%=basePath%>">

	<meta charset="UTF-8">
	<title>新增地址</title>
	<meta name="viewport"
		  content="maximum-scale=1.0,minimum-scale=1.0,user-scalable=no,width=device-width,initial-scale=1.0"/>
	<!-- 禁止将数字变为电话号码 -->
	<meta name="format-detection" content="telephone=no"/>
	<!-- iphone设备中的safari私有meta标签,允许全屏模式浏览，隐藏浏览器导航栏 -->
	<meta name="apple-mobile-web-app-capable" content="yes"/>
	<!-- iphone的私有标签,它指定的iphone中safari顶端的状态条的样式 -->
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<link rel="stylesheet" href="css/bootstrap-switch.css">
	<link rel="stylesheet" href="css/master.css">
	<link rel="stylesheet" href="css/module.css">
</head>

<body>
<div class="content-index">
	<!--标题-->
	<header>
		新增地址
		<!--操作按钮-->
		<div class="header-box">
			<a href="/user/address/userAllAddress">
				<button class="header-left">
					<i class="icon icon-return"></i>
					返回
				</button>
			</a>
		</div>
		<!--操作按钮 END-->
	</header>
	<!--标题 END-->
	<!-- 编辑收货地址 -->
	<form action="/user/address/addAddress">			<%--跳转到新增用户地址的action--%>
		<div class="edit-add-box">
			<label>
				<input name="address.recipients" type="text" placeholder="收件人：">
			</label>
			<label>
				<input name="address.tel" type="text" placeholder="手机号：">
			</label>
			<%--<label>
				<input name="location" type="text" placeholder="所在地：">
			</label>--%>
			<!-- 省市级联地址插件 -->
			<div id="test"></div>
			<!-- 省市级联地址插件END -->
			<input name="address.location" type="text" class="write" placeholder="详细地址：">
		</div>
		<!-- 清楚浮动 -->
		<div class="clear"></div>

		<div class="edit-add-input">
			<!-- 保存按钮 -->
			<label>
				<input type="submit" value="保存并使用"  />
			</label>
			<!-- 保存按钮END -->
		</div>
	</form>
	<!-- 编辑收货地址END -->
</div>
</body>
</html>
<script src="script/lib/jquery.1.10.2.js" type="text/javascript"></script>
<script src="script/lib/bootstrap/bootstrap.min.js"></script>
<script src="script/lib/bootstrap/bootstrap-switch.js"></script>
<script src="script/lib/jquery.provincesCity.js" type="text/javascript"></script>
<script src="script/lib/provinces-data.js" type="text/javascript"></script>
