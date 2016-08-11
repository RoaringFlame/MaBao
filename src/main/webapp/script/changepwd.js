"use strict";

$(function () {
    var ok1 = false; //密码校验
    var ok2 = false; //确认密码校验

    $('#newPwd').focus(function () {
        $('.warning').text('');
    }).blur(function () {
        pwdCheck();
    });

    $('#confirm-pwd').focus(function () {
    }).blur(function () {
        confirmCheck();
    });

    $('#up-pwd').click(function () {
        pwdCheck();
        confirmCheck();
        if ($('#newPwd').val() == "") {
            $('.warning').text("请输入密码！");
        }
        if (ok1 && ok2) {//当以上判断全部成立，即执行后面的代码
            $.post("person/passwordChange",{password: $('#newPwd').val()},
                function (data) {
                    //根据服务器返回的值判断
                    if (data.status == "success") {
                        //跳转到登录页面
                        $('.warning').text("");
                        window.location.href = "login";
                    }
                    else if (data.status == "failure") {
                        $('.warning').text(data.message);
                    }
                },"json")
        }
    });

    //密码校验
    function pwdCheck() {
        ok1 = false;
        var password = $('#newPwd').val();
        var num = 0; //密码验证通过数
        var number = 0;  //数字
        var letter = 0; //小写字符
        var bigLetter = 0; //大写字符
        var chars = 0;
        if (password.search(/[0-9]/) != -1) {  //判断密码中是否有数字
            num += 1;
            number = 1;
        }
        if (password.search(/[A-Z]/) != -1) {  //判断密码中是否有大写字母
            num += 1;
            bigLetter = 1;
        }
        if (password.search(/[a-z]/) != -1) {  //判断密码中是否有小写字母
            num += 1;
            letter = 1;
        }
        if (password.search(/[^A-Za-z0-9]/) != -1) {  //判断密码中是否全部是字符
            num += 1;
            chars = 1;
        }
        if (num >= 2 && password.length >= 6 && password.length <= 16 && password != '') {  //密码的长度在6~16位之间并且要有字符和数字
            $('.warning').text('');
            ok1 = true;
        } else if (password.length < 6 || password.length > 16) {
            $('.warning').text('密码为6-16位之间');
        } else if (num == 1) {
            if (number == 1) {
                $('.warning').text("不能全为数字!");
            }
            if (letter == 1) {
                $('.warning').text("不能全为字母!");
            }
            if (bigLetter == 1) {
                $('.warning').text("不能全为字母!");
            }
            if (chars == 1) {
                $('.warning').text("不能全为字符!");
            }
        }
    }

    //密码确认校验
    function confirmCheck() {
        ok2 = false;
        var confirmPwd = $('#confirm-pwd').val();
        if (confirmPwd == $('#newPwd').val()) {//判断密码是否正确
            ok2 = true;
        } else {
            $('.warning').text('输入的密码不一致');
        }
    }
});