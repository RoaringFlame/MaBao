<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>


    <link rel="stylesheet" href="../../css/bootstrap.min.css">
    <link rel="stylesheet" href="../../css/master.css">
    <link rel="stylesheet" href="../../css/module.css">
</head>

<body>
<div class="content-index">
    <!--标题-->
    <header>
        首页
        <!--操作按钮-->
        <div class="header-box">
            <a href="#">
                <button class="header-left">
                    <i class="icon icon-return"></i>
                    登陆
                </button>
            </a>
        </div>
        <!--操作按钮 END-->
    </header>
    <!--标题 END-->

    <!--搜索框-->
    <div class="search">
        <div class="column">
            <i class="icon icon-dire"></i>
        </div>
        <div class="search-input">
            <button>
                <i class="icon icon-search"></i>
            </button>
            <input title="请输入关键字">
        </div>
    </div>
    <!-- 侧导航栏 -->
    <div class="sidebar" id="sidebar">
        <ul>
            <li><a href="#">婴儿车</a></li>
            <li><a href="#">安全座椅</a></li>
            <li><a href="#">玩具</a></li>
            <li><a href="#">家具家电</a></li>
            <li><a href="#">服饰鞋帽</a></li>
            <li><a href="#">图片绘本</a></li>
            <li><a href="#">其它产品</a></li>
        </ul>
    </div>
    <!--搜索框 END-->

    <!--轮播图-->
    <div id="myCarousel" class="carousel slide">
        <!-- 轮播（Carousel）指标 -->
        <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
        </ol>
        <!-- 轮播（Carousel）项目 -->
        <div class="carousel-inner">
            <div class="item active">
                <img src="../img/img-01.png" alt="First slide">
            </div>
            <div class="item">
                <img src="../img/img-01.png" alt="Second slide">
            </div>
            <div class="item">
                <img src="../img/img-01.png" alt="Third slide">
            </div>
        </div>
        <!-- 轮播（Carousel）导航 -->
        <a class="carousel-control left" href="#myCarousel"
           data-slide="prev">&lsaquo;</a>
        <a class="carousel-control right" href="#myCarousel"
           data-slide="next">&rsaquo;</a>
    </div>
    <!--轮播图 END-->
    <!--商品-->
    <div class="goods">
        <!-- 功能切换-->
        <div class="scroll-menu">
            <ul>
                <li><a class="focus" href="">新品</a></li>
                <li><a href="">猜你喜欢</a></li>
            </ul>
        </div>
        <!-- 功能切换 END-->
        <ul class="goods-list clearfix">
            <!--部品列表-->
            <li>
                <img src="../img/main-new1.png" alt="">
                <div>
                    <p>
                        <span>￥30.00</span>
                        <span>九成新</span>
                    </p>
                    <p>H&M&nbsp;CARDIGN</p>
                    <p>纯棉轻薄，无刺激，适合宝宝娇嫩肌肤</p>
                </div>
            </li>
            <!--部品列表 END-->
            <!--部品列表-->
            <li>
                <img src="../img/main-new1.png" alt="">
                <div>
                    <p>
                        <span>￥30.00</span>
                        <span>九成新</span>
                    </p>
                    <p>H&M&nbsp;CARDIGN</p>
                    <p>纯棉轻薄，无刺激，适合宝宝娇嫩肌肤</p>
                </div>
            </li>
            <!--部品列表 END-->
            <!--部品列表-->
            <li>
                <img src="../img/main-new1.png" alt="">
                <div>
                    <p>
                        <span>￥30.00</span>
                        <span>九成新</span>
                    </p>
                    <p>H&M&nbsp;CARDIGN</p>
                    <p>纯棉轻薄，无刺激，适合宝宝娇嫩肌肤</p>
                </div>
            </li>
            <!--部品列表 END-->
            <!--部品列表-->
            <li>
                <img src="../img/main-new1.png" alt="">
                <div>
                    <p>
                        <span>￥30.00</span>
                        <span>九成新</span>
                    </p>
                    <p>H&M&nbsp;CARDIGN</p>
                    <p>纯棉轻薄，无刺激，适合宝宝娇嫩肌肤</p>
                </div>
            </li>
            <!--部品列表 END-->
            <!--部品列表-->
            <li>
                <img src="../img/main-new1.png" alt="">
                <div>
                    <p>
                        <span>￥30.00</span>
                        <span>九成新</span>
                    </p>
                    <p>H&M&nbsp;CARDIGN</p>
                    <p>纯棉轻薄，无刺激，适合宝宝娇嫩肌肤</p>
                </div>
            </li>
            <!--部品列表 END-->
            <!--部品列表-->
            <li>
                <img src="../img/main-new1.png" alt="">
                <div>
                    <p>
                        <span>￥30.00</span>
                        <span>九成新</span>
                    </p>
                    <p>H&M&nbsp;CARDIGN</p>
                    <p>纯棉轻薄，无刺激，适合宝宝娇嫩肌肤</p>
                </div>
            </li>
            <!--部品列表 END-->
        </ul>
        <!-- 猜你喜欢 -->
        <form action="" style="display:none">
            <div class="you-like">
                <p>系统正在为您查询您感兴趣的宝物......</p>
                <p>请填写以下信息</p>
                <ul>
                    <li>
                        <label>宝宝姓名：</label>
                        <label><input name="babyName" type="text" id="username"></label>
                    </li>
                    <li>
                        <label>宝宝生日：</label>
                        <label><input name="babyData" type="date"></label>
                    </li>

                    <li>
                        <label>宝宝性别：</label>
                        <label>
                            <select name="sex" id="sex">
                                <option value="">男</option>
                                <option value="">女</option>
                            </select>
                        </label>
                    </li>

                    <li>
                        <label>宝宝爱好：</label>
                        <label><input type="text"></label>
                    </li>
                </ul>
                <button class="like-up-button" type="submit">提交</button>
            </div>
        </form>
        <!-- 猜你喜欢END -->

        <jsp:include page="../../page/footer.html"/>
    </div>
</div>
</body>
<script>
    $(function(){
        alert(1);
    });
</script>
</html>
