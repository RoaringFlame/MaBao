<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>首页</title>
    <meta name="viewport"
          content="maximum-scale=1.0,minimum-scale=1.0,user-scalable=no,width=device-width,initial-scale=1.0"/>
    <!-- 禁止将数字变为电话号码 -->
    <meta name="format-detection" content="telephone=no"/>
    <!-- iphone设备中的safari私有meta标签,允许全屏模式浏览，隐藏浏览器导航栏 -->
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <!-- iphone的私有标签,它指定的iphone中safari顶端的状态条的样式 -->
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <!--     <link rel="stylesheet" href="css/scrollbar.css"> -->

    <link href="../../css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../../css/public.css">
    <link rel="stylesheet" href="../../css/index.css">
    <style type="text/css">
        .carousel-inner > .item > img {
            margin: 0 auto;
            max-width: 32rem;
            height: 11rem;
        }

    </style>
</head>
<body>
<section class="header-top" id="header-top">

    <div class="fanhui"><a onclick=window.location.href="login.html"><img src="../../img/back.png" alt=""></a><a
            onclick=window.location.href="login.html" class="tiaozhuan" id="sy">返回</a></div>
    <div class="shouye"><p>首页</p></div>

</section>
<!-- 顶部搜索框 -->
<div id="header">
    <div class="home">
        <div class="slidebar" id="slidebar" onclick="_block()">
            <img src="../../img/menu.png" alt="">
        </div>
        <form  method="post" name="search">
            <div class="search">
                <i type="submit" id="search" class="search-button" onclick="searchsubmit()"></i>
                <input type="text" name="search" style="border:none;" id="input">
            </div>
        </form>
    </div>
    <!-- 隐藏分类 -->
    <section class="classify" id="classify">
        <ul>
            <c:forEach var="selector" items="${goodsTypeSelector}">
                <li><a href="/goods/goodsType?typeName=${selector.value}&page=0&size=4">
                        ${selector.value}</a></li>
            </c:forEach>
        </ul>
    </section>

    <div id="myCarousel" class="carousel slide">
        <!-- 轮播（Carousel）指标 -->
        <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
        </ol>
        <!-- 轮播（Carousel）项目 -->
        <div class="carousel-inner">
            <c:forEach var="goods" items="${circleList}" varStatus="var">
                <c:if test="${var.index==0}">
                    <div class="item active">
                        <img src="/upload/${goods.picture}" alt="First slide"
                             onclick=window.location.href="/goodsDetail?id=${goods.id}">
                    </div>
                </c:if>
                <c:if test="${var.index>0}">
                    <div class="item">
                        <img src="/upload/${goods.picture}" alt="Second slide"
                             onclick=window.location.href="/goodsDetail?id=${goods.id}">
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
            <li class="focus" onclick="_block1()">新品</li>
            <!-- 防止a标签的跳转 -->
            <li class="li.2" onclick="_block2()">猜你喜欢</li>
        </ul>
    </div>
</div>

<div class="main" id="main" action="" method="">
    <!-- 新品 -->
    <section class="main-cons" id="showNewGoods" style="display:block">
        <div style="display:none">
            <figure id="figNewGoods" onclick=window.location.href="#">
                <img src="../../img/main-new1.png" alt="">
                <figcaption>
                    <p><span>￥30.00</span><span>九成新</span></p>
                    <p>H&M&nbsp;CARDIGN</p>
                    <p>纯棉轻薄，无刺激，适合宝宝娇嫩肌肤</p>
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
            <div class="clear"  ></div>
        </section>
    </section>
    <!-- 猜你喜欢 -->
    <section class="main-cons" id="youLike" style="display:none">
        <div class="youlike">
            <form method="post" name="babyform">
                <p>系统正在为您查询您感兴趣的宝物......</p>
                <p>请填写以下信息</p>
                <ul>
                    <li><label for="">宝宝姓名：</label><label for=""><input type="text" id="username"
                                                                        name="babyName"></label></li>

                    <li><label for="">宝宝生日：</label><label for=""><input type="date" name="babyBirth"></label></li>

                    <li><label for="">宝宝性别：</label><label for=""><select name="babySex" id="sex">
                        <option value="男">男</option>
                        <option value="女">女</option>
                    </select></label></li>

                    <li><label for="">宝宝爱好：</label><label for=""><input type="text" name="babyHobby"></label></li>
                </ul>
                <div class="like-up">
                    <input type="button" style="border:none" value="提交" id="like-up" onclick=formsubmit()>
                </div>
            </form>
            <div class="clear"></div>
        </div>
    </section>
</div>
<%--为按钮添加事件--%>
<script type="text/javascript">
    function formsubmit() {
        document.babyform.action = "/goodsTable";
        document.babyform.submit();
    }

    function searchsubmit() {
        document.search.action = "/goodsTitle";
        document.search.submit();
    }
</script>


<div class="back-top" id="back-top">
    <p><a href="#main">回到顶部</a></p>
</div>

<div class="menu" id="footer">
    <a href="index.jsp">
        <i class="icon-menu icon-menu1"><img src="../../img/footer-c1.png" alt=""></i>
    </a>
    <a>
        <i class="icon-menu icon-menu2"><img src="../../img/footer-2.png" alt=""></i>
    </a>
    <a href="consignment.html">
        <i class="icon-menu icon-menu3"><img src="../../img/footer-3.png" alt=""></i>
    </a>
    <a href="javascript:;" id="shopping">
        <i class="icon-menu icon-menu4"><img src="../../img/footer-4.png" alt=""></i>
    </a>
    <a href="personal.html">
        <i class="icon-menu icon-menu5"><img src="../../img/footer-5.png" alt=""></i>
    </a>
</div>

<script src="../../js/jquery.min.js"></script>
<script src="../../js/bootstrap.min.js"></script>
<script src="../../js/_index.js"></script>


<!-- // (function($){
// 	$(function(){
// 		var $nav=$('#title')
// 		   $current_item=$nav.find('.focus'),
// 		   $lava=$('<li class="lava"/>');
// 	});
// })(jQuery);

// $lava.css({
// 	background:'#ccc'
// }).appendTo($nav.find('ul')); -->
<!-- $("").css("display","none").siblings().css("display",'none'); -->
<script>

    $(document).ready(function () {
        $(".focus").click(function () {
            $('li.focus').siblings().css('color', '#fff;');
        });
    });

    $(document).ready(function () {
        $(".li2").click(function () {
            $('li.li2').siblings().css('color', '#fff;');
        });
    });


</script>
</body>
</html>