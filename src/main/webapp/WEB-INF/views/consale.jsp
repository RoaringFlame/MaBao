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
	<!-- 编辑收货地址 -->
	<form action="/sell/receiptPlaceAdd" method="post" modelAttribute="address">
		<div class="edit-add-box">
			<p class="p-tit">请填写您的地址及电话，我们会安排上门收货</p>
			<label>
				<input path="recipients" type="text" placeholder="收件人：">
			</label>
			<label>
				<input path="tel" type="text" placeholder="手机号：">
			</label>
			<label>
				<input path="area" type="text" placeholder="所在地：">
			</label>
			<!-- 省市级联地址插件 -->
			<div id="test"></div>
			<!-- 省市级联地址插件END -->
			<label>
				<input path="location" type="text" class="write" placeholder="详细地址：">
			</label>
			<div class="clear"></div>
		</div>
		<!-- 清楚浮动 -->
		<!--服务条款-->
		<label class="terms">
            <textarea name="terms" cols="30" rows="10">
服务条款
            </textarea>
		</label>
		<!-- 清楚浮动 -->
		<div class="clear"></div>
		<label class="terms">
			<input type="checkbox" checked="checked">
			<span class="agree">我同意寄售服务条款</span>
		</label>
		<!--服务条款END-->
		<div class="edit-add-input ">
			<!-- 保存按钮 -->
			<label>
				<input class="disabled" type="submit" value="提交" >
			</label>
			<!-- 保存按钮END -->
		</div>
	</form>
	<!-- 编辑收货地址END -->
</div>
</body>
</html>

<script src="../../script/lib/jquery.1.10.2.js" type="text/javascript"></script>
<script src="../../script/lib/jquery.provincesCity.js" type="text/javascript"></script>
<script src="../../script/lib/provinces-data.js" type="text/javascript"></script>
<script src="../../script/lib/bootstrap/bootstrap.min.js"></script>