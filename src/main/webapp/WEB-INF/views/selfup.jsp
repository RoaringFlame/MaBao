<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>自助发布：转让宝物</title>
    <meta name="viewport" content="maximum-scale=1.0,minimum-scale=1.0,user-scalable=no,width=device-width,initial-scale=1.0"/>
    <!-- 禁止将数字变为电话号码 -->
    <meta name="format-detection" content="telephone=no" />
    <!-- iphone设备中的safari私有meta标签,允许全屏模式浏览，隐藏浏览器导航栏 -->
    <meta name="apple-mobile-web-app-capable" content="yes" />
    <!-- iphone的私有标签,它指定的iphone中safari顶端的状态条的样式 -->
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <link rel="stylesheet" href="../css/public.css">
    <link rel="stylesheet" href="../css/res.css">
    <link href="../css/bootstrap-switch.css" rel="stylesheet">
</head>
<body> 
    <section class="header-top">
        <div class="fanhui"><a href="consignment.html" ><img src="../img/back.png" alt=""></a><a href="consignment.html" class="tiaozhuan">返回</a></div>
        <div class="shouye"><p>转让宝物</p></div>
    </section>
    <section class="container">
        <div class="main-tit">
        <p><span>请如实填写您的转让信息</span><a href="" class="need-a">卖家须知</a></p>
        </div>
        <form method="" action="">
        <section class="baby-sale">
            <div class="title">
            	<input type="text" name="title" value="宝物标题">
            </div>
             <ul>
                <li class="left">
                <label for="kind" class="baby">宝物类型：</label>
                <select name="kind" id="kind">
                <option value="童车">童车</option>
                <option value="安全座椅">安全座椅</option>
                <option value="玩具">玩具</option>
                <option value="家具">家具</option>
                <option value="电器">电器</option>
                </select>
                </li>
                <li class="right">
                <label for="sex" class="baby">宝物品牌：</label>
                <select name="sex" id="sex">
                <option value="强生">强生</option>
                <option value="好孩子">好孩子</option>
                <option value="贝亲">贝亲</option>
                </select>
                </li>
                <li class="left" >
                <label for="time" class="baby">购物时间：</label>
                <input name="time" id="time" type="date"/>
                </li>
                <li class="right">
                <label for="level" class="baby">新旧程度：</label>
                <select name="level" id="level">
                <option value="全新">全新</option>
                <option value="9成新">9成新</option>
                <option value="8成新">8成新</option>
                <option value="6-7成新">6-7成新</option>
                <option value="5成新以下">5成新以下</option>
                </select>
                </li>
                <li class="left">
                <label for="size" class="baby">宝物尺码：</label>
                <select name="size" id="size">
                <option value="0—3m">0-3m</option>
                <option value="0—3m">3-6m</option>
                <option value="6—9m">6-9m</option>
                <option value="9—12m">9-12m</option>
                <option value="12—18m">12-18m</option>
                <option value="18—24m">18-24m</option>
                <option value="2T">2T</option>
                <option value="3T">3T</option>
                <option value="4T">4T</option>
                <option value="5T">5T</option>
                <option value="6T">6T</option>
                </select>
                </li>
                <li class="right">
                <label for="fit" class="baby">适合宝宝：</label>
                <select name="fit" id="fit">
                <option value="男">男</option>
                <option value="女">女</option>
                <option value="所有宝宝">所有宝宝</option>
                </select>
                </li>
                <li class="left radio-choose">
                <label for="seitch1" class="baby">原装包装：</label>
                </li>
                <li class="right radio-choose">
                <label for="seitch2" class="baby">发票小票：</label>
                </li>
                <li class="left text">
                <label for="oldprice" class="baby">购买原价：</label>
                <input type="text" name="oldprice" id="oldprice">
                </li>
                <li class="right text-right">
                <label for="newprice" class="baby">转让现价：</label>
                <input type="text" name="newprice" id="newprice">
                </li>
             </ul>
                <div class="switch1" id="switch1" name="seitch1">
                  <input class="form-control" type="checkbox" checked>
                </div>
                <div class="switch2" id="switch2" name="seitch2">
                  <input class="form-control" type="checkbox" checked>
                </div>
        </section>
        <section class="wish">
            <label for="">卖家寄语：<br>宝物详情&nbsp;/<br>使用心得&nbsp;/<br>瑕疵情况等</label>
            <textarea name="" id="" cols="30" rows="10"></textarea>
            <div>
            <input type="file" accept="image/png,image/gif" style="display: none;" id="upimg">
            <img src="../img/1.png" alt="" onclick="javascript:$('#upimg').click()">
            <img src="../img/2.png" alt="">
            <img src="../img/3.png" alt="">
            </div>          
        </section>
        <div class="clear"></div>
        <section class="quick-sale">
            <input type="submit" value="一键卖出" onclick=window.location.href="publish-success.html">
        </section>
    </section>
    </form>
</body>
</html>

<!-- //按钮 -->
<script src="../js/jquery.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/bootstrap-switch.js"></script>
<script>
$(function(argument) {
  $('[type="checkbox"]').bootstrapSwitch();
})
</script>