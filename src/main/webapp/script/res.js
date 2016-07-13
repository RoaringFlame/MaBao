"use strict";

$(function () {
    var ok1 = false; //用户名校验
    var ok2 = false; //密码校验
    var ok3 = false; //密码一致校验
    var ok4 = false; //邮箱校验

    $('#userName').focus(function () {
        $('.warning').text(''); //设置提示内容为空
    }).blur(function () { //用户名框失焦时执行
        usernameCheck();
    });

    $('#passWord').focus(function () {
    }).blur(function () {//密码框失焦时执行
        pwdCheck();
    });

    $('#confirmPwd').focus(function () {
    }).blur(function () {//确认密码框失焦时执行
        confirmCheck();
    });

    $('#email').focus(function () {
    }).blur(function () {//邮件框失焦时执行
        emailCheck();
    });

    //用户名校验
    function usernameCheck() {
        ok1 = false;
        //前端验证用户名是否为空，且不出现特殊字符
        var reg = /[`~!@#$%^&*_+<>{}\/'[\]]/im;
        var username = $('#userName').val();
        if (username != '' && username.length >= 2 && username.length <= 10) { //判断用户名的长度大于2小于10
            if (reg.test(username)) { //判断用户名中是否含有非法字符
                $('.warning').text('账号含有非法字符');// 有则提示
            } else {
                $('.warning').text(''); //无则为空
                ok1 = true; // 用户名验证通过
            }
        } else {
            $('.warning').text('用户名长度为2-10位之间');
        }
    }

    $('#up-to-login').click(function () {
        if ($('#passWord').val() == "") {
            $('.warning').text("请输入密码！");
        }
        usernameCheck();
        pwdCheck();
        confirmCheck();
        emailCheck();
        if (ok1 && ok2 && ok3 && ok4) {//当以上判断全部成立，即执行后面的代码
            $.post("http://localhost:8080/mb/LoginRegisterServlet?method=RegisterCheck",
                {username: $('#userName').val(), pwd: $('#passWord').val(), email: $('#email').val()},
                function (data) {
                    //根据服务器返回的值判断
                    if (data == 0) {
                        //跳转到登录页面
                        window.location.href = "/login";
                    }
                    else if (data == 1) {
                        $('.warning').text("用户名重复");
                    }
                    else {
                        $('.warning').text("邮箱重复");
                    }

                }, 'json')
        } else {
            return false;
        }
    })

    //密码校验
    function pwdCheck() {
        ok2 = false;
        var password = $('#passWord').val();
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
            ok2 = true;
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
        ok3 = false;
        var confirmPwd = $('#confirmPwd').val();
        if (confirmPwd == $('#passWord').val()) {//判断密码是否正确
            $('.warning').text('');
            ok3 = true;
        } else {
            $('.warning').text('输入的密码不一致');
        }
    }

    //邮箱校验
    function emailCheck() {
        ok4 = false;
        var email = $('#email').val();
        if (email != "" && email.search(/\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/) == 0) {// 验证邮箱格式
            $('.warning').text('');
            ok4 = true;
        } else {
            $('.warning').text('请输入正确的email格式');
        }
    }

})
