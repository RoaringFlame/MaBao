<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/"+"MaBao/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
    <title>自助发布：转让宝物</title>
    <meta name="viewport"
          content="maximum-scale=1.0,minimum-scale=1.0,user-scalable=no,width=device-width,initial-scale=1.0"/>
    <!-- 禁止将数字变为电话号码 -->
    <meta name="format-detection" content="telephone=no"/>
    <!-- iphone设备中的safari私有meta标签,允许全屏模式浏览，隐藏浏览器导航栏 -->
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <!-- iphone的私有标签,它指定的iphone中safari顶端的状态条的样式 -->
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <link rel="stylesheet" href="css/bootstrap-switch.css">
    <link rel="stylesheet" href="css/master.css">
    <link rel="stylesheet" href="css/module.css">
    <script src="script/lib/jquery.1.10.2.js"></script>
    <script src="script/lib/bootstrap/bootstrap.min.js"></script>
    <script src="script/lib/bootstrap/bootstrap-switch.js"></script>
    <%--关于图片上传下载的插件--%>
    <link rel="stylesheet" type="text/css" href="script/lib/imageupload/css/webuploader.css" />
    <link rel="stylesheet" type="text/css" href="script/lib/imageupload/css/style.css" />
    <script type="text/javascript" src="script/lib/imageupload/js/jquery.js"></script>
    <script type="text/javascript" src="script/lib/imageupload/js/webuploader.js"></script>
    <script type="text/javascript" src="script/lib/imageupload/js/upload.js"></script>
    <%--关于时间插件的js--%>
    <script src="script/lib/date/dev/js/mobiscroll.core-2.6.2.js" type="text/javascript"></script>
    <link href="script/lib/date/dev/css/mobiscroll.core-2.6.2.css" rel="stylesheet" type="text/css" />
    <script src="script/lib/date/dev/js/mobiscroll.datetime-2.6.2.js" type="text/javascript"></script>
    <script src="script/lib/date/dev/js/mobiscroll.list-2.6.2.js" type="text/javascript"></script>
    <script src="script/lib/date/dev/js/mobiscroll.select-2.6.2.js" type="text/javascript"></script>
    <script src="script/lib/date/dev/js/mobiscroll.android-2.6.2.js" type="text/javascript"></script>
    <link href="script/lib/date/dev/css/mobiscroll.android-2.6.2.css" rel="stylesheet" type="text/css" />
    <script src="script/lib/date/dev/js/mobiscroll.android-ics-2.6.2.js" type="text/javascript"></script>
    <link href="script/lib/date/dev/css/mobiscroll.android-ics-2.6.2.css" rel="stylesheet" type="text/css" />
    <script src="script/lib/date/dev/js/mobiscroll.ios-2.6.2.js" type="text/javascript"></script>
    <link href="script/lib/date/dev/css/mobiscroll.ios-2.6.2.css" rel="stylesheet" type="text/css" />

    <script type="text/javascript">
        $(function () {
            var curr = new Date().getFullYear();
            var opt = {

            }

            opt.date = {preset : 'date'};
            opt.datetime = { preset : 'datetime', minDate: new Date(2012,3,10,9,22), maxDate: new Date(2014,7,30,15,44), stepMinute: 5  };
            opt.time = {preset : 'time'};
            opt.tree_list = {preset : 'list', labels: ['Region', 'Country', 'City']};
            opt.image_text = {preset : 'list', labels: ['Cars']};
            opt.select = {preset : 'select'};
            <!--Script-->

            $('select.changes').bind('change', function() {
                var demo = $('#demo').val();
                $(".demos").hide();
                if (!($("#demo_"+demo).length))
                    demo = 'default';

                $("#demo_" + demo).show();
                $('#test_'+demo).val('').scroller('destroy').scroller($.extend(opt[$('#demo').val()], { theme: $('#theme').val(), mode: $('#mode').val(), display: $('#display').val(), lang: $('#language').val() }));
            });

            $('#demo').trigger('change');
        });
    </script>

</head>

