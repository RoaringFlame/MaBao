 // 首页动态效果
"use strict";
window.onload = function(){
		 slidemenu();
//     menuswitch();
	}

  // 隐藏分类菜单
		 function slidemenu(){
			var menu = document.getElementById('slidebar');
			var classify = document.getElementById('classify');

			menu.onclick = function(){
				 if(classify.style.display==""||classify.style.display=="none"){
                 classify.style.display="block";
                }else{
                 classify.style.display="none";
               }
           }
       }

      // 首页页面跳转
   // function pageto(){
   //    var main = document.getElementById('main-cons');
   //    var items = main.getElementsByTagName('figure');
   //    for(var i = 0 ;i<items.length;i++)
   //    { 
   //      items[i].id = i;
   //      items[i].onclick = function(){
   //        window.location.href="detail.html";   
   //      }
   //    }
   //  }
     //新品和猜你喜欢菜单跳转
////      function menuswitch(){
//        var title = document.getElementById('title');
//        var lis = title.getElementsByTagName('li');
//        var main = document.getElementById('main');
//        var sections = main.getElementsByTagName('section');
//        
//        if(lis.length != sections.length)
//          return;
//        for(var i = 0 ; i<lis.length ; i++)
//        {  
//          lis[i].id = i;
//          lis[i].onclick = function(){
//          for(var j = 0;j<lis.length;j++)
//          {
//            lis[j].className='';
//            sections[j].style.display ="none";
//            
//
//          }
//           	this.className ='active';
//            sections[this.id].style.display ="block";
//           
//          }
//
//        }
//     }
	

  


  