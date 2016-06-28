<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>首页</title>
    <meta name="viewport" content="maximum-scale=1.0,minimum-scale=1.0,user-scalable=no,width=device-width,initial-scale=1.0"/>
    <!-- 禁止将数字变为电话号码 -->
    <meta name="format-detection" content="telephone=no" />
    <!-- iphone设备中的safari私有meta标签,允许全屏模式浏览，隐藏浏览器导航栏 -->
    <meta name="apple-mobile-web-app-capable" content="yes" />
    <!-- iphone的私有标签,它指定的iphone中safari顶端的状态条的样式 -->
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
    <link rel="stylesheet" href="css/index.css">
    <link rel="stylesheet" href="css/public.css">
</head>
<body>
<section class="header-top">
    <div class="fanhui"><a href="login.html" ><img src="img/back.png" alt=""></a><a href="login.html" class="tiaozhuan">返回</a></div>
    <div class="shouye"><p>首页</p></div>
</section>
<header id="header" class="home">
    <figure class="home-i" id="home-i">
        <img src="img/menu.png" alt="">
    </figure>
    <input type="text" name="search" id="search" class="search">
</header>
<section class="classify" id="classify">
    <ul>
        <li><a href="">婴儿车</a></li>
        <li><a href="">安全座椅</a></li>
        <li><a href="">玩具</a></li>
        <li><a href="">家具家电</a></li>
        <li><a href="">服饰鞋帽</a></li>
        <li><a href="">图片绘本</a></li>
        <li><a href="">其它产品</a></li>
    </ul>
</section>
<section class="slider" id="slider">
    <ul>
        <li><a href=""><img src="img/img-01.png" alt=""></a></li>
        <li><a href=""><img src="img/detail.jpg" alt=""></a></li>
        <li><a href=""><img src="img/img-01.png" alt=""></a></li>
        <li><a href=""><img src="img/detail.jpg" alt=""></a></li>
    </ul>
    <ul id="position">
        <li class="cur"></li>
        <li></li>
        <li></li>
        <li></li>
    </ul>
</section>
<section class="main" id="main">
    <figure class="title" id="title">
        <ul>
            <li class="active"><a href="javascript:;">新品</a></li>
            <li><a href="javascript:;">猜你喜欢</a></li>
        </ul>
    </figure>
    <section class="main-cons">
        <c:forEach var="goods" items="${newGoods}">
            <figure>
                <img src="upload/${goods.picture}" alt="">
                <figcaption>
                    <p><span>￥${goods.price/100}</span><span>${goods.newDegree}</span></p>
                    <p>${goods.brand}&nbsp;${goods.title}</p>
                </figcaption>
            </figure>
        </c:forEach>
    </section>
    <section class="main-cons" style="display: none;">
        <figure>
            <img src="img/main-like1.png" alt="">
            <figcaption>
                <p><span>￥29.00</span><span>九成新</span></p>
                <p>H&M&nbsp;CARDIGN</p>
            </figcaption>
        </figure>
        <figure>
            <img src="img/main-like1.png" alt="">
            <figcaption>
                <p><span>￥29.00</span><span>九成新</span></p>
                <p>H&M&nbsp;CARDIGN</p>
            </figcaption>
        </figure>
        <figure>
            <img src="img/main-like1.png"alt="">
            <figcaption>
                <p><span>￥29.00</span><span>九成新</span></p>
                <p>H&M&nbsp;CARDIGN</p>
            </figcaption>
        </figure>
        <figure>
            <img src="img/main-like1.png" alt="">
            <figcaption>
                <p><span>￥29.00</span><span>九成新</span></p>
                <p>H&M&nbsp;CARDIGN</p>
            </figcaption>
        </figure>
    </section>
</section>
<section class="clear"></section>
<div class="menu">
    <a class="active"  href="index.html">
        <i class="icon-menu icon-menu1"></i>
    </a>
    <a>
        <i class="icon-menu icon-menu2"></i>
    </a>
    <a  href="consignment.html">
        <i class="icon-menu icon-menu3"></i>
    </a>
    <a  href="shopping.html">
        <i class="icon-menu icon-menu4"></i>
    </a>
    <a  href="personal.html">
        <i class="icon-menu icon-menu5"></i>
    </a>
</div>
</body>
</html>
