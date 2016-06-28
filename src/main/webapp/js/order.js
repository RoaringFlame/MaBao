"use strict";
$(function(){
	init();
	
})

//var order =[
//{
// "orderid":"1",
// "imgsrc":"img/u8.jpg",
// "name":"H&M CARDIGAN",
// "size":"S",
// "price":"35.5",
// "status":"正在出库",
//},
//{
//"orderid":"2",
//"imgsrc":"img/u20.jpg",
// "name":"H&M CARDIGAN",
// "size":"S",
// "price":"35.5",
// "status":"正在出库",
//},
//{
//"orderid":"3",
//"imgsrc":"img/u20.jpg",
// "name":"H&M CARDIGAN",
// "size":"S",
// "price":"35.5",
// "status":"正在出库",
//},
//{
//"orderid":"4",
//"imgsrc":"img/u20.jpg",
// "name":"H&M CARDIGAN",
// "size":"S",
// "price":"40.0",
// "status":"正在出库",
//},
//];

// 加载所有订单
function init(){
	 $.get("http://localhost:8080/mb/OrderServlet?method=findOrderGoods",{},function(data){
   $(".bottom p").find("i").text(data.length); 
    var sum =0;
   for(var i=0;i<data.length;i++)
        {
	   		var price= new Number((data[i].price));
            sum = sum + price;
         }  
   $(".bottom p").find("b").text(sum+10); 
		 $(data).each(function(index,good){
		 	$("#main").append($("<div></div>").addClass("top")
    	         .append($('<img src="" alt="" />').attr("src",good.brand))
    	         .append($("<div></div>").addClass("b")
    	         .append($("<p></p>").text(good.goodsName)).append($("<p></p>").text(good.goodsSize))
    	         .append($("<div></div>").addClass("a").append($("<p></p>").text("￥"+good.price)).append($("<p></p>").text(good.status)))
    	         )
    	         .click(function(){
               window.location.href = "detail.jsp?id="+good.goodsId;//encodeURI(encodeURI(good.orderid))
               })
           )
          })

//		$(order).each(function(index,good){
//        $(".bottom p").find("i").text(order.length);
//        var sum =0;
//        for(var i=0;i<order.length;i++)
//        {
//           var price = new Number(order[i].price)
//           sum = sum + price
//         }
//           
//        $(".bottom span").find("b").text(sum);
//        $("#main").append($("<div></div>").addClass("top")
//   	         .append($('<img src="" alt="" />').attr("src",good.imgsrc))
//   	         .append($("<div></div>").addClass("b")
//   	         .append($("<p></p>").text(good.name)).append($("<p></p>").text(good.size))
//   	         .append($("<div></div>").addClass("a").append($("<p></p>").text("￥"+good.price)).append($("<p></p>").text(good.status)))
//   	         )
//   	         .click(function(){
//              window.location.href = "detail.html?orderId="+encodeURI(encodeURI(good.orderid));
//              })
//             )
//
//       })

	 },'json')  
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

//    function loaded() {
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





