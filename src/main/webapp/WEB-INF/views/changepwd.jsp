<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <base href="<%=basePath%>">

    <meta charset="UTF-8">
    <title>修改密码</title>
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
    <script type="text/javascript" src="script/lib/jquery.1.10.2.js"></script>
    <script type="text/javascript" src="script/common.js"></script>
    <script type="text/javascript" src="script/changepwd.js"></script>
</head>
<body>
<div class="content-index">
    <!--标题-->
    <header>
        修改密码
        <!--操作按钮-->
        <div class="header-box">
            <a href="/jsp/personal">
                <button class="header-left">
                    <i class="icon icon-return"></i>
                    返回
                </button>
            </a>
        </div>
        <!--操作按钮 END-->
    </header>
    <!--标题 END-->
    <!--修改密码表单-->
    <div class="change-pwd" action="">

        <!-- 修改密码成功跳转到个人中心页面 -->
        <label for="newPwd">新密码:
            <input type="password" id="newPwd">
        </label>
        <label for="confirm-pwd">确认密码:
            <input type="password" id="confirm-pwd">
        </label>
        <!-- 校验提示 -->
        <p class="warning"></p>
        <!-- 提交按钮 -->
        <!--提交后跳转到登陆页面-->
        <button class="submit" type="button" value="提交" id="up-pwd">提交</button>
        <!--提交按钮END-->
    </div>
    <!--修改密码表单END-->
</div>
</body>
</html>