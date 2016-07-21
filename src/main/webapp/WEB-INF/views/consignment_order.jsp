<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>寄售订单</title>
    <meta name="viewport"
          content="maximum-scale=1.0,minimum-scale=1.0,user-scalable=no,width=device-width,initial-scale=1.0"/>
    <!-- 禁止将数字变为电话号码 -->
    <meta name="format-detection" content="telephone=no"/>
    <!-- iphone设备中的safari私有meta标签,允许全屏模式浏览，隐藏浏览器导航栏 -->
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <!-- iphone的私有标签,它指定的iphone中safari顶端的状态条的样式 -->
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <!--     <script type="text/javascript" src="js/jquery.1.10.2.js"></script> -->
    <link rel="stylesheet" href="css/master.css">
    <link rel="stylesheet" href="css/module.css">
</head>

<body>
    <div class="content-index">
        <!--标题-->
        <header>
           寄售订单
            <!--操作按钮-->
           <div class="header-box">
                <a href="user">
                  <p class="header-left">
                  <i class="icon icon-return"></i>
                   返回
                </p>
                </a>
           </div>
            <!--操作按钮 END-->
        </header>
         <!--标题 END-->
        <!-- 我是卖家——寄售订单 -->
        <div class="order"> 

          <!-- 寄售订单 -->
            <c:forEach var="goods" items="${allOrder}">
                <div class="order-box" onclick=window.location.href="/goods/goodsDetail？goodsId=${goods.id}">
                    <p class="unpaid-txt">交易完成</p>
                    <img src="${goods.picture}" alt="宝物">
                    <div class="order-box-right">
                        <p>${goods.brand}</p>
                        <p>尺寸：${goods.size}</p>
                        <p class="order-box-left">出售价格：${goods.price}</p>
                        <p class="order-box-left">扣除佣金可得：￥${goods.realprice}</p>
                    </div>
                </div>
            </c:forEach>
          <!-- 寄售订单END -->

          <!-- 共计 -->
            <div class="order-bottom">
                <p>共计${goodsNum}件商品 小计：<span>${totalSum}</span> (含运费￥${totalFreight})</p>
            </div>
           <!-- 共计END -->
        </div>
         <!-- 我是买家-寄售订单END -->
    </div>

</body>
</html>