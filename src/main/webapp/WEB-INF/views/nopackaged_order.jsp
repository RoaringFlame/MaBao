<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>我是买家</title>
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
        <header>
           待发货
            <!--操作按钮-->
           <div class="header-box">
                <a href="personal">
                  <p class="header-left">
                  <i class="icon icon-return"></i>
                   返回
                </p>
                </a>
           </div>
            <!--操作按钮 END-->
        </header>
         <!--标题 END-->
         <!-- 我是买家——购买订单 -->
        <div class="order"> 

          <!-- 购买订单 -->
            <c:forEach items="${}" var="goods">
                <div class="order-box" onclick=window.location.href="/goods/goodsDetail？goodsId=${goods.id}">
                    <p class="unpaid-txt">买家已付款</p>
                    <img src="${goods.picture}" alt="宝物">
                    <div class="order-box-right">
                        <p>${goods.brand}</p>
                        <p>${goods.size}/p>
                        <p class="order-box-left">￥${goods.price}</p>
                    </div>
                </div>
            </c:forEach>
          <!-- 购买订单END -->
          <!-- 共计 -->
            <div class="order-bottom">
                <p>共计${}件商品 小计：<span>${}</span> (含运费￥${})</p>
            </div>
           <!-- 共计END -->
        </div>
         <!-- 我是买家-购买订单END -->
    </div>
</body>
</html>