"use strict";
$(function(){
    function initGoodsTypeAndCarousel(){
        $.get("/home",{},function(data){
            console.log(data);
        },"json");
    }
    function initGoods(){

    }
    function init(){
        initGoodsTypeAndCarousel();
        initGoods();
    }
    init();
});