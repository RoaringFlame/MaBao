<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: maxu
  Date: 2016/7/8
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>购物车</title>
    <meta name="viewport"
          content="maximum-scale=1.0,minimum-scale=1.0,user-scalable=no,width=device-width,initial-scale=1.0"/>
    <!-- 禁止将数字变为电话号码 -->
    <meta name="format-detection" content="telephone=no"/>
    <!-- iphone设备中的safari私有meta标签,允许全屏模式浏览，隐藏浏览器导航栏 -->
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <!-- iphone的私有标签,它指定的iphone中safari顶端的状态条的样式 -->
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <!-- 	<script type="text/javascript" src="../js/jquery-1.8.3.min.js"></script> -->
    <link rel="stylesheet" href="../../css/master.css">
    <link rel="stylesheet" href="../../css/module.css">
    <script src="../../script/lib/jquery.1.10.2.js"></script>
    <script src="../../script/shopping.js"></script>
</head>

<body>
<div class="content-index">
    <!--标题-->
    <header>
        购物车
        <!--操作按钮-->
        <div class="header-box">
            <a href="../../static/index.html">
                <button class="header-left">
                    <i class="icon icon-return"></i>
                    返回
                </button>
            </a>
                <!--点击编辑出现删除商品按钮-->
                <button class="header-right">
                    编辑
                </button>
        </div>
        <!--操作按钮 END-->
    </header>
    <!--标题 END-->
<div id="goodsContainer" style="display: none;">
    <!--商品信息-->
    <div class="main-item">
        <div class="cartId" style="display: none;" >1</div>
        <!--选择商品-->
        <label>
            <input class="select" name="itemContainer" type="checkBox">
        </label>
        <img class="goods-img" src="../../img/main-new1.png" alt="">
        <div class="goods-info">
            <p>H&M&nbsp;&nbsp;CARDIGAN</p>
            <p>尺寸&nbsp;:&nbsp;S</p>
            <p>￥35.50</p>
        </div>
        <!--删除商品按钮-->
        <button class="goods-del"></button>
        <!--删除商品按钮END-->
        <!--加减商品数量-->
        <div class="shopping-cart">
            <button class="shopping-cart-reduce"></button>
            <p class="shopping-cart-sum">1</p>
            <button class="shopping-cart-add"></button>
        </div>
        <!--加减商品数量END-->
    </div>
    <!--商品信息END-->
</div>
    <div class="iscroll-wrapper" style="top:48px;bottom: -12px;">
    <div id="container">

    </div>
        <div class="blank"></div>
    </div>
        <!--付款按钮-->
        <div class="up-to-pay">
            <ul>
                <li>总计&nbsp;:&nbsp;<b>￥131.00</b></li>
                <li>
                    <!--<a href="pay.html">-->
                        <button class="pay" type="submit">付款</button>
                    <!--</a>-->
                </li>
            </ul>
        </div>
        <!--付款按钮END-->
    <!--底部导航-->
    <div class="menu" id="menu">
        <a href="index.html">
            <i class="icon-menu icon-menu1"><img src="../../img/footer-c1.png" alt=""></i>
        </a>
        <a>
            <i class="icon-menu icon-menu2"><img src="../../img/footer-2.png" alt=""></i>
        </a>
        <a href="consignment.html">
            <i class="icon-menu icon-menu3"><img src="../../img/footer-3.png" alt=""></i>
        </a>
        <a href="" id="shopping">
            <i class="icon-menu icon-menu4"><img src="../../img/footer-4.png" alt=""></i>
        </a>
        <a href="personal.html">
            <i class="icon-menu icon-menu5"><img src="../../img/footer-5.png" alt=""></i>
        </a>
    </div>
    <!--底部导航 END-->
</div>
</body>
</html>