<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/"+"MaBao/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <base href="<%=basePath%>">
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
    <script src="script/lib/jquery.1.10.2.js"></script>
    <script src="script/order.js"></script>
    <script src="script/common.js"></script>
</head>

<body>
<div class="content-index">
    <!--标题-->
    <%--<header>--%>
        <%--待付款--%>
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
    <!-- 我是买家——购买订单 -->
    <div class="order">

        <!-- 购买订单 -->
        <c:forEach items="${allOrder}" var="goods">
            <div class="order-box">
                <div class="goodsId" style="display: none;">${goods.goodsId}</div>
                <p class="unpaid-txt">${goods.state.getText()}</p>
                <img src="upload/${goods.picture}" alt="宝物">
                <div class="order-box-right">
                    <p>${goods.brand}</p>
                    <p>${goods.size}/p>
                    <p class="order-box-left">￥${goods.unitCost}</p>
                </div>
            </div>
        </c:forEach>
        <!-- 购买订单END -->
        <!-- 共计 -->
        <div class="order-bottom">
            <p>共计${goodsNum}件商品 小计：<span>${totalSum}</span> (含运费￥${totalFreight})</p>
        </div>
        <!-- 共计END -->
        <!-- 确认收货按钮 -->
        <button type="submit" value="确认收货">确认收货</button>
        <!-- 确认收货按钮END -->
    </div>
    <!-- 我是买家-购买订单END -->
</div>

</body>
</html>