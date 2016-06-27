//"use strict";
//$(function(){

//var detailgood = [
//
//{  
//   "imgsrc":"img/main-new1.png",
//   "name":"H&M  CARDIGN",
//   "price":"￥33.5",
//   "oldPrice":"100",
//   "brand":"HM",
//   "type":"春装",
//   "date":"2015.10.14",
//   "status":"九成新",
//   "size":"S",
//   "package":"有",
//   "recepit":"有",
//   "share":"开发商开发快手快脚付款设计开发就开始看了几款手机会计师看看时间的看法就开始就分开的看法就开始减肥可是看见快速开发深刻理解付款了水电开发监控数据介绍的空间",
//   "picture":"img/detail.png"
//},
//{  
//   "imgsrc":"img/main-new1.png",
//   "name":"H&M  CARDIGN",
//   "price":"￥33.5",
//   "oldPrice":"100",
//   "brand":"HM",
//   "type":"春装",
//   "date":"2015.10.14",
//   "status":"九成新",
//   "size":"S",
//   "package":"有",
//   "recepit":"有",
//   "share":"开发商开发快手快脚付款设计开发就开始看了几款手机会计师看看时间的看法就开始就分开的看法就开始减肥可是看见快速开发深刻理解付款了水电开发监控数据介绍的空间",
//   "picture":"img/detail.png"
//},
//{  
//   "imgsrc":"img/main-new1.png",
//   "name":"H&M  CARDIGN",
//   "price":"￥33.5",
//   "oldPrice":"100",
//   "brand":"HM",
//   "type":"春装",
//   "date":"2015.10.14",
//   "status":"九成新",
//   "size":"S",
//   "package":"有",
//   "recepit":"有",
//   "share":"开发商开发快手快脚付款设计开发就开始看了几款手机会计师看看时间的看法就开始就分开的看法就开始减肥可是看见快速开发深刻理解付款了水电开发监控数据介绍的空间",
//   "picture":"img/detail.png"
//},
//{  
//   "imgsrc":"img/main-new1.png",
//   "name":"H&M  CARDIGN",
//   "price":"￥33.5",
//   "oldPrice":"100",
//   "brand":"HM",
//   "type":"春装",
//   "date":"2015.10.14",
//   "status":"九成新",
//   "size":"S",
//   "package":"有",
//   "recepit":"有",
//   "share":"开发商开发快手快脚付款设计开发就开始看了几款手机会计师看看时间的看法就开始就分开的看法就开始减肥可是看见快速开发深刻理解付款了水电开发监控数据介绍的空间",
//   "picture":"img/detail.png"
//},
//{  
//   "imgsrc":"img/main-new1.png",
//   "name":"H&M  CARDIGN",
//   "price":"￥33.5",
//   "oldPrice":"100",
//   "brand":"HM",
//   "type":"春装",
//   "date":"2015.10.14",
//   "status":"九成新",
//   "size":"S",
//   "package":"有",
//   "recepit":"有",
//   "share":"开发商开发快手快脚付款设计开发就开始看了几款手机会计师看看时间的看法就开始就分开的看法就开始减肥可是看见快速开发深刻理解付款了水电开发监控数据介绍的空间",
//   "picture":"img/detail.png"
//}
//
//];

//   var goodid = switchNum(window.location.search);
//  $.get("/api/MbShopGoods",{id:goodid},function(data){
//      $("#baby-img").find("img").attr("src",detailgood[goodid-1].imgsrc);
//		  $("#baby-img").find("p:first").text(detailgood[goodid-1].name);
//		  $("#baby-img").find("span:first").text(detailgood[goodid-1].price);
//		  $("#baby-img").find("span:last i:last").text(detailgood[goodid-1].oldPrice);
//		  $(".p-1").find("div:last").text(detailgood[goodid-1].type);
//		  $(".p-2").find("div:last").text(detailgood[goodid-1].brand);
//		  $(".p-3").find("div:eq(1)").text(detailgood[goodid-1].date);
//		  $(".p-3").find("div:eq(3)").text(detailgood[goodid-1].status);
//		  $(".p-4").find("div:eq(1)").text(detailgood[goodid-1].size);
//		  $(".p-4").find("div:eq(3)").text(detailgood[goodid-1].package);
//		  $(".p-4").find("div:eq(5)").text(detailgood[goodid-1].recepit);
//		  $(".p-5").find("div:last").text(detailgood[goodid-1].share);
//		  $(".p-6").find("div:last img").attr("src",detailgood[goodid-1].picture); 
         
    // },'json')

//    	function switchNum(str){
//    		return parseInt(str.replace(/[^0-9]/ig ,""));
//    	}

// $.get("/api/MbShopGoods",{goodid:goodid},function(data){
//            $(data).each(function(index,good){
//            $("#baby-img").find("img").attr("src",good.imgsrc);
//           $("#baby-img").find("p:first").text(good.name);
//           $("#baby-img").find("span:first").text(good.price);
//           $("#baby-img").find("span:last i:last").text(good.oldPrice);
//           $(".p-1").find("div:last").text(good.type);
//           $(".p-2").find("div:last").text(good.brand);
//           $(".p-3").find("div:eq(1)").text(good.date);
//           $(".p-3").find("div:eq(3)").text(good.status);
//           $(".p-4").find("div:eq(1)").text(good.size);
//           $(".p-4").find("div:eq(3)").text(good.package);
//           $(".p-4").find("div:eq(5)").text(good.recepit);
//           $(".p-5").find("div:last").text(good.share);
//           $(".p-6").find("div:last img").attr("src",good.picture); 
//          });
//     },'json')


//})