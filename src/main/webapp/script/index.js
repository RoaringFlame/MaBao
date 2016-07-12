"use strict";
$(function () {

    var currentPageNew=1;
    var currentPageLike=1;
    var pageSize=4;
    var searchKey="";
    var goodsTypeId="";
    var myScroll;
    var upOrDown="";
    var babyId=null;
    var isNew=true;     //是否当前展示的是新品

    //1.首页信息初始化
    function initIndexPage(){
        $.get("/home",{},function(data){
            console.log(data);

            //1.侧边栏的初始化
            var typeSidebar=$("#sidebar");
            $("#searchBox").find("div.column").click(function(){
                typeSidebar.toggleClass("hide");
            });
            var typeList=data.goodsTypeList;
            $(typeList).each(function(index,goodsType){
                var li=$($("<li></li>")
                        .text(goodsType.value)
                ).click(function(){
                    if(index>0){
                    goodsTypeId=goodsType.key;
                    loadNewGoods();
                    }
                });
                typeSidebar.find("ul").append(li);
            });

            //2.搜索框的初始化
            $("#btnSearch").click(function(){
                searchKey=$(this).next("input").val();
                loadNewGoods();
            });

            //3.轮播的初始化
            var smallBanner=data.smallBanner;//获取轮播图片集
            var myCarousel=$("#myCarousel");//找到jsp页面对应id为myCarousel的项
            //遍历获取到的轮播图片集,index为索引（从0开始），banner自己定义的名称用来取smallBanner中的值
            $(smallBanner).each(function(index,banner){
                var li=$("<li></li>")//添加li标签并为其添加属性值
                    .attr("data-target","#myCarousel")
                    .attr("data-slide-to",index)
                var img=$("<div></div>").addClass("item")//在div中添加一些属性
                    .append($("<img>")
                    .attr("src","../upload/"+banner.picture)//添加图片
                    .attr("alt",banner.alt)//添加提示信息
                    .click(function(){//点击图片跳转到商品详情
                        window.location="/goods/goodsDetail?goodsId="+banner.id;
                    })
                    );
                if(index==0){
                    //索引为0的轮播图设0为主轮播图
                    li.addClass("active");
                    img.addClass("active");
                }
                //将li标签信息添加到轮播导航中
                myCarousel.find(".carousel-indicators").append(li);
                //将img标签信息添加到论波栏目中
                myCarousel.find(".carousel-inner").append(img);
            });

            //猜你喜欢，初始化宝宝信息
            if(data.baby){
                babyId=data.baby.id;
                babyId=null;
            }

            //猜你喜欢，初始化宝宝性别
            var genderList=data.gender;
            var genderSelector=$("#sex");
            $(genderList).each(function(index,gender){
                var option=$("<option></option>").val(gender.key).text(gender.value);
                genderSelector.append(option);
            });

            //加载新品和猜你喜欢
            initGoods();

        },"json");
    }

    //2.初始化新品和猜你喜欢的切换
    function initGoods(){
        //$("#likeForm").hide();//猜你喜欢表单的隐藏
        $("#newGoodsList").show();//新品页初始化为显示
        $("#likeGoodsList").hide();//猜你喜欢页初始化为隐藏
        var newGoods=$("#newGoods");
        newGoods.find("div.scroll-menu ul li:eq(0)").click(function(){//找到div对应的scroll-menu下的ul得第一个li
            $(this).addClass("focus");//点击新品时给新品加红色下划线
            $(this).next("li").removeClass("focus");//猜你喜欢下无红色下划线
            $("#newGoodsList").show();//点击新品时新品列表的显示
            $("#likeGoodsList").hide();//猜你喜欢列表的隐藏
            isNew=true;//是否为新品 设为真
        });
        newGoods.find("div.scroll-menu ul li:eq(1)").click(function(){
            $(this).addClass("focus");//点击猜你喜欢时给新品加红色下划线
            $(this).prev("li").removeClass("focus");//新品无下划线
            $("#newGoodsList").hide();//点击猜你喜欢列表的显示
            $("#likeGoodsList").show();//新品的隐藏
            isNew=false;//是否为新品  设为假
        });
        //加载新品
        loadNewGoods();
        //加载猜你喜欢
        loadLikeGoods();
    }

    //3.加载新品数据集
    function loadNewGoods(){
        $("#likeForm").show();//猜你喜欢表单的隐藏
        var params={
            page:currentPageNew,//新品当前页面数
            pageSize:pageSize,//新品每页展示的数据信息
            searchKey:searchKey,//搜索关键字
            goodsTypeId:goodsTypeId//宝物对应的id
        };
        var backGoods=$("#hideGoods").find("li");//查找到新品列表下的li标签
        var newGoodsBox=$("#newGoodsList");//新品展示
        $.get("/home/goodsSearch",{params:params},function(data){
            //打印从后台取出的数据信息
            console.log(data);
            var goodsList=data.items;
            $(goodsList).each(function(index,goods){//对新品进行遍历
                var newGoods=backGoods.clone();//克隆信息
                newGoods.find("img").attr("src","../upload/"+goods.picture)
                    .click(function(){//点击图片跳转到商品详情
                        window.location="/goods/goodsDetail?goodsId="+goods.id;
                    });
                newGoods.find("div>p:eq(0)>span:eq(0)").text("￥"+goods.price);
                newGoods.find("div>p:eq(0)>span:eq(1)").text(goods.newDegree);
                newGoods.find("div>p:eq(1)").text(goods.brand);
                newGoods.find("div>p:eq(2)").text(goods.title);
                newGoodsBox.append(newGoods);
            });
            //initScroll();
        },"json");
    }


    //4.加载猜你喜欢
    function loadLikeGoods(){
        if(babyId){//如果宝宝id是存在
            //$("#likeForm").hide();//猜你喜欢表单的隐藏
            var backGoods=$("#hideGoods").find("li");
            var likeGoodsBox=$("#likeGoodsList");
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
            });
        }
        else{
            //宝宝信息不存在点击猜你喜欢时显示表单页面
            $("#newGoods").find("li:eq(1)").click(function(){
                $("#likeForm").show();
            })
            $("#likeGoodsList").hide();
        }
    }

    //猜你喜欢表单初始化
    function initFormAction(){
        $("#btnLikeSubmit").click(function () {
            var likeForm=$("#likeForm");
            var babyName=likeForm.find("input[name='babyName']").val();
            var babyDate=likeForm.find("input[name='babyDate']").val();
            var babySex=likeForm.find("input[name='babySex']").val();
            var hobby=likeForm.find("input[name='hobby']").val();
        });
    }


    //5.初始化函数
    function init(){
        initIndexPage();
    }

    //6.调用初始化函数
    init();

});