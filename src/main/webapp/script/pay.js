/**
 * Created by maxu on 2016/7/10.
 */
"use strict";
$(function(){
    function init(){
        //点击按钮跳转到所有收货地址页面
        $(".add-jump-arrow").click(function(){
            $.get("/user/address/userAllAddress",{},function(data){
                console.log(data);
            });
        });
        //宝物点击事件

    }
    init();
});
