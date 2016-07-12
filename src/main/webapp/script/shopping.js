"use strict";
$(function () {
    var main = $("#container");                      //商品列表容器
    var payForm = $("#frmPay");                      //存储要够买的商品id和num
    var editBtn = $("div.header-box").find(".header-right");
    //获取商品信息
    function getGoods() {
        $.get("/cart", {}, function (data) {
            $(data).each(function (index, goods) {
                var newGoods = $("#goodsContainer").find("div.main-item").clone();             //克隆goodsContainer中商品信息
                newGoods.find("div.cartId").text(goods.id);                                    //从后台获取cartId
                newGoods.find("img").attr("src", "../upload/" + goods.picture);                //从后台获取picture
                newGoods.find("div.goods-info").find("p:eq(0)").text(goods.brand);             //从后台获取brand
                newGoods.find("div.goods-info").find("p:eq(1)").text(goods.size);              //从后台获取size
                newGoods.find("div.goods-info").find("p:eq(2)").text("￥" + goods.price);      //从后台获取price
                main.append(newGoods);                                                         //在main中加入商品信息
            });
            //编辑按钮
            editBtn.click(function () {
                edit();                                //完成按钮变成编辑
                });
            //复选框事件
            main.find(".select")
                .attr("checked", true)        //默认全选
                .click(function () {
                    setTotal();              //复选框点击后重新计算总价
                });
            //增加按钮
            main.find(".shopping-cart-add").click(function () {
                $(this).prev("p").text(parseInt($(this).prev("p").text()) + 1);  //点击增加按钮后商品数量加1
                setTotal();                                                       //点击增加按钮后重新计算总价
            });
            //减少按钮
            main.find(".shopping-cart-reduce").click(function () {
                var num = parseInt($(this).next("p").text());                   //获取商品数量
                $(this).next("p").text(num <= 1 ? 1 : num - 1);                 //如果商品数量为1则商品数量不变，否则商品数量减1
                setTotal();                                                     //点击减少按钮后重新计算总价
            });
            //删除按钮
            main.find(".goods-del")
                .hide()
                .click(function () {
                    var cartId = $(this).prevAll("div.cartId").text();
                    var delItem = $(this).parent();
                    $.ajax({
                        url: "/cart/deleteGoods/" + cartId,
                        type: 'DELETE',
                        success: function () {
                            alert("OK");
                            delItem.remove();                //删除购物车商品
                        }
                    });
                    setTotal();                              //删除按钮后重新计算总价
                });
            setTotal();
        }, "json");
    }

    //编辑按钮事件
    function edit() {
        if (editBtn.text() == "编辑") {
            main.find(".goods-del").show();                      //点击编辑，删除按钮出现
            editBtn.text("完成");                                //编辑按钮变成完成
        }
        else {
            main.find(".goods-del").hide();                      //点击完成，删除按钮隐藏
            editBtn.text("编辑");                                //完成按钮变成编辑
        }
    }

    //计算总价
    function setTotal() {
        var sum = 0;
        main.find(".goods-info").each(function () {
            var price = parseFloat($(this).find("p:eq(2)").text().substring(1));            //获得商品价格
            var num = parseInt($(this).next().next().find("p").text());                     //获得商品数量
            var eachSum = num * price;                                                      //每一件商品数量
            if ($(this).prev().prev().find("input").is(':checked')) {
                sum += eachSum;  //累加计算总价
            }
            $("div.up-to-pay").find("ul li:eq(0) b").text("￥" + Math.round(sum * 100) / 100);   //总价
        });
    }

    //付款
    function pay(cartAndNum) {
        payForm.find("input[name='cartAndNum']").val(cartAndNum);                   //给表单中的input赋值
        payForm.submit();                                                           //提交表单
    }

    function init() {
        //购物车商品初始化
        getGoods();
        //编辑按钮
        //var edit = $("div.header-box").find(".header-right");
        //edit.click(function () {
        //    if (edit.text() == "编辑") {
        //        main.find(".goods-del").show();                    //点击编辑，删除按钮出现
        //        edit.text("完成");                                 //编辑按钮变成完成
        //    }
        //    else {
        //        main.find(".goods-del").hide();                   //点击完成，删除按钮隐藏
        //        edit.text("编辑");                                //完成按钮变成编辑
        //    }
        //});
        //付款按钮
        $(".pay").click(function () {
            var cart = main.find("div.cartId");
            var cartAndNum = "";                                                               //存储cartId和num
            cart.each(function () {
                if (main.find(".select").is(':checked')) {
                    var id = $(this).text();                                                  //获取cartId
                    var num = parseInt($(this).nextAll(".shopping-cart").find("p").text());   //获取num
                    cartAndNum += id + "-" + num + ",";                                        //以“1-1，2-1，3-1”形式存储cartId和num
                }
            });
            cartAndNum = cartAndNum.substring(0, cartAndNum.length - 1);
            pay(cartAndNum);
        });
    }

    init();
});
