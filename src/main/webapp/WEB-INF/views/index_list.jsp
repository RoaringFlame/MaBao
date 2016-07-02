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
<!--     <link rel="stylesheet" href="css/scrollbar.css"> -->
	<link rel="stylesheet" href="../../css/index.css">
	<link rel="stylesheet" href="../../css/public.css">
	<style type="text/css">
        #header-top{position: fixed;top: 0;}
        .menu_list{position: fixed;top: 0;left: 0;width: 100%;}
        .main{padding-top:11.5rem; }
	</style>
</head>
  <body>
    <section class="header-top" id="header-top">

	    <div class="fanhui"><a href="index.jsp" ><img src="../../img/back.png" alt=""></a><a href="javascript:;" class="tiaozhuan" id="sy">返回</a></div>
	    <div class="shouye" ><p>首页</p></div>

    </section>
    <!-- 顶部搜索框 -->
  
    <div class="menu_list"> 
		<div id="header" class="home">
		  	<div class="slidebar" id="slidebar" onclick="_block()">
		  		<img src="../../img/menu.png" alt="">
		  	</div>
		  	<div class="search">
		  	<i id="search" class="search-button"></i>
		  	<input type="text" name="search"  style="border:none;" id="input">
		  	</div>	
		</div>
	    <!-- 隐藏分类 -->
		<section class="classify" id="classify" style="display: none;" >
			<ul>
				<li><a href="javascript:;">婴儿车</a></li>
				<li><a href="javascript:;">安全座椅</a></li>
				<li><a href="javascript:;">玩具</a></li>
				<li><a href="javascript:;">家具家电</a></li>
				<li><a href="javascript:;">服饰鞋帽</a></li>
				<li><a href="javascript:;">图片绘本</a></li>
				<li><a href="javascript:;">其它产品</a></li>
			</ul>
		</section>
	      
		<div class="title" id="title">
	   	<ul>
	   		<li class="active" >
	   		<a id="acta" href="javascript:;">综合</a>
	   		</li>
	   		<!-- 防止a标签的跳转 -->
	   		<li><a href="javascript:;">销量</a></li>
	   		<li><a href="javascript:;">新品</a></li>
	   		<li><a href="javascript:;">价格</a></li>
	   	</ul>
	   	</div>
    </div> 
    
	<form class="main" id="main" action="" method="">
	    <section class="main-cons" id="main-cons">
		   	<figure onclick=window.location.href="detail.html">
				    <img src="../../img/main-new1.png" alt="">
					<figcaption>
						<p><span>￥30.00</span><span>九成新</span></p>
						<p>H&M&nbsp;CARDIGN</p>
						<p>纯棉轻薄，无刺激，适合宝宝娇嫩肌肤</p>
					</figcaption>
			</figure>
			<figure>
				    <img src="../../img/main-new1.png" alt="">
					<figcaption>
						<p><span>￥30.00</span><span>九成新</span></p>
						<p>H&M&nbsp;CARDIGN</p>
						<p>纯棉轻薄，无刺激，适合宝宝娇嫩肌肤</p>
					</figcaption>
			</figure>
			<figure>
				    <img src="../../img/main-new1.png" alt="">
					<figcaption>
						<p><span>￥30.00</span><span>九成新</span></p>
						<p>H&M&nbsp;CARDIGN</p>
						<p>纯棉轻薄，无刺激，适合宝宝娇嫩肌肤</p>
					</figcaption>
			</figure>
			<figure>
				    <img src="../../img/main-new1.png" alt="">
					<figcaption>
						<p><span>￥30.00</span><span>九成新</span></p>
						<p>H&M&nbsp;CARDIGN</p>
						<p>纯棉轻薄，无刺激，适合宝宝娇嫩肌肤</p>
					</figcaption>
			</figure>
			<figure>
				    <img src="../../img/main-new1.png" alt="">
					<figcaption>
						<p><span>￥30.00</span><span>九成新</span></p>
						<p>H&M&nbsp;CARDIGN</p>
						<p>纯棉轻薄，无刺激，适合宝宝娇嫩肌肤</p>
					</figcaption>
			</figure>
			<figure>
				    <img src="../../img/main-new1.png" alt="">
					<figcaption>
						<p><span>￥30.00</span><span>九成新</span></p>
						<p>H&M&nbsp;CARDIGN</p>
						<p>纯棉轻薄，无刺激，适合宝宝娇嫩肌肤</p>
					</figcaption>
			</figure>
			<figure>
				    <img src="../../img/main-new1.png" alt="">
					<figcaption>
						<p><span>￥30.00</span><span>九成新</span></p>
						<p>H&M&nbsp;CARDIGN</p>
						<p>纯棉轻薄，无刺激，适合宝宝娇嫩肌肤</p>
					</figcaption>
			</figure>
			<figure>
				    <img src="../../img/main-new1.png" alt="">
					<figcaption>
						<p><span>￥30.00</span><span>九成新</span></p>
						<p>H&M&nbsp;CARDIGN </p>
						<p>纯棉轻薄，无刺激，适合宝宝娇嫩肌肤</p>
					</figcaption>
			</figure>
        </section>

		<div class="clear" style="height: 0"></div>
  		<div id="pullUp">
			<button class="pullUpLabel" type="submit" >点击加载更多</button>
		</div>
		<div class="clear" ></div>
   </form>

    <div class="back-top" id="back-top">
    	<p><a href="#main">回到顶部</a></p>
    </div>

	<div class="menu" id="footer">
            <a   href="index.jsp">
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

<script type="text/javascript">
     function _block(){
        var mychar=document.getElementById('classify');
        if(mychar.style.display=="none")
        {
        mychar.style.display="block";
        }
        else
        {
        mychar.style.display="none";
        }
    }
</script>	
</body>
</html>