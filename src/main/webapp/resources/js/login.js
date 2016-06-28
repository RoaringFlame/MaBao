"use strict";
$(function(){
	var ok=true;
	$("#login").click(function(){
		
		var username=$('input[name="username"]').val();//获取用户输入的用户名
		var password=$('input[name="password"]').val();//获取用户输入的密码
		$.post("http://localhost:8080/mb/LoginRegisterServlet?method=LoginCheck",{username:username,password:password},function(data){
			if(username == "" || password == ""){//判断是否为空
			   	$(".warning").text("请输入用户名和密码");// 提示
			}
			if(data == 1){//根据服务器传来的值判断用户名密码是否正确
				window.location.href = "index.html?username="+username;
			}
	     	if(data == 0){
				$(".warning").text("用户名或密码错误!");
			}
		},'json')
	})
	$("#free-res").click(function(){//免费注册的跳转
	 	window.location.href = "res.html";
	})
})

