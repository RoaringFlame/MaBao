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
    <title>支付订单</title>
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
        <%--支付订单--%>
        <%--<!--操作按钮-->--%>
        <%--<div class="header-box">--%>
            <%--<a href="personal.html">--%>
                <%--<p class="header-left">--%>
                    <%--<i class="icon icon-return"></i>--%>
                    <%--返回--%>
                <%--</p>--%>
            <%--</a>--%>
        <%--</div>--%>
        <%--<!--操作按钮 END-->--%>
    <%--</header>--%>
    <!--标题 END-->
    <!-- 支付订单 -->
    <form action="" class="pay-box">
        <p class="pay-top"><img src="img/pay3.jpg" alt="">
            <span>微信支付</span>
            <label class="checked-active">
                <input type="radio" checked>
            </label>
        </p>
        <p class="pay-top pay-top-last"><img src="img/pay4.png" alt="">
            <span>支付宝支付</span>
            <label>
                <input type="radio">
            </label>
        </p>
        <div class="blank"></div>
        <a class="button-bottom" href="login.html">
            <button class="submit" type="reset">支付</button>
        </a>

    </form>
    <!-- 支付订单END -->
</div>
</body>
</html>