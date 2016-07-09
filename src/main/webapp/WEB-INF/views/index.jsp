<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>首页</title>
    <meta name="viewport"
          content="maximum-scale=1.0,minimum-scale=1.0,user-scalable=no,width=device-width,initial-scale=1.0"/>
    <!-- 禁止将数字变为电话号码 -->
    <meta name="format-detection" content="telephone=no"/>
    <!-- iphone设备中的safari私有meta标签,允许全屏模式浏览，隐藏浏览器导航栏 -->
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <!-- iphone的私有标签,它指定的iphone中safari顶端的状态条的样式 -->
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <link rel="stylesheet" href="../../css/bootstrap.min.css">
    <link rel="stylesheet" href="../../css/scrollbar.css">
    <link rel="stylesheet" href="../../css/public.css">
    <link rel="stylesheet" href="../../css/index.css">
</head>
<body>
<section class="header-top" id="header-top">

    <div class="back">
        <a href="login.jsp"><img src="../../img/back.png" alt=""></a>
        <a href="login.jsp" class="jump-to">登陆</a>
    </div>
    <div class="title-bar">
        <p>首页</p>
    </div>

</section>
<!-- 顶部搜索框 -->

<div id="wrapper">
    <div id="scroller">
        <div id="header" class="home">
            <div class="sidebar" id="sidebar">
                <img src="../../img/menu.png" alt="">
            </div>
            <div class="search">
                <i id="search" class="search-button"></i>
                <input type="text" name="search" id="input">
            </div>
        </div>
        <!-- 隐藏分类 -->
        <section class="classify" id="classify">
            <ul>
                <li><a href="javascript:;">婴儿车</a></li>
                <li><a href="javascript:;">安全座椅</a></li>
                <li><a href="javascript:;">玩具</a></li>
                <li><a href="javascript:;">家具家电</a></li>
                <li><a href="javascript:;">服饰鞋帽</a></li>
                <li><a href="javascript:;">图片绘本</a></li>
                <li><a href="javascript:;">其它产品</a></li>
            </ul>
        </section>

        <div id="myCarousel" class="carousel slide">
            <!-- 轮播（Carousel）指标 -->
            <ol class="carousel-indicators">
                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                <li data-target="#myCarousel" data-slide-to="1"></li>
                <li data-target="#myCarousel" data-slide-to="2"></li>
            </ol>
            <!-- 轮播（Carousel）项目 -->
            <div class="carousel-inner">
                <c:forEach var="goods" items="${circleList}" varStatus="var">
                    <c:if test="${var.index==0}">
                <div class="item active">
                    <img src="/upload/${goods.picture}" alt="First slide" onclick="window.location.href='/goods/goodsDetail?d=${goods.id}'">
                </div>
                    </c:if>
                    <c:if test="${var.index>0}">
                <div class="item">
                    <img src="/upload/${goods.picture}" alt="Second slide" onclick="window.location.href='/goods/goodsDetail?d=${goods.id}'">
                </div>
                    </c:if>
                </c:forEach>
            </div>
            <!-- 轮播（Carousel）导航 -->
            <a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a>
            <a class="carousel-control right" href="#myCarousel" data-slide="next">&rsaquo;</a>
        </div>

        <div class="title" id="title">
            <ul>
                <li class="focus">新品</li>
                <li>猜你喜欢</li>
            </ul>
        </div>

        <div class="main" id="main">
            <section class="main-cons" style="display:block">
                <div id="main-cons"></div>
                <div id="pullUp">
                    <span class="pullUpIcon"></span>
                    <span class="pullUpLabel">加载更多</span>
                </div>
            </section>

            <section class="main-cons" style="display:none">
                <div class="you-like">
                    <p>系统正在为您查询您感兴趣的宝物......</p>
                    <p>请填写以下信息</p>
                    <ul>
                        <li>
                            <label>宝宝姓名：</label>
                            <label><input type="text" id="username"></label>
                        </li>
                        <li>
                            <label>宝宝生日：</label>
                            <label><input type="date"></label>
                        </li>

                        <li>
                            <label>宝宝性别：</label>
                            <label>
                                <select name="sex" id="sex">
                                    <option value="">男</option>
                                    <option value="">女</option>
                                </select>
                            </label>
                        </li>

                        <li>
                            <label>宝宝爱好：</label>
                            <label><input type="text"></label>
                        </li>
                    </ul>
                    <div class="like-up">
                        <input type="button" style="border:none" value="提交" id="like-up">
                    </div>
                </div>
            </section>
        </div>
    </div>
</div>
<div class="back-top" id="back-top">
    <p>回到顶部</p>
</div>

<div class="menu" id="footer">
    <a href="/">
        <i class="icon-menu icon-menu1"><img src="../../img/footer-c1.png" alt=""></i>
    </a>
    <a>
        <i class="icon-menu icon-menu2"><img src="../../img/footer-2.png" alt=""></i>
    </a>
    <a href="consignment.jsp">
        <i class="icon-menu icon-menu3"><img src="../../img/footer-3.png" alt=""></i>
    </a>
    <a href="javascript:;" id="shopping">
        <i class="icon-menu icon-menu4"><img src="../../img/footer-4.png" alt=""></i>
    </a>
    <a href="personal.jsp">
        <i class="icon-menu icon-menu5"><img src="../../img/footer-5.png" alt=""></i>
    </a>
</div>

<script type="text/javascript" src="../../js/jquery.1.10.2.js"></script>
<!-- 轮播 -->
<script type="text/javascript" src="../../js/bootstrap.min.js"></script>
<!-- 下拉刷新 -->
<script type="text/javascript" src="../../js/dataBind.js"></script>
<script type="text/javascript" src="../../js/hhSwipe.js"></script>
<script type="text/javascript" src="../../js/iscroll.js"></script>
</body>
</html>