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
    <title>修改宝宝信息</title>
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
</head>
<body>
<div class="content-index">
    <!--标题-->
    <header>
        <!--操作按钮-->
        <div class="header-box">
            <a href="">
                <p class="header-left">
                    <i class="icon icon-return"></i>
                    返回
                </p>
            </a>
        </div>
        <!--操作按钮 END-->
    </header>
    <!--标题 END-->
    <!--发布成功提示-->
    <div class="publish-success-box">
        <p>此功能页面正在开发中！</p>
        <p>敬请期待哟～</p>
        <a href="" class="share-bottom">
            <button>去逛逛</button>
        </a>
        <!--发布成功提示END-->
    </div>
    <!--底部导航-->
    <div class="menu" id="menu">
        <a href="">
            <i class="icon-menu icon-menu1"><img src="img/footer-c1.png" alt=""></i>
        </a>
        <a href="developing">
            <i class="icon-menu icon-menu2"><img src="img/footer-2.png" alt=""></i>
        </a>
        <a href="consignment">
            <i class="icon-menu icon-menu3"><img src="img/footer-3.png" alt=""></i>
        </a>
        <a href="user/shopping" >
            <i class="icon-menu icon-menu4"><img src="img/footer-4.png" alt=""></i>
        </a>
        <a href="user">
            <i class="icon-menu icon-menu5"><img src="img/footer-5.png" alt=""></i>
        </a>
    </div>
    <!--底部导航 END-->
</div>
</body>
</html>