<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>付款</title>
	<meta name="viewport" content="maximum-scale=1.0,minimum-scale=1.0,user-scalable=no,width=device-width,initial-scale=1.0"/>
	<!-- 禁止将数字变为电话号码 -->
	<meta name="format-detection" content="telephone=no" />
	<!-- iphone设备中的safari私有meta标签,允许全屏模式浏览，隐藏浏览器导航栏 -->
	<meta name="apple-mobile-web-app-capable" content="yes" />
	<!-- iphone的私有标签,它指定的iphone中safari顶端的状态条的样式 -->
	<meta name="apple-mobile-web-app-status-bar-style" content="black">

	<link rel="stylesheet" href="../../css/master.css">
    <link rel="stylesheet" href="../../css/module.css">
</head>
<body>
 	<section class="header-top">
		<!--商品详情页面的url传递-->
    	<div class="fanhui"><a onclick=window.location.href="/goodsDetail?id=${goods.id}" >
			<img src="../../img/back.png" alt=""></a><a onclick=window.location.href="/goodsDetail?id=${goods.id}" class="tiaozhuan">返回</a></div>
    	<div class="shouye"><p>确认订单</p></div>
    </section>
	<div class="header home" onclick=window.location.href="address.html">
		<div class="ui-left"><img src="../../img/pay-1.png" alt=""></div>
		<div class="mes-right">
			<div class="mes-right-top">
				<dl>
					<dd>张淑敏</dd>
					<dt>电话:15994203504</dt>
				</dl>
			</div>
			<div class="mes-right-bottom">
				<p>广东省&nbsp;&nbsp;深圳&nbsp;&nbsp;宝安区</p>
				<p>桃源居商务大厦B座</p>
			</div>
		</div>
		<div class="jump-arrow"></div>
	</div>
	<div class="pay-for-baobei">
		<div class="baobei">
			<img src="../../img/main-new1.png" alt="">
		</div>
		<div class="intro">
			<p>H&M&nbsp;&nbsp;CARDIGAN</p>
			<p>尺寸&nbsp;:&nbsp;S</p>
		</div>
		<div class="price">
			<p>￥35.5</p>
		</div>
	</div>
	<div class="lists">
		<ul>
			<li>共计1件商品&nbsp;小计：<b>￥35.5</b></li>
			<li><span>快递费</span> <span><b>￥20</b></span></li>
		</ul>
	</div>
	<div class="notes">
		<div class="notes-tit">备注</div>
		<div class="text">
			<textarea name="" id="" cols="30" rows="10"></textarea>
		</div>
	</div>
	<div class="clear"></div>
	<div class="up-to-pay">
		<ul>
			<li>总计&nbsp;:&nbsp;<b>￥55.5</b></li>
			<li onclick=window.location.href="">付款</li>
		</ul>
	</div>
</body>
</html>