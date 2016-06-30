<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!--动态获取主机的url信息-->
<%
    StringBuffer localurl = request.getRequestURL();
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>首页</title>
    <meta name="viewport"
          content="maximum-scale=1.0,minimum-scale=1.0,user-scalable=no,width=device-width,initial-scale=1.0"/>
    <!-- 禁止将数字变为电话号码 -->
    <meta name="format-detection" content="telephone=no"/>
    <!-- iphone设备中的safari私有meta标签,允许全屏模式浏览，隐藏浏览器导航栏 -->
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <!-- iphone的私有标签,它指定的iphone中safari顶端的状态条的样式 -->
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <link rel="stylesheet" href="css/scrollbar.css">
    <link rel="stylesheet" href="css/index.css">
    <link rel="stylesheet" href="css/public.css">
</head>
<body>
<section class="header-top" id="header-top">
    <div class="fanhui"><a href="login.html"><img src="img/back.png" alt=""></a><a href="login.html" class="tiaozhuan"
                                                                                   id="sy">登录</a></div>
    <div class="shouye"><p>首页</p></div>
</section>
<!-- 顶部搜索框 -->
<div id="wrapper">
    <div id="scroller">
        <div id="header" class="home">
            <div class="slidebar" id="slidebar">
                <img src="img/menu.png" alt="">
            </div>
            <div class="search">
                <i id="search" class="search-button"></i>
                <input type="text" name="search" style="border:none;" id="input">
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

        <section class="slider" id="slider">
            <ul id="imgs">
            </ul>
            <ul id="position">
                <li class="cur"></li>
                <li></li>
                <li></li>
                <li></li>
            </ul>
        </section>

        <div class="main" id="main">
            <figure class="title" id="title">
                <ul>
                    <li class="active"><a href="/">新品</a></li>
                    <!-- 防止a标签的跳转 -->
                    <li><a href="javascript:;">猜你喜欢</a></li>
                </ul>

            </figure>
            <div style="display: none">
                <figure id="figNewGoods" onclick=window.location.href="/goodsDetail?id=${goods.id}">
                    <img src="/upload/${goods.picture}" alt="图片">
                    <figcaption>
                        <p><span>￥${goods.price/100}</span><span>${goods.newDegree}</span></p>

                        <p>${goods.brand}&nbsp;${goods.title}</p>
                    </figcaption>
                </figure>
            </div>
            <section id="newGoods" class="main-cons">

            </section>

            <section id="btnLoadMore" class="main-cons" style="display:block">
                <div id="main-cons"></div>
                <div id="pullUp">
                    <span class="pullUpIcon"></span><span id="loadMore" class="pullUpLabel">加载更多</span>
                </div>
            </section>

            <section class="main-cons" style="display:none">
                <div class="youlike">
                    <p>系统正在为您查询您感兴趣的宝物......</p>

                    <p>请填写以下信息</p>
                    <ul>
                        <li><label>宝宝姓名：</label><label><input type="text" id="username"></label></li>
                        <li><label>宝宝生日：</label><label><input type="date"></label></li>
                        <li><label>宝宝性别：</label><label><select name="" id="sex">
                            <option value="">男</option>
                            <option value="">女</option>
                        </select></label></li>
                        <li><label>宝宝爱好：</label><label><input type="text"></label></li>
                    </ul>
                    <div class="like-up">
                        <input type="button" style="border:none" value="提交" id="like-up">
                    </div>
                </div>
            </section>
        </div>


        <!-- <section class="clear"></section>-->
    </div>
</div>
<div class="back-top" id="back-top">
    <p>回到顶部</p>
</div>

<div class="menu" id="footer">
    <a href="index.jsp">
        <i class="icon-menu icon-menu1"><img src="img/footer-c1.png" alt=""></i>
    </a>
    <a>
        <i class="icon-menu icon-menu2"><img src="img/footer-2.png" alt=""></i>
    </a>
    <a href="consignment.html">
        <i class="icon-menu icon-menu3"><img src="img/footer-3.png" alt=""></i>
    </a>
    <a href="javascript:;" id="shopping">
        <i class="icon-menu icon-menu4"><img src="img/footer-4.png" alt=""></i>
    </a>
    <a href="personal.jsp">
        <i class="icon-menu icon-menu5"><img src="img/footer-5.png" alt=""></i>
    </a>
</div>

<script type="text/javascript" src="js/jquery.1.10.2.js"></script>
<script type="text/javascript" src="js/ajax.js"></script>
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
                    newfig.find("figcaption>p:eq(1)").text(item['brand']+" "+item['title']);
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