/**
 * Created by Emma-pc on 2016/7/14.
 * 详情页面点击购物车登录的情况下提示加入购物车成功
 */
"use strict";
$(function () {
    //详情页面弹框效果的实现
    function init() {                                           //调用函数
        $("#addToCarts").click(function () {
            $("#textShow").removeClass("hide");
        })
    }

    init();
});
