<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>个人中心</title>
	<meta name="viewport" content="maximum-scale=1.0,minimum-scale=1.0,user-scalable=no,width=device-width,initial-scale=1.0"/>
	<!-- 禁止将数字变为电话号码 -->
	<meta name="format-detection" content="telephone=no" />
	<!-- iphone设备中的safari私有meta标签,允许全屏模式浏览，隐藏浏览器导航栏 -->
	<meta name="apple-mobile-web-app-capable" content="yes" />
	<!-- iphone的私有标签,它指定的iphone中safari顶端的状态条的样式 -->
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
	<link rel="stylesheet" href="css/index.css">
	<link rel="stylesheet" href="css/personal.css">
	<link rel="stylesheet" href="css/public.css">
</head>
<body>
	<section class="header-top">
    	<div class="fanhui"><a href="javascript:;" onclick="location.href='javascript:history.go(-1);'"><img src="img/back.png" alt=""></a><a href="javascript:;" onclick="location.href='javascript:history.go(-1);'" class="tiaozhuan">返回</a></div>
    	<div class="shouye"><p>个人中心</p></div>
    </section>
	<div class="message">
		<figure><img src="img\u6.JPG" alt="头像" onclick=$("#pictrue").click()></figure>
		<input type="file" id="pictrue" style="display:none">
		<figcaption>
			<p>当前用户： ${loginUser.userName}</p>
			<p class="line">宝宝：${Baby.getBabyName()}</p>
		</figcaption>
	</div>
	<div class="main-i">
		    <p class="top">我的订单：</p>
		    <div class="a">
		    	<p class="left">我是<span>买家</span></p>
		        <p class="right">我是<span>卖家</span></p>
		    </div>

		    <div class="order">
				<ul>
					<li class="link"><a href="order.html" style="border: none">全部</a></li>
					<li class="link"><a href="order.html">待发货</a></li>
					<li class="link"><a href="order.html">待确认</a></li>
					<li class="link"><a href="order2.html">全部</a></li>
					<li class="link"><a href="order2.html">已发布</a></li>
					<li class="link"><a href="order2.html">待发布</a></li>
	            </ul>
	            <div class="order-i">
					<a href="changepwd.jsp"><p>修改密码</p></a>
					<a href="javascript:;"><p>绑定微信（调用微信接口）</p></a>
					<a href="http://localhost:8080/mb/AddressServlet?method=findAddress"><p>收货地址</p></a>
					<a href="http://localhost:8080/mb/BabyServlet?method=findBaby"><p>宝宝信息</p></a>
					<a href="bindphone.html"><p>绑定手机</p></a>
				</div>
		    </div>
	</div>
    <div class="bottom"><p onclick=window.location.href="http://localhost:8080/mb/LoginOutServlet">注销</p></div>
	<section class="clear"></section>
	<div class="menu">
            <a class="active"  href="index.jsp">
                <i class="icon-menu icon-menu1"><img src="img/footer-1.png" alt=""></i>
            </a>
            <a>
                <i class="icon-menu icon-menu2"><img src="img/footer-2.png" alt=""></i>
            </a>
            <a  href="consignment.html">
                <i class="icon-menu icon-menu3"><img src="img/footer-3.png" alt=""></i>
            </a>
            <a  href="shopping.html">
                <i class="icon-menu icon-menu4"><img src="img/footer-4.png" alt=""></i>
            </a>
            <a  href="personal.jsp">
                <i class="icon-menu icon-menu5"><img src="img/footer-c5.png" alt=""></i>
            </a>
    </div>
<!--     <script type="text/javascript">
    	$(function(){
    		$(".icon-menu1").parent().removeClass("active");
    		$(".icon-menu5").parent().addClass("active");
    	})
    </script> -->
</body>
</html>