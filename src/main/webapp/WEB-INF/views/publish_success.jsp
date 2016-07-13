<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0"/>
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
		发布成功
		<!--操作按钮-->
		<div class="header-box">
			<a href="/jsp/selfup">
				<button class="header-left">
					<i class="icon icon-return"></i>
					返回
				</button>
			</a>
		</div>
		<!--操作按钮 END-->
	</header>
	<!--标题 END-->
	<section class="message1">
		<p>恭喜您发布成功！</p>
	</section>
	<section class="message2">
		<p>感谢您支持低碳生活</p>
		<p>给了每一件宝物第二次生命</p>
	</section>
	<section class="message3">
		<p>您可以在个人账户中查询详情及交易进度</p>
	</section>
	<section class="share">
		<input type="button" name="goShare" id="goShare" value="分享到朋友圈" onclick=window.location.href="index.html">
	</section>
	</div>
</body>
</html>