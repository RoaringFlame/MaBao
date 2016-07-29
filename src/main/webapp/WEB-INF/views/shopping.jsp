<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <base href="<%=basePath%>">

    <meta charset="UTF-8">
    <title>购物车</title>
    <meta name="viewport"
          content="maximum-scale=1.0,minimum-scale=1.0,user-scalable=no,width=device-width,initial-scale=1.0"/>
    <!-- 禁止将数字变为电话号码 -->
    <meta name="format-detection" content="telephone=no"/>
    <!-- iphone设备中的safari私有meta标签,允许全屏模式浏览，隐藏浏览器导航栏 -->
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <!-- iphone的私有标签,它指定的iphone中safari顶端的状态条的样式 -->
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <!-- 	<script type="text/javascript" src="../js/jquery-1.8.3.min.js"></script> -->
    <link rel="stylesheet" href="css/master.css">
    <link rel="stylesheet" href="css/module.css">
    <script src="script/lib/jquery.1.10.2.js"></script>
    <script src="script/shopping.js"></script>
    <script src="script/common.js"></script>
</head>

<body>
<script>
    window.onerror = function (err) {
        log('window.onerror: ' + err)
    }

    function setupWebViewJavascriptBridge(callback) {
        if (window.WebViewJavascriptBridge) {
            return callback(WebViewJavascriptBridge);
        }
        if (window.WVJBCallbacks) {
            return window.WVJBCallbacks.push(callback);
        }
        window.WVJBCallbacks = [callback];
        var WVJBIframe = document.createElement('iframe');
        WVJBIframe.style.display = 'none';
        WVJBIframe.src = 'wvjbscheme://__BRIDGE_LOADED__';
        document.documentElement.appendChild(WVJBIframe);
        setTimeout(function () {
            document.documentElement.removeChild(WVJBIframe)
        }, 0)
    }

    setupWebViewJavascriptBridge(function (bridge) {

        bridge.registerHandler('testJavascriptHandler', function (data, responseCallback) {
            var responseData = {'Javascript Says': 'Right back atcha!'}
            responseCallback(responseData)
        })

        var callbackButton = document.getElementById('buttons');
        callbackButton.onclick = function (e) {
            e.preventDefault()
            bridge.callHandler('shopping', {'url': 'cart/orderConfirm','state':"success"}, function (response) {
            })
        }
    })
</script>
<c:if test="${sessionScope['SPRING_SECURITY_CONTEXT'].authentication.principal.userId ne null}">
<div class="content-index pay-padding">
    <!--标题-->
    <header>
        购物车
        <!--操作按钮-->
        <div class="header-box">
            <%--<a href="">--%>
                <%--<p class="header-left">--%>
                    <%--<i class="icon icon-return"></i>--%>
                    <%--返回--%>
                <%--</p>--%>
            <%--</a>--%>
            <!--点击编辑出现删除商品按钮-->
            <p class="header-right">
                编辑
            </p>
        </div>
        <!--操作按钮 END-->
    </header>
    <!--标题 END-->
    <div id="goodsContainer" style="display: none;">
        <!--商品信息-->
        <div class="main-item">
            <div class="cartId" style="display: none;">1</div>
            <div class="goodsId" style="display: none;">1</div>
            <!--选择商品-->
            <label>
                <input class="select" name="itemContainer" type="checkBox">
            </label>
            <img class="goods-img" src="img/main-new1.png" alt="">

            <div class="goods-info">
                <p>H&M&nbsp;&nbsp;CARDIGAN</p>

                <p>尺寸&nbsp;:&nbsp;S</p>

                <p>￥35.50</p>
            </div>
            <!--删除商品按钮-->
            <button class="goods-del"></button>
            <!--删除商品按钮END-->
            <!--加减商品数量-->
            <div class="shopping-cart">
                <button class="shopping-cart-reduce"></button>
                <p class="shopping-cart-sum">1</p>
                <button class="shopping-cart-add"></button>
            </div>
            <!--加减商品数量END-->
        </div>
        <!--商品信息END-->
    </div>
    <div class="iscroll-wrapper" style="top:48px;bottom: -12px;">
        <div id="container">

        </div>
        <div class="blank"></div>
    </div>
    <!--付款按钮-->
    <div class="up-to-pay">
        <ul>
            <li>总计&nbsp;:&nbsp;<b>￥0.00</b></li>
            <li>
                <button class="pay" type="submit" id="buttons">结算</button>
            </li>
        </ul>
    </div>
    <form id="frmPay" action="cart/orderConfirm" method="get">
        <input type="hidden" name="cartIds">
    </form>
    <!--付款按钮END-->
    <!--底部导航-->
    <%--<div class="menu" id="menu">--%>
        <%--<a href="">--%>
            <%--<i class="icon-menu icon-menu1"><img src="img/footer-1.png" alt=""></i>--%>
        <%--</a>--%>
        <%--<a href="developing">--%>
            <%--<i class="icon-menu icon-menu2"><img src="img/footer-2.png" alt=""></i>--%>
        <%--</a>--%>
        <%--<a href="consignment">--%>
            <%--<i class="icon-menu icon-menu3"><img src="img/footer-3.png" alt=""></i>--%>
        <%--</a>--%>
        <%--<a href="user/shopping" >--%>
            <%--<i class="icon-menu icon-menu4"><img src="img/footer-c4.png" alt=""></i>--%>
        <%--</a>--%>
        <%--<a href="user">--%>
            <%--<i class="icon-menu icon-menu5"><img src="img/footer-5.png" alt=""></i>--%>
        <%--</a>--%>
    <%--</div>--%>
    <!--底部导航 END-->
</div>
</c:if>
<c:if test="${sessionScope['SPRING_SECURITY_CONTEXT'].authentication.principal.userId eq null}">
<div class="content-index">
    <div class="share-bottom">
        <img src="img/AppIcon-120.png" alt="">
        <p>您还未登录！</p>
        <%--<a href="#" class="share-bottom" >--%>
            <%--<button>去登录</button>--%>
        <%--</a>--%>
        <!--发布成功提示END-->
    </div>
</div>
</c:if>
</body>
</html>