"use strict";
$(function(){ 
    var ids = new Array();
    init();
    setTimeout(function(){
    var checkBoxs = $(".main-item").find("input");
    var adds = $(".add");
    var reduces = $(".reduce");
    
       var nums=new Array(); 
       $(checkBoxs).each(function(index,obj) {       
         $(this).change(function(){ 
          if($(this).is(':checked')||$.inArray(index,nums)<0){
          nums.push(index);
          }else{
          nums.splice($.inArray(index,nums),1);
          }  
           var i=$(this);
           setTotal(nums); 
          });                    
      });

     //增加按钮
       console.log(checkBoxs);
     $(adds).each(function(index,obj){
       $(this).on("click",function(){
       var num = parseInt($(".sum").eq(index).text());
         num++;
         $(".sum").eq(index).text(num); 
        setTotal(nums);
      });
       
    });
   //减少按钮
     $(reduces).each(function(index,obj){
         $(this).click(function(){
          var num = parseInt($(".sum").eq(index).text());
         if(num<=1){
          $(".good-reduce-warning").text("不能再减少了！")
         }else{
           num--;
           $(".sum").eq(index).text(num);
        }
         setTotal(nums);
      })

    })
    console.log(ids);
      var a = new Array();
      var b = new Array();
     $(".up-to-pay").find("li:last").click(function(){
        $(checkBoxs).each(function(index,obj){       
          if($(this).is(':checked')){
              a.push(ids[index]);
              b.push($(".sum").eq(index).text());
          }
        })
        if(a.length>0)
        {
           var objJson = [];
           for(var i=0;i<a.length;i++){ 
           objJson.push(jQuery.parseJSON('{"id":' + a[i] + ',"num":' + b[i] + '}'));
            }
           var json = (JSON.stringify(objJson));
           window.location.href = 'http://localhost:8080/mb/OrderServlet?method=toPay&aa='+json;
        }
        else{
         $(".pay-warning").text("您还没有选择任何商品！")
        }
       
    
     });

     function setTotal(nums){ 
       var s=0; 
       $(nums).each(function(index,obj){
         s+=parseInt($(".sum").eq(obj).text())*parseFloat($(".mark b").eq(obj).text()); 
       }); 
       $(".up-to-pay").find("li:first").find('b').text(s);

   } 
    },50);

  

     // 页面的跳转
    
   
   
    function init(){
    	
    	$.post("http://localhost:8080/mb/ShoppingServlet?method=findShopGoods",{username:username},function(data){
        
       $(data).each(function(index,good){
    	   ids.push(good.goodsId);
               $("#main").append($("<section></section>").addClass("main-item")
                    .append($("<div></div>").addClass("select").append($('<input type="checkBox"/>')))
                    .append($("<div></div>").addClass("user-img").append($('<img src="" alt="" />').attr("src",good.brand)))
                        .append($("<div></div>").addClass("user-intro").append($("<p></p>").text(good.goodsName)).append($("<p></p>").text(good.goodsSize)).append($("<p></p>").addClass("mark").text("￥").append($("<b></b>").text(good.price))))
                        .append($("<div></div>").addClass("add-reduce").append($("<div></div>").addClass("reduce").append($('<img src="" alt="" />').attr("src","img/reduce.png")))
                        .append($("<div></div>").addClass("sum").append($("<p></p>").text("1")))
                          .append($("<div></div>").addClass("add").append($('<img src="" alt="" />').attr("src","img/shopping-1.png")))

                      ))
                      .append($("<div></div>").addClass("hr"))
       		});
       console.log(2);
    	},'json')
    }
})

//    $(shoppingmall).each(function(index,good){     
//      ids.push(good.orderid);
//      $("#main").append($("<section></section>").addClass("main-item")
//                   .append($("<div></div>").addClass("select").append($('<input type="checkBox" name="_check"/>')))
//                   .append($("<div></div>").addClass("user-img").append($('<img src="" alt="" />').attr("src",good.imgsrc)))
//                       .append($("<div></div>").addClass("user-intro").append($("<p></p>").text(good.name)).append($("<p></p>").text(good.size)).append($("<p></p>").addClass("mark").text("￥").append($("<b></b>").text(good.price))))
//                       .append($("<div></div>").addClass("add-reduce").append($("<div></div>").addClass("reduce").append($('<img src="" alt="" />').attr("src","img/reduce.png")))
//                        .append($("<div></div>").addClass("sum").append($("<p></p>").text("1")))
//                        .append($("<div ></div>").addClass("add").append($('<img src="" alt="" />').attr("src","img/shopping-1.png")))
//
//                    ))
//                     .append($("<div></div>").addClass("hr"));                     
//            })




//事件委托机制
 
 


 

// var myScroll,pullDownEl,pullDownOffset,pullUpEl, pullUpOffset,generatedCount = 0;
  
//   function pullUpAction(){
//   var el = document.getElementById('container');

//   setTimeout(function () { 
//    init();
//    myScroll.refresh();  
//   }, 1000); 
// }
//  function loaded() {
//   pullUpEl = document.getElementById('pullUp'); 
//   pullUpOffset = pullUpEl.offsetHeight;
  
//   myScroll = new iScroll('wrapper', {
//     scrollbarClass: 'myScrollbar',
//     useTransition: false,
//     topOffset: pullUpOffset,
//     onRefresh: function () {
//       if (pullUpEl.className.match('loading')) {
//         pullUpEl.className = '';
//         pullUpEl.querySelector('.pullUpLabel').innerHTML = '上拉加载...';
//       }
//     },
//     onScrollMove: function () {
//        if (this.y < (this.maxScrollY - 5) && !pullUpEl.className.match('flip')) {
//         pullUpEl.className = 'flip';
//         pullUpEl.querySelector('.pullUpLabel').innerHTML = '松手开始...';
//         this.maxScrollY = this.maxScrollY;
//       } else if (this.y > (this.maxScrollY + 5) && pullUpEl.className.match('flip')) {
//         pullUpEl.className = '';
//         pullUpEl.querySelector('.pullUpLabel').innerHTML = '上拉加载...';
//         this.maxScrollY = pullUpOffset;
//       }
//     },
//     onScrollEnd: function () {
//        if (pullUpEl.className.match('flip')) {
//         pullUpEl.className = 'loading';
//         pullUpEl.querySelector('.pullUpLabel').innerHTML = 'loading...';        
//         pullUpAction(); // Execute custom function (ajax call?)
//       }
//     }
//   });
  
//   setTimeout(function () { document.getElementById('wrapper').style.left = '0'; }, 800);
// }

// document.addEventListener('touchmove', function (e) { e.preventDefault(); }, false);

// document.addEventListener('DOMContentLoaded', function () { setTimeout(loaded, 100); }, false);



