<%--
  Created by IntelliJ IDEA.
  User: makaiqin
  Date: 2016/6/30
  Time: 17:56
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>首页</title>
    <meta name="viewport" content="maximum-scale=1.0,minimum-scale=1.0,user-scalable=no,width=device-width,initial-scale=1.0"/>
    <!-- 禁止将数字变为电话号码 -->
    <meta name="format-detection" content="telephone=no" />
    <!-- iphone设备中的safari私有meta标签,允许全屏模式浏览，隐藏浏览器导航栏 -->
    <meta name="apple-mobile-web-app-capable" content="yes" />
    <!-- iphone的私有标签,它指定的iphone中safari顶端的状态条的样式 -->
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <!--<link rel="stylesheet" href="css/scrollbar.css"> -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/index.css">
    <link rel="stylesheet" href="css/public.css">
    <style type="text/css">
        #header-top{position: fixed;top: 0;}
        #header{position: fixed;top: 0;left: 0;width: 100%;}
        .main{padding-top:23rem; }
    </style>
</head>
<body>
<section class="header-top" id="header-top">
    <div class="fanhui"><a onclick=window.location.href="login.html"><img src="img/back.png" alt=""></a><a onclick=window.location.href="login.html" class="tiaozhuan" id="sy">返回</a></div>
    <div class="shouye" ><p>首页</p></div>
</section>
<!-- 顶部搜索框 -->
<div  id="header" >
    <div class="home" >
        <div class="slidebar" id="slidebar">
            <img src="img/menu.png" alt="">
        </div>
        <div class="search">
            <i id="search" class="search-button"></i>
            <input type="text" name="search"  style="border:none;" id="input">
        </div>
    </div>
    <!-- 隐藏分类 -->
    <section class="classify" id="classify">
        <ul>
            <!--商品类别列表-->
            <c:forEach var="selector" items="${goodsTypeSelector}">
                <li><a href="/goods/goodsType?typeName=${selector.value}&page=0&size=4">
                        ${selector.value}</a></li>
            </c:forEach>
        </ul>
    </section>
    <div id="myCarousel" class="carousel slide" >
        <!-- 轮播（Carousel）指标 -->
        <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
        </ol>
        <!-- 轮播（Carousel）项目 -->
        <div class="carousel-inner">
            <c:forEach items="goods" var="${circleList}">
                <c:if test="${var.index==0}">
            <div class="item active">
                <img src="/upload/${goods.picture}" alt="First slide" href="/goodsDetail?id=${goods.id}">
            </div>
                </c:if>
                <c:if test="${var.index>0}">
                <div class="item">
                <img src="/upload/${goods.picture}" alt="Second slide" href="/goodsDetail?id=${goods.id}">
            </div>
                </c:if>
            </c:forEach>
        </div>
        <!-- 轮播（Carousel）导航 -->
        <a class="carousel-control left" href="#myCarousel"
           data-slide="prev">&lsaquo;</a>
        <a class="carousel-control right" href="#myCarousel"
           data-slide="next">&rsaquo;</a>
    </div>
    <div class="title" id="title">
        <ul>
            <li class="active" onclick="_block()" >
                <a id="acta" href="javascript:;">新品</a></li>
            <!-- 防止a标签的跳转 -->
            <li onclick="_block()"><a href="javascript:;">猜你喜欢</a></li>
        </ul>
    </div>
</div>
<form class="main" id="main" action="" method="">
    <!-- 新品 -->
    <section class="main-cons"  style="display:block">
        <div style="display: none">
            <c:forEach items="goods" var="${circleList}">
            <figure id="figNewGoods" onclick=window.location.href="/goodsDetail?id=${goods.id}">
                <img src="/upload/${goods.picture}" alt="图片">
                <figcaption>
                    <p><span>￥${goods.price/100}</span><span>${goods.newDegree}</span></p>
                    <p>${goods.brand}&nbsp;${goods.title}</p>
                </figcaption>
            </figure>
            </c:forEach>
        </div>
        <section id="newGoods" class="main-cons">
        </section>
        <!-- 猜你喜欢 -->
        <section class="main-cons" style="display:none">
            <div class="youlike">
                <p>系统正在为您查询您感兴趣的宝物......</p>
                <p>请填写以下信息</p>
                <ul>
                    <li><label for="">宝宝姓名：</label><label for=""><input type="text" id="username"></label></li>
                    <li><label for="">宝宝生日：</label><label for=""><input type="date"></label></li>
                    <li><label for="">宝宝性别：</label><label for=""><select name="" id="sex"><option value="">男</option><option value="">女</option></select></label></li>
                    <li><label for="">宝宝爱好：</label><label for=""><input type="text"></label></li>
                </ul>
                <div class="like-up">
                    <input type="button" style="border:none" value="提交" id="like-up">
                </div>
            </div>
        </section>
        <section id="btnLoadMore" class="main-cons" style="display:block">
            <div id="main-cons"></div>
            <div id="pullUp">
                <span class="pullUpIcon"></span><span id="loadMore" class="pullUpLabel">加载更多</span>
            </div>
        </section>
    </section>
</form>
<div class="back-top" id="back-top">
    <p><a href="#main">回到顶部</a></p>
</div>
<div class="menu" id="footer">
    <a   href="index.html">
        <i class="icon-menu icon-menu1"><img src="img/footer-c1.png" alt=""></i>
    </a>
    <a>
        <i class="icon-menu icon-menu2"><img src="img/footer-2.png" alt=""></i>
    </a>
    <a  href="consignment.html">
        <i class="icon-menu icon-menu3"><img src="img/footer-3.png" alt=""></i>
    </a>
    <a  href="javascript:;" id="shopping">
        <i class="icon-menu icon-menu4"><img src="img/footer-4.png" alt=""></i>
    </a>
    <a  href="personal.html">
        <i class="icon-menu icon-menu5"><img src="img/footer-5.png" alt=""></i>
    </a>
</div>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script>
    $(function(){
        var currentPage=0;
        var pageSize=4;
        var totalPage=0;
        var totalCount=0;
        $("#loadMore").click(function(){
            if(currentPage<totalPage){
                currentPage++;
                loadingResult();
            }
        });
        /**
         *  加载新品上市数据
         */
        var loadingResult=function(){
            $.get("",{currentPage:currentPage,pageSize:pageSize},function(data){
                currentPage=data.currentPage;
                pageSize=data.pageSize;
                totalPage=data.totalPage;
                totalCount=data.totalCount;
                //如果没有更多的数据则隐藏加载更多按钮
                if(currentPage==totalPage){
                    $("#btnLoadMore").hide();
                }
                var items=data.items;
                for(var i=0;i<items.length;i++){
                    var item=items[i];
                    var newfig=$("#figNewGoods").clone();
                    var clickUrl="/goodsDetail?id="+item.id;
                    newfig.find("img").attr("src","/upload/"+item['picture']);
                    newfig.find("figcaption>p:eq(0)>span:eq(0)").text("￥"+item.price/100);
                    newfig.find("figcaption>p:eq(0)>span:eq(1)").text(item['newDegree']);
                    newfig.find("figcaption>p:eq(1)").text(item['brand']);
                    newfig.find("figcaption>p:eq(2)").text(item['title']);
                    newfig.click(function(){
                        window.location.href=clickUrl;
                    });
                    $("#newGoods").append(newfig);
                }
            },"json");
        };
        loadingResult();
    });
</script>
</body>
</html>
