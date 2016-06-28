<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="service.GoodsService" %>
<%@ page import="pojo.Goods" %>
<%@ page import="pojo.Address" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

	<link rel="stylesheet" href="css/buy.css">
	<link rel="stylesheet" href="css/public.css">
</head>
<body>
<%
	String id=request.getParameter("id");
	GoodsService gs=new GoodsService();
	Goods goods=gs.findById(Integer.parseInt(id));
 %>
 	<section class="header-top">
    	<div class="fanhui"><a href="javascript:;" onclick="location.href='javascript:history.go(-1);'"><img src="img/back.png" alt=""></a><a href="javascript:;" onclick="location.href='javascript:history.go(-1);'" class="tiaozhuan">返回</a></div>
    	<div class="shouye"><p>确认订单</p></div>
    </section>
	<div class="header home" onclick=window.location.href="http://localhost:8080/mb/AddressServlet?method=findAddress">
		<div class="ui-left"><img src="img/pay-1.png" alt=""></div>
		<c:forEach var="addr" items="${LoginAddr}" begin="0" end="0">
		<div class="mes-right">
			<div class="mes-right-top">
				<dl>
					<dd>收件人:${LoginAddr.get(0).getRecipients()}</dd>
					<dt>电话:${LoginAddr.get(0).getTel()}</dt>
				</dl>
			</div>
			<div class="mes-right-bottom">
				<p>收件地址:${LoginAddr.get(0).getAddress()} </p>
				<p></p>
			</div>
		</div>
		</c:forEach>
		<div class="jump-arrow"></div>
	</div>
	<div class="pay-for-baobei">
		<div class="baobei">
			<img src="<%=goods.getBrand() %>" alt="">
		</div>
		<div class="intro">
			<p><%=goods.getGoodsBrand() %>&nbsp;&nbsp;CARDIGAN</p>
			<p>尺寸&nbsp;:&nbsp;<%=goods.getGoodsSize() %></p>
		</div>
		<div class="price">
			<p>￥<%=goods.getPrice() %></p>
		</div>
	</div>
	<div class="lists">
		<ul>
			<li>共计1件商品&nbsp;小计：<b>￥<%=goods.getPrice() %></b></li>
			<li><span>快递费</span> <span><b>￥10</b></span></li>
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
			<li>总计&nbsp;:&nbsp;<b>￥<%=goods.getPrice()+10 %></b></li>
			<li onclick=window.location.href="http://localhost:8080/mb/OrderServlet?method=saveToOrderSingle&id="+<%=id%>>付款</li>
		</ul>
	</div>
</body>
</html>