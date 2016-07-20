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
    <title>编辑收货地址</title>
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
    <link rel="stylesheet" href="css/bootstrap-switch.css">

    <script src="script/lib/jquery.1.10.2.js" type="text/javascript"></script>
    <script src="script/lib/bootstrap/bootstrap.min.js"></script>
    <script src="script/lib/bootstrap/bootstrap-switch.js"></script>
    <script src="script/lib/jquery.provincesCity.js" type="text/javascript"></script>
    <script src="script/lib/provinces-data.js" type="text/javascript"></script>
    <script src="script/chadd.js"></script>
    <script src="script/common.js"></script>
</head>
<body>
<div class="content-index">
    <!--标题-->
    <header>
        编辑收货地址
        <!--操作按钮-->
        <div class="header-box">
            <a href="user/address/userAllAddress">
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
    <form id="frmAddress" >
        <div class="edit-add-box">
            <input name="recipients" type="text" placeholder="收件人：" value="${address.recipients}">
            <input name="tel" type="text" placeholder="手机号：" value="${address.tel}">
            <p class="address">所在地：</p>
            <label>
            <select id="provinces">
                <option value="${address.area.parentArea.parentArea.id}">请选择</option>
            </select>
            <select>
                <option value="${address.area.parentArea.id}">请选择</option>
            </select>
            <select>
                <option value="${address.area.id}">请选择</option>
                <input id="areaId" name="areaId" type="hidden" value="">
            </select>
            <input name="area" type="hidden" value="${address.area}">
        </label>

            <input name="addressId" value="${address.id}" style="display: none">
            <input name="user" value="${address.user}" style="display: none">
            <input name="location" type="text" class="write" placeholder="详细地址：" value="${address.location}">
            <div class="default-add">
                <p>默认地址</p>
                <span>注：每次下单时会使用该地址</span>
                <div class="switch">
                    <label>
                        <input class="form-control" type="checkbox" value="${address.state}">
                        <input name="state" type="hidden">
                    </label>
                </div>
            </div>
        </div>
        <!-- 清楚浮动 -->
        <div class="clear"></div>

        <div class="edit-add-input">
            <!-- 删除按钮 -->
            <label>
                <input type="button" value="删除该地址">
            </label>
            <!-- 删除按钮END -->
            <!-- 保存按钮 -->
            <label>
                <input type="button" value="保存并使用">
            </label>
            <!-- 保存按钮END -->
        </div>

    </form>
    <!-- 编辑收货地址END -->

</div>

</body>
</html>

