<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>宝物详情</title>
	<meta name="viewport" content="maximum-scale=1.0,minimum-scale=1.0,user-scalable=no,width=device-width,initial-scale=1.0"/>
	<!-- 禁止将数字变为电话号码 -->
	<meta name="format-detection" content="telephone=no" />
	<!-- iphone设备中的safari私有meta标签,允许全屏模式浏览，隐藏浏览器导航栏 -->
	<meta name="apple-mobile-web-app-capable" content="yes" />
	<!-- iphone的私有标签,它指定的iphone中safari顶端的状态条的样式 -->
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<script type="text/javascript" src="/resources/js/jquery-1.8.3.min.js"></script>
	<link rel="stylesheet" href="/resources/css/public.css">
	<link rel="stylesheet" href="/resources/css/buy.css">
		
</head>
<body>
	<section class="header-top">
    	<div class="fanhui"><a href="index.jsp" ><img src="/resources/img/back.png" alt=""></a><a href="index.jsp" class="tiaozhuan">返回</a></div>
    	<div class="shouye"><p>宝物详情</p></div>
    </section>

	<div class="baobei-img" id="baby-img">
		<figure>
			<img src="/resources/upload/<c:out value="${goods.picture}" />" alt="">
			<figcaption>
				<p></p>
				<p><span></span><span><i>原价：</i>
					<i>￥<fmt:formatNumber type="number" value="${goods.price/100}" pattern="0.00" maxFractionDigits="2"/>
				</i></span> </p>
			</figcaption>
		</figure>
	</div>
	<div class="baobei-intro" id="baby-intro">
		<div class="baobei-intro-p p-1"><div>宝物类型&nbsp;:</div><div><c:out value="${goods.typeName}" /></div></div>
		<div class="baobei-intro-p p-2"><div>宝物品牌&nbsp;:</div><div><c:out value="${goods.brand}" /></div></div>
		<div class="baobei-intro-p p-3"><div>购买日期&nbsp;:</div><div>
			<fmt:formatDate value="${goods.upTime}" type="date" pattern="yyyy/MM/dd" /></div><div>
			新旧程度&nbsp;:</div><div><c:out value="${goods.newDegree>0?goods.newDegree+'成':'全新'}" /></div></div>
		<div class="baobei-intro-p p-4"><div> 宝物尺码&nbsp;:</div><div><c:out value="${goods.size}" /><div></div>
			包装&nbsp;：</div><div><c:out value="${goods.pack?'有':'无'}" /></div><div>
			小票&nbsp;：</div><div><c:out value="${goods.receipt?'有':'无'}"/></div></div>
		<div class="baobei-intro-p p-5"><div>卖家分享&nbsp;:</div><div><c:out value="${goods.message}" /></div></div>
	    <div class="baobei-intro-p p-6"><div>宝物图片&nbsp;:</div><div><img src="/resources/upload/detail.png" alt=""></div></div>
	</div>
	
	<section class="operate">
     	<div>
     		<input type="button" name="button" class="button-left" id="toShop" value="加入购物车">
	    	<input type="button" name="button" class="button-right" id="toPay" value="立即购买">
    	</div>
		<input type="button" name="button" class="button" value="我要转让" onclick=location.href="consignment.html">
	</section>
	<!--  <script type="text/javascript">
		 $(function () {
		 	var goodID=switchNum(window.location.search);
		 	function switchNum(str){
			 	return parseInt(str.replace(/[^0-9]/ig, "")); 				
		 	}
		 	console.log(goodID);
		 	// $.post("请求页面",{id:goodID},function(data,status){return data;});
		 });
	</script>
	<script type="text/javascript" src="js/detail.js"></script>-->
	<script type="text/javascript">
       $("#toShop").click(function(){
         window.location.href="http://localhost:8080/mb/ShoppingServlet?method=saveToShop&id="+<c:out value="${goods.id}" />;
  		})
  	   $("#toPay").click(function(){
         window.location.href="http://localhost:8080/mb/pay.jsp?id="+<c:out value="${goods.id}" />;
  		})
    </script>

</body>
</html>