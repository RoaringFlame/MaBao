<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>编辑收货地址</title>
	<meta name="viewport" content="maximum-scale=1.0,minimum-scale=1.0,user-scalable=no,width=device-width,initial-scale=1.0"/>
	<!-- 禁止将数字变为电话号码 -->
	<meta name="format-detection" content="telephone=no" />
	<!-- iphone设备中的safari私有meta标签,允许全屏模式浏览，隐藏浏览器导航栏 -->
	<meta name="apple-mobile-web-app-capable" content="yes" />
	<!-- iphone的私有标签,它指定的iphone中safari顶端的状态条的样式 -->
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<link rel="stylesheet" href="../../css/buy.css">
	<link rel="stylesheet" href="../../css/public.css">
    <link href="../../css/bootstrap-switch.css" rel="stylesheet">
<!--     <link href="css/bootstrap.min.css" rel="stylesheet"> -->
    <script src="../../js/jquery.min.js"></script>
    <script src="../../script/lib/jquery.1.10.2.js" type="text/javascript"></script>
    <script src="../../script/lib/bootstrap/bootstrap.min.js"></script>
    <script src="../../script/lib/bootstrap/bootstrap-switch.js"></script>
    <script src="../../script/lib/jquery.provincesCity.js" type="text/javascript"></script>
    <script src="../../js/provincesdata.js" type="text/javascript"></script>
</head>
<body>
 	<section class="header-top">
    	<div class="fanhui">
	    	<a onclick=window.location.href="../../user/allAddress"><img src="../../img/back.png" alt=""></a>
	    	<a onclick=window.location.href="../../user/allAddress" class="tiaozhuan">返回</a>
	    </div>
    	<div class="shouye"><p>编辑收货地址</p></div>
    </section>

    <form method="post" name="addressForm">
	<section method="post" action="save.php" class="mesgbox">
	<input name="addressee" type="text" class="write" placeholder="收件人：${address.recipients}">
	<input name="tel" type="phone" class="write" placeholder="手机号：${address.tel}">
	<input name="location" type="text" class="write" placeholder="所在地:">
    <div id="test"></div>
	<input name="ditail-add" type="text" class="write" placeholder="详细地址:${address.location}">
	<div class="default">
		<p>默认地址</p> 
		   <div class="switch0">
	          <input style="border: none;" name="switch0" class="form-control" type="checkbox" checked>
	       </div>
		<span>注：每次下单时会使用该地址</span>
    </div>
	</div> 
	</section>
	<div class="clear"></div>
		<section class="foot-input2">
		  <input  type="button" value="删除该地址" onclick="deleteAddressForm()">
	    </section>
	    <section class="foot-input">
		  <input type="button" value="保存并使用" onclick="saveAddressForm()">
	    </section>
	</form>

	<!--为按钮添加事件:删除地址方法deleteAddressForm()-->
	<script type="text/javascript">
	function deleteAddressForm(){
	    document.addressForm.action = "/user/removeAddressSubmit";
	    document.addressForm.submit();
	}
	<!--为按钮添加事件:新增地址方法saveAddressForm()-->
	function saveAddressForm(){
		document.addressForm.action = "/user/updateAddressSubmit";
		document.addressForm.submit();
	}
	</script>

	<script>
	//调用地址插件
	$(function(){
		$("#test").ProvinceCity();
	});
    </script>

	<script>
	$('.toggle').click(function(e){
    e.preventDefault(); // The flicker is a codepen thing
    $(this).toggleClass('toggle-on');
    });
    </script>

    <script>
    $(function(argument) {
    $('[type="checkbox"]').bootstrapSwitch();
    })
    </script>
</body>
</html>