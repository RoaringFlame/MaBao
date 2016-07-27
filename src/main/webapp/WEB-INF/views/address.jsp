<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <base href="<%=basePath%>">

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

    <link rel="stylesheet" href="css/master.css">
    <link rel="stylesheet" href="css/module.css">
</head>
<body>
<div class="content-index">
    <!--标题-->
    <%--<header>--%>
    <%--选择收货地址--%>
    <%--<!--操作按钮-->--%>
    <%--<div class="header-box">--%>
    <%--<a href="user">--%>
    <%--<p class="header-left">--%>
    <%--<i class="icon icon-return"></i>--%>
    <%--返回--%>
    <%--</p>--%>
    <%--</a>--%>
    <%--</div>--%>
    <%--<!--操作按钮 END-->--%>
    <%--</header>--%>
    <!--标题 END-->

    <!-- 收货地址 -->

    <c:forEach var="address" items="${addressList}">
    <div class="box add">
        <div class="box-left">
            <img src="img/pay-1.png" alt="">
        </div>

        <div class="box-right">
            <div class="box-right-top">
                <dl>
                    <dd>${address.recipients}</dd>
                    <dt>电话:${address.tel}</dt>
                </dl>
            </div>
            <div class="box-right-bottom">
                <p>${address.area.mergerName}</p>
                <p>${address.location}</p>
            </div>
        </div>
        <a href="user/address/getAddress?addressId=${address.id}">
            <button class="add-jump-arrow"></button>
        </a>
        <div class="clear"></div>
        <div class="addressId" style="display: none">${address.id}</div>
        <p class="default-add">
            <input name="defaultAddress" type="radio" ${address.state ? "checked = 'checked '": '' }><span>设为默认地址</span>
            <i class="icon-trash"></i>
            <a href="user/address/deleteAddress?addressId=${address.id}">
                <button>删除</button>
            </a>
        </p>
    </div>
</div>
</c:forEach>
<!-- 收货地址 END-->
<!-- 新增收货地址按钮 -->
<div class="address-bottom">
    <a href="user/new_address" class="button-bottom pay-fixed">
        <input class="submit " type="submit" value="新增收货地址">
    </a>
</div>
<!-- 新增收货地址按钮END -->


</div>
</body>
</html>
<script src="script/lib/jquery.1.10.2.js" type="text/javascript"></script>
<script src="script/address.js"></script>
<script src="script/common.js"></script>