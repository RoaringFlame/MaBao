"use strict"
$(function () {
    $('#sendSms').click(function () {
        MB.sendAjax("post", "person/sendMes",
            {state:2},function (data) {
                //根据服务器返回的值判断
                if (data.status == "success") {
                    alert(data);
                    $('.warning').text(data.message);
                }
                else if (data.status == "failure") {
                    alert(data);
                    $('.warning').text(data.message);
                }
                else {
                    alert(data);
                    $('.warning').text(data.message);
                }
            })
    })
})