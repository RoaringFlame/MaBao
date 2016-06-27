<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>宝宝信息</title>
	<meta name="viewport" content="maximum-scale=1.0,minimum-scale=1.0,user-scalable=no,width=device-width,initial-scale=1.0"/>
	<!-- 禁止将数字变为电话号码 -->
	<meta name="format-detection" content="telephone=no" />
	<!-- iphone设备中的safari私有meta标签,允许全屏模式浏览，隐藏浏览器导航栏 -->
	<meta name="apple-mobile-web-app-capable" content="yes" />
	<!-- iphone的私有标签,它指定的iphone中safari顶端的状态条的样式 -->
	<meta name="apple-mobile-web-app-status-bar-style" content="black">

	<link rel="stylesheet" href="css/public.css">
	<link rel="stylesheet" href="css/res.css">
</head>
<body>
   <section class="header-top">
    	<div class="fanhui"><a href="personal.jsp" ><img src="img/back.png" alt=""></a><a href="personal.jsp" class="tiaozhuan">返回</a></div>
    	<div class="shouye"><p>宝宝信息</p></div>
    </section>
    <form method="post" action="http://localhost:8080/mb/BabyServlet" class="person-msg" id="form1">
    <section class="person">
    <ul>
        <li><label for="">宝宝生日：</label><input type="date" name="babyBir"></li>
        <li><label for="">宝宝姓名：</label><input type="text"  name="username"></li>
        <li><label for="">宝宝性别：</label>  
        <select name="sex" id="">
            <option value="男">男</option>
            <option value="女">女</option>
        </select>
        </li>
    </ul>
    
    </section>
    <div  class="reset">
       <input type="submit" value="修改" form="form1">
    </div>
    </form>
</body>
</html>