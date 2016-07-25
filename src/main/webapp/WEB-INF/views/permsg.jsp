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
        个人信息
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
    <!-- 编辑宝宝信息 -->
    <form action="user/baby/addBaby" class="person-msg"  method="post">
        <%--<input name="userId" style="display: none" type="text" value="8">--%>
        <label for="babyData">宝宝生日：
            <input name="birthday" id="babyData" type="date" value="${baby.birthday}">
        </label>
        <label for="babyName">宝宝姓名：
            <input name="name" id="babyName" type="text" value="${baby.name}">
        </label>
        <label for="sex">宝宝性别：
            <select name="gender" id="sex">
                <option value="MEN">男</option>
                <option value="WOMEN">女</option>
                <option value="UNLIMITED">中性</option>
            </select>
        </label>

        <div class="person-button">
            <button type="button">新增宝宝信息</button>
        </div>

    </form>
    <!-- 编辑宝宝信息END -->
    <div class="tip" id="textShow" style="display: none"></div>     <%--弹窗--%>
</div>
</body>
<script src="script/lib/jquery.1.10.2.js" type="text/javascript"></script>
<script src="script/babyinfo.js"></script>
<script src="script/common.js"></script>
</html>