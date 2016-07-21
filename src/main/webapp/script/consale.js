"use strict";
$(function () {
    var provinceId;                //省份id
    var cityId;                    //城市id
    var areaId;                    //地区id
    var dropDownList = $(".edit-add-box").find("label:eq(2)");
    var city = dropDownList.find("select:eq(1)");
    var country = dropDownList.find("select:eq(2)");
    //初始化第一个下拉框
    function initDropDownList() {
        MB.sendAjax("get", "provinces", {}, function (data) {
            $(data).each(function (index) {
                dropDownList.find("select:eq(0)").append("<option value=" + data[index].key + " >" + data[index].value + "</option>");      //为第一个下拉框添加省份节点
            });
        });
    }

    //第一个下拉框改变事件
    function fistDropDownListChange() {
        provinceId = dropDownList.find("select:eq(0)").val();               //获取第二个下拉框城市对应的provinceId
        MB.sendAjax("get", "province/" + provinceId + "/allCity", {}, function (data) {
            city.find("option").remove();                                    //移除第二个下拉框节点
            country.find("option").remove();                                 //移除第三个下拉框节点
            city.append("<option value='请选择'>请选择</option>");
            country.append("<option value='请选择'>请选择</option>");
            $(data).each(function (index) {
                dropDownList.find("select:eq(1)").append("<option value=" + data[index].key + ">" + data[index].value + "</option>");        //为第二个下拉框添加第一个下拉框选择省份的对应城市信息
            });
        });
    }

    //第二个下拉框改变事件
    function secondDropDownListChange() {
        cityId = dropDownList.find("select:eq(1)").val();              //获取第二个下拉框城市对应的cartId
        MB.sendAjax("get", "city/" + cityId + "/allCounty", {}, function (data) {
            country.find("option").remove();                            //移除第三个下拉框的城区节点
            country.append("<option value='请选择'>请选择</option>");
            $(data).each(function (index) {
                dropDownList.find("select:eq(2)").append("<option value=" + data[index].key + ">" + data[index].value + "</option>");    //为第三个下拉框添加对应城市的区信息
            });
        });

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
        submit.attr("disabled", false);                             //初始化提交按钮可用
        $("label.terms input").click(function () {
                if ($(this).is(':checked')) {
                    submit.removeClass("disabled");                     //若同意条款勾选框勾选则提交按钮可用，背景为蓝色
                    submit.addClass("default");
                    submit.removeAttr("disabled");
                } else {
                    submit.removeClass("default");                      //若同意条款勾选框勾选则提交按钮不可用，背景为灰色
                    submit.addClass("disabled");
                    submit.attr("disabled", true);
                }
            }
        );

    }

    init();
});
