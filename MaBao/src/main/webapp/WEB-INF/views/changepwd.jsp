<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>修改密码</title>
	<meta name="viewport" content="maximum-scale=1.0,minimum-scale=1.0,user-scalable=no,width=device-width,initial-scale=1.0"/>
	<!-- 禁止将数字变为电话号码 -->
	<meta name="format-detection" content="telephone=no" />
	<!-- iphone设备中的safari私有meta标签,允许全屏模式浏览，隐藏浏览器导航栏 -->
	<meta name="apple-mobile-web-app-capable" content="yes" />
	<!-- iphone的私有标签,它指定的iphone中safari顶端的状态条的样式 -->
	<meta name="apple-mobile-web-app-status-bar-style" content="black">

	<link rel="stylesheet" href="css/message.css">
	<link rel="stylesheet" href="css/public.css">
</head>
<body>
	<section class="header-top">
    	<div class="fanhui"><a href="personal.jsp" ><img src="img/back.png" alt=""></a><a href="personal.jsp" class="tiaozhuan">返回</a></div>
    	<div class="shouye"><p>修改密码</p></div>
    </section>
    <div class="top">
         <form action="http://localhost:8080/mb/LoginRegisterServlet?method=updatePassword" method="post">
         <!-- 修改密码成功跳转到个人中心页面 -->
	    <div >
	    	<p class="changepwd" >新密码:</p>
	    	<input type="password" id="newpwd" name="newPassword">
	    </div>
	    <div class="clear">
	        <p class="changepwd" >确认密码:</p>
	    	<input type="password" id="renewpwd"> 
	    </div>
	    <p class="warning"></p>
    </div>

    <div class="bottom"><input type="submit" value="提交" class="submit" /></div>
    <script type="text/javascript" src="js/jquery.1.10.2.js"></script>
     <script type="text/javascript">
     
      $("#newpwd").focus(function(){
        $(".warning").text('');
    }).blur(function(){
    var password = $("#newpwd").val();
    var num = 0;  
    var number = 0 ;  
    var letter = 0 ;  
    var bigLetter = 0 ;  
    var chars = 0 ;  
    if (password.search(/[0-9]/) != -1) {  
        num += 1;  
        number =1;  
    }  
    if (password.search(/[A-Z]/) != -1) {  
        num += 1;  
        bigLetter = 1 ;  
    }  
    if (password.search(/[a-z]/) != -1) {  
        num += 1;  
        letter = 1 ;  
    }  
    if (password.search(/[^A-Za-z0-9]/) != -1) {  
        num += 1;  
        chars = 1 ;  
    }  
     if(num >= 2&&$(this).val().length >= 6 && $(this).val().length<=16 &&  $(this).val()!=''){                     
                        $(".warning").text('');
                        ok1=true;
                        
                    }else if($(this).val().length < 6 || $(this).val().length >16){
                        $(".warning").text('密码为6-16位之间');
                    }else if(num==1){
                      if(number==1){  
                        $(".warning").text("不能全为数字!");  
                    }  
                    if(letter==1){  
                        $(".warning").text("不能全为字母!");  
                    }  
                    if(bigLetter==1){  
                       $(".warning").text("不能全为字母!");  
                    }  
                    if(chars==1){  
                        $(".warning").text("不能全为字符!");  
                    }    
                    }  
                 

    });
$('#renewpwd').focus(function(){
            $(".warning").text('');
                }).blur(function(){

                    if($(this).val().length >= 6 && $(this).val().length <=16 && $(this).val()!='' && $(this).val() == $('#newpwd').val()){
                        $(".warning").text('');
                        ok2=true;
                    }else{
                        $(".warning").text('输入的密码不一致');
                    }
                     
                });
        
         
    </script>
</body>
</html>