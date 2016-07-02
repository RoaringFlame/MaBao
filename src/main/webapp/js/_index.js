"use strict";
//首页数据刷新加载
$(function(){
        var currentPage=0;
        var pageSize=4;
        var totalPage=0;
        var totalCount=0;
        $("#loadMore").click(function(){
            if(currentPage<totalPage){
                currentPage++;
                loadingResult();
            }
        });
        /**
        *  加载新品上市数据
         */
        var loadingResult=function(){
            $.get("goods/goodsList",{page:currentPage,size:pageSize},function(data){
                currentPage=data.currentPage;
                pageSize=data.pageSize;
                totalPage=data.totalPage;
                totalCount=data.totalCount;
                //如果没有更多的数据则隐藏加载更多按钮
                if(currentPage==totalPage){
                    $("#btnLoadMore").hide();
                }

                var items=data.items;
                for(var i=0;i<items.length;i++){
                    var item=items[i];
                    var newfig=$("#figNewGoods").clone();
                    var clickUrl="/goodsDetail?id="+item.id;
                    newfig.find("img").attr("src","/upload/"+item['picture']);
                    newfig.find("figcaption>p:eq(0)>span:eq(0)").text("￥"+item.price);
                    newfig.find("figcaption>p:eq(0)>span:eq(1)").text(item['newDegree']);
                    newfig.find("figcaption>p:eq(1)").text(item['brand']);
                    newfig.find("figcaption>p:eq(2)").text(item['title']);
                    newfig.click(function(){
                        window.location.href=clickUrl;
                    });
                    $("#newGoods").append(newfig);
                }
            },"json");
        };
        loadingResult();
    });
    //轮播时间

	$('.carousel').carousel({
	  interval: 2500
	})
	// 分类列表
     function _block(){
        var mychar=document.getElementById('classify');
        if(mychar.style.display=="none")
        {
        mychar.style.display="block";
        }
        else
        {
        mychar.style.display="none";
        }
    }
    // 新品，猜你喜欢切换
        function _block1(){
        var _shownewgods=document.getElementById('showNewGoods');
        var _youlike=document.getElementById('youLike');
        if(_shownewgods.style.display=="none")
        {
        _shownewgods.style.display="block";
        _youlike.style.display="none";

        }
    }
            function _block2(){
        var _shownewgods=document.getElementById('showNewGoods');
        var _youlike=document.getElementById('youLike');
        var _active=document.getElementById('active');
        var _acta=document.getElementById('acta');
        if(_youlike.style.display=="none")
        {
        _youlike.style.display="block";
        _shownewgods.style.display="none";
        // _acta.style.color="#4A5254";
        // _active.style.border="none";
        }

    }
