"use strict";
$(function () {
    var payBtn=$("button.pay");                      //付款按钮
    var addressId = $(".box-right input").val();     //获取当前addressId

    function showMsg(msg) {
        //提示框弹出信息停留3秒消失
        $('#textShow').text(msg).fadeIn(1000).delay(2000).fadeOut(1000);
    }

    //付款按钮初始化
    function initPayBtn(){
        if (addressId !== "") {
            payBtn.removeClass("disabled");          //如果默认地址不为空，付款按钮为红色，可点击
            payBtn.addClass("confirm");
            payBtn.attr("disabled",false);

        }else {
            payBtn.removeClass("confirm");           //如果默认地址为空，付款按钮为灰色，不可点击，弹出提示框
            payBtn.addClass("disabled");
            payBtn.attr("disabled",true);
            showMsg("请添加默认地址！");
        }
    }


    function init() {
        $("#textShow").hide();
        initPayBtn();
        //点击图片进入商品详情
        $(".order-box img").click(function(){
            var goodsId=$(this).prev(".goodsId").text();
            window.location = "goods/goodsDetail?goodsId=" + goodsId;
        });
    }

    init();
});
