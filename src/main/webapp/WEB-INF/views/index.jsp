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

    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/master.css">
    <link rel="stylesheet" href="css/module.css">

    <link rel="stylesheet" href="script/lib/iscroll/iscroll.css">
    <script src="script/lib/jquery.1.10.2.js"></script>
    <script src="script/lib/bootstrap/bootstrap.min.js"></script>
    <script src="script/lib/iscroll/iscroll.js"></script>
    <script src="script/common.js"></script>
    <script src="script/index.js"></script>
</head>

<body>
<div id="err"></div>
<div class="content-index">
    <!--标题-->
    <header>
        首页
        <!--操作按钮-->
        <div class="header-box">
            <a href="/jsp/login">
                <p class="header-left">
                    <i class="icon icon-return"></i>
                    登陆
                </p>
            </a>
        </div>
        <!--操作按钮 END-->
    </header>
    <!--标题 END-->

    <!--搜索框-->
    <div id="searchBox" class="search">
        <!--商品类型查询-->
        <div class="column">
            <i class="icon icon-dire"></i>
        </div>
        <!--关键字查询-->
        <div class="search-input">
            <p id="btnSearch">
                <i class="icon icon-search"></i>
            </p>
            <input id="txtSearch" title="请输入关键字">
        </div>
        <!-- 侧导航栏 -->
        <div class="sidebar hide" id="sidebar">
            <ul>
            </ul>
        </div>
    </div>
    <!--搜索框 END-->
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
                <!--商品-->
                <!--新品列表-->
                <li>
                    <img src="" alt="">
                    <div>
                        <p>
                            <span></span><!--宝物价格-->
                            <span></span><!--宝物新旧程度-->
                        </p>
                        <p></p><!--宝物品牌-->
                        <p></p><!--宝物标题-->
                    </div>
                </li>
                <!--新品列表 END-->
            </ul>

            <div id="newGoods" class="goods">
                <!-- 功能切换-->
                <div class="scroll-menu">
                    <ul>
                        <li class="focus"> 新品</li>
                        <li>猜你喜欢</li>
                    </ul>
                </div>
                <!-- 功能切换 END-->
                <div class="goods-list">
                    <!--新品列表的展示-->
                    <ul id="newGoodsList" class="goods-list clearfix"></ul>
                    <!--猜你喜欢物品的展示-->
                    <ul id="likeGoodsList" class="goods-list clearfix">
                    </ul>
                </div>

                <!-- 猜你喜欢 -->
                <div id="likeForm" class="you-like hide">
                    <%--<p>系统正在为您查询您感兴趣的宝物......</p>--%>
                    <p>请填写以下信息</p>
                    <ul>
                        <li>
                            <label>宝宝姓名：</label>
                            <label><input name="babyName" type="text"></label>
                        </li>
                        <li>
                            <label>宝宝生日：</label>
                            <label><input name="babyBirthday" type="date"></label>
                        </li>

                        <li>
                            <label>宝宝性别：</label>
                            <label>
                                <select name="sex" id="sex">
                                </select>
                            </label>
                        </li>

                        <li>
                            <label>宝宝爱好：</label>
                            <label><input type="text" name="hobby"></label>
                        </li>
                    </ul>
                    <button id="btnLikeSubmit" class="like-up-button" type="submit">提交</button>
                </div>
                <!-- 猜你喜欢END -->
            </div><%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <base href="<%=basePath%>">

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

    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/master.css">
    <link rel="stylesheet" href="css/module.css">

    <link rel="stylesheet" href="script/lib/iscroll/iscroll.css">
    <script src="script/lib/jquery.1.10.2.js"></script>
    <script src="script/lib/bootstrap/bootstrap.min.js"></script>
    <script src="script/lib/iscroll/iscroll.js"></script>
    <script src="script/common.js"></script>
    <script src="script/index.js"></script>
</head>

