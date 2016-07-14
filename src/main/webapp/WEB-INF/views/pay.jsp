<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>付款</title>
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
		确认订单
		<!--操作按钮-->
		<div class="header-box">
			<a href="/jsp/detail">
				<button class="header-left">
					<i class="icon icon-return"></i>
					返回
				</button>
			</a>
		</div>
		<!--操作按钮 END-->
	</header>
	<!--标题 END-->
	<!-- 收货地址 -->
	<div class="box add">
		<div class="box-left">
			<img src="../../img/pay-1.png" alt="">
		</div>
		<div class="box-right">
			<div class="box-right-top">
				<dl>
					<dd>${defaultAddress.recipients}</dd>
					<dt>电话:${defaultAddress.tel}</dt>
				</dl>
			</div>
			<div class="box-right-bottom">
				<p>${defaultAddress.area}</p>
				<p>${defaultAddress.location}</p>
			</div>
		</div>
		<a href="/user/address/updateAddress">
			<button class="add-jump-arrow"></button>
		</a>
	</div>
	<!-- 收货地址 END-->
	<!-- 购买订单 -->
	<c:forEach var="goods" items="${checkedGoodsList}">
	<div class="order-box" onclick=window.location.href="detail.html">
		<img src="../../img/u8.jpg" alt="宝物">
		<div class="order-box-right">
			<p>H&M CARDIGAN</p>
			<p>尺寸：S</p>
			<p class="order-box-left">￥35.5</p>
		</div>
	</div>
	<!-- 购买订单END -->

	<ul class="lists">
		<li>共计1件商品&nbsp;小计：<b>￥${checkedGoodsList.sum}</b></li>
		<li><span>快递费</span> <span><b>￥${freight}</b></span></li>
	</ul>
	</c:forEach>
	<label class="notes">备注
		<textarea cols="30" rows="10"></textarea>
	</label>
	<!--付款按钮-->
	<div class="up-to-pay pay-fixed">
		<ul>
			<li>总计&nbsp;:&nbsp;<b>￥131.00</b></li>
			<li>
				<a href="pay.html">
					<button type="submit">付款</button>
				</a>
			</li>
		</ul>
	</div>
	<!--付款按钮END-->
	<div class="blank"></div>
</div>
</body>
</html>