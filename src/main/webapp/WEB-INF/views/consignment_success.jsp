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
	<title>寄售成功</title>
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
			<a href="sell/releaseSelector">
				<button class="header-left">
					<i class="icon icon-return"></i>
					返回
				</button>
			</a>
		</div>
		<!--操作按钮 END-->
	</header>
	<!--标题 END-->
	<!--发布成功提示-->
	<div class="publish-success-box">
		<p>您的寄售已经提交！</p>
		<p>请您收拾好想要寄售的物品</p>
		<p>两个工作日内，我们会安排快递公司上门取件</p>
		<p>请保持电话畅通哦～</p>
		<a href="" class="share-bottom">
			<button>去逛逛</button>
		</a>
		<!--发布成功提示END-->
	</div>
</div>
</body>
</html>