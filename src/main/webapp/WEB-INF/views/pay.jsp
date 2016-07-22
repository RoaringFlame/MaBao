<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html lang="en">
<head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
    <title>付款</title>
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
    <script src="script/lib/jquery.1.10.2.js"></script>
    <script src="script/common.js"></script>
    <script src="script/pay.js"></script>

</head>

<body>
<div class="content-index">
    <!--标题-->
    <header>
        确认订单
        <!--操作按钮-->
        <div class="header-box">
            <a href="user/shopping">
                <p class="header-left">
                    <i class="icon icon-return"></i>
                    返回
                </p>
            </a>
        </div>
        <!--操作按钮 END-->
    </header>
    <!--标题 END-->
    <!-- 收货地址 -->

    <a href="user/address/userAllAddress">
        <button class="add-jump-arrow"></button>
    </a>
    <form id="pay" action="order/payConfirm">
        <div class="box">
            <div class="box-left">
                <img src="img/pay-1.png" alt="">
            </div>
            <div class="box-right">
                <input name="addressId" style="display: none" value="${defaultAddress.id}">
                <div class="box-right-top">
                    <dl>
                        <dd>${defaultAddress.recipients}</dd>
                        <dt>${defaultAddress.tel}</dt>
                    </dl>
                </div>
                <div class="box-right-bottom">
                    <p>${defaultAddress.mergerName}</p>
                    <p>${defaultAddress.location}</p>
                </div>
            </div>
        </div>
        <!-- 收货地址 END-->
        <!-- 购买订单 -->
        <input name="cartIds" type="hidden" value="${cartIds}">
        <c:forEach var="goods" items="${checkedGoodsList}">
            <div class="order-box">
                <div class="goodsId" style="display: none">${goods.goodsId}</div>
                <img src="upload/${goods.picture}" alt="宝物">
                <div class="order-box-right">
                    <p>${goods.brandName}</p>
                    <p>尺寸：${goods.size}</p>
                    <p class="order-box-left"><span>×${goods.quantity}</span>￥${goods.price}</p>
                </div>
            </div>
            <!-- 购买订单END -->

            <ul class="lists">
                <li>共计${goods.quantity}件商品&nbsp;小计：<b>￥${goods.getSubtotal()}</b></li>
            </ul>
        </c:forEach>
        <ul class="lists">
            <li><span>快递费</span> <span><b>￥${freight}</b></span></li>
        </ul>
        <label class="notes">备注
            <textarea name="message" cols="30" rows="10"></textarea>
        </label>
    </form>
    <!--付款按钮-->
    <div class="up-to-pay pay-fixed">
        <ul>
            <li>总计&nbsp;:&nbsp;<b>￥${totalSum}</b></li>
            <li>
                <button class="pay" type="submit" form="pay">付款</button>
            </li>
        </ul>
    </div>
    <!--付款按钮END-->
    <div class="blank"></div>
    <div class="tip" id="textShow"></div>
</div>
</body>
</html>