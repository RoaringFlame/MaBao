<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
    <title>短信验证</title>
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
    <script src="script/message.js"></script>
</head>

<body>
<div class="content-index">
    <!--标题-->
    <header>
        短信验证
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
    <!-- 找回密码表单 -->
    <c:if test="${phone ne null}">
        <div class="get-back-pwd">
            <!--当前绑定手机号为用户号码-->
            <p>当前绑定手机号为${phone}</p>
            <!-- 找回密码跳转到修改密码页面 -->
            <button type="submit" class="button-right" id="sendSms">获取验证码</button>
            <label>
                <input type="text" placeholder="验证码" id="code">
            </label>
            <p class="warning" id="warning"></p>
            <!--提交按钮-->
            <a class="button-bottom">
                <button type="submit" class="submit" id="submit">提交</button>
            </a>
            <!--提交按钮END-->
        </div>
    </c:if>
    <c:if test="${phone eq null}">
        您暂未绑定手机号！<br>
        <a href="user/bindphone">===前去绑定===</a>
    </c:if>
    <!--找回密码表单END-->
</div>
</body>
</html>