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
    <link href="../../css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../../css/scrollbar.css">
    <link rel="stylesheet" href="../../css/index.css">
    <link rel="stylesheet" href="../../css/public.css">
    <style type="text/css">
        .carousel-inner>.item>img{margin: 0 auto;max-width :32rem;height:11rem;}
    </style>
</head>
<body>
主页存在问题，待修复
<section class="header-top" id="header-top">

    <div class="fanhui"><a href="../login.html" ><img src="../../img/back.png" alt=""></a>
        <a href="javascript:;" class="tiaozhuan" id="sy">返回</a></div>
    <div class="shouye" ><p>首页</p></div>

</section>
<!-- 顶部搜索框 -->
<div id="wrapper">
    <div id="scroller">

        <div id="header" class="home">
            <div class="slidebar" id="slidebar">
                <img src="../../img/menu.png" alt="">
            </div>
            <div class="search">
                <i type="button" id="search" class="search-button" onclick="searchSubmit()"></i>
                <input type="text" name="search"  style="border:none;" id="input">
            </div>
        </div>
        <!-- 隐藏分类 -->
        <section class="classify" id="classify">
            <ul>
                <c:forEach var="selector" items="${goodsTypeSelector}">
                    <li><a href="/goodsType?typeName=${selector.value}&page=0&size=4">
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
                <div class="item active">
                    <c:forEach var="goods" items="${circleList}" varStatus="var">
                        <c:if test="${var.index==0}">
                            <div class="item active">
                                <img src="/upload/${goods.picture}" alt="First slide"
                                     onclick=window.location.href="/goods/goodsDetail?id=${goods.id}">
                            </div>
                        </c:if>
                        <c:if test="${var.index>0}">
                            <div class="item">
                                <img src="/upload/${goods.picture}" alt="Second slide"
                                     onclick=window.location.href="/goods/goodsDetail?id=${goods.id}">
                            </div>
                        </c:if>
                    </c:forEach>
                </div>
            </div>
            <!-- 轮播（Carousel）导航 -->
            <a class="carousel-control left" href="#myCarousel"
               data-slide="prev">&lsaquo;</a>
            <a class="carousel-control right" href="#myCarousel"
               data-slide="next">&rsaquo;</a>
        </div>


        <div class="title" id="title">
            <ul>
                <li class="focus">新品</li>
                <!-- 防止a标签的跳转 -->
                <li>猜你喜欢</li>
            </ul>
        </div>

        <!--新品-->
        <div class="main" id="main">
            <section class="main-cons"  style="display:block">
                <div id="main-cons">
                    <!--逐一获取新品的信息·并显示出来-->
                    <c:forEach var="goods" items="${goodsList}" >
                    <div style="display:none">
                        <figure id="figNewGoods" onclick=window.location.href="#">
                            <!--商品图片信息-->
                            <img src="../../upload/${detail.png}" alt="">
                            <figcaption>
                                <!--商品价格信息-->
                                <p><span>￥<fmt:formatNumber type="number" value="${goods.price/100}"
                                                            pattern="0.00" maxFractionDigits="2"/></span>
                                    <span><c:out value="${goods.newDegree>0?goods.newDegree+'成新':'全新'}" /></span></p>
                                <!--商品品牌信息-->
                                <p><c:out value="${goods.brand}"/></p>
                                <%--<p>纯棉轻薄，无刺激，适合宝宝娇嫩肌肤</p>--%>
                            </figcaption>
                        </figure>
                    </div>
                    </c:forEach>
                </div>


                <div id="pullUp">
                    <span class="pullUpIcon"></span><span class="pullUpLabel">加载更多</span>
                </div>
            </section>

            <section class="main-cons" style="display:none">
                <div class="youlike">
                    <form method="post" name="babyForm">
                    <p>系统正在为您查询您感兴趣的宝物......</p>
                    <p>请填写以下信息</p>
                    <ul>
                        <li><label for="" >宝宝姓名：</label><label for=""><input type="text" id="username"></label></li>

                        <li><label for="">宝宝生日：</label><label for=""><input type="date"></label></li>

                        <li><label for="">宝宝性别：</label><label for=""><select name="" id="sex">
                            <option value="">男</option><option value="">女</option></select></label></li>

                        <li><label for="">宝宝爱好：</label><label for=""><input type="text"></label></li>
                    </ul>
                    <div class="like-up">
                        <input type="button" style="border:none" value="提交" id="like-up" onclick=formSubmit()>
                    </div>
                    </form>
                </div>
            </section>
        </div>
        <%--为按钮添加事件--%>
        <script type="text/javascript">
            function formSubmit() {
                document.babyForm.action = "/goodsTable";
                document.babyForm.submit();
            }
            function searchSubmit() {
                document.search.action = "/goodsTitle";
                document.search.submit();
            }
        </script>

    </div>
</div>
<div class="back-top" id="back-top">
    <p>回到顶部</p>
</div>

<div class="menu" id="footer">
    <a   href="index.html">
        <i class="icon-menu icon-menu1"><img src="../../img/footer-c1.png" alt=""></i>
    </a>
    <a>
        <i class="icon-menu icon-menu2"><img src="../../img/footer-2.png" alt=""></i>
    </a>
    <a  href="consignment.html">
        <i class="icon-menu icon-menu3"><img src="../../img/footer-3.png" alt=""></i>
    </a>
    <a  href="javascript:;" id="shopping">
        <i class="icon-menu icon-menu4"><img src="../../img/footer-4.png" alt=""></i>
    </a>
    <a  href="personal.html">
        <i class="icon-menu icon-menu5"><img src="../../img/footer-5.png" alt=""></i>
    </a>
</div>


<script type="text/javascript" src="../../js/jquery.1.10.2.js"></script>
<script type="text/javascript" src="../../js/dataBind.js"></script>
<script type="text/javascript" src="../../js/hhSwipe.js"></script>
<script type="text/javascript" src="../../js/iscroll.js"></script>
<script type="text/javascript" src="../../js/analyPara.js"></script>
<script type="text/javascript" src="../../js/jquery.min.js"></script>
<script type="text/javascript" src="../../js/bootstrap.min.js"></script>
<script>
    $('.carousel').carousel({
        interval: 2500
    })
</script>
</html>
