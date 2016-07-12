"use strict";
$(function() {
    //获取商品信息
    function getGoods() {
        $.get("/cart", {}, function (data) {
            $(data).each(function (index,goods) {
                var newGoods = $("#goodsContainer").find("div.main-item").clone();
                newGoods.find("div.cartId").text(index);
                newGoods.find("img").attr("src", "../upload/" + goods.picture);
                newGoods.find("div.goods-info").find("p:eq(0)").text(goods.brand);
                newGoods.find("div.goods-info").find("p:eq(1)").text(goods.size);
                newGoods.find("div.goods-info").find("p:eq(2)").text("￥"+goods.price);
                $("#container").append(newGoods);
                //复选框事件
                $("#container").find(".select").attr("checked", true)
                            .click(function () {
                                setTotal();
                });
                //增加按钮
                $("#container").find(".shopping-cart-add").eq(index).click(function(){
                    var num = parseInt($("#container").find(".shopping-cart-sum").eq(index).text());
                    num++;
                    $("#container").find(".shopping-cart-sum").eq(index).text(num);
                    setTotal();
                });
                //减少按钮
                $("#container").find(".shopping-cart-reduce").eq(index).click(function(){
                    var num = parseInt($("#container").find(".shopping-cart-sum").eq(index).text());
                    $("#container").find(".shopping-cart-sum").eq(index).text(num <= 1 ? 1 : num - 1);
                    setTotal();
                });
                //删除按钮
                $("#container").find(".goods-del").eq(index).click(function () {
                    //$(this).eq(index).parent().remove();
                    var cartId = $("#container").find(".cartId").eq(index).text();
                    //removeGoods(cartId);
                    $.ajax({
                        url:'/cart/cart/{cartId}',
                        type:'DELETE',
                        success:function(){
                        $("main-item").eq(index).parent().remove();
                    }
                    });
                    setTotal();
                });
                setTotal();
            });
        }, "json");
    }
    //计算总价
    function setTotal() {
        var $obj = $(".goods-info");
        var sum = 0;
        $obj.each(function (index,goods) {
            //获得商品价格
            var price = parseFloat($("#container").find(".goods-info").find("p:eq(2)").eq(index).text().substring(1));
            //获得商品数量
            var num = parseInt($("#container").find(".shopping-cart-sum").eq(index).text());
            var eachSum = num * price;
            if ($("#container").find(".select").eq(index).is(':checked')) {
                sum += eachSum;  //累加计算总价
            }
        $("div.up-to-pay").find("ul").find("li:eq(0)").find("b").text("￥" + sum);
        });
    }
    //付款
    function pay(cartAndNum) {
        $.get("/cart/orderConfirm", {cartAndNum: cartAndNum}, function (data) {
            console.log(data);
        }, "json");
    }
    function init() {
        //购物车商品初始化
        getGoods();
        //编辑按钮
        var edit=$("div.header-box").find(".header-right");
        $("#container").find(".goods-del").hide();
        edit.click(function () {
            if (edit.html() == "编辑") {
                $("#container").find(".goods-del").show();
                edit.html("完成");
            }
            else {
                $("#container").find(".goods-del").hide();
                edit.html("编辑");
            }
        });
        //删除按钮
        //$(".goods-del").click(function () {
        //    $(this).parent().remove();
        //    var goodsId = $(this).parent().find(".goodsId").html();
        //    removeGoods(goodsId);
        //    setTotal();
        //});
        //付款按钮
        $(".pay").click(function () {
            var cart= $("#container").find("div.cartId");
            var cartAndNum = "";
            cart.each(function (index,goods) {
                if ($("#container").find(".select").eq(index).is(':checked')) {
                    var id =cart.eq(index).text();
                    alert(id);
                    var num = parseInt($("#container").find(".shopping-cart-sum").eq(index).text());
                    cartAndNum += id + "-" + num + ",";
                }
            });
            pay(cartAndNum);
        });
    }

    init();
});
