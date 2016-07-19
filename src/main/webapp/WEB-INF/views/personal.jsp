<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/" + "MaBao/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
	<base href="<%=basePath%>">

	<meta charset="UTF-8">
	<title>个人中心</title>
	<meta name="viewport"
		  content="maximum-scale=1.0,minimum-scale=1.0,user-scalable=no,width=device-width,initial-scale=1.0"/>
	<!-- 禁止将数字变为电话号码 -->
	<meta name="format-detection" content="telephone=no"/>
	<!-- iphone设备中的safari私有meta标签,允许全屏模式浏览，隐藏浏览器导航栏 -->
	<meta name="apple-mobile-web-app-capable" content="yes"/>
	<!-- iphone的私有标签,它指定的iphone中safari顶端的状态条的样式 -->
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<link rel="stylesheet" href="">
	<link rel="stylesheet" href="css/master.css">
	<link rel="stylesheet" href="css/module.css">
</head>

<body>
<div class="content-index">
	<!--标题-->
	<header>
		个人中心
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
	<!--宝宝图片上传-->
	<div class="baby-photo">
		<figure><img src="${userInfo.userPicture}" alt="头像"></figure>
		<figcaption>
			<p>${userInfo.userName}</p>
			<p class="line">${userInfo.babyName}</p>
		</figcaption>
	</div>
	<!--宝宝图片上传-END-->
	<!--个人中心信息-->
	<div class="personal-center">
		<p class="order-top">我的订单：</p>
		<!--我是买家订单-->
		<div>
			<p class="order-bottom">我是<span class="red">买家</span></p>
			<ul>
				<li ><a class="link" href="purchase_order">全部</a></li>				<!-- 作为买家的相关操作列表 -->
				<li ><a href="unpaid_order">待付款</a></li>							<!-- 订单状态还没结算的订单列表 -->
				<li ><a href="nopackaged_order">待发货</a></li>							<!-- 需要consignment的商品列表 -->
				<li ><a href="ckeck_order">待确认</a></li>							<%--  发送出去而没有确认收货额商品列表 --%>
			</ul>
		</div>
		<!--我是买家订单END-->
		<!--我是买家订单-->
		<div>
			<p class="order-bottom">我是<span class="blue">卖家</span></p>
			<ul>
				<li ><a class="link" href="consignment_order">全部</a></li>			<%--作为卖家相关操作列表--%>
				<li ><a href="finish_order">已出售</a></li>						<%--已经卖出的商品列表--%>
				<li ><a href="published_order">已发布</a></li>						<%--上架热卖的商品列表--%>
				<li ><a href="unpublished_order">待发布</a></li>						<%--准备上架卖出的商品列表--%>
			</ul>
		</div>
		<!--我是买家订单END-->
		<!--个人中心操作-->
		<div class="personal-center-control">
			<a href="changepwd?userId=${userInfo.userId}"><p>修改密码</p></a>
			<a href="javascript:;"><p>绑定微信（调用微信接口）</p></a>
			<a href="user/address/userAllAddress"><p>收货地址</p></a>
			<a href="user/baby/showBabyInfo"><p>宝宝信息</p></a>
			<a href="static/bindphone.html"><p>绑定手机</p></a>
		</div>

		<!--个人中心操作END-->
	</div>
	<!--个人中心信息END-->
	<!--注销按钮-->
	<a class="personal-center-button" href="login">
		<button type="reset">注销</button>
	</a>
	<!--注销按钮END-->
	<!--底部导航-->
	<div class="menu" id="menu">
		<a href="">
			<i class="icon-menu icon-menu1"><img src="img/footer-c1.png" alt=""></i>
		</a>
		<a href="#">
			<i class="icon-menu icon-menu2"><img src="img/footer-2.png" alt=""></i>
		</a>
		<a href="consignment">
			<i class="icon-menu icon-menu3"><img src="img/footer-3.png" alt=""></i>
		</a>
		<a href="user/shopping" id="shopping">
			<i class="icon-menu icon-menu4"><img src="img/footer-4.png" alt=""></i>
		</a>
		<a href="user/personal">
			<i class="icon-menu icon-menu5"><img src="img/footer-5.png" alt=""></i>
		</a>
	</div>
	<!--底部导航 END-->
</div>
</body>
</html>