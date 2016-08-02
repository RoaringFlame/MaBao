<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/" + "MaBao/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
    <title>待上架商品</title>
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
           待发布
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
         
        <div class="order">
            <c:forEach var="goods" items="${goodsList}">
         <!-- 未发布商品 -->
                <div class="order-box">
                    <p class="unpaid-txt">${goods.state}</p>
                    <img src="upload/${goods.picture}" alt="宝物">
                    <div class="order-box-right">
                        <p>${goods.brandName}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                ${goods.title}</p>
                        <p>尺寸：${goods.size}</p>
                        <p class="order-box-left">￥${goods.price}</p>
                        <p class="order-box-left">扣除佣金可得：￥${goods.price - 3.00}</p>
                    </div>
                </div>
            <!-- 未发布商品END -->
            </c:forEach>
        </div>

    </div>

</body>
</html>