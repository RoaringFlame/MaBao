<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登陆</title>
    <meta name="viewport"
          content="maximum-scale=1.0,minimum-scale=1.0,user-scalable=no,width=device-width,initial-scale=1.0"/>
    <!-- 禁止将数字变为电话号码 -->
    <meta name="format-detection" content="telephone=no"/>
    <!-- iphone设备中的safari私有meta标签,允许全屏模式浏览，隐藏浏览器导航栏 -->
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <!-- iphone的私有标签,它指定的iphone中safari顶端的状态条的样式 -->
    <meta name="apple-mobile-web-app-status-bar-style" content="black">

    <link rel="stylesheet" href="../../css/login.css">
    <link rel="stylesheet" href="../../css/public.css">
</head>
<body>
<section class="header-top">
    <div class="back"><a href=""><img src="../../img/back.png" alt=""></a>
        <a href="" class="jump-to">返回</a></div>
    <div class="title-bar"><p>登录</p></div>
</section>

<div class="top1">

    <p class="warning"></p>
    <div>
        <!-- <p class="changepwd">用户名：</p> -->
        <input type="text" name="username" placeholder="用户名">
    </div>
    <div class="clear">
        <!-- <p class="changepwd">密&nbsp;码：</p> -->
        <input type="password" name="password" placeholder="密码">
    </div>
</div>

<div class="bottom" id="login"><p>登陆</p></div>

<div class="forget-psd"><a href="findpwd.html" class="forget-psd">忘记密码</a></div>

<div class="free-res" id="free-res">免费注册</div>

<script type="text/javascript" src="../js/jquery.1.10.2.js"></script>
<script type="text/javascript" src="../js/login.js"></script>
</body>
</html>