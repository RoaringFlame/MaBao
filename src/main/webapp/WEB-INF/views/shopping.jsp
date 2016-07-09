<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: maxu
  Date: 2016/7/8
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <link rel="stylesheet" type="text/css" href="../css/index.css">
    <link rel="stylesheet" href="../css/buy.css">
    <link rel="stylesheet" href="../css/public.css">
</head>
<body>
<section class="header-top">
    <div class="back" onclick=window.location.href="index.html">
        <img src="../img/back.png" alt="">
        <a class="jump-to">返回</a>
    </div>
    <div class="title-bar"><p>购物车</p></div>
    <p class="edit" id="edit">编辑</p>
</section>

<form method="" action="">
    <div class="container">
        <c:forEach var="goods" items="${goodsPage}">
        <section class="main-item">

            <input class="select" name="itemContainer" type="checkBox">
            <div class="user-img">
                <img src="../img/main-new1.png" alt="">
            </div>
            <div class="user-intro">
                <p>H&M&nbsp;&nbsp;CARDIGAN</p>
                <p>尺寸&nbsp;:&nbsp;S</p>
                <p class="mark">35.50</p>
            </div>
            <img class="del" src="../img/del.png" alt="">
            <div class="add-reduce">
                <div class="reduce">
                    <img src="../img/reduce.png" alt="">
                </div>
                <div class="sum">
                    2
                </div>
                <div class="add">
                    <img src="../img/shopping-1.png" alt="">
                </div>
            </div>
        </section>
        <%--<section class="main-item">--%>

            <%--<input class="select" name="itemContainer" type="checkBox" checked="checked">--%>
            <%--<div class="user-img">--%>
                <%--<img src="../img/main-new1.png" alt="">--%>
            <%--</div>--%>
            <%--<div class="user-intro">--%>
                <%--<p>H&M&nbsp;&nbsp;CARDIGAN</p>--%>
                <%--<p>尺寸&nbsp;:&nbsp;S</p>--%>
                <%--<p class="mark">35.50</p>--%>
            <%--</div>--%>
            <%--<img class="del" src="../img/del.png" alt="">--%>
            <%--<div class="add-reduce">--%>
                <%--<div class="reduce">--%>
                    <%--<img src="../img/reduce.png" alt="">--%>
                <%--</div>--%>
                <%--<div class="sum">--%>
                    <%--1--%>
                <%--</div>--%>
                <%--<div class="add">--%>
                    <%--<img src="../img/shopping-1.png" alt="">--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</section>--%>
        <%--<section class="main-item"></section>--%>
    </div>
    <div class="up-to-pay">
        <ul>
            <li>总计&nbsp;:&nbsp;<span id="sumPrice"></span></li>
            <li onclick=window.location.href="pay.html">付款
                <input class="sr_button" type="submit" value="付款" >
            </li>
        </ul>
    </div>
</form>

<section class="clear"></section>
<div class="menu">
    <a class="active" href="index.html">
        <i class="icon-menu icon-menu1"><img src="../img/footer-1.png" alt=""></i>
    </a>
    <a>
        <i class="icon-menu icon-menu2"><img src="../img/footer-2.png" alt=""></i>
    </a>
    <a href="consignment.html">
        <i class="icon-menu icon-menu3"><img src="../img/footer-3.png" alt=""></i>
    </a>
    <a href="shopping.html">
        <i class="icon-menu icon-menu4"><img src="../img/footer-c4.png" alt=""></i>
    </a>
    <a href="personal.html">
        <i class="icon-menu icon-menu5"><img src="../img/footer-5.png" alt=""></i>
    </a>
</div>
<!-- 显示删除选项 -->
</body>
</html>
<script type="text/javascript" src="../js/jquery.1.10.2.js"></script>
<script type="text/javascript" src="../js/shopping.js"></script>
<%--<script type="text/javascript">--%>
    <%--$(function(){--%>
        <%--$("#edit").click(function(){--%>
            <%--if($(this).text()=="编辑"){--%>
                <%--$(".del").show();--%>
                <%--$(this).html("完成");}--%>
        <%--});--%>
    <%--});--%>
<%--</script>--%>
