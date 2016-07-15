<%--
  Created by IntelliJ IDEA.
  User: maxu
  Date: 2016/7/14
  Time: 17:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
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

    <link rel="stylesheet" href="../../css/master.css">
    <link rel="stylesheet" href="../../css/module.css">
</head>
<body>
<div class="content-index">
    <!--标题-->
    <header>
        个人信息
        <!--操作按钮-->
        <div class="header-box">
            <a href="/jsp/personal">
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
    <form action="/user/baby/addBaby" class="person-msg">

        <label for="babyData">宝宝生日：
            <input name="baby-data" id="babyData" type="date" value="babyData">
        </label>
        <label for="babyName">宝宝姓名：
            <input name="baby-name" id="babyName" type="text" value="babyName">
        </label>
        <label for="sex">宝宝性别：
            <select name="sex" id="sex">
                <option value="男">男</option>
                <option value="女">女</option>
            </select>
        </label>

        <div class="person-button">
            <button type="submit">新增宝宝信息</button>
        </div>

    </form>
    <!-- 编辑宝宝信息END -->
</div>
</body>
</html>
