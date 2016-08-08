<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/" + "MaBao/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
    <title>我是买家</title>
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
    <link rel="stylesheet" href="css/transport.css">
</head>

<body>

<!--标题-->
<header>
    查看物流
    <!--操作按钮-->
    <div class="header-box">
        <a href="user">
            <p class="header-left">
                <i class="icon icon-return"></i>
                返回
            </p>
            <!--点击编辑出现删除商品按钮-->
        </a>

    </div>
    <!--操作按钮 END-->
</header>
<!--标题 END-->

<div data-mohe-type="kuaidi_new" class="g-mohe content-index" id="mohe-kuaidi_new">
    <c:if test="${expressVO ne null}">
        <div class="transport-box">
            <p>物流公司: <span>${expressVO.company}</span></p>
            <p>运单号: <span>${expressVO.portNum}</span></p>
        </div>
        <div id="mohe-kuaidi_new_nucom">
            <div class="mohe-wrap mh-wrap">
                <div class="mh-cont mh-list-wrap mh-unfold">
                    <div class="mh-list">
                        <ul>
                            <c:forEach items="${expressVO.contentList}" var="contentVO" varStatus="state">
                                <li <c:if test="${state.first}">class="first"</c:if>>
                                    <p>${contentVO.time}</p>
                                    <p>${contentVO.context}</p>
                                    <span class="before"></span><span class="after"></span>
                                    <c:if test="${state.first}"><i class="mh-icon mh-icon-new"></i></c:if>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </c:if>
    <c:if test="${expressVO eq null}">
        暂无物流信息
    </c:if>
</div>

</body>
</html>