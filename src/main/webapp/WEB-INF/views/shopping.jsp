<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>购物车</title>
	<meta name="viewport" content="maximum-scale=1.0,minimum-scale=1.0,user-scalable=no,width=device-width,initial-scale=1.0"/>
	<!-- 禁止将数字变为电话号码 -->
	<meta name="format-detection" content="telephone=no" />
	<!-- iphone设备中的safari私有meta标签,允许全屏模式浏览，隐藏浏览器导航栏 -->
	<meta name="apple-mobile-web-app-capable" content="yes" />
	<!-- iphone的私有标签,它指定的iphone中safari顶端的状态条的样式 -->
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
<!-- 	<script type="text/javascript" src="../js/jquery-1.8.3.min.js"></script> -->
	<link rel="stylesheet" type="text/css" href="../css/index.css">
	<link rel="stylesheet" href="../css/buy.css">
	<link rel="stylesheet" href="../css/public.css">
</head>
<body>
 <section class="header-top">
    	<div class="fanhui" onclick=window.location.href="index.html">
    	<img src="../img/back.png" alt="">
    	<a class="tiaozhuan">返回</a>
    	</div>
    	<div class="shouye"><p>购物车</p></div>
    	<p class="edit" id="finish" onclick="_block()">编辑</p>
 </section>

 <form method="" action="">
	<div class="container">
        <c:forEach var="goods" items="${goodsList}">
		<section class="main-item">
<!-- 		    <div class="select" name="_select">
		    	<input class="edit-button" name="itemContainer" type="checkBox">
		    </div> -->
		    <input class="select" name="itemContainer" type="checkBox">
			<div class="user-img">
				<img src="/upload/main-new1.png" alt="">
			</div>
			<div class="user-intro">
				<p><c:out value="${goods.brand}"/></p>
				<p>尺寸&nbsp;:&nbsp;<c:out value="${goods.size}"/></p>
				<p class="mark">￥{fmt:formatNumber type="number" value="${goods.price/100}"
					pattern="0.00" maxFractionDigits="2"/>}</p>
			</div>
			<div class="add-reduce">
				<div class="reduce">
					<img src="../img/reduce.png" alt="">
					<div></div>
				</div>
				<div class="sum">
					2
				</div>
				<div class="add">
					<img src="../img/shopping-1.png" alt="">
				</div>
			</div>
		</section>
			</c:forEach>
		<%--<section class="main-item">--%>
<%--<!-- 		    <div class="select"  name="_select">--%>
		    	<%--<input class="edit-button" name="itemContainer"  type="checkBox">--%>
		    <%--</div> -->--%>
		    <%--<input class="select" name="itemContainer" type="checkBox">--%>
			<%--<div class="user-img">--%>
				<%--<img src="../img/main-new1.png" alt="">--%>
			<%--</div>--%>
			<%--<div class="user-intro">--%>
				<%--<p>H&M&nbsp;&nbsp;CARDIGAN</p>--%>
				<%--<p>尺寸&nbsp;:&nbsp;S</p>--%>
				<%--<p class="mark">￥35.50</p>--%>
			<%--</div>--%>
			<%--<div class="add-reduce">--%>
				<%--<div class="reduce">--%>
					<%--<img src="../img/reduce.png" alt="">--%>
				<%--</div>--%>
				<%--<div class="sum">--%>
					<%--1--%>
				<%--</div>--%>
				<%--<div class="add">--%>
					<%--<img src="../img/shopping-1.png" alt="">--%>
				<%--<span class="glyphicon glyphicon-minus-sign" aria-hidden="true"></span>	--%>
				<%--</div>--%>
			<%--</div>--%>
		<%--</section>--%>
		<section class="main-item"></section>
	</div>
	<div class="up-to-pay">
		<ul>
				<li>总计&nbsp;:&nbsp;<b>￥131.00</b></li>
				<li >付款
				  <input type="submit" value="付款" class="sr_button"> 
				</li>
			</ul>
	</div>
	<div class="up-to-pay" id="txt">
		<ul>
				<li>	
				    <div>   
<!-- 					<div class="select" name="_select" style="margin:1rem 1rem 1rem 3rem; "> -->
			    	<!-- <input class="edit-button" type="checkBox" id="checkAll"> -->
			    	<input class="select" name="itemContainer" type="checkBox" id="checkAll" 
			    	style="margin:1rem 0rem 1rem 3rem;">
			    	<p class="choose" >全选</p>
			        </div>
		        </li>
				<li >删除
				<input type="reset" value="删除" class="sr_button">
				</li>
			</ul>
	</div>
 </form>

<section class="clear"></section>
	<div class="menu">
            <a class="active"  href="index.html">
                <i class="icon-menu icon-menu1"><img src="../img/footer-1.png" alt=""></i>
            </a>
            <a>
                <i class="icon-menu icon-menu2"><img src="../img/footer-2.png" alt=""></i>
            </a>
            <a  href="consignment.html">
                <i class="icon-menu icon-menu3"><img src="../img/footer-3.png" alt=""></i>
            </a>
            <a  href="shopping.html">
                <i class="icon-menu icon-menu4"><img src="../img/footer-c4.png" alt=""></i>
            </a>
            <a  href="personal.html">
                <i class="icon-menu icon-menu5"><img src="../img/footer-5.png" alt=""></i>
            </a>
    </div>
<!-- 显示删除选项 -->
<script type="text/javascript">
    function _block(){
        var mychar=document.getElementById('txt');
        if(mychar.style.display=="none")
        {
        mychar.style.display="block";
        var sta=document.getElementById('finish');
        sta.innerHTML="完成";
        }
        else
        {
        mychar.style.display="none";
        var sta=document.getElementById('finish');
        sta.innerHTML="编辑";
        }
    }
// 全选or不选 
    window.onload = init;
    function init() {
        var checkAllNode = document.getElementById("checkAll"),
        items = document.getElementsByName("itemContainer"),
        _select=document.getElementsByName("_select");
        
        checkAllNode.onclick = function() {

           	for(var i = 0, j = items.length; i < j; i++) {
		        items[i].checked = this.checked;
		        }         	
        }
    }
	$(function(){
		var nums=new Array();
		var checkBoxs=$("input");
		$(checkBoxs).each(function(index,obj) {
			$(this).change(function(){
				if($(this).is(':checked')||$.inArray(index,nums)<0){
					nums.push(index);
				}else{
					nums.splice($.inArray(index,nums),1);
				}
				setTotal(nums);
			});
		});

		$('.add').each(function(index,obj){
			$(this).click(function(){
				var t=$(".sum").eq(index);
				t.text(parseInt(t.text())+1);
				console.log(nums);
				setTotal(nums);
			});
		});
		$('.reduce').each(function(index,obj){
			$(this).click(function(){
				var t=$(".sum").eq(index);
				t.text(parseInt(t.text())-1)
				if(parseInt(t.text())<=1){
					t.text(1);
				}
				setTotal(nums);
			});
		});

	})
	function setTotal(nums){
		var s=0;
		$(nums).each(function(index,obj){
			s+=parseInt($(".sum").eq(obj).text())*parseFloat($(".mark").eq(obj).text());
		});
		$(".up-to-pay").find("li:first").find('b').text(s);

	}
</script>	
</body>
</html>
