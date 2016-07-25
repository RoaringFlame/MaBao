/**
 * Created by lies on 2016/7/24.
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
            var birthday = $("#babyData").val();
            var name = $("#babyName").val();
            var gender = $("#sex").val();
            if (birthday !== "" && name !== "" && gender !== "") {
                $(".person-msg").submit();
            } else {
                showMsg("请完善宝宝信息");
            }
        }

        //
        function init() {
            $(".person-button button").click(function () {
                checkInput();
            });
        }

        init();
    }
);