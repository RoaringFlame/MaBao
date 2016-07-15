<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>自助发布：转让宝物</title>
    <meta name="viewport"
          content="maximum-scale=1.0,minimum-scale=1.0,user-scalable=no,width=device-width,initial-scale=1.0"/>
    <!-- 禁止将数字变为电话号码 -->
    <meta name="format-detection" content="telephone=no"/>
    <!-- iphone设备中的safari私有meta标签,允许全屏模式浏览，隐藏浏览器导航栏 -->
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <!-- iphone的私有标签,它指定的iphone中safari顶端的状态条的样式 -->
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <link rel="stylesheet" href="css/bootstrap-switch.css">
    <link rel="stylesheet" href="css/master.css">
    <link rel="stylesheet" href="css/module.css">
</head>

<body>
<div class="content-index">
    <!--标题-->
    <header>
        转让宝物
        <!--操作按钮-->
        <div class="header-box">
            <a href="consignment">
                <button class="header-left">
                    <i class="icon icon-return"></i>
                    返回
                </button>
            </a>
        </div>
        <!--操作按钮 END-->
    </header>
    <!--标题 END-->

    <!--转让宝物信息填写-->
    <div class="transfer-box">
        <!--提示信息-->
        <p>
            <span>请如实填写您的转让信息</span>
            <a href="#">卖家须知</a>
        </p>
        <!--提示信息END-->
        <!--转让宝物信息表单-->
        <form class="transfer-form" action="/sell/release" id="console-form">
            <label class="title">
                <input type="text" name="title" value="宝物标题">
            </label>
            <!--宝物信息选框-->
            <ul class="transfer-info" id="transferInfo">
                <li>
                    <label for="kind">宝物类型：</label>
                    <select name="kind" id="kind">
                        <c:forEach items="${goodsType}" var="Type">
                            <option value="${Type.value}" >${Type.value}</option>
                        </c:forEach>
                    </select>
                </li>
                <li>
                    <label for="brand">宝物品牌：</label>
                    <select name="brand" id="brand">
                        <c:forEach items="${brand}" var="one_brand">
                            <option value="${one_brand.value}" >${one_brand.value}</option>
                        </c:forEach>
                    </select>
                </li>
                <li>
                    <label for="time">购物时间：</label>
                    <input name="time" id="time" type="date"/>
                </li>
                <li>
                    <label for="level">新旧程度：</label>
                    <select name="level" id="level">
                        <option value="全新">全新</option>
                        <option value="9成新">9成新</option>
                        <option value="8成新">8成新</option>
                        <option value="6-7成新">6-7成新</option>
                        <option value="5成新以下">5成新以下</option>
                    </select>
                </li>
                <li>
                    <label for="size">宝物尺码：</label>
                    <select name="size" id="size">goodsSize
                        <c:forEach items="${goodsSize}" var="size">
                            <option value="${size.value}" >${size.value}</option>
                        </c:forEach>
                    </select>
                </li>
                <li>
                    <label for="sex">适合宝宝：</label>
                    <select name="sex" id="sex">
                        <c:forEach items="${gender}" var="babygender">
                            <option value="${babygender.value}" >${babygender.value}</option>
                        </c:forEach>
                    </select>
                </li>
                <li>
                    <label for="packet">原装包装：
                        <input id="packet" type="checkbox" checked="" data-size="mini">
                    </label>
                </li>
                <li>
                    <label for="invoice">发票小票：
                        <input id="invoice" type="checkbox" checked="" data-size="mini">
                    </label>
                </li>
                <li>
                    <label for="oldPrice">购买原价：
                        <input type="text" name="oldPrice" id="oldPrice">
                    </label>

                </li>
                <li>
                    <label for="newPrice">转让现价：
                        <input type="text" name="newPrice" id="newPrice">
                    </label>

                </li>
            </ul>
            <!--宝物信息选框END-->
            <!--清楚浮动-->
            <div class="clear"></div>
            <!--买家寄语-->
            <div class="transfer-form-bottom">
                <label for="">卖家寄语：<br>宝物详情&nbsp;/<br>使用心得&nbsp;/<br>瑕疵情况等</label>
                <textarea name="" id="" cols="30" rows="10"></textarea>
                <!--上传照片-->
                <div>
                    <input type="file" accept="image/png,image/gif" style="display: none;" id="uploadPhoto">
                    <img src="img/1.png" alt="">
                    <img src="img/2.png" alt="">
                    <img src="img/3.png" alt="">
                </div>
                <!--上传照片END-->
            </div>
            <!--买家寄语END-->

        </form>
        <!--转让宝物信息表单END-->
        <!--提交按钮-->
        <!--提交后跳转到朋友圈分享页面-->
        <a href="#" class="transfer-form-button">
            <button type="submit" form="console-form">一键卖出</button>
        </a>
        <!--提交按钮END-->

    </div>
</div>
<!--转让宝物信息填写END-->
</body>
</html>

<!-- //按钮 -->
<script src="script/lib/jquery.1.10.2.js"></script>
<script src="script/lib/bootstrap/bootstrap.min.js"></script>
<script src="script/lib/bootstrap/bootstrap-switch.js"></script>
