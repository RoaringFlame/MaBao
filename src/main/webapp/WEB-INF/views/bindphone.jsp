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
    <title>绑定手机</title>
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
    <script src="script/common.js"></script>
    <script src="script/bindphone.js"></script>
</head>

<body>
<div class="content-index">
    <!--标题-->
    <header>
        绑定手机
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
    <!-- 绑定手机表单 -->
    <div class="bind-top">
        <form action="">
            <!-- 绑定手机号成功后跳转到个人中心页面 -->
            <label>
                <input type="text" placeholder="输入完整手机号" id="telNum">
            </label>
            <p class="warning"></p>
            <button class="bind-right-button" type="submit" id="sendSms">发送验证</button>
            <label>
                <input type="text" placeholder="验证码">
            </label>
            <!-- 校验提示 -->
            <p class="warning"></p>
            <!-- 提交按钮 -->
            <button type="submit" value="提交" class="submit">提交</button>
        </form>
    </div>
    <!-- 绑定手机表单END -->
</div>
</body>
</html>