/**
 * Created by lies on 2016/7/26.
 */
"use strict";
$(function () {

        //弹框事件
        function showMsg(msg) {
            //提示框弹出信息停留3秒消失
            $('#textShow').text(msg).fadeIn(1000).delay(2000).fadeOut(1000);
        }

        //数据校验
        function checkInput() {
            var oldPrice = $("#oldPrice").val();
            var newPrice = $("#newPrice").val();
            var z= /^[0-9]*$/;
            if(z.test(oldPrice)&&z.test(newPrice)){
                $(".transfer-form").submit();
            }else{
                showMsg("价格栏必须是数字");
            };
        }

        //
        function init() {
            $("#transferButton").click(function () {
                checkInput();
            });
        }

        init();
    }
);
