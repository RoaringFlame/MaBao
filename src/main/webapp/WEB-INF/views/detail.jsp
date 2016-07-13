<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
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
    <script type="text/javascript" src="../../script/lib/jquery.1.10.2.js"></script>
    <link rel="stylesheet" href="../../css/public.css">
    <link rel="stylesheet" href="../../css/buy.css">
</head>
<body>
<section class="header-top">

    <div class="back">
        <a onclick="window.location.href='/'"><img src="../../img/back.png" alt=""></a>
        <a onclick="window.location.href='/'" class="jump-to">返回</a>
    </div>
    <div class="title-bar">
        <p>宝物详情</p>
    </div>
</section>
<div class="baby-img" id="baby-img">
    <figure>
        <!--加载图片信息-->
        <img src="/upload/<c:out value="${goodsDetail.picture}" />" alt="">
        <figcaption>
            <p></p>
            <p><span></span><span><i>原价：</i>
                <i>￥<fmt:formatNumber type="number" value="${goodsDetail.price/100}"
                                      pattern="0.00" maxFractionDigits="2"/></i></span></p>
        </figcaption>
    </figure>
</div>
<div class="baby-intro" id="baby-intro">
    <div class="baby-intro-p p-1">
        <div>宝物类型&nbsp;:</div>
        <div><c:out value="${goodsDetail.typeName}" /></div>
    </div>
    <div class="baby-intro-p p-2">
        <div>宝物品牌&nbsp;:</div>
        <div><c:out value="${goodsDetail.brand}" /></div>
    </div>
    <div class="baby-intro-p p-3">
        <div>购买日期&nbsp;:</div>
        <div><fmt:formatDate value="${goodsDetail.upTime}" type="date" pattern="yyyy/MM/dd" /></div>
        <div>新旧程度&nbsp;:</div>
        <div><c:out value="${goodsDetail.newDegree>0?goodsDetail.newDegree+'成新':'全新'}" /></div>
    </div>
    <div class="baby-intro-p p-4">
        <div> 宝物尺码&nbsp;:</div>
        <div><c:out value="${goodsDetail.size}" /></div>
        <div>包装&nbsp;：</div>
        <div><c:out value="${goodsDetail.pack?'有':'无'}" /></div>
        <div>小票&nbsp;：</div>
        <div><c:out value="${goodsDetail.receipt?'有':'无'}"/></div>
    </div>
    <div class="baby-intro-p p-5">
        <div>卖家分享&nbsp;:</div>
        <div><c:out value="${goodsDetail.message}" /></div>
    </div>
    <div class="baby-intro-p p-6">
        <div>宝物图片&nbsp;:</div>
        <div>
            <img src="/upload/1.jpg" alt="">
        </div>
    </div>

    <section class="operate">
        <div>
            <a onclick="window.location.href='shopping.jsp'">
                <input type="button" name="button" class="button-left" value="加入购物车">
            </a>
            <a onclick="window.location.href='pay.jsp'">
                <input type="button" name="button" class="button-right" value="立即购买">
            </a>
        </div>
        <a onclick="window.location.href='consignment.jsp'">
            <input type="button" name="button" class="button" value="我要转让">
        </a>
    </section>
    </div>
</body>
</html>