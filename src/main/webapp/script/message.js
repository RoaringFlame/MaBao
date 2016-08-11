"use strict";
//全局变量
var count = 120; //信息存储时间
var countdown;   //倒计时时间
$(function () {
    //绑定发送验证码按钮事件
    $("#sendSms").click(function () {
        sendCode($("#sendSms"));
    });
    //判断倒计时是否存在
    countdown = getCookieValue("remained") ?
        getCookieValue("remained") : 0;//获取cookie值
    if (countdown > 0) {
        countdown++;
        editCookie("remained", countdown, countdown + 1);
        settime($("#sendSms"));//开始倒计时
    }
    //绑定提交验证码按钮事件
    $("#submit").click(function () {
        submitCode();
    });
});

//发送验证码时添加cookie
function addCookie(name, value, expiresHours) {
    var cookieString = name + "=" + value;
    //判断是否设置过期时间,0代表关闭浏览器时失效
    if (expiresHours > 0) {
        var date = new Date();
        date.setTime(date.getTime() + expiresHours * 1000);
        cookieString = cookieString + ";expires=" + date.toUTCString();
    }
    document.cookie = cookieString;
}

//修改cookie的值
function editCookie(name, value, expiresHours) {
    var cookieString = name + "=" + value;
    if (expiresHours > 0) {
        var date = new Date();
        date.setTime(date.getTime() + expiresHours * 1000); //单位是毫秒
        cookieString = cookieString + ";expires=" + date.toGMTString();
    }
    document.cookie = cookieString;
}

//根据名字获取cookie的值
function getCookieValue(name) {
    var strCookie = document.cookie;
    var arrCookie = strCookie.split("; ");
    for (var i = 0; i < arrCookie.length; i++) {
        var arr = arrCookie[i].split("=");
        if (arr[0] == name) {
            return arr[1];
            break;
        }
    }
}

function settime(obj) {
    countdown = getCookieValue("remained");
    if (countdown == undefined) {
        obj.removeAttr("disabled");
        obj.text("获取验证码");
        return;
    } else {
        obj.attr("disabled", true);
        obj.text("重新发送(" + countdown + ")");
        countdown--;
        editCookie("remained", countdown, countdown + 1);
    }
    setTimeout(function () {
        settime(obj)
    }, 1000); //每1000毫秒执行一次
}

//发送验证码
function sendCode(obj) {
    doPostBack('person/sendMes', sendBack, {"state": 2});
    addCookie("remained", count, count); //添加cookie记录,测试为5秒
    settime(obj);//开始倒计时
    $('#warning').text('');
}

//发送请求并进行回调
function doPostBack(url, backFunc, queryParam) {
    $.ajax({
        cache: false,
        type: 'POST',
        url: url,// 请求的action路径
        data: queryParam,
        error: function () {// 请求失败处理函数
        },
        success: backFunc
    });
}

//提交验证码
function submitCode() {
    if (countdown > 0) {
        if ($("#code").val() != "") {
            var code = $("#code").val();
            doPostBack('person/submitCode', submitBack, {"state": 2, "code": code});
        }
        else {
            $('#warning').text('请输入验证码！');
        }
    } else {
        $('#warning').text('验证码已失效，请重新获取获取！');
        if ($("#code").val() == "") {
            $('#warning').text('请点击获取验证码！');
        }
    }
}

//短信发送回调
function sendBack(data) {
    $('#warning').text(data.message);
}

//测试回调
function submitBack(data) {
    if (data.status != "success") {
        $('#warning').text(data.message);
    } else {//返回验证码
        window.location = "user/changePwd?code=" + data.message;
    }
}

//测试回调1短信发送
function backFunc1(data) {
    if (data.status != "success") {
        alert(data.message);
    } else {//返回验证码
        alert("模拟验证码:" + data.message);
        $("#code").val(data.message);
    }
}

//测试回调2验证码校验
function backFunc2(data) {
    if (data.status != "success") {
        alert(data.message);
    } else {//返回验证码
        alert("回调验证码:" + data.message);
        window.location = "user/changePwd?code=" + data.message;
    }
}
