"use strict";
$(function(){
    var currentPageNew=0;
    var currentPageLike=0;
    var pageSize=4;
    var searchKey="";
    var goodsTypeId="";
    var myScroll;
    var upOrDown="";
    var babyId=null;
    var isNew=true;     //是否当前展示的是新品
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
            //初始化宝宝信息
            if(data.baby){
                babyId=data.baby.id;
                babyId=null;
            }
            //初始化宝宝性别
            var genderList=data.gender;
            var genderSelector=$("#sex");
            $(genderList).each(function(index,gender){
                var option=$("<option></option>").val(gender.key).text(gender.value);
                genderSelector.append(option);
            });
            initGoods();
        },"json");
    }

    function initGoods(){
        //初始化新品和猜你喜欢的切换
        $("#newGoodsList").show();
        $("#likeGoodsList").hide();
        var newGoods=$("#newGoods");
        newGoods.find("div.scroll-menu ul li:eq(0)").click(function(){
            $(this).find("a").addClass("focus");
            $(this).next("li").find("a").removeClass("focus");
            $("#newGoodsList").show();
            $("#likeGoodsList").hide();
            isNew=true;
        });
        newGoods.find("div.scroll-menu ul li:eq(1)").click(function(){
            $(this).find("a").addClass("focus");
            $(this).prev("li").find("a").removeClass("focus");
            $("#newGoodsList").hide();
            $("#likeGoodsList").show();
            isNew=false;
        });
        //加载新品
        loadNewGoods();
        //加载猜你喜欢
        loadLikeGoods();
    }
    //加载猜你喜欢
    function loadLikeGoods(){
        if(babyId){
            var backGoods=$("#hideGoods").find("li");
            var likeGoodsBox=$("#likeGoodsList");
            $("#likeForm").hide();
            likeGoodsBox.show();
            var params={
                page:currentPageLike,
                pageSize:pageSize
            };
            $.get("/home/goodsGuess/baby/"+babyId,{params:params},function(data){
                var goodsList=data.items;
                $(goodsList).each(function(index,goods){
                    var likeGoods=backGoods.clone();
                    likeGoods.find("img").attr("src","../upload/"+goods.picture);
                    likeGoods.find("div>p:eq(0)>span:eq(0)").text("￥"+goods.price);
                    likeGoods.find("div>p:eq(0)>span:eq(1)").text(goods.newDegree);
                    likeGoods.find("div>p:eq(1)").text(goods.brand);
                    likeGoods.find("div>p:eq(2)").text(goods.title);
                    likeGoodsBox.append(likeGoods);
                });
                initScroll();
            });
        }
        else{
            $("#likeForm").show();
            $("#likeGoodsList").hide();
        }
    }
    //加载新品数据集
    function loadNewGoods(){
        var params={
            page:currentPageNew,
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
            initScroll();
        },"json");
    }
    function initScroll(){
        if(myScroll){
            myScroll.refresh();
        }
        else{
            //拉动刷新
            myScroll = new IScroll('div.iscroll-wrapper');
            myScroll.on("scrollEnd",function(){
                var wrapperHeight=$('div.iscroll-wrapper').height();
                if(myScroll.y-wrapperHeight<myScroll.maxScrollY){
                    if(isNew){
                        currentPageNew++;
                        loadNewGoods();
                    }
                    else{
                        if(babyId){
                            currentPageLike++;
                            loadLikeGoods();
                        }
                        else{
                            console.log(112);
                        }
                    }
                }
                //console.log(currentPageNew+"------"+myScroll.y+"-"+myScroll.absStartY+"-"+myScroll.distY+"-"+myScroll.maxScrollY);
            });
            document.addEventListener('touchmove', function (e) { e.preventDefault(); }, false);
        }
    }

    function initFormAction(){
        $("#btnLikeSubmit").click(function () {
            var likeForm=$("#likeForm");
            var babyName=likeForm.find("input[name='babyName']").val();
            var babyDate=likeForm.find("input[name='babyDate']").val();
            var babyName=likeForm.find("input[name='babyName']").val();
            var hobby=likeForm.find("input[name='hobby']").val();
        });
    }
    function init(){
        initGoodsTypeAndCarousel();
    }
    init();
});