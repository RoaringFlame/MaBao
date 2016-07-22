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
            <input name="recipients" type="text" placeholder="收件人：" value="${addressList.recipients}">
            <input name="tel" type="text" placeholder="手机号：" value="${addressList.tel}">
            <p class="address">所在地：</p>
            <label>
                <select>
                    <option value="${addressList.area.parentsArea.parentsArea.id}">${addressList.area.parentsArea.parentsArea.shortName}</option>
                    <input id="provinceId" name="area.parentsArea.parentsArea.id" type="hidden" value="${addressList.area.parentsArea.parentsArea.id}">
                </select>
                <select>
                    <option value="${addressList.area.parentsArea.id}">${addressList.area.parentsArea.shortName}</option>
                    <input id="cityId" name="area.parentsArea.id" type="hidden" value="${addressList.area.parentsArea.id}">
                </select>
                <select>
                    <option value="${addressList.area.id}">${addressList.area.shortName}</option>
                    <input id="areaId" name="area.id" type="hidden" value="${addressList.area.id}">
                </select>
            </label>

            <input name="id" value="${addressList.id}" style="display: none">
            <input name="user.id" value="${addressList.user.id}" style="display: none">
            <input name="location" type="text" class="write" placeholder="详细地址：" value="${addressList.location}">
            <input name="state" type="hidden" value="${addressList.state}">
            <%--<div class="default-add">--%>
                <%--<p>默认地址</p>--%>
                <%--<span>注：每次下单时会使用该地址</span>--%>
                <%--<div class="switch">--%>
                    <%--<label>--%>
                        <%--<input class="form-control" type="checkbox" value="${addressList.state}">--%>
                        <%--<input name="state" type="hidden">--%>
                    <%--</label>--%>
                <%--</div>--%>
            <%--</div>--%>
        </div>
        <!-- 清楚浮动 -->
        <div class="clear"></div>

        <div class="edit-add-input">
            <!-- 保存按钮 -->
            <label>
                <input class="default" type="button" value="保存并使用">
            </label>
            <!-- 保存按钮END -->
        </div>

    </form>
    <!-- 编辑收货地址END -->
    <div class="tip" id="textShow" style="display: none"></div>
</div>

</body>
</html>
<script src="script/lib/jquery.1.10.2.js" type="text/javascript"></script>
<script src="script/lib/bootstrap/bootstrap.min.js"></script>
<script src="script/chadd.js"></script>
<script src="script/common.js"></script>
