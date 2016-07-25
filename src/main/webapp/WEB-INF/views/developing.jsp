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
    <title>开发中...</title>
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
    <%--<!--标题-->--%>
    <%--<header>--%>
        <%--<!--操作按钮-->--%>
        <%--<div class="header-box">--%>
        <%--</div>--%>
        <%--<!--操作按钮 END-->--%>
    <%--</header>--%>
    <!--标题 END-->
    <!--发布成功提示-->
    <div class="publish-success-box">
        <p>此页面正在开发中...</p>
        <p>敬请期待哟～</p>
        <a href="" class="share-bottom">
            <button>去逛逛</button>
        </a>
        <!--发布成功提示END-->
    </div>
</div>
</body>
</html>