<body>
<div id="err"></div>
<div class="content-index">
    <!--标题-->
    <header>
        首页
        <!--操作按钮-->
        <div class="header-box">
            <a href="/jsp/login">
                <p class="header-left">
                    <i class="icon icon-return"></i>
                    登陆
                </p>
            </a>
        </div>
        <!--操作按钮 END-->
    </header>
    <!--标题 END-->

    <!--搜索框-->
    <div id="searchBox" class="search">
        <!--商品类型查询-->
        <div class="column">
            <i class="icon icon-dire"></i>
        </div>
        <!--关键字查询-->
        <div class="search-input">
            <p >
                <i class="icon icon-search"></i>
            </p>
            <input id="txtSearch" title="请输入关键字">
        </div>
        <!-- 侧导航栏 -->
        <div class="sidebar hide" id="sidebar">
            <ul>
            </ul>
        </div>
    </div>
    <!--搜索框 END-->
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
                <!--商品-->
                <!--新品列表-->
                <li>
                    <img src="" alt="">
                    <div>
                        <p>
                            <span></span><!--宝物价格-->
                            <span></span><!--宝物新旧程度-->
                        </p>
                        <p></p><!--宝物品牌-->
                        <p></p><!--宝物标题-->
                    </div>
                </li>
                <!--新品列表 END-->
            </ul>

            <div id="newGoods" class="goods">
                <!-- 功能切换-->
                <div class="scroll-menu">
                    <ul>
                        <li class="focus"> 新品</li>
                        <li>猜你喜欢</li>
                    </ul>
                </div>
                <!-- 功能切换 END-->
                <div class="goods-list">
                    <!--新品列表的展示-->
                    <div id="newGoodsList">
                        <ul class="goods-list clearfix"></ul>
                    </div>
                    <!--猜你喜欢物品的展示-->
                    <div id="likeGoodsList" >
                        <!--猜你喜欢主体-->
                        <ul class="goods-list clearfix"></ul>
                        <!-- 猜你喜欢 -->
                        <div id="likeForm" class="you-like">
                            <%--<p>系统正在为您查询您感兴趣的宝物......</p>--%>
                            <p>请填写以下信息</p>
                            <ul>
                                <li>
                                    <label>宝宝姓名：</label>
                                    <label><input name="babyName" type="text"></label>
                                </li>
                                <li>
                                    <label>宝宝生日：</label>
                                    <label><input name="babyBirthday" type="date"></label>
                                </li>

                                <li>
                                    <label>宝宝性别：</label>
                                    <label>
                                        <select name="sex" id="sex">
                                        </select>
                                    </label>
                                </li>

                                <li>
                                    <label>宝宝爱好：</label>
                                    <label><input type="text" name="hobby"></label>
                                </li>
                            </ul>
                            <button id="btnLikeSubmit" class="like-up-button" type="submit">提交</button>
                        </div>
                        <!-- 猜你喜欢END -->
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<!--底部导航-->
<div class="menu" id="menu">
    <a href="/">
        <i class="icon-menu icon-menu1"><img src="img/footer-c1.png" alt=""></i>
    </a>
    <a>
        <i class="icon-menu icon-menu2"><img src="img/footer-2.png" alt=""></i>
    </a>
    <a href="/jsp/consignment">
        <i class="icon-menu icon-menu3"><img src="img/footer-3.png" alt=""></i>
    </a>
    <a href="/jsp/shopping" id="shopping">
        <i class="icon-menu icon-menu4"><img src="img/footer-4.png" alt=""></i>
    </a>
    <a href="/jsp/personal">
        <i class="icon-menu icon-menu5"><img src="img/footer-5.png" alt=""></i>
    </a>
</div>
<!--底部导航 END-->
</body>
</html>

        </div>
    </div>
</div>


<!--底部导航-->
<div class="menu" id="menu">
    <a href="/">
        <i class="icon-menu icon-menu1"><img src="img/footer-c1.png" alt=""></i>
    </a>
    <a>
        <i class="icon-menu icon-menu2"><img src="img/footer-2.png" alt=""></i>
    </a>
    <a href="/jsp/consignment">
        <i class="icon-menu icon-menu3"><img src="img/footer-3.png" alt=""></i>
    </a>
    <a href="/jsp/shopping" id="shopping">
        <i class="icon-menu icon-menu4"><img src="img/footer-4.png" alt=""></i>
    </a>
    <a href="/jsp/personal">
        <i class="icon-menu icon-menu5"><img src="img/footer-5.png" alt=""></i>
    </a>
</div>
<!--底部导航 END-->
</body>
</html>
