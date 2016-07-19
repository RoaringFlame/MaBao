"use strict";
$(function () {
    //设置全局参数
    var totalPageNew = 1;                             //新品总页数
    var totalPageLike = 1;                            //猜你喜欢总页数
    var currentPageNew = 0;                           //新品展示页当前页面
    var currentPageLike = 0;                          //猜你喜欢当前页面
    var pageSize = 4;                                 //每页展示的宝物数量
    var goodsTypeId = "";                             //商品类型id
    var myScroll = "";                                //轮播
    var baby = null;                                    //宝宝对象
    var isNew = true;                                   //是否当前展示的是新品
    var backGoods = $("#hideGoods").find("li");         //查找到新品列表下的li标签
    var newGoodsBox = $("#newGoodsList");          //新品展示
    var likeGoodsBox = $("#likeGoodsList");        //猜你喜欢展示
    var typeSidebar = $("#sidebar");                //侧边栏
    var newGoods = $("#newGoods");                  //新品
    //侧边栏初始化
    function initGoodsType(typeList){
        $("#searchBox").find("div.column").click(function () {
            typeSidebar.toggleClass("hide");                  //侧边栏的隐藏与显示，toggleClass()函数，当属性存在则移除，当属性不存在则添加属性
        });
        typeList.unshift({key: "", value: "所有"});          //添加点击跳转所有的选项，unshift()方法可向数组的开头添加一个或更多元素，并返回新的长度
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
                    if (isNew == true) {                     //如果按钮在新品页面点击商品类型直接切换
                        newGoodsBox.empty();                  //点击完后清空信息
                        currentPageNew = 0;                   //点击完后页面定位0
                        loadNewGoods();                       //数据清空后重新加载分类页面
                    } else if (isNew == false) {             //如果按钮再猜你喜欢页面点击商品类型控制切换
                        //找到div对应的scroll-menu下的ul得第一个li
                        newGoods.find("div.scroll-menu ul li:eq(0)").addClass("focus");                                  //点击新品时给新品加红色下划线
                        newGoods.find("div.scroll-menu ul li:eq(1)").removeClass("focus");                               //猜你喜欢下无红色下划线
                        newGoodsBox.show();                                                 //点击新品时新品列表的显示
                        likeGoodsBox.hide();                                                //猜你喜欢列表的隐藏
                        newGoodsBox.empty();                                                //点击完后清空信息
                        currentPageNew = 0;                                                 //点击完后页面定位0
                        loadNewGoods();                                                     //数据清空后重新加载分类页面
                    }
                });
            typeSidebar.find("ul").append(li);
        });
    }
    //搜索框初始化
    function initSearch(){
        $("#txtSearch").change(function () {                 //手机上点击完成实现搜索
            if (isNew == true) {
                newGoodsBox.empty();
                currentPageNew = 0;                            //点击完后页面定位0
                loadNewGoods();
            } else if (isNew == false) {
                //找到div对应的scroll-menu下的ul得第一个li
                newGoods.find("div.scroll-menu ul li:eq(0)").addClass("focus");                                  //点击新品时给新品加红色下划线
                newGoods.find("div.scroll-menu ul li:eq(1)").removeClass("focus");                               //猜你喜欢下无红色下划线
                newGoodsBox.show();                                                 //点击新品时新品列表的显示
                likeGoodsBox.hide();                                                //猜你喜欢列表的隐藏
                newGoodsBox.empty();                   //点击完后清空信息
                currentPageNew = 0;                    //点击完后页面定位0
                loadNewGoods();
            }
        });
    }
    //轮播初始化
    function initCarousel(smallBanner){                                              //获取轮播图片集
        var myCarousel = $("#myCarousel");                                                 //找到jsp页面对应id为myCarousel的项
        $(function () {                                                                     //设定轮播时间2秒
            $('.carousel').carousel({
                interval: 2000
            })
        });
        //遍历获取到的轮播图片集,index为索引（从0开始），banner自己定义的名称用来取smallBanner中的值
        $(smallBanner).each(function (index, banner) {
            var li = $("<li></li>")                                       //添加li标签并为其添加属性值
                .attr("data-target", "#myCarousel")
                .attr("data-slide-to", index);
            var img = $("<div></div>").addClass("item")                  //在div中添加一些属性
                .append($("<img>")
                    .attr("src", MB.getRootPath() + "/upload/" + banner.picture)           //添加图片
                    .attr("alt", banner.alt)                                                //添加提示信息
                    .click(function () {                                                    //点击图片跳转到商品详情
                        window.location = "goods/goodsDetail?goodsId=" + banner.id;
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
    }
    //初始化猜你喜欢
    function initLikeBox(){
        if (data.baby) {
            baby = data.baby;
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
    }
    //初始化新品
    function initNewGoodsBox(){

    }
    //首页信息初始化
    function initIndexPage() {
        MB.sendAjax("get", "home", {}, function (data) {
            console.log("首页信息初始化");
            console.log(data);
            //侧边栏的初始化
            initGoodsType(data.goodsTypeList);
            //轮播的初始化
            initCarousel(data.smallBanner);
            //搜索框的初始化
            initSearch();
            //新品初始化
            initNewGoodsBox();
            //猜你喜欢初始化
            initLikeBox();
        });
    }

    //初始化新品和猜你喜欢的切换
    function initGoods() {
        //进去就加载新品
        $("#newGoodsList").show();                                                          //新品页初始化为显示
        $("#likeGoodsList").hide();                                                         //猜你喜欢页初始化为隐藏
        newGoods.find("div.scroll-menu ul li:eq(0)").click(function () {              //找到div对应的scroll-menu下的ul得第一个li
            if(!isNew){
                console.log("新品的点击正在执行！");
                $(this).addClass("focus");                                                   //点击新品时给新品加红色下划线
                $(this).next("li").removeClass("focus");                                    //猜你喜欢下无红色下划线
                $("#newGoodsList").show();                                                  //点击新品时新品列表的显示
                $("#likeGoodsList").hide();                                                 //猜你喜欢列表的隐藏
                isNew = true;                                                                //是否为新品 设为真
                //加载新品
                loadNewGoods();
            }
        });
        newGoods.find("div.scroll-menu ul li:eq(1)").click(function () {
            if(isNew){
                $(this).addClass("focus");                                                  //点击猜你喜欢时给新品加红色下划线
                $(this).prev("li").removeClass("focus");                                   //新品无下划线
                $("#newGoodsList").hide();                                                 //点击猜你喜欢列表的显示
                $("#likeGoodsList").show();                                                //新品的隐藏
                isNew = false;                                                              //是否为新品  设为假
                //加载猜你喜欢
                loadLikeGoods();
                typeSidebar.addClass("hide");              //侧边栏添加隐藏样式
            }
        });
        loadNewGoods();
    }

    //加载新品数据集
    function loadNewGoods() {
        var params = {
            page: currentPageNew,                             //新品当前页面数
            pageSize: pageSize,                                //新品每页展示的数据信息
            searchKey: $("#txtSearch").val(),                //搜索关键字
            goodsTypeId: goodsTypeId                          //宝物对应的id
        };
        if (currentPageNew <= totalPageNew) {                   //判断当前页面是否小于等于总页数
            MB.sendAjax("get", "home/goodsSearch", params, function (data) {
                //console.log(data);
                var goodsList = data.items;
                totalPageNew = data.totalPage;                                                    //获取总页数
                $(goodsList).each(function (index, goods) {                                      //对新品进行遍历
                    var newGoods = backGoods.clone();                                             //克隆信息
                    newGoods.find("img").attr("src", MB.getRootPath() + "/upload/" + goods.picture)
                        .click(function () {                                                     //点击图片跳转到商品详情
                            window.location = "goods/goodsDetail?goodsId=" + goods.id;
                        });
                    newGoods.find("div>p:eq(0)>span:eq(0)").text("￥" + goods.price);
                    newGoods.find("div>p:eq(0)>span:eq(1)").text(goods.newDegree);
                    newGoods.find("div>p:eq(1)").text(goods.brand);
                    newGoods.find("div>p:eq(2)").text(goods.title);
                    newGoodsBox.append(newGoods);
                });
                initScroll();                               //下拉滚动刷新
                typeSidebar.addClass("hide");              //侧边栏添加隐藏样式
            });
        }
    }

    //加载猜你喜欢
    function loadLikeGoods() {
        currentPageNew = 0;                    //点击完后页面定位0
        newGoodsBox.empty();                   //清空新品列表
        typeSidebar.addClass("hide");                      //侧边栏添加隐藏样式（假设侧边栏被点开时）
        if (baby) {                                        //如果宝宝id是存在加载猜你喜欢物品列表页
            $("#likeForm").hide();
            var backGoods = $("#hideGoods").find("li");
            likeGoodsBox.show();                           //显示猜你喜欢列表页
            var params = {
                name: baby.name,                          //宝宝姓名
                birthday: baby.birthday,                 //宝宝生日
                gender: baby.gender,                     //宝宝性别
                hobby: baby.hobby,                       //宝宝爱好
                page: currentPageLike,                    //猜你喜欢当前页面
                pageSize: pageSize                       //猜你喜欢每页展示的物品数量
            };
            if (currentPageLike <= totalPageLike) {       //判断当前页面是否小于等于总页数
                MB.sendAjax("get", "home/goodsGuess", params, function (data) {
                    console.log("猜你喜欢的加载！");
                    console.log(data);
                    var goodsList = data.items;
                    totalPageLike = data.totalPage;                      //获取猜你喜欢总页数
                    $(goodsList).each(function (index, goods) {
                        var likeGoods = backGoods.clone();
                        likeGoods.find("img")
                            .attr("src", MB.getRootPath() + "/upload/" + goods.picture)
                            .click(function () {                          //猜你喜欢页面详情点击事件的添加
                                window.location = "goods/goodsDetail?goodsId=" + goods.id;
                            });
                        likeGoods.find("div>p:eq(0)>span:eq(0)").text("￥" + goods.price);
                        likeGoods.find("div>p:eq(0)>span:eq(1)").text(goods.newDegree);
                        likeGoods.find("div>p:eq(1)").text(goods.brand);
                        likeGoods.find("div>p:eq(2)").text(goods.title);
                        likeGoodsBox.append(likeGoods);
                    });
                    initScroll();                               //下拉滚动刷新
                });
            }
        }
        else {                                                                //宝宝信息不存在点击猜你喜欢时显示表单页面
            $("#likeForm").removeClass("hide");                             //显示猜你喜欢表单
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
                name: babyName,                       //宝宝姓名
                birthday: babyBirthday,              //宝宝生日
                gender: gender,                      //宝宝性别
                hobby: hobby                         //宝宝爱好
            };
            MB.sendAjax("get", "home/babySubmit", params, function (data) {
                baby = data;
                //if(babyName!=null&&babyBirthday!=null&&gender!=null&&hobby!=null){
                loadLikeGoods();
                //}else{
                //    showMsg("请填写完整宝宝信息！");
                //}
            });
        });
    }

    ////表单提交弹框效果的实现
    //function showMsg(msg) {
    //    //提示框弹出信息停留3秒消失
    //    $('#textShow1').text(msg).fadeIn(1000).delay(2000).fadeOut(1000);
    //}

    //拉动刷新和加载更多的实现
    function iScrollClick() {                                                        //判断函数
        if (/iPhone|iPad|iPod|Macintosh/i.test(navigator.userAgent)) return false;
        if (/Chrome/i.test(navigator.userAgent)) return (/Android/i.test(navigator.userAgent));
        if (/Silk/i.test(navigator.userAgent)) return false;
        if (/Android/i.test(navigator.userAgent)) {
            var s = navigator.userAgent.substr(navigator.userAgent.indexOf('Android') + 8, 3);
            return (parseFloat(s[0] + s[3]) < 44 ? false : true);
        }
    }

    function initScroll() {
        if (myScroll) {
            myScroll.refresh();
        }
        else {
            //拉动刷新
            myScroll = new IScroll('div.iscroll-wrapper', {                 //滚动点击事件初始化
                click: iScrollClick(), //调用判断函数
                scrollbars: true,//有滚动条
                mouseWheel: true,//允许滑轮滚动
                fadeScrollbars: true//滚动时显示滚动条，默认影藏，并且是淡出淡入效果
            });
            //myScroll = new IScroll('div.iscroll-wrapper');
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