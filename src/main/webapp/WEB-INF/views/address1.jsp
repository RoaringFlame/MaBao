<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>选择收货地址</title>
    <meta name="viewport"
          content="maximum-scale=1.0,minimum-scale=1.0,user-scalable=no,width=device-width,initial-scale=1.0"/>
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
        选择收货地址
        <!--操作按钮-->
        <div class="header-box">
            <a href="../../static/pay.html">
                <button class="header-left">
                    <i class="icon icon-return"></i>
                    返回
                </button>
            </a>
        </div>
        <!--操作按钮 END-->
    </header>
    <!--标题 END-->

    <!-- 收货地址 -->
    <div class="box-add">
        <c:forEach items="addressList" var="address">
            <div class="box-left">
                <img src="../../img/pay-1.png" alt="">         <!--用户头像-->
            </div>
            <div class="box-right">
                <div class="box-right-top">
                    <dl>
                        <dd>${address.recipients}</dd>
                        <dt>电话:${address.tel}</dt>
                    </dl>
                </div>
                <div class="box-right-bottom">
                   <%-- <p>广东省&nbsp;&nbsp;深圳&nbsp;&nbsp;宝安区</p>--%>
                    <p>${address.area}</p>
                    <!--详细地址信息-->
                    <p>${address.location}</p>
                </div>
            </div>
            <a href="/user/address/updateAddress">
                <button class="add-jump-arrow"></button>
            </a>
            </c:forEach>
    </div>
    <!-- 收货地址 END-->

    <!-- 新增收货地址按钮 -->
    <a class="input-add" href="/user/address/addAddress">
        <%--<button type="submit">新增收货地址</button>--%>
        新增收货地址
    </a>

    <!-- 新增收货地址按钮END -->
</div>
</body>
</html>