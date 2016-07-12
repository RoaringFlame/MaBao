"use strict";
$();
$(function() {
    var main=$("#container");
    var payForm=$("#frmPay");
    //获取商品信息
    function getGoods() {
        $.get("/cart", {}, function (data) {
            console.log(data);
            $(data).each(function (index,goods) {
                var newGoods = $("#goodsContainer").find("div.main-item").clone();
                newGoods.find("div.cartId").text(goods.cartId);
                newGoods.find("img").attr("src", "../upload/" + goods.picture);
                newGoods.find("div.goods-info").find("p:eq(0)").text(goods.brand);
                newGoods.find("div.goods-info").find("p:eq(1)").text(goods.size);
                newGoods.find("div.goods-info").find("p:eq(2)").text("￥"+goods.price);
                main.append(newGoods);
            });
            main.find(".select")        //复选框事件
                .attr("checked",true)
                .click(function () {
                    setTotal();
                });
            //增加按钮
            main.find(".shopping-cart-add").click(function(){
                $(this).prev("p").text(parseInt($(this).prev("p").text())+1);
                setTotal();
            });
            //减少按钮
            main.find(".shopping-cart-reduce").click(function(){
                $(this).prev("p").text(parseInt($(this).prev("p").text())-1);
                setTotal();
            });
            //删除按钮
            main.find(".goods-del").click(function(){
                var cartId = $(this).prevAll("div.cartId").text();
                var delItem=$(this).parent();
                alert(cartId);
                //removeGoods(cartId);
                $.ajax({
                    url:"/cart/cart/"+cartId,
                    type:'DELETE',
                    success:function(){
                        alert("OK");
                        delItem.remove();
                    }
                });
                setTotal();
            });
            setTotal();
        }, "json");
    }
    //计算总价
    function setTotal() {
        var $obj = $(".goods-info");
        var sum = 0;
        $obj.each(function (index,goods) {
            //获得商品价格
            var price = parseFloat(main.find(".goods-info").find("p:eq(2)").eq(index).text().substring(1));
            //获得商品数量
            var num = parseInt(main.find(".shopping-cart-sum").eq(index).text());
            var eachSum = num * price;
            if (main.find(".select").eq(index).is(':checked')) {
                sum += eachSum;  //累加计算总价
            }
            $("div.up-to-pay").find("ul li:eq(0) b").text("￥" + Math.round(sum*100)/100);
        });
    }
    //付款
    function pay(cartAndNum) {
        payForm.find("input[name='cartAndNum']").val(cartAndNum);
        payForm.submit();
    }
    function init() {
        //购物车商品初始化
        getGoods();
        //编辑按钮
        var edit=$("div.header-box").find(".header-right");
        main.find(".goods-del").hide();
        edit.click(function () {
            if (edit.html() == "编辑") {
                main.find(".goods-del").show();
                edit.html("完成");
            }
            else {
                main.find(".goods-del").hide();
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
            var cart= main.find("div.cartId");
            var cartAndNum = "";
            cart.each(function (index) {
                if (main.find(".select").eq(index).is(':checked')) {
                    var id =cart.eq(index).text();
                    alert(id);
                    var num = parseInt(main.find(".shopping-cart-sum").eq(index).text());
                    cartAndNum += id + "-" + num + ",";
                }
            });
            pay(cartAndNum);
        });
    }

    init();
});
