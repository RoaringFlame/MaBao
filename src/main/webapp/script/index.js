"use strict";
$(function () {
    //设置全局参数
    var totalPageNew = 1;                             //新品总页数
    var totalPageLike = 1;                            //猜你喜欢总页数
    var currentPageNew = 0;                           //新品展示页当前页面
    var currentPageLike = 0;                          //猜你喜欢当前页面
    var pageSize = 4;                                 //每页展示的宝物数量
    var searchKey = "";                               //搜索栏搜索关键字
    var goodsTypeId = "";                             //商品类型id
    var myScroll;
    var babyId = null;                                //宝宝id
    var isNew = true;                                 //是否当前展示的是新品
    var backGoods = $("#hideGoods").find("li");     //查找到新品列表下的li标签
    var newGoodsBox = $("#newGoodsList");           //新品展示
    var typeSidebar = $("#sidebar");                 //侧边栏

    //首页信息初始化
    function initIndexPage() {
        MB.sendAjax("get", "/home", {}, function (data) {
            //console.log(data);
            //侧边栏的初始化
            $("#searchBox").find("div.column").click(function () {
                typeSidebar.toggleClass("hide");                  //侧边栏的隐藏与显示，toggleClass()函数，当属性存在则移除，当属性不存在则添加属性
            });
            var typeList = data.goodsTypeList;
            typeList.unshift({key: "", value: "所有"});          //添加点击跳所有的选项，unshift() 方法可向数组的开头添加一个或更多元素，并返回新的长度
            $(typeList).each(function (index, goodsType) {
                var li = $("<li></li>")
                    .text(goodsType.value)
                    .click(function () {
                        if (index > 0) {                           //去掉下标为0的值
                            goodsTypeId = goodsType.key;           //获取商品类型id
                        }
                        else {
                            goodsTypeId = null;                   //设置商品id为空
                        }
                        newGoodsBox.empty();                       //点击完后清空信息
                        loadNewGoods();
                    });
                typeSidebar.find("ul").append(li);
            });
            //搜索框的初始化
            $("#btnSearch").click(function () {
                searchKey = $(this).next("input").val();
                newGoodsBox.empty();
                loadNewGoods();
            });
            //轮播的初始化
            var smallBanner = data.smallBanner;                                                  //获取轮播图片集
            var myCarousel = $("#myCarousel");                                                 //找到jsp页面对应id为myCarousel的项
            //遍历获取到的轮播图片集,index为索引（从0开始），banner自己定义的名称用来取smallBanner中的值
            $(smallBanner).each(function (index, banner) {
                var li = $("<li></li>")                                       //添加li标签并为其添加属性值
                    .attr("data-target", "#myCarousel")
                    .attr("data-slide-to", index);
                                    var img = $("<div></div>").addClass("item")                //在div中添加一些属性
                    .append($("<img>")
                        .attr("src", MB.getRootPath() + "/upload/" + banner.picture)           //添加图片
                        .attr("alt", banner.alt)                                                //添加提示信息
                        .click(function () {                                                    //点击图片跳转到商品详情
                            window.location = "/goods/goodsDetail?goodsId=" + banner.id;
                        })
                    );
                if (index == 0) {
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
            if (data.baby) {
                babyId = data.baby.id;
                babyId = null;
            }

            //猜你喜欢，初始化宝宝性别
            var genderList = data.gender;
            var genderSelector = $("#sex");
            $(genderList).each(function (index, gender) {
                var option = $("<option></option>").val(gender.key).text(gender.value);
                if (index == 0) {
                    option.attr("checked", true);
                }
                genderSelector.append(option);
            });
            //加载新品和猜你喜欢
            initGoods();
            //加载表单信息
            initFormAction();
        });

    }

    //初始化新品和猜你喜欢的切换
    function initGoods() {
        //$("#likeForm").hide();                                                          //猜你喜欢表单的隐藏
        $("#newGoodsList").show();                                                      //新品页初始化为显示
        $("#likeGoodsList").hide();                                                     //猜你喜欢页初始化为隐藏
        var newGoods = $("#newGoods");
        newGoods.find("div.scroll-menu ul li:eq(0)").click(function () {              //找到div对应的scroll-menu下的ul得第一个li
            $(this).addClass("focus");                                                   //点击新品时给新品加红色下划线
            $(this).next("li").removeClass("focus");                                    //猜你喜欢下无红色下划线
            $("#newGoodsList").show();                                                  //点击新品时新品列表的显示
            $("#likeGoodsList").hide();                                                 //猜你喜欢列表的隐藏
            $("#likeForm").hide();
            isNew = true;                                                                //是否为新品 设为真
        });
        newGoods.find("div.scroll-menu ul li:eq(1)").click(function () {
            $(this).addClass("focus");                                                  //点击猜你喜欢时给新品加红色下划线
            $(this).prev("li").removeClass("focus");                                   //新品无下划线
            $("#newGoodsList").hide();                                                 //点击猜你喜欢列表的显示
            $("#likeGoodsList").show();                                                //新品的隐藏
            $("#likeForm").show();
            isNew = false;                                                              //是否为新品  设为假
        });
        //加载新品
        loadNewGoods();
        //加载猜你喜欢
        loadLikeGoods();
    }

    //加载新品数据集
    function loadNewGoods() {
        var params = {
            page: currentPageNew,                 //新品当前页面数
            pageSize: pageSize,                  //新品每页展示的数据信息
            searchKey: searchKey,                //搜索关键字
            goodsTypeId: goodsTypeId             //宝物对应的id
        };

        if (currentPageNew <= totalPageNew) {
            MB.sendAjax("get", "home/goodsSearch", params, function (data) {
                console.log(data);
                var goodsList = data.items;
                totalPageNew = data.totalPage;                                                    //获取总页数
                $(goodsList).each(function (index, goods) {                                      //对新品进行遍历
                    var newGoods = backGoods.clone();                                             //克隆信息
                    newGoods.find("img").attr("src", MB.getRootPath() + "/upload/" + goods.picture)
                        .click(function () {                                                      //点击图片跳转到商品详情
                            window.location = "/goods/goodsDetail?goodsId=" + goods.id;
                        });
                    newGoods.find("div>p:eq(0)>span:eq(0)").text("￥" + goods.price);
                    newGoods.find("div>p:eq(0)>span:eq(1)").text(goods.newDegree);
                    newGoods.find("div>p:eq(1)").text(goods.brand);
                    newGoods.find("div>p:eq(2)").text(goods.title);
                    newGoodsBox.append(newGoods);
                });
                initScroll();                                                                    //下拉滚动刷新
                typeSidebar.addClass("hide");                                                   //侧边栏添加隐藏样式
            });
        }
    }

    //加载猜你喜欢
    function loadLikeGoods() {
        if (babyId) {                                             //如果宝宝id是存在加载猜你喜欢物品列表页
            var backGoods = $("#hideGoods").find("li");
            var likeGoodsBox = $("#likeGoodsList");
            likeGoodsBox.show();                                  //显示猜你喜欢列表页
            var params = {
                page: currentPageLike,                           //猜你喜欢当前页面
                pageSize: pageSize                               //彩泥喜欢每页展示的宝物数量
            };

            if (currentPageNew <= totalPageLike) {
                MB.sendAjax("get", "home/goodsGuess/baby/" + babyId, params, function (data) {
                    var goodsList = data.items;
                    totalPageNew = data.totalPageLike;                         //获取猜你喜欢总页数
                    $(goodsList).each(function (index, goods) {
                        var likeGoods = backGoods.clone();
                        likeGoods.find("img").attr("src", MB.getRootPath() + "/upload/" + goods.picture);
                        likeGoods.find("div>p:eq(0)>span:eq(0)").text("￥" + goods.price);
                        likeGoods.find("div>p:eq(0)>span:eq(1)").text(goods.newDegree);
                        likeGoods.find("div>p:eq(1)").text(goods.brand);
                        likeGoods.find("div>p:eq(2)").text(goods.title);
                        likeGoodsBox.append(likeGoods);
                    });
                });
            }
        }
        else {                                                                //宝宝信息不存在点击猜你喜欢时显示表单页面
            $("#newGoods").find("li:eq(1)").click(function () {
                $("#likeForm").removeClass("hide");                         //移除表单css样式，显示表单
            });
            $("#likeGoodsList").hide();                                     //猜你喜欢列表页的隐藏
        }
    }

    //猜你喜欢表单初提交
    function initFormAction() {
        $("#btnLikeSubmit").click(function () {
            var likeForm = $("#likeForm");
            var babyName = likeForm.find("input[name='babyName']").val();              //宝宝姓名的获取
            var babyBirthday = likeForm.find("input[name='babyBirthday']").val();     //宝宝生日的获取
            var gender = likeForm.find("select[name='sex']").val();                    //宝宝性别的获取
            var hobby = likeForm.find("input[name='hobby']").val();                    //宝宝爱好的获取
            var params = {
                babyName: babyName,                  //宝宝姓名
                babyBirthday: babyBirthday,         //宝宝生日
                gender: gender,                      //宝宝性别
                hobby: hobby,                        //宝宝爱好
                page: currentPageLike,               //猜你喜欢当前页面
                pageSize: pageSize                  //猜你喜欢每页展示的物品数量
            };
            console.log(params);
            MB.sendAjax("get", "home/goodsGuess", params, function (data) {
                console.log(data);
                console.log("猜你喜欢表单初提交");
                //通过宝宝id是否存在的判断，判断页面的跳转
                loadLikeGoods();
            });
        });
    }

    //拉动刷新和加载更多的实现
    function initScroll() {
        if (myScroll) {
            myScroll.refresh();
        }
        else {
            //拉动刷新
            myScroll = new IScroll('div.iscroll-wrapper');
            myScroll.on("scrollEnd", function () {
                var wrapperHeight = $('div.iscroll-wrapper').height();
                if (myScroll.y - wrapperHeight < myScroll.maxScrollY) {
                    if (isNew) {                        //若为新品页面，新品页面增加
                        currentPageNew++;
                        loadNewGoods();
                    }
                    else {
                        currentPageLike++;              //若为猜你喜欢页面，新品页面增加
                        loadLikeGoods();
                    }
                }
            });
            document.addEventListener('touchmove', function (e) {
                e.preventDefault();
            }, false);
        }
    }

    //初始化函数
    function init() {
        initIndexPage();
    }

    //调用初始化函数
    init();
});