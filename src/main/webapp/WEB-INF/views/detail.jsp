<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
    <title>宝物详情</title>
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
    <script src="script/detail.js"></script>
    <script src="script/common.js"></script>
</head>

<body>
<div class="content-index">
    <!--标题-->
    <%--<header>--%>
        <%--宝物详情--%>
        <%--<!--操作按钮-->--%>
        <%--<div class="header-box">--%>
            <%--<a href="">--%>
                <%--<p class="header-left">--%>
                    <%--<i class="icon icon-return"></i>--%>
                    <%--返回--%>
                <%--</p>--%>
            <%--</a>--%>
        <%--</div>--%>
        <div id="goodsId" style="display:none;">${goodsDetail.id}</div>
        <%--<!--操作按钮 END-->--%>
    <%--</header>--%>
    <!--标题 END-->
    <!--宝物详情-->
    <div class="goods-detail">
        <!--宝物图片-->
        <div class="goods-detail-top">
            <img src="upload/${goodsDetail.picture}" alt="">
            <div>
                <p>${goodsDetail.brandName}</p>
                <p>
                    <span>￥<fmt:formatNumber type="number" value="${goodsDetail.price}" pattern="0.00"
                                             maxFractionDigits="2"/></span>
                    <span>原价：￥<fmt:formatNumber type="number" value="${goodsDetail.oldPrice}" pattern="0.00"
                                               maxFractionDigits="2"/></span>
                </p>
            </div>
        </div>
        <!--宝物图片END-->
        <!--宝物信息-->
        <div class="goods-detail-content">
            <p>
                <span>宝物类型：</span>
                <span>${goodsDetail.typeName}</span>
            </p>
            <p>
                <span>宝物品牌：</span>
                <span>${goodsDetail.brandName}</span>
            </p>

            <p>
                <span>购物日期：</span>
                <span><fmt:formatDate value="${goodsDetail.upTime}" type="date" pattern="yyyy/MM/dd"/></span>
            </p>
            <p>
                <span>新旧程度：</span>
                <span>${goodsDetail.newDegree}</span>
            </p>
            <p>
                <span>宝物尺码：</span>
                <span>${goodsDetail.size}</span>
            </p>
            <p>
                <span>原包装：</span>
                <span>${goodsDetail.pack?'有':'无'}</span>
                <span>发票/小票：</span>
                <span>${goodsDetail.receipt?'有':'无'}</span>
            </p>
        </div>
        <!--宝物信息END-->
        <!--清楚浮动-->
        <div class="clear"></div>
        <!--买家分享-->
        <div class="goods-detail-bottom">
            <p>卖家分享：
                <span>${goodsDetail.message}</span>
            </p>
            <div class="clear"></div>
            <p>宝物图片:</p>
            <c:forEach items="${goodsDetail.pictureList}" var="goodsPicture">
                <img src="upload/${goodsPicture}" alt="图片正在加载中...">
            </c:forEach>
        </div>

        <!--卖家分享END-->
        <!--按钮-->
        <div class="goods-detail-button">
            <div>
                <a>
                    <button id="addToCarts">加入购物车</button>
                </a>
                <a>
                    <button id="buyNow">立即购买</button>
                </a>
            </div>
            <a href="consignment">
                <button class="button">我要转让</button>
            </a>
        </div>
        <!--按钮END-->
        <!--宝物详情END-->
    </div>
    <div class="tip" id="textShow"></div>
</div>
</body>
</html>