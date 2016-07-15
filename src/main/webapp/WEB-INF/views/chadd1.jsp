<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>编辑收货地址</title>
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
    <link rel="stylesheet" href="../../css/bootstrap-switch.css">
</head>

<body>
<div class="content-index">
    <!--标题-->
    <header>
        编辑收货地址
        <!--操作按钮-->
        <div class="header-box">
            <a href="../../static/address.html">
                <button class="header-left">
                    <i class="icon icon-return"></i>
                    返回
                </button>
            </a>
        </div>
        <!--操作按钮 END-->
    </header>
    <!--标题 END-->
    <!-- 编辑收货地址 -->
    <form action="">
        <div class="edit-add-box">
            收件人： <input name="addressee" type="text" placeholder="${recipients.name}">
            手机号： <input name="tel" type="text" placeholder="${recipients.tel}">
            <input name="location" type="text" placeholder="所在地：">
            <!-- 省市级联地址插件 -->
            <div id="test"></div>
            <!-- 省市级联地址插件END -->
            详细地址：<input name="detail-add" type="text" class="write" placeholder="${detailLocation}">
            <div class="default-add">
                <p>默认地址</p>
                <span>注：每次下单时会使用该地址</span>
                <div class="switch">
                    <label>
                        <input class="form-control" name="switch" type="checkbox" >
                    </label>
                </div>
             </div>
        </div>
        <!-- 清楚浮动 -->
        <div class="clear"></div>

        <div class="edit-add-input">
            <!-- 删除按钮 -->
            <label>
                <input type="button" value="删除该地址" onclick=window.location.href="../../static/address.html" >
            </label>
            <!-- 删除按钮END -->
            <!-- 保存按钮 -->
            <label>
                <input type="button" value="保存并使用" onclick=window.location.href="../../static/address.html" >
            </label>
            <!-- 保存按钮END -->
        </div>

    </form>
    <!-- 编辑收货地址END -->

</div>

</body>
</html>
<script src="../../script/lib/jquery.1.10.2.js" type="text/javascript"></script>
<script src="../../script/lib/bootstrap/bootstrap.min.js"></script>
<script src="../../script/lib/bootstrap/bootstrap-switch.js"></script>
<script src="../../script/lib/jquery.provincesCity.js" type="text/javascript"></script>
<script src="../../script/lib/provinces-data.js" type="text/javascript"></script>
