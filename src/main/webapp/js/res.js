"use strict";

$(function(){
             
             var ok1=false;
             var ok2=false;
             var ok3=false;
             var ok4=false;
   //前端验证用户名是否为空，长度控制在8个以内，且不出现特殊字符
             var reg=/[`~!@#$%^&*_+<>{}\/'[\]]/im;
        
                $('#username').focus(function(){
                  $(".warning").text('');
                }).blur(function(){
                    if($(this).val().length >= 3 && $(this).val().length<=8 &&  $(this).val()!=''){                     
                        if(reg.test($(this).val())){
                             $(".warning").text('账号含有非法字符');
                        }else{
                             $(".warning").text('');
                             ok1=true;
                        }
                    }
                    else{
                         $(".warning").text('用户名长度为3-8位之间');
                    }
                     
                });
                   
   
 
    //前端验证密码长度6-16，且要控制格式为字母加数字

    $("#pwd").focus(function(){
    
    }).blur(function(){
    var password = $("#pwd").val();
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
                        ok2=true;
                        
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

   
    



    //验证确认密码
               $('#repwd').focus(function(){
         
                }).blur(function(){

                    if($(this).val().length >= 6 && $(this).val().length <=16 && $(this).val()!='' && $(this).val() == $('#pwd').val()){
                        $(".warning").text('');
                        ok3=true;
                    }else{
                        $(".warning").text('输入的密码不一致');
                    }
                     
                });


                //验证邮箱
                $('#email').focus(function(){
                     
                }).blur(function(){
                    if($(this).val!= "" && $(this).val().search(/\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/)==0){
                        $(".warning").text('');
                        ok4=true;
                    }else{                  
                        $(".warning").text('请输入正确的EMAIL格式');
                        
                    }
                     
                });


                $('#up-to-login').click(function(){
                  var username =  $("#username").val();
                  
                    if(ok1 && ok2 && ok3 && ok4){
                        $.get("http://localhost:8080/mb/LoginRegisterServlet?method=RegisterCheck",
                            {username:$("#username").val(),pwd:$("#pwd").val(),email:$("#email").val()},
                            function(data){  
                                if(data == 0)
                                  {
                                    window.location.href ="login.html?username="+username; 
                                  }
                                else if(data == 1)
                                 {
                                    $(".warning").text("用户名重复");
                                 }
                                 else{
                                    $(".warning").text("邮箱重复");
                                 }
                                
                            },'json')
                       
                    }else{
                        return false;
                    }
                })
                
         });            
       