<body>
<div class="content-index">
    <!--标题-->
    <header>
        转让宝物
        <!--操作按钮-->
        <div class="header-box">
            <a href="consignment">
                <button class="header-left">
                    <i class="icon icon-return"></i>
                    返回
                </button>
            </a>
        </div>
        <!--操作按钮 END-->
    </header>
    <!--标题 END-->

    <!--转让宝物信息填写-->
    <div class="transfer-box">
        <!--提示信息-->
        <p>
            <span>请如实填写您的转让信息</span>
            <a >卖家须知</a>
        </p>
        <!--提示信息END-->
        <!--转让宝物信息表单-->
        <form class="transfer-form" action="<%--sell/release--%>user/consignment_success" id="console-form" method="post" >
            <label class="title">
                <input type="text" name="title" value="宝物标题:">
            </label>
            <!--宝物信息选框-->
            <ul class="transfer-info" id="transferInfo">
                <li>
                    <label for="kind">宝物类型：</label>
                    <select name="typeId" id="kind">
                        <c:forEach items="${goodsType}" var="Type">
                            <option value="${Type.key}" >${Type.value}</option>
                        </c:forEach>
                    </select>
                </li>
                <li>
                    <label for="brand">宝物品牌：</label>
                    <select name="brandId" id="brand">
                        <c:forEach items="${brand}" var="one_brand">
                            <option value="${one_brand.key}" >${one_brand.value}</option>
                        </c:forEach>
                    </select>
                </li>
                <li>
                    <div style="display: none">
                        <label for="demo">Demo</label>
                        <select name="demo" id="demo" class="changes">
                            <option value="date" selected>Date</option>
                            &lt;!&ndash;Demos&ndash;&gt;
                        </select>
                    </div>
                    <div id="demo_default" class="demos">
                        <label for="test_default">购物时间：</label>
                        <input type="text" name="upTime" id="test_default" />
                    </div>
                </li>
                <li>
                    <label for="level">新旧程度：</label>
                    <select name="newDegree" id="level">
                        <c:forEach items="${newDegree}" var="degree">
                            <option value="${degree.key}" >${degree.value}</option>
                        </c:forEach>
                    </select>

                </li>
                <li>
                    <label for="size">宝物尺码：</label>
                    <select name="size" id="size">goodsSize
                        <c:forEach items="${goodsSize}" var="size">
                            <option value="${size.key}" >${size.value}</option>
                        </c:forEach>
                    </select>
                </li>

                <li>
                    <label for="sex">适合宝宝：</label>
                    <select name="babyType" id="sex">
                        <c:forEach items="${gender}" var="babygender">
                            <option value="${babygender.key}" >${babygender.value}</option>
                        </c:forEach>
                    </select>
                </li>
                <li>
                    <label for="packet">原装包装：
                        <input name="pack" id="packet" type="checkbox" checked="" data-size="mini">
                    </label>
                </li>
                <li>
                    <label for="invoice">发票小票：
                        <input name="receipt" id="invoice" type="checkbox" checked="" data-size="mini">
                    </label>
                </li>
                <li>
                    <label for="oldPrice">购买原价：
                        <input type="text" name="oldPrice" id="oldPrice">
                    </label>

                </li>
                <li>
                    <label for="newPrice">转让现价：
                        <input type="text" name="price" id="newPrice">
                    </label>

                </li>
            </ul>
            <!--宝物信息选框END-->
            <!--清楚浮动-->
            <div class="clear"></div>
            <!--买家寄语-->
            <div class="transfer-form-bottom">
                <label for="">卖家寄语：<br>宝物详情&nbsp;/<br>使用心得&nbsp;/<br>瑕疵情况等</label>
                <textarea name="message" id="" cols="30" rows="10"></textarea>
            </div>
            <div class="clear"></div>
            <!--上传照片-->
            <div id="uploader-demo">

                <div id="uploader">
                    <div class="queueList">
                        <div id="dndArea" class="placeholder">
                            <div id="filePicker"> </div>
                            <p>或将照片拖到这里，单次最多可选2张</p>
                        </div>
                    </div>
                    <div class="statusBar" style="display:none;">
                        <div class="progress">
                            <span class="text">0%</span>
                            <span class="percentage"></span>
                        </div><div class="info"></div>
                        <div class="btns">
                            <div id="filePicker2"></div><div class="uploadBtn">开始上传</div>
                        </div>
                    </div>
                </div>
            </div>
            <!--上传照片END-->

            <!--买家寄语END-->
            <input name="state" style="display: none" value="1">
        </form>
        <!--转让宝物信息表单END-->
        <!--提交按钮-->
        <a href="#" class="transfer-form-button">
            <button type="submit" form="console-form">一键卖出</button>
        </a>
        <!--提交按钮END-->

    </div>
</div>
<!--转让宝物信息填写END-->
</body>
</html>

<!-- //按钮 -->
