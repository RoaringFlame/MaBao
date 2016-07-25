/**
 * Created by lies on 2016/7/21.
 */
"use strict";
$(function () {
    function init() {
        $(".order-box").click(function () {
            var goodsId = $(this).find(".goodsId").text();
            window.location = "goods/goodsDetail?goodsId=" + goodsId;
        });
    }
    init();
});