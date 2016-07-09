"use strict";
$(function() {
    function init() {
        //编辑按钮
        $(".edit").click(function(){
            if($(".edit").html()=="编辑") {
                $(".del").show();
                $(".edit").html("完成");
            }
            else {
                    $(".del").hide();
                    $(".edit").html("编辑");
                }
        });
        //默认全选
        $($(".select")).attr("checked",true);
        setTotal();
    }
    //选择框点击事件
    $(".select").click(function(){
        setTotal();
    });
    //删除按钮
    $(".del").click(function(){
        $(this).parent().remove();
        setTotal();
    });
    //增加按钮
    $(".add").click(function () {
        var $num=parseInt($(this).prev().html());
        $(this).prev().html($num+1);
        setTotal();
    });
    //减少按钮
    $(".reduce").click(function () {
        var $num=parseInt($(this).next().html());
        $(this).next().html($num<=1?1:$num-1);
        setTotal();
    });
    //计算总价
    function setTotal(){
        var $obj = $(".del");
        var sum =0;
        $obj.each(function(){
            //获得商品价格
            var $price = parseFloat($(this).prev().find(".mark").html());
            //获得商品数量
            var $count = parseInt($(this).next().find(".sum").html());
            var eachSum =$count*$price;
            //$(this).parent().parent().next().find(".sumPrice").html("￥"+price);//给商品小计赋值
            sum +=eachSum;  //累加计算总价
        });
        $("#sumPrice").html("￥"+sum);
    };


    ////如果商品选中，总价随数值改变.如果取消已勾选的商品，总价会减去该商品的价格
    //if ($($(".select")).is(':checked')) {
    //    $($(".sum")).each(function () {
    //        $(this).keyup(function () {
    //            var num = $(this).html();
    //            if (num != "") {
    //                setTotal();
    //            } else {
    //                $(".sum").val(1);  //赋一个默认数量1
    //                setTotal()();
    //            }
    //        });
    //    });
    //}


    init();

})
