"use strict";


$(function(){	
	  $("#login").click(function(){
		var username=$('input[name="username"]').val();
		var password=$('input[name="password"]').val();
		$.post("http://localhost:8080/mb/LoginRegisterServlet?method=LoginCheck",{username:username,password:password},function(data){
			
			if(data == 0)
			{
				window.location.href = "index.html?username="+username;
			}
	     	if(data == 1)
			{
				  $(".warning").text("用户名或密码错误!");
			}
		},'json')
	})
	 $("#free-res").click(function(){
	 	window.location.href = "res.html";
	 })
})

