"use strict";

$(function () {
    var ok1 = false; //密码校验
    var ok2 = false; //重复密码校验

    $('#newPwd').focus(function () {
        $('.warning').text('');
    }).blur(function () {
        var password = $('#newPwd').val();
        var num = 0;
        var number = 0;
        var letter = 0;
        var bigLetter = 0;
        var chars = 0;
        if (password.search(/[0-9]/) != -1) {
            num += 1;
            number = 1;
        }
        if (password.search(/[A-Z]/) != -1) {
            num += 1;
            bigLetter = 1;
        }
        if (password.search(/[a-z]/) != -1) {
            num += 1;
            letter = 1;
        }
        if (password.search(/[^A-Za-z0-9]/) != -1) {
            num += 1;
            chars = 1;
        }
        if (num >= 2 && $(this).val().length >= 6 && $(this).val().length <= 16 && $(this).val() != '') {
            $('.warning').text('');
            ok1 = true;
        } else if ($(this).val().length < 6 || $(this).val().length > 16) {
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
    });

    $('#confirm-pwd').focus(function () {
    }).blur(function () {
        if ($(this).val().length >= 6 && $(this).val().length <= 16 && $(this).val() != '' && $(this).val() == $('#newPwd').val()) {
            $('.warning').text('');
            ok2 = true;
        } else {
            $('.warning').text('输入的密码不一致');
        }
        if ($('#newPwd').val() == "") {
            $('.warning').text("请输入密码！");
        }
    });

    //点击提交
    $('#change-pwd').click(function () {
        if ($('#newPwd').val() == "") {
            $('.warning').text("请输入密码！");
        }
        if (ok1 && ok2) {//当以上判断全部成立，即执行后面的代码
            $.post("/LoginRegisterServlet?method=RegisterCheck",
                {pwd: $('#newPwd').val()}, function (data) {
                //根据服务器返回的值判断
                if (data == 0) {
                    //跳转到登录页面
                    window.location.href = "/login";
                }
            }, 'json')
        } else {
            return false;
        }
    })
});