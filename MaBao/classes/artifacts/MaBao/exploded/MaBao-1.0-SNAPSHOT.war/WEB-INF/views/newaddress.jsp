<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>新增地址</title>
	<meta name="viewport" content="maximum-scale=1.0,minimum-scale=1.0,user-scalable=no,width=device-width,initial-scale=1.0"/>
	<!-- 禁止将数字变为电话号码 -->
	<meta name="format-detection" content="telephone=no" />
	<!-- iphone设备中的safari私有meta标签,允许全屏模式浏览，隐藏浏览器导航栏 -->
	<meta name="apple-mobile-web-app-capable" content="yes" />
	<!-- iphone的私有标签,它指定的iphone中safari顶端的状态条的样式 -->
	<meta name="apple-mobile-web-app-status-bar-style" content="black">

	<link rel="stylesheet" href="css/buy.css">
	<link rel="stylesheet" href="css/public.css">

	  <script src="js/jquery-1[1].2.6.js" type="text/javascript"></script>
	  <script src="js/jquery.provincesCity.js" type="text/javascript"></script>
	  <script src="js/provincesdata.js" type="text/javascript"></script>
	  <script>
		//调用插件
		$(function(){
			$("#test").ProvinceCity();
		});
	  </script>
</head>
<body>
 	<section class="header-top">
    	<div class="fanhui"><a href="address.jsp" ><img src="img/back.png" alt=""></a><a href="address.jsp" class="tiaozhuan">返回</a></div>
    	<div class="shouye"><p>新增地址</p></div>
    </section>
	<form class="mesgbox1" method="post" action="http://localhost:8080/mb/AddressServlet?method=save">
		<input type="text" placeholder="收件人" name="recipients">
		<input type="phone" placeholder="手机号" name="tel">
		<input type="text" placeholder="所在地" >
		<div id="test" ></div>
		<textarea name="detail" id="" placeholder="详细地址" name="detail"></textarea>
		
		<div class="foot-input1">
			<input type="submit" value="提交" >
		</div>
	</form>
</body>
</html>