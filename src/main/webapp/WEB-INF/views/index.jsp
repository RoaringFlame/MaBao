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
    <link rel="stylesheet" href="../../css/master.css">
    <link rel="stylesheet" href="../../css/module.css">
    <link rel="stylesheet" href="../../script/lib/iscroll/iscroll.css">
    <script src="../../script/lib/jquery.1.10.2.js"></script>
    <script src="../../script/lib/bootstrap/bootstrap.min.js"></script>
    <script src="../../script/lib/iscroll/iscroll.js"></script>
    <script src="../../script/index.js"></script>
</head>

<body>
<div class="content-index">
    <!--标题-->
    <header>
        首页
        <!--操作按钮-->
        <div class="header-box">
            <a href="login.html">
                <button class="header-left">
                    <i class="icon icon-return"></i>
                    登陆
                </button>
            </a>
        </div>
        <!--操作按钮 END-->
    </header>
    <!--标题 END-->

    <!--搜索框-->
    <div id="searchBox" class="search">
        <div class="column">
            <i class="icon icon-dire"></i>
        </div>
        <div class="search-input">
            <button id="btnSearch">
                <i class="icon icon-search"></i>
            </button>
            <input title="请输入关键字">
        </div>
    </div>
    <!--搜索框 END-->
    <!-- 侧导航栏 -->
    <div class="sidebar hide" id="sidebar">
        <ul>
        </ul>
    </div>

    <div class="iscroll-wrapper" style="top:48px;bottom: -12px;">
        <div class="iscroll-scroller">
            <!--轮播图-->
            <div id="myCarousel" class="carousel slide">
                <!-- 轮播（Carousel）指标 -->
                <ol class="carousel-indicators">
                </ol>
                <!-- 轮播（Carousel）项目 -->
                <div class="carousel-inner">
                </div>
                <!-- 轮播（Carousel）导航 -->
                <a class="carousel-control left" href="#myCarousel"
                   data-slide="prev">&lsaquo;</a>
                <a class="carousel-control right" href="#myCarousel"
                   data-slide="next">&rsaquo;</a>
            </div>
            <!--轮播图 END-->
            <ul id="hideGoods" style="display: none;">
                <!--部品列表-->
                <li>
                    <img src="../img/main-new1.png" alt="">
                    <div>
                        <p>
                            <span>￥30.00</span>
                            <span>九成新</span>
                        </p>
                        <p>H&M&nbsp;CARDIGN</p>
                        <p>纯棉轻薄，无刺激，适合宝宝娇嫩肌肤</p>
                    </div>
                </li>
                <!--部品列表 END-->
            </ul>
            <!--商品-->
            <div id="newGoods" class="goods">
                <!-- 功能切换-->
                <div class="scroll-menu">
                    <ul>
                        <li><a class="focus" href="#">新品</a></li>
                        <li><a href="#">猜你喜欢</a></li>
                    </ul>
                </div>
                <!-- 功能切换 END-->
                <ul id="newGoodsList" class="goods-list clearfix">
                </ul>
                <ul id="likeGoodsList" class="goods-list clearfix">
                </ul>
            </div>
        </div>
    </div>
    <!-- 猜你喜欢 -->
    <form id="likeForm" action="">
        <div class="you-like">
            <p>请填写以下信息</p>
            <ul>
                <li>
                    <label>宝宝姓名：</label>
                    <label><input name="babyName" type="text" id="username"></label>
                </li>
                <li>
                    <label>宝宝生日：</label>
                    <label><input name="babyDate" type="date"></label>
                </li>

                <li>
                    <label>宝宝性别：</label>
                    <label>
                        <select name="sex" id="sex"></select>
                    </label>
                </li>

                <li>
                    <label>宝宝爱好：</label>
                    <label><input name="hobby" type="text"></label>
                </li>
            </ul>
            <button id="btnLikeSubmit" class="like-up-button" type="submit">提交</button>
        </div>
    </form>
    <!-- 猜你喜欢END -->
    <!--底部导航-->
    <div class="menu" id="menu">
        <a href="#">
            <i class="icon-menu icon-menu1"><img src="../../img/footer-c1.png" alt=""></i>
        </a>
        <a href="#">
            <i class="icon-menu icon-menu2"><img src="../../img/footer-2.png" alt=""></i>
        </a>
        <a href="#">
            <i class="icon-menu icon-menu3"><img src="../../img/footer-3.png" alt=""></i>
        </a>
        <a href="#">
            <i class="icon-menu icon-menu4"><img src="../../img/footer-4.png" alt=""></i>
        </a>
        <a href="#">
            <i class="icon-menu icon-menu5"><img src="../../img/footer-5.png" alt=""></i>
        </a>
    </div>
    <!--底部导航 END-->
</div>
</body>
</html>
