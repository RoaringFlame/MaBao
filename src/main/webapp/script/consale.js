"use strict";
$(function () {
    var provinceId;                //省份id
    var cityId;                    //城市id
    var areaId;                    //地区id
    var dropDownList = $(".edit-add-box").find("label:eq(2)");
    var provinces = dropDownList.find("select:eq(0)");
    var cities = dropDownList.find("select:eq(1)");
    var countries = dropDownList.find("select:eq(2)");
    //初始化第一个下拉框
    function initDropDownList() {
        MB.sendAjax("get", "provinces", {}, function (data) {
            $(data).each(function (index, province) {               //为第一个下拉框添加省份节点
                provinces.append($("<option></option>")
                    .val(province.key)
                    .text(province.value)
                );
            });
        });
    }

    //第一个下拉框改变事件
    function fistDropDownListChange() {
        provinceId = dropDownList.find("select:eq(0)").val();               //获取第二个下拉框城市对应的provinceId
        MB.sendAjax("get", "province/" + provinceId + "/allCity", {}, function (data) {
            cities.empty();                                    //移除第二个下拉框节点
            countries.empty();                                 //移除第三个下拉框节点
            cities.append($("<option></option>")
                .text("请选择")
            );
            countries.append($("<option></option>")
                .text("请选择")
            );
            $(data).each(function (index, city) {              //为第二个下拉框添加第一个下拉框选择省份的对应城市信息
                cities.append($("<option></option>")
                    .val(city.key)
                    .text(city.value)
                );
            });
        });
    }

    //第二个下拉框改变事件
    function secondDropDownListChange() {
        cityId = dropDownList.find("select:eq(1)").val();              //获取第二个下拉框城市对应的cartId
        MB.sendAjax("get", "city/" + cityId + "/allCounty", {}, function (data) {
            countries.empty();                                         //移除第三个下拉框的城区节点
            countries.append($("<option></option>")
                .text("请选择")
            );
            $(data).each(function (index, country) {                   //为第三个下拉框添加对应城市的区信息
                countries.append($("<option></option>")
                    .val(country.key)
                    .text(country.value)
                );
            });
        });

    }

    //弹框事件
    function showMsg(msg) {
        //提示框弹出信息停留3秒消失
        $('#textShow').text(msg).fadeIn(1000).delay(2000).fadeOut(1000);
    }

    function init() {
        //初始化第一个下拉框
        initDropDownList();
        //第一个下拉框值改变事件
        dropDownList.find("select:eq(0)").change(function () {
            fistDropDownListChange();
        });
        //第二个下拉框值改变事件
        dropDownList.find("select:eq(1)").change(function () {
            secondDropDownListChange();
        });
        //第三个下拉框值改变事件
        dropDownList.find("select:eq(2)").change(function () {
            areaId = $(this).val();
            $(this).next("input[name='areaId']").val(areaId);
        });
        //提交按钮
        var submit = $(".edit-add-input input");
        submit.addClass("default");                                 //初始化提交按钮背景为蓝色
        submit.click(function () {
            var recipients = $(".edit-add-box input:eq(0)").val();
            var tel = $(".edit-add-box input:eq(1)").val();
            var areaId = $(".edit-add-box input:eq(2)").val();
            var location = $(".edit-add-box input:eq(3)").val();
            var checkBox = $("label.terms input");
            if (recipients == "" || tel == "" || areaId == "" || location == "") {
                showMsg("请完善地址信息！");
            } else if (!(checkBox.is(':checked'))) {
                showMsg("您必须同意服务条款！");
            } else if (tel.length !== 11) {
                showMsg("您的电话格式不对！");
            }
            else {
                $("#edit-add").submit();
            }

        });

    }

    init();
});
