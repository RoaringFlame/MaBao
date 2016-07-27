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
	<title>个人中心</title>
	<meta name="viewport"
		  content="maximum-scale=1.0,minimum-scale=1.0,user-scalable=no,width=device-width,initial-scale=1.0"/>
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
	<%--<header>--%>
		<%--个人中心--%>
		<%--<!--操作按钮-->--%>
		<%--<div class="header-box">--%>
			<%--<a href="">--%>
				<%--<p class="header-left">--%>
					<%--<i class="icon icon-return"></i>--%>
					<%--返回--%>
				<%--</p>--%>
			<%--</a>--%>
		<%--</div>--%>
		<%--<!--操作按钮 END-->--%>
	<%--</header>--%>
	<!--标题 END-->
	<!--宝宝图片上传-->
	<div class="baby-photo">
		<figure><img src="photo/${userInfo.userPicture}" alt="头像"></figure>
		<figcaption>
			<p>${userInfo.userName}</p>
			<p class="line">宝宝：${userInfo.babyName}</p>
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
				<li><a class="link" href="developing">全部</a></li>
				<li><a href="developing">待付款</a></li>
				<li><a href="developing">待发货</a></li>
				<li><a href="developing">待确认</a></li>
			</ul>
		</div>
		<!--我是买家订单END-->
		<!--我是买家订单-->
		<div>
			<p class="order-bottom">我是<span class="blue">卖家</span></p>
			<ul>
				<li><a class="link" href="developing">全部</a></li>
				<li><a href="developing">已出售</a></li>
				<li><a href="developing">已发布</a></li>
				<li><a href="developing">待发布</a></li>
			</ul>
		</div>
		<!--我是买家订单END-->
		<!--个人中心操作-->
		<div class="personal-center-control">
			<a href="user/changepwd"><p>修改密码</p></a>
			<a><p>绑定微信（调用微信接口）</p></a>
			<a href="user/address/userAllAddress"><p>收货地址</p></a>
			<a href="user/baby/allBabyInfo?babyId=${userInfo.babyId}"><p>宝宝信息</p></a>
			<a><p>绑定手机</p></a>
		</div>
		<!--个人中心操作END-->
	</div>
	<!--个人中心信息END-->
	<!--注销按钮-->
	<a class="button-bottom" href="logout">
		<button class="submit" type="reset">注销</button>
	</a>
	<div class="blank"></div>
	<!--注销按钮END-->
	<!--底部导航-->
	<%--<div class="menu" id="menu">--%>
		<%--<a href="">--%>
			<%--<i class="icon-menu icon-menu1"><img src="img/footer-1.png" alt=""></i>--%>
		<%--</a>--%>
		<%--<a href="developing">--%>
			<%--<i class="icon-menu icon-menu2"><img src="img/footer-2.png" alt=""></i>--%>
		<%--</a>--%>
		<%--<a href="consignment">--%>
			<%--<i class="icon-menu icon-menu3"><img src="img/footer-3.png" alt=""></i>--%>
		<%--</a>--%>
		<%--<a href="user/shopping" >--%>
			<%--<i class="icon-menu icon-menu4"><img src="img/footer-4.png" alt=""></i>--%>
		<%--</a>--%>
		<%--<a href="user">--%>
			<%--<i class="icon-menu icon-menu5"><img src="img/footer-c5.png" alt=""></i>--%>
		<%--</a>--%>
	<%--</div>--%>
	<!--底部导航 END-->
</div>
</body>
</html>