"use strict";
// 更新数据的方法
$(function(){

  init();
 
        
})
    var classifyText;
    var imgs =[
    { "id":"1",
      "src":"../img/img-01.png"
    },
    { "id":"2",
      "src":"../img/detail.jpg"
    },
    { "id":"3",
      "src":"../img/img-01.png"
    },
    { "id":"4",
      "src":"../img/detail.jpg"
    },
    ];
   
    var newgoods =[
          {  
              "id":"1",
              "src":"../img/main-new1.png",
              "price":"￥30.00",
              "type":"全新",
              "name":"H&M  CARDIGN"
             
          },
          {
             "id":"2",
              "src":"../img/main-new1.png",
              "price":"￥30.00",
              "type":"全新",
              "name":"H&M  CARDIGN"
          },
           {
             "id":"3",
              "src":"../img/main-new1.png",
              "price":"￥30.00",
              "type":"全新",
              "name":"H&M  CARDIGN"
          },
          {
             "id":"4",
              "src":"../img/main-new1.png",
              "price":"￥30.00",
              "type":"全新",
              "name":"H&M  CARDIGN"
          },
        ];
         
    var likegoods = [
          {
             "id":"1",
              "src":"../img/main-new2.png",
              "price":"￥33.00",
              "type":"九成新",
              "name":"H&M"
          },
          {
             "id":"2",
              "src":"../img/main-new2.png",
              "price":"￥33.00",
              "type":"九成新",
              "name":"H&M"
          },
           {
             "id":"3",
              "src":"../img/main-new2.png",
              "price":"￥33.00",
              "type":"九成新",
              "name":"H&M"
          },
          {
             "id":"4",
              "src":"../img/main-new2.png",
              "price":"￥33.00",
              "type":"九成新",
              "name":"H&M"
          }];
         //回到顶部按钮
         $("#back-top").click(function(){ 
          $("#scroller").css("top","-4rem");}
        
       );
       
       // 分类的显示和隐藏
        $("#sidebar").click(function(){
          $("#classify").toggle();
        })
      // search框点击事件
         $("#search").click(function(){
           $("#main").find("section:first").css("display","block");
            $("#main").find("section:last").css("display","none");
           $("#main-cons").find("figure").remove();
           searchData();
           myScroll.refresh();
          });


          //猜你喜欢表单提交
          $("#like-up").click(function(){
          $('#main').find('section:last').css("display","none")
          $('#main').find('section:first').css("display","block")
          $("#main-cons").find("figure").remove();
          resetData();
          myScroll.refresh();
        });

         //下拉分页菜单的点击事件
          $('#classify li').each(function(index,obj){
            $(this).click(function(){
              classifyText=$(this).text();
            $("#classify").toggle();
            $('#main').find('section:last').css("display","none")
            $('#main').find('section:first').css("display","block")
            $("#title").find("li:first").addClass("active").siblings().removeClass("active");
            $("#main-cons").find("figure").remove();
              searchTypeData(classifyText);
              myScroll.refresh();
         });
        });
         
         
          
  //猜你喜欢和新品菜单切换

          $("#title").find("li:first").click(function(){
            $(".main-cons:first").css("display","block");
            $(".main-cons:last").css("display","none");
            $(this).addClass("focus").siblings().removeClass("focus");
            $(this).addClass("acta").siblings().removeClass("acta");
            $("#main-cons").find("figure").remove();
                init(); 
                myScroll.refresh();
            
          })

          $("#title").find("li:last").click(function(){
          $(this).addClass("focus").siblings().removeClass("focus");
          $(this).addClass("acta").siblings().removeClass("acta");
            $('.main-cons:last').css("display","block");
            $(".main-cons:first").css("display","none");
               myScroll.refresh();
          })

         // 回到顶部按钮
  
         $("#back-top").click(function(){ //当点击标签的时候,使用animate在200毫秒的时间内,滚到顶部
          $("#scroller").css("top","-4rem");
         var wrapper = $("#wrapper");
         wrapper.scrollTop(0);

       });
  
//新品初始化
    function init(){
           status = 1;
           $(newgoods).each(function(index,good){
           $("#main-cons").append($('<figure></figure>').append($('<img src="" alt="" />').attr('src',good.src))
                          .append($('<figcaption></figcaption>')
                          .append($('<p></p>').append($('<span></span>').text(good.price))
                          .append($('<span></span>').text(good.type)))
                          .append($('<p></p>').text(good.name)))
                          .click(function(){
                          window.location.href="detail.html?id="+good.id;          
                          })
                          )
                  
                });
        
           
         } 
        
//猜你喜欢物品初始化
    function resetData(){
           status = 2;
           $(likegoods).each(function(index,good){
                 $("#main-cons").append($('<figure></figure>').append($('<img src="" alt="" />').attr('src',good.src))
                          .append($('<figcaption></figcaption>')
                          .append($('<p></p>').append($('<span></span>').text(good.price))//价格
                          .append($('<span></span>').text(good.type)))//新旧程度
                          .append($('<p></p>').text(good.name)))
                           .click(function(){
                          window.location.href="detail.html?id="+good.id; })
                          )
              })
           
         }

//搜索框点击商品初始化
    function searchData(){
           status = 3;
           $(likegoods).each(function(index,good){
                 $("#main-cons").append($('<figure></figure>').append($('<img src="" alt="" />').attr('src',good.src))
                          .append($('<figcaption></figcaption>')
                          .append($('<p></p>').append($('<span></span>').text(good.price))//价格
                          .append($('<span></span>').text(good.type)))//新旧程度
                          .append($('<p></p>').text(good.name)))
                           .click(function(){
                          window.location.href="detail.html?id="+good.id; })
                          )
              })
           
         }

//按照分类搜索商品初始化
      function searchTypeData(classifyText){
           status = 4;
                   $(likegoods).each(function(index,good){
                         $("#main-cons").append($('<figure></figure>').append($('<img src="" alt="" />').attr('src',good.src))
                                  .append($('<figcaption></figcaption>')
                                  .append($('<p></p>').append($('<span></span>').text(good.price))//价格
                                  .append($('<span></span>').text(good.status)))//新旧程度
                                  .append($('<p></p>').text(good.name)))
                                   .click(function(){
                                  window.location.href="detail.html?id="+good.id; })
                                  )         
                          });
                  
            
          }
//下拉刷新
  var myScroll,pullDownEl,pullDownOffset,pullUpEl, pullUpOffset,generatedCount = 0;
  
  function pullUpAction(){
  var el = document.getElementById('main-cons');

  setTimeout(function () { 
   
    switch(status) {
      case '1':init();
      break;
      case '2': resetData();
      break;
      case '3': searchData();
      break;
      case '4':searchTypeData();
      break;
     }
    
    myScroll.refresh();  
  }, 1000); 
}

  function loaded() {
  pullUpEl = document.getElementById('pullUp'); 
  pullUpOffset = pullUpEl.offsetHeight;
  
  myScroll = new iScroll('wrapper', {
    scrollbarClass: 'myScrollbar',
    useTransition: false,
    topOffset: pullUpOffset,
    onRefresh: function () {
      if (pullUpEl.className.match('loading')) {
        pullUpEl.className = '';
        pullUpEl.querySelector('.pullUpLabel').innerHTML = '上拉加载...';
      }
    },
    onScrollMove: function () {
       if (this.y < (this.maxScrollY - 5) && !pullUpEl.className.match('flip')) {
        pullUpEl.className = 'flip';
        pullUpEl.querySelector('.pullUpLabel').innerHTML = '松手开始...';
        this.maxScrollY = this.maxScrollY;
      } else if (this.y > (this.maxScrollY + 5) && pullUpEl.className.match('flip')) {
        pullUpEl.className = '';
        pullUpEl.querySelector('.pullUpLabel').innerHTML = '上拉加载...';
        this.maxScrollY = pullUpOffset;
      }
    },
    onScrollEnd: function () {
       if (pullUpEl.className.match('flip')) {
        pullUpEl.className = 'loading';
        pullUpEl.querySelector('.pullUpLabel').innerHTML = 'loading...';        
        pullUpAction(); // Execute custom function (ajax call?)
      }
    }
  });
  
  setTimeout(function () { document.getElementById('wrapper').style.left = '0'; }, 800);
}

//轮播切换时间
  $(function(){
       $('.carousel').carousel({
         interval: 2500
     })
  });
document.addEventListener('touchmove', function (e) { e.preventDefault(); }, false);

document.addEventListener('DOMContentLoaded', function () { setTimeout(loaded, 100); }, false);


