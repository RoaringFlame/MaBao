/**
 * Created by Emma-pc on 2016/7/14.
 * 详情页面点击购物车登录的情况下提示加入购物车成功
 */
"use strict";
function showMsg(msg){
    $('#textShow').text(msg).fadeIn(1000).delay(2000).fadeOut(1000);
}
$(function () {
    //详情页面弹框效果的实现

    function init() {                                           //调用函数
        $("#textShow").hide();
        $("#addToCarts").click(function () {
            var goodsId=$("#goodsId").text();
            var url="/cart/cartAddGoods?goodsId="+goodsId+"&jump=false";
            showMsg("商品已成功添加到购物车");
        });
    }

    init();
});
