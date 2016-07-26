"use strict";
$(function () {
    var main = $("#container");                                //商品列表容器
    var payForm = $("#frmPay");                                //存储要购买的商品cartId
    var editBtn = $("div.header-box").find(".header-right");   //编辑按钮
    var payBtn = $(".pay");
    var cartIds;                                          //存储cartId
    //获取商品信息
    function getGoods() {
        MB.sendAjax("get", "cart/showCart", {}, function (data) {
            $(data).each(function (index, goods) {
                var newGoods = $("#goodsContainer").find("div.main-item").clone();                       //克隆goodsContainer中商品信息
                newGoods.find("div.cartId").text(goods.id);                                              //从后台获取cartId
                newGoods.find("img").attr("src", MB.getRootPath() + "/upload/" + goods.picture);                          //从后台获取picture
                newGoods.find("div.goods-info").find("p:eq(0)").text(goods.brand);                       //从后台获取brand
                newGoods.find("div.goods-info").find("p:eq(1)").text(goods.size);                        //从后台获取size
                newGoods.find("div.goodsId").text(goods.goodsId);                                              //从后台获取cartId
                newGoods.find("div.goods-info").find("p:eq(2)").text("￥" + goods.price.toFixed(2));                //从后台获取price
                newGoods.find("div.shopping-cart").find("p").text(goods.quantity);                       //从后台获取quantity
                main.append(newGoods);                                                                   //在main中加入商品信息
            });
            //复选框事件
            main.find(".select")
                .attr("checked", true)        //默认全选
                .click(function () {
                    setTotal();               //复选框点击后重新计算总价
                    isPay();                  //判断付款按钮是否可用
                });
            //增加按钮
            main.find(".shopping-cart-add").click(function () {
                var cartId = $(this).parent().prevAll("div.cartId").text();           //获取当前商品的cartId
                var num = parseInt($(this).prev("p").text());                         //获取当前商品数量
                MB.sendAjax("get", "cart/changeNum/" + cartId, {opt: 1}, function () {
                    setTotal();                          //点击增加按钮后重新计算总价
                });
                $(this).prev("p").text(num + 1);
            });
            //减少按钮
            main.find(".shopping-cart-reduce").click(function () {
                var cartId = $(this).parent().prevAll("div.cartId").text();          //获取当前商品的cartId
                var num = parseInt($(this).next("p").text());                        //获取当前购物车商品数量
                MB.sendAjax("get", "cart/changeNum/" + cartId, {opt: 2}, function () {
                    setTotal();                                               //点击减少按钮后重新计算总价
                });
                $(this).next("p").text(num <= 1 ? 1 : num - 1);                       //如果商品数量为1则商品数量不变，否则商品数量减1
            });
            //删除按钮
            main.find(".goods-del").click(function () {
                var cartId = $(this).prevAll("div.cartId").text();
                var delItem = $(this).parent();
                MB.sendAjax("DELETE", "cart/deleteGoods/" + cartId, {}, function () {
                    delItem.remove();          //删除购物车商品
                    setTotal();                //点击删除按钮后重新计算总价
                    cartIds = cartIds.replace(cartId + ",", '');                          //从cartIds中删除已经删除的商品的cartId
                    if (cartIds == "") {
                        payBtn.removeClass("confirm");                                    //如果cartIds为空则按钮为灰色，不可点击
                        payBtn.addClass("disabled");
                        payBtn.attr("disabled", true);
                    }

                });

            });
            //点击图片进入商品详情
            main.find(".main-item").find("img").click(function () {
                var goodsId = $(this).prevAll(".goodsId").text();
                window.location = "goods/goodsDetail?goodsId=" + goodsId;
            });
            //点击商品信息进入商品详情
            $(".goods-info").click(function () {
                var goodsId = $(this).prevAll(".goodsId").text();
                window.location = "goods/goodsDetail?goodsId=" + goodsId;
            });
            setTotal();                      //计算总价
            initEdit();                      //编辑按钮初始化
            isPay();
        });
    }

    //编辑按钮事件
    function initEdit() {
        main.find(".goods-del").hide();                              //点击编辑，删除按钮出现
        editBtn.text("编辑");
        editBtn.click(function () {
            if (editBtn.text() == "编辑") {
                main.find(".goods-del").show();                      //点击编辑，删除按钮出现
                editBtn.text("完成");                                //编辑按钮变成完成
            }
            else {
                main.find(".goods-del").hide();                      //点击完成，删除按钮隐藏
                editBtn.text("编辑");                                //完成按钮变成编辑
            }
        });
    }

    //计算总价
    function setTotal() {
        $("div.up-to-pay").find("ul li:eq(0) b").text("￥0.00");                            //初始化总价为0
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
    function pay(cartIds) {
        cartIds = cartIds.substring(0, cartIds.length - 1);
        payForm.find("input[name='cartIds']").val(cartIds);                   //给表单中的input赋值字符串
        payForm.submit();                                                    //提交表单
    }


    //判断付款按钮是否可用
    function isPay() {
        cartIds = "";                                                          //cartId初始化
        main.find("div.cartId").each(function (index) {
            if (main.find(".select").eq(index).is(':checked')) {
                var id = $(this).text();                                     //获取cartId
                cartIds += id + ",";                                           //以“1,2,3”形式存储cartId
            }
        });
        if (cartIds !== "") {
            payBtn.removeClass("disabled");                                    //如果cartId不为空则按钮为红色，可点击
            payBtn.addClass("confirm");
            payBtn.attr("disabled", false);
        } else {
            payBtn.removeClass("confirm");                                    //如果cartId为空则按钮为灰色，不可点击
            payBtn.addClass("disabled");
            payBtn.attr("disabled", true);
        }
    }

    function init() {
        //购物车商品初始化
        getGoods();
        //付款按钮点击事件
        payBtn.click(function () {
            //pay(cartIds);
        });

    }

    init();
});
