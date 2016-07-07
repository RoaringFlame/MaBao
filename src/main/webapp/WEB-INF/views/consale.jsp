<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>寄售：增加售货地址</title>
	<meta name="viewport" content="maximum-scale=1.0,minimum-scale=1.0,user-scalable=no,width=device-width,initial-scale=1.0"/>
	<!-- 禁止将数字变为电话号码 -->
	<meta name="format-detection" content="telephone=no" />
	<!-- iphone设备中的safari私有meta标签,允许全屏模式浏览，隐藏浏览器导航栏 -->
	<meta name="apple-mobile-web-app-capable" content="yes" />
	<!-- iphone的私有标签,它指定的iphone中safari顶端的状态条的样式 -->
	<meta name="apple-mobile-web-app-status-bar-style" content="black">

	<link rel="stylesheet" href="../../css/public.css">
	<link rel="stylesheet" href="../../css/buy.css">
</head>
<body>
	<section class="header-top">
    	<div class="fanhui"><a href="pay.jsp" ><img src="../../img/back.png" alt=""></a>
			<a href="pay.jsp" class="tiaozhuan">返回</a></div>
    	<div class="shouye"><p>增加售货地址</p></div>
    </section>
    <section class="container">
    	<p class="p-tit">请填写您的地址及电话，我们会安排上门收货</p>
    	<section class="msg-sale">
			<!--通过form表单将前台数据传到后台-->
			<form method="post">
    		<input type="text" placeholder="收件人" name="recipients">
    		<input type="text" maxlength="11" placeholder="手机号" name="tel">
    		<input type="text" placeholder="所在地" name="location">
    		<input type="text" placeholder="详细地址" name="address">
			</form>
    	</section>
    	<section class="server">
    		<div class="server-c">
                <p style="text-align: center;">寄售服务条款</p>
                <p style="text-indent:1.5rem;">哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈
					哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈</p>
            </div>
    		<p style="text-align: center;"><input type="checkbox" checked="true"><span class="agree">我同意寄售服务条款</span></p>
    	</section>
        <div class="clear"></div>
    	<section class="up">
    		<input type="button" value="提交" onclick="window.location.href='/sell/receiptPlaceAdd'">
    	</section>
    </section>
</body>
</html>