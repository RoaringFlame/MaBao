<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>注册</title>
    <meta name="viewport"
          content="maximum-scale=1.0,minimum-scale=1.0,user-scalable=no,width=device-width,initial-scale=1.0"/>
    <!-- 禁止将数字变为电话号码 -->
    <meta name="format-detection" content="telephone=no"/>
    <!-- iphone设备中的safari私有meta标签,允许全屏模式浏览，隐藏浏览器导航栏 -->
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <!-- iphone的私有标签,它指定的iphone中safari顶端的状态条的样式 -->
    <meta name="apple-mobile-web-app-status-bar-style" content="black">

     <link rel="stylesheet" href="../css/master.css">
    <link rel="stylesheet" href="../css/module.css">
</head>

<body>
    <div class="content-index">
        <!--标题-->
        <header>
           注册
            <!--操作按钮-->
           <div class="header-box">
                <a href="login.html">
                  <button class="header-left">
                  <i class="icon icon-return"></i>
                   返回
                </button>
                </a>
           </div>
            <!--操作按钮 END-->
        </header>
         <!--标题 END-->

		<form class="register-box">
		<label for="userName">账户名：
			<input type="text" name="username" id="userName" >
		</label>
		<label for="userName">密码：
			<input type="password" name="password" id="passWord" >
		</label>
		<label for="userName">确认密码：
			<input type="password" name="confirm-pwd" id="confirmPwd" >
		</label>
		<label for="userName">邮箱：
			<input type="email" name="email" id="email" >
		</label>

		    <p class="warning"></p>
            <!--注册成功跳转到登陆页面-->
            <!-- 注册按钮 -->
            <a class="button-bottom" href="login.html">
                <button type="submit" class="submit">注册</button>
            </a>
            <!-- 注册按钮END -->
		</form>

	</div>
</body>
</html>