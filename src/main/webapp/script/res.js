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

    $('#up-to-login').click(function () {
        emailCheck();
        confirmCheck();
        pwdCheck();
        usernameCheck();
        if (ok1 && ok2 && ok3 && ok4) {//当以上判断全部成立，即执行后面的代码
            MB.sendAjax("post","person/register",
                {userName: $('#userName').val(), password: $('#passWord').val(), email: $('#email').val()},
                function (data) {
                    //根据服务器返回的值判断
                    if (data.status == "success") {
                        //显示注册成功信息
                        $('.warning').text(data.message);
                    }
                    else if (data.status == "failure") {
                        $('.warning').text(data.message);
                    }
                    else {
                        $('.warning').text(data.message);
                    }})
        } else {
            return false;
        }
    })

    //用户名校验
    function usernameCheck() {
        ok1 = false;
        var username = $('#userName').val();
        if (username == "") {
            $('.warning').text("请输入用户名！");
        }else {
            //前端验证用户名是否为空，且不出现特殊字符
            var reg = /[`~!@#$%^&*_+<>{}\/'[\]]/im;
            if (username != '' && username.length >= 2 && username.length <= 10) { //判断用户名的长度大于2小于10
                if (reg.test(username)) { //判断用户名中是否含有非法字符
                    $('.warning').text('账号含有非法字符');// 有则提示
                } else {
                    ok1 = true; // 用户名验证通过
                }
            } else {
                $('.warning').text('用户名长度为2-10位之间');
            }
        }
    }

    //密码校验
    function pwdCheck() {
        ok2 = false;
        var password = $('#passWord').val();
        if (password == "") {
            $('.warning').text("请输入密码！");
        }else {
            if (password != '') {
                ok2 = true;
            } else {
                $('.warning').text("请输入密码!");
            }
        }
    }

    //密码确认校验
    function confirmCheck() {
        ok3 = false;
        var confirmPwd = $('#confirmPwd').val();
        if (confirmPwd == $('#passWord').val()) {//判断密码是否正确
            ok3 = true;
        } else {
            $('.warning').text('输入的密码不一致');
        }
    }

    //邮箱校验
    function emailCheck() {
        ok4 = false;
        var email = $('#email').val();
        if (email == "") {
            $('.warning').text("请输入邮箱！");
        }else if (email != "" && email.search(/\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/) == 0) {// 验证邮箱格式
            ok4 = true;
        } else {
            $('.warning').text('请输入正确的email格式');
        }
    }
})
