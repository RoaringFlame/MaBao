<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>宝宝信息</title>
	<meta name="viewport" content="maximum-scale=1.0,minimum-scale=1.0,user-scalable=no,width=device-width,initial-scale=1.0"/>
	<!-- 禁止将数字变为电话号码 -->
	<meta name="format-detection" content="telephone=no" />
	<!-- iphone设备中的safari私有meta标签,允许全屏模式浏览，隐藏浏览器导航栏 -->
	<meta name="apple-mobile-web-app-capable" content="yes" />
	<!-- iphone的私有标签,它指定的iphone中safari顶端的状态条的样式 -->
	<meta name="apple-mobile-web-app-status-bar-style" content="black">

	<link rel="stylesheet" href="css/buy.css">
	<link rel="stylesheet" href="css/public.css">
</head>
<body>
 <section class="header-top">
    	<div class="fanhui"><a href="personal.jsp" ><img src="img/back.png" alt=""></a><a href="personal.jsp" class="tiaozhuan">返回</a></div>
    	<div class="shouye"><p>宝宝信息</p></div>
    </section>
     <c:forEach var="baby" items="${LoginBaby}">
	<div class="header home1">
		<div class="ui-left"><img src="img/pay-1.png" alt=""></div>
		<div class="mes-right" onclick=window.location.href="changemsg.jsp?id="+${baby.getId()}>
			<div class="mes-right-top">
				<dl>
					<dd>${baby.getBabyName()}</dd>
					<!-- <dt>电话:15994203504</dt> -->
				</dl>
			</div>
			<div class="mes-right-bottom">
				<p>${baby.getSex()}</p>
				<p>${baby.getBabybir().toString().substring(0,10)}</p>
			</div>
		</div>

		<div class="jump-arrow1" onclick=window.location.href="changemsg.jsp?id="+${baby.getId()}></div>
	</div>
	</c:forEach>
	
	<div class="clear"></div>
		<form method="" action="" class="input-add">
			<input type="button" value="新增宝宝信息" onclick=window.location.href="newmsg.jsp">
		</form>
</body>
</html>