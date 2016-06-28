<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="pojo.Baby" %>
<%@ page import="service.BabyService" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>修改宝宝信息</title>
	<meta name="viewport" content="maximum-scale=1.0,minimum-scale=1.0,user-scalable=no,width=device-width,initial-scale=1.0"/>
	<!-- 禁止将数字变为电话号码 -->
	<meta name="format-detection" content="telephone=no" />
	<!-- iphone设备中的safari私有meta标签,允许全屏模式浏览，隐藏浏览器导航栏 -->
	<meta name="apple-mobile-web-app-capable" content="yes" />
	<!-- iphone的私有标签,它指定的iphone中safari顶端的状态条的样式 -->
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<script type="text/javascript" src="js/jquery.1.10.2.js"></script>
	<link rel="stylesheet" href="css/public.css">
	<link rel="stylesheet" href="css/res.css">
</head>
<body>
<%
	String id=request.getParameter("id");
	BabyService bs=new BabyService();
	Baby baby=bs.findById(Integer.parseInt(id));
 %>
	<section class="header-top">
    	<div class="fanhui"><a href="permsg.jsp" ><img src="img/back.png" alt=""></a><a href="permsg.jsp" class="tiaozhuan">返回</a></div>
    	<div class="shouye"><p>编辑宝宝信息</p></div>
    </section>
    <section class="person">
    <form method="post" action="http://localhost:8080/mb/BabyServlet?method=updateBaby"  class="person-msg">
    <ul>
    <li><label for="babydata">宝宝生日：</label>
        <input name="babyBir" type="date" placeholder=<%=baby.getBabybir().toString().substring(0,10)%>></li>
    <li><label for="babyname">宝宝姓名：</label>
        <input name="babyName" type="text" placeholder=<%=baby.getBabyName()%>>
        <%--下面两行隐藏的是传给后台的该地址对应的id和调用后台对应的方法 --%>
	<input name="id" type="hidden" value=<%=baby.getId()%>></li>
    <li>
    <label for="sex0">宝宝性别：</label>
    <select name="babySex" id="sex0">
    	<option value="男">男</option>
    	<option value="女">女</option>
    </select>
    </li>
    </ul>
	    <section class="reset">
	        <input type="submit" value="确认修改">
	        <input class="right1" type="button" value="删除信息" id="del" name="del">
	    </section>
    </form>
    <script type="text/javascript">
       $("#del").click(function(){
         window.location.href="http://localhost:8080/mb/BabyServlet?method=deleteBaby&id="+<%=baby.getId()%>;
         });
    </script>
    </section>

</body>
</html>