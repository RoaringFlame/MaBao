"use strict";
$(function(){
    var currentPage=0;
    var pageSize=4;
    var searchKey="";
    var goodsTypeId="";
    var myScroll;
    var upOrDown="";
    function initGoodsTypeAndCarousel(){
        $.get("/home",{},function(data){
            //初始化轮播
            var smallBanner= data.smallBanner;
            var myCarousel=$("#myCarousel");
            $(smallBanner).each(function(index,banner){
                var li=$("<li></li>")
                    .attr("data-target","#myCarousel")
                    .attr("data-slide-to",index);
                var img=$("<div></div>").addClass("item").append(
                    $("<img>")
                        .attr("src","../upload/"+banner.picture)
                        .attr("alt",banner.alt)
                        .click(function(){
                            window.location="/goods/goodsDetail?goodsId="+banner.goodsId;
                        })
                );
                if(index==0){
                    li.addClass("active");
                    img.addClass("active");
                }
                myCarousel.find(".carousel-indicators").append(li);
                myCarousel.find(".carousel-inner").append(img);
            });
            //初始化类型列表
            var typeSidebar=$("#sidebar");
            $("#searchBox").find("div.column").click(function(){
                typeSidebar.toggleClass("hide");
            });
            var typeList=data.goodsTypeList;
            $(typeList).each(function(index,goodsType){
                var li=$("<li></li>").append(
                    $("<a></a>")
                        .attr("href","#")
                        .text(goodsType.value)
                ).click(function(){
                        goodsTypeId=goodsType.key;
                        loadNewGoods();
                });
                typeSidebar.find("ul").append(li);
            });
            //初始化搜索文本框
            $("#btnSearch").click(function(){
                searchKey=$(this).next("input").val();
                loadNewGoods();
            });
        },"json");
    }
    function initGoods(){
        loadNewGoods();
    }
    //加载新品数据集
    function loadNewGoods(){
        var params={
            page:currentPage,
            pageSize:pageSize,
            searchKey:searchKey,
            goodsTypeId:goodsTypeId
        };
        var backGoods=$("#hideGoods").find("li");
        var newGoodsBox=$("#newGoodsList");
        $.get("/home/goodsSearch",{params:params},function(data){
            var goodsList=data.items;
            $(goodsList).each(function(index,goods){
                var newGoods=backGoods.clone();
                newGoods.find("img").attr("src","../upload/"+goods.picture);
                newGoods.find("div>p:eq(0)>span:eq(0)").text("￥"+goods.price);
                newGoods.find("div>p:eq(0)>span:eq(1)").text(goods.newDegree);
                newGoods.find("div>p:eq(1)").text(goods.brand);
                newGoods.find("div>p:eq(2)").text(goods.title);
                newGoodsBox.append(newGoods);
            });
        },"json");
    }
    function init(){
        initGoodsTypeAndCarousel();
        initGoods();
        $("#newGoodsList").show();
        $("#likeGoodsList").hide();
        var newGoods=$("#newGoods");
        newGoods.find("div.scroll-menu ul li:eq(0)").click(function(){
            $(this).find("a").addClass("focus");
            $(this).next("li").find("a").removeClass("focus");
            $("#newGoodsList").show();
            $("#likeGoodsList").hide();
        });
        newGoods.find("div.scroll-menu ul li:eq(1)").click(function(){
            $(this).find("a").addClass("focus");
            $(this).prev("li").find("a").removeClass("focus");
            $("#newGoodsList").hide();
            $("#likeGoodsList").show();
        });
        //拉动刷新
        myScroll=new iScroll("wrapper",{
            onRefresh: function () {
                console.log(1);
            },
            onScrollMove: function () {
                if(this.y>5){
                    upOrDown="up";
                }
                else if(this.y<-5){
                    upOrDown="down";
                }
            },
            onScrollEnd: function () {
                if(upOrDown=="up"){
                    loadNewGoods();
                }
                else if(upOrDown=="down"){
                    currentPage++;
                    loadNewGoods();
                }
            }
        });
    }
    init();
});