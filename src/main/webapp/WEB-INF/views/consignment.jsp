<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
	<base href="<%=basePath%>">
	<meta charset="UTF-8">
	<title>寄售</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0"/>
	<!-- 禁止将数字变为电话号码 -->
	<meta name="format-detection" content="telephone=no"/>
	<!-- iphone设备中的safari私有meta标签,允许全屏模式浏览，隐藏浏览器导航栏 -->
	<meta name="apple-mobile-web-app-capable" content="yes"/>
	<!-- iphone的私有标签,它指定的iphone中safari顶端的状态条的样式 -->
	<meta name="apple-mobile-web-app-status-bar-style" content="black">

	<link rel="stylesheet" href="css/master.css">
	<link rel="stylesheet" href="css/module.css">
</head>

<body>
<div class="content-index">
	<!--标题-->
	<header>
		转让宝物
		<!--操作按钮-->
		<div class="header-box">
			<a href="">
				<p class="header-left">
					<i class="icon icon-return"></i>
					返回
				</p>
			</a>
		</div>
		<!--操作按钮 END-->
	</header>
	<!--标题 END-->
	<!--寄售要求-->
	<div class="consignment">
		<p class="consignment-title">简单+快捷+安心</p>
		<div class="consignment-top">
			<p>全程无忧</p>
			<p>寄售服务</p>
		</div>
		<div class="consignment-content">
			<ul>
				<li>
					<span>1.</span>
					<img src="img/service1.png" alt="">
					<span class="content">告诉我们，您的地址</span>
				</li>
				<li>
					<span class="index">2.</span>
					<img src="img/service2.png" alt="">
					<span class="content">我们派人上门取货，您无需支付运费</span>
				</li>
				<li>
					<span class="index">3.</span>
					<img src="img/service3.png" alt="">
					<span class="content">我们帮您确认寄售商品的情况、价格、拍照上传，为宝物寻找下一个主人</span>
				</li>
				<li>
					<span class="index">4.</span>
					<img src="img/service4.png" alt="">
					<span class="content">成交后，我们将宝物快递给买家，同时支付您货款</span>
				</li>
			</ul>
		</div>
		<!-- 后续内容 -->
		<div class="blank"></div>
		<!--我要寄售按钮-->
		<a class="consignment-button" href="user/consale">
			<button>我要寄售</button>
		</a>
		<!--我要寄售按钮END-->
		<p class="consignment-bottom" >
			<a href="sell/releaseSelector">或者,您也可以自助发布宝物</a>
		</p>
	</div>
	<div class="blank"></div>

	<!--寄售要求END-->
	<!--底部导航-->
	<div class="menu" id="menu">
		<a href="">
			<i class="icon-menu icon-menu1"><img src="img/footer-c1.png" alt=""></i>
		</a>
		<a href="developing">
			<i class="icon-menu icon-menu2"><img src="img/footer-2.png" alt=""></i>
		</a>
		<a href="consignment">
			<i class="icon-menu icon-menu3"><img src="img/footer-3.png" alt=""></i>
		</a>
		<a href="user/shopping" >
			<i class="icon-menu icon-menu4"><img src="img/footer-4.png" alt=""></i>
		</a>
		<a href="user">
			<i class="icon-menu icon-menu5"><img src="img/footer-5.png" alt=""></i>
		</a>
	</div>
	<!--底部导航 END-->
</div>
</body>
</html>