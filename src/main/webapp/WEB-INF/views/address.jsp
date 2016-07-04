<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>选择收货地址</title>
	<meta name="viewport" content="maximum-scale=1.0,minimum-scale=1.0,user-scalable=no,width=device-width,initial-scale=1.0"/>
	<!-- 禁止将数字变为电话号码 -->
	<meta name="format-detection" content="telephone=no" />
	<!-- iphone设备中的safari私有meta标签,允许全屏模式浏览，隐藏浏览器导航栏 -->
	<meta name="apple-mobile-web-app-capable" content="yes" />
	<!-- iphone的私有标签,它指定的iphone中safari顶端的状态条的样式 -->
	<meta name="apple-mobile-web-app-status-bar-style" content="black">

	<link rel="stylesheet" href="../../css/buy.css">
	<link rel="stylesheet" href="../../css/public.css">
</head>
<body>
 <section class="header-top">
	 <!--返回的url的修改-->
    	<div class="fanhui"><a onclick=window.location.href="/orders">
			<img src="../../img/back.png" alt=""></a>
			<a onclick=window.location.href="/orders" class="tiaozhuan">返回</a></div>
    	<div class="shouye"><p>选择收货地址</p></div>
	 <c:forEach items="addressList" var="allAddress">
    </section>
	<div class="header home1">
		<div class="ui-left"><img src="../../img/pay-1.png" alt=""></div>
		<div class="mes-right" onclick=window.location.href="/orders"><!--确认订单页的url-->
			<div class="mes-right-top">
				<dl>
					<dd>${allAddress.recipients}</dd>
					<dt>电话:${allAddress.tel}</dt>
				</dl>
			</div>
			<div class="mes-right-bottom">
				<p>${allAddress.location}</p>
				<p>${allAddress.detailLocation}</p>
			</div>
		</div>
		</c:forEach>
		<!--编辑收货地址url-->
		<div class="jump-arrow1" onclick=window.location.href="/user/updateAddressRedirect"></div>
	</div>
	<div class="clear"></div>
		<div class="input-add">
			<!--新增收货地址url-->
			<input type="button" value="新增收货地址" onclick=window.location.href="/user/addAddressRedirect"><!--新增地址url-->
		</div>
</body>
</html>