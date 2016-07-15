/**
 * Created by Emma-pc on 2016/7/14.
 * 详情页面点击购物车登录的情况下提示加入购物车成功
 */
"use strict";
function showMsg(msg) {                                                              //提示框弹出信息停留3秒消失
    $('#textShow').text(msg).fadeIn(1000).delay(2000).fadeOut(1000);
}
//详情页面弹框效果的实现
function init() {                                                                    //调用函数
    $("#textShow").hide();
    var goodsId = $("#goodsId").text();
    $("#addToCarts").click(function () {                                            //点击添加到购物车按钮判断是否成功加入购物车
        $.get("cart/cartAddGoods", {goodsId: goodsId}, function (data) {
            showMsg(data.message);                                                    //提示框弹出信息停留3秒消失
            console.log(data);
            console.log("详情页面弹框效果的实现");
        });

    });
    $("#addToCarts").click(function () {
        $.get("cart/cartAddGoods", {goodsId: goodsId}, function (data) {
            console.log(data);
            console.log("详情页面弹框效果的实现");
            if (data.status == "success") {
                window.location = "cart/showCart";
            } else {
                showMsg("商品添加失败");
            }
        });

    });
    init();
}
