<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>首页</title>
	<meta name="viewport" content="maximum-scale=1.0,minimum-scale=1.0,user-scalable=no,width=device-width,initial-scale=1.0"/>
	<!-- 禁止将数字变为电话号码 -->
	<meta name="format-detection" content="telephone=no" />
	<!-- iphone设备中的safari私有meta标签,允许全屏模式浏览，隐藏浏览器导航栏 -->
	<meta name="apple-mobile-web-app-capable" content="yes" />
	<!-- iphone的私有标签,它指定的iphone中safari顶端的状态条的样式 -->
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
    <link rel="stylesheet" href="/resources/css/scrollbar.css">
	<link rel="stylesheet" href="/resources/css/index.css">
	<link rel="stylesheet" href="/resources/css/public.css">
</head>
  <body>
    <section class="header-top" id="header-top">

	    <div class="fanhui"><a href="login.html" ><img src="/resources/img/back.png" alt=""></a><a href="login.html" class="tiaozhuan" id="sy">登录</a></div>
	    <div class="shouye" ><p>首页</p></div>

    </section>
    <!-- 顶部搜索框 -->
  
<div id="wrapper">
   <div id="scroller">
   
	<div id="header" class="home">
	  	<div class="slidebar" id="slidebar">
	  		<img src="/resources/img/menu.png" alt="">
	  	</div>
	  	<div class="search">
	  	<i id="search" class="search-button"></i>
	  	<input type="text" name="search"  style="border:none;" id="input">
	  	</div>	
	</div>
    <!-- 隐藏分类 -->
	<section class="classify" id="classify">
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
      
	<section class="slider" id="slider">
		<ul id="imgs">
			<!-- <li></li>
			<li></li>
			<li></li>
			<li></li> -->
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
	   		<li class="active" ><a href="javascript:;">新品</a></li>
	   		<!-- 防止a标签的跳转 -->
	   		<li><a href="javascript:;">猜你喜欢</a></li>
	   	</ul>
	   	</figure>
	   	<section class="main-cons"  style="display:block">

	   	 <div id="main-cons"></div>

		<div id="pullUp">
			<span class="pullUpIcon"></span><span class="pullUpLabel">加载更多</span>
		</div>
	   </section>
		
		<section class="main-cons" style="display:none">
			<div class="youlike">
			    <p>系统正在为您查询您感兴趣的宝物......</p>
				<p>请填写以下信息</p>
				<ul>
				<li><label for="" >宝宝姓名：</label><label for=""><input type="text" id="username"></label></li>
				
				<li><label for="">宝宝生日：</label><label for=""><input type="date"></label></li>

				<li><label for="">宝宝性别：</label><label for=""><select name="" id="sex"><option value="">男</option><option value="">女</option></select></label></li>
				
				<li><label for="">宝宝爱好：</label><label for=""><input type="text"></label></li>
				</ul>
				<div class="like-up">
                <input type="button" style="border:none" value="提交" id="like-up">
                </div>
		    </div>
		</section>	
   </div>

   
	<!-- <section class="clear"></section>
  -->
 </div>
 </div>
    <div class="back-top" id="back-top">
    	<p>回到顶部</p>
    </div>

	<div class="menu" id="footer">
            <a   href="index.jsp">
                <i class="icon-menu icon-menu1"><img src="/resources/img/footer-c1.png" alt=""></i>
            </a>
            <a>
                <i class="icon-menu icon-menu2"><img src="/resources/img/footer-2.png" alt=""></i>
            </a>
            <a  href="consignment.html">
                <i class="icon-menu icon-menu3"><img src="/resources/img/footer-3.png" alt=""></i>
            </a>
            <a  href="javascript:;" id="shopping">
                <i class="icon-menu icon-menu4"><img src="/resources/img/footer-4.png" alt=""></i>
            </a>
            <a  href="personal.jsp">
                <i class="icon-menu icon-menu5"><img src="/resources/img/footer-5.png" alt=""></i>
            </a>
    </div>
   
	<script type="text/javascript" src="/resources/js/jquery.1.10.2.js"></script>
	 <script type="text/javascript" src="/resources/js/ajax.js"></script>
	<!--<script type="text/javascript" src="js/dataBind.js"></script>-->
	<script type="text/javascript" src="/resources/js/hhSwipe.js"></script>
	<script type="text/javascript" src="/resources/js/iscroll.js"></script>
	<script type="text/javascript" src="/resources/js/analyPara.js"></script>
	<script>
	var bullets = document.getElementById('position').getElementsByTagName('li');
    var banner = Swipe(document.getElementById('slider'), {
        auto: 4000,
        continuous: true,
        disableScroll:false,
        callback: function(pos) {
        var i = bullets.length;
        while (i--) {
          bullets[i].className = ' ';
        }
          bullets[pos].className = 'cur';
        }
    })

     $("#shopping").click(function(){
    	window.location.href = "shopping.html?username="+encodeURI(encodeURI(username));
     })

   
   
	</script>
</body>
</html>