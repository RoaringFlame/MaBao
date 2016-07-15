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

    <link rel="stylesheet" href="../../css/master.css">
    <link rel="stylesheet" href="../../css/module.css">
</head>

<body>
<div class="content-index">
    <!--标题-->
    <header>
        登录
        <!--操作按钮-->
        <div class="header-box">
            <a href="personal.html">
                <button class="header-left">
                    <i class="icon icon-return"></i>
                    返回
                </button>
            </a>
        </div>
        <!--操作按钮 END-->
    </header>
    <!--标题 END-->
    <!-- 登陆表单 -->
    <form class="login-box" action="/login" method="POST">
        <!-- 校验提示 -->
        <c:if test="${not empty error}">
        <p class="warning">${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</p>
        </c:if>
        <label for="userName">用户名
            <input type="text" name="username" id="userName">
        </label>
        <label for="passWord">密码
            <input type="password" name="password" id="passWord">
        </label>
        <!-- 登陆按钮 -->
        <button name="sumbit" type="submit">登陆</button>
        <input name="${_csrf.parameterName}" type="hidden" value="${_csrf.token}">
        <!-- 登陆按钮END -->
        <a href="findpwd.html" class="login-right">忘记密码</a>
        <a href="res.html" class="login-bottom">免费注册</a>
    </form>
    <!-- 登陆表单END -->
</div>
</body>
</html>