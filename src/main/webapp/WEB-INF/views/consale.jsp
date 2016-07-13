<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>寄售：增加售货地址</title>
	<meta name="viewport"
		  content="maximum-scale=1.0,minimum-scale=1.0,user-scalable=no,width=device-width,initial-scale=1.0"/>
	<!-- 禁止将数字变为电话号码 -->
	<meta name="format-detection" content="telephone=no"/>
	<!-- iphone设备中的safari私有meta标签,允许全屏模式浏览，隐藏浏览器导航栏 -->
	<meta name="apple-mobile-web-app-capable" content="yes"/>
	<!-- iphone的私有标签,它指定的iphone中safari顶端的状态条的样式 -->
	<meta name="apple-mobile-web-app-status-bar-style" content="black">

	<link rel="stylesheet" href="../../css/master.css">
	<link rel="stylesheet" href="../../css/module.css">
</head>

<body>
<div class="content-index">
	<!--标题-->
	<header>
		增加售货地址
		<!--操作按钮-->
		<div class="header-box">
			<a href="/jsp/pay">
				<button class="header-left">
					<i class="icon icon-return"></i>
					返回
				</button>
			</a>
		</div>
		<!--操作按钮 END-->
	</header>
	<!--标题 END-->
	<!-- 绑定手机表单 -->
	<section class="container">
		<p class="p-tit">请填写您的地址及电话，我们会安排上门收货</p>
		<form method="post">
		<section class="msg-sale">
			<input type="text" placeholder="收件人" name="">
			<input type="text" placeholder="手机号" name="tel">
			<input type="text" placeholder="所在地" name="">
			<input type="text" placeholder="详细地址" name="">
		</section>
		<section class="server">
			<div class="terms">
				<p >寄售服务条款</p>
				<p >
					哈哈哈哈哈哈哈哈哈哈哈</p>
			</div>
			<p><input type="checkbox" checked="true"><span class="agree">我同意寄售服务条款</span></p>
		</section>
		<div class="clear"></div>
		<section class="up">
			<input type="button" value="提交" onclick=window.location.href="/jsp/consignment_success">
		</section>
	</section>
	</div>
</body>
</html>