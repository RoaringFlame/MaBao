<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>编辑收货地址</title>
	<meta name="viewport" content="maximum-scale=1.0,minimum-scale=1.0,user-scalable=no,width=device-width,initial-scale=1.0"/>
	<!-- 禁止将数字变为电话号码 -->
	<meta name="format-detection" content="telephone=no" />
	<!-- iphone设备中的safari私有meta标签,允许全屏模式浏览，隐藏浏览器导航栏 -->
	<meta name="apple-mobile-web-app-capable" content="yes" />
	<!-- iphone的私有标签,它指定的iphone中safari顶端的状态条的样式 -->
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<link rel="stylesheet" href="css/buy.css">
	<link rel="stylesheet" href="css/public.css">
  
  <script src="js/jquery-1[1].2.6.js" type="text/javascript"></script>
  <script src="js/jquery.provincesCity.js" type="text/javascript"></script>
  <script src="js/provincesdata.js" type="text/javascript"></script>
  <script>
	//调用插件
	$(function(){
		$("#test").ProvinceCity();
	});	
  </script>
</head>
<body>
<%
	String id=request.getParameter("id");
	AddressService gs=new AddressService();
	Address address=gs.findById(Integer.parseInt(id));
 %>
 	<section class="header-top">
    	<div class="fanhui"><a href="address.jsp" ><img src="img/back.png" alt=""></a><a href="address.jsp" class="tiaozhuan">返回</a></div>
    	<div class="shouye"><p>编辑收货地址</p></div>
    </section>
	<form class="mesgbox" method="post" action="http://localhost:8080/mb/AddressServlet" >
	<input type="text" class="write" placeholder=<%=address.getRecipients()%> name="recipients" >
	<input type="phone" class="write" placeholder=<%=address.getTel()%> name="tel">
	<input type="text" class="write" placeholder="所在地" >
	<%--下面两行隐藏的是传给后台的该地址对应的id和调用后台对应的方法 --%>
	<input name="id" type="hidden" value=<%=address.getAddressId()%>>
	<input name="method" type="hidden" value="updateAddr">
    <div id="test"></div>
	<input type="text" class="write" placeholder=<%=address.getAddress() %> name="detail">
	<div class="default">
		<p>默认地址</p> 
		<span>注：每次下单时会使用该地址</span>
		<div class="clear"></div>
	     <div class="slideThree">  
	     <input type="checkbox" value="None" id="slideThree2" name="check" checked />
	     <label for="slideThree2" class="st1"></label>
	     </div>
	</div> 
	
	<div class="clear"></div>
		<div class="foot-input2">
		<input type="button" value="删除该地址" id="del" name="del"/>
	</div>
	<div class="foot-input">
		<input type="submit" value="保存并使用" />
	</div>
	</form>
	 <script type="text/javascript">
       $("#del").click(function(){
         window.location.href="http://localhost:8080/mb/AddressServlet?method=deleteAddr&id="+<%=address.getAddressId()%>;
         })

    </script>
    
</body>
</html>