"use strict";
$(function(){
	init();
	
})

var order=[
{
 "orderid":"1",
 "imgsrc":"img/u8.jpg",
 "name":"H&M CARDIGAN",
 "size":"S",
 "preprice":"35.5",
 "price":"30.0",
 "status":"等待成交",
},
{
"orderid":"1",
"imgsrc":"img/u20.jpg",
 "name":"H&M CARDIGAN",
 "size":"S",
 "preprice":"35.5",
 "price":"30.0",
 "status":"等待成交",
},
{
"orderid":"1",
"imgsrc":"img/u20.jpg",
 "name":"H&M CARDIGAN",
 "size":"S",
 "preprice":"35.5",
 "price":"30.0",
 "status":"等待成交",
},
{
"orderid":"1",
"imgsrc":"img/u20.jpg",
 "name":"H&M CARDIGAN",
 "size":"S",
 "preprice":"35.5",
 "price":"30.0",
 "status":"等待成交",
},
];


function init(){
  // $.get("",{id:((page-1)*pagesize+1);size:pagesize}.function(data){
		// $(data).each(function(index,good){
    // $(".bottom p").find("i").text(order.length);
		// 	$("#main").append($("<div></div>").addClass("top")
  //  	         .append($('<img src="" alt="" />').attr("src",good.imgsrc))
  //  	         .append($("<div></div>").addClass("b")
  //  	         .append($("<p></p>").text(good.name)).append($("<p></p>").text(good.size))
  //  	         .append($("<div></div>").addClass("a").append($("<p></p>").text("出售价格：￥"+good.preprice)).append($("<p></p>").text("扣除佣金可得：￥"+good.price)).append($("<p></p>").text(good.status)))
  //  	         )
  //  	         .click(function(){
  //             window.location.href = "detail.html?orderId="+encodeURI(encodeURI(good.orderid));
  //             })
  //         )
  //        })
  //        
$(order).each(function(index,good){
   $(".bottom p").find("i").text(order.length);
        var sum =0;
        for(var i=0;i<order.length;i++)
        {
           var price = new Number(order[i].price)
           sum = sum + price
         }
           
        $(".bottom span").find("b").text(sum);
        $("#main").append($("<div></div>").addClass("top")
   	         .append($('<img src="" alt="" />').attr("src",good.imgsrc))
   	         .append($("<div></div>").addClass("b")
   	         .append($("<p></p>").text(good.name)).append($("<p></p>").text(good.size))
   	         .append($("<div></div>").addClass("a").append($("<p></p>").text("出售价格：￥"+good.preprice)).append($("<p></p>").text("扣除佣金可得：￥"+good.price)).append($("<p></p>").text(good.status)))
   	         )
   	         .click(function(){
              window.location.href = "detail.html?orderId="+encodeURI(encodeURI(good.orderid));
          })
             )

})

}

// var myScroll,pullDownEl,pullDownOffset,pullUpEl, pullUpOffset,generatedCount = 0;
  
//   function pullUpAction(){
//   var el = document.getElementById('container');

//   setTimeout(function () { 
//    page++;
//    init();
//    myScroll.refresh();  
//   }, 1000); 
// }

//   function loaded() {
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



