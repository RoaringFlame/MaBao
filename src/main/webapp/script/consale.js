/**
 * Created by maxu on 2016/7/14.
 */
"use strict";
$(function () {
    var provinceId;                //省份id
    var cityId;                    //城市id
    var areaId;                    //地区id
    var dropDownList = $(".edit-add-box").find("label:eq(3)");
    //初始化第一个下拉框
    function initDropDownList() {
        MB.sendAjax("get", "Provinces", {}, function (data) {
            $(data).each(function (index) {
                dropDownList.find("select:eq(0)").append("<option value=" + data[index].key + " >" + data[index].value + "</option>");      //为第一个下拉框添加省份节点
            });
        });
    }
    //第一个下拉框改变事件
    function fistDropDownListChange() {
        provinceId = dropDownList.find("select:eq(0)").val();               //获取第二个下拉框城市对应的provinceId
        var city=dropDownList.find("select:eq(1)");
        MB.sendAjax("get", "Province/" + provinceId + "/allCity", {}, function (data) {
            city.find("option").remove();                                    //移除第二个下拉框节点
            city.append("<option value='请选择'>请选择</option>");
            $(data).each(function (index) {
                dropDownList.find("select:eq(1)").append("<option value=" + data[index].key + ">" + data[index].value + "</option>");        //为第二个下拉框添加第一个下拉框选择省份的对应城市信息
            });
        });
    }
    //第二个下拉框改变事件
    function secondDropDownListChange() {
        cityId = dropDownList.find("select:eq(1)").val();              //获取第二个下拉框城市对应的cartId
        var country=dropDownList.find("select:eq(2)");
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
            areaId=$(this).val();
           $(this).next("input[name='areaId']").val(areaId);
        });
        //提交按钮
        var submit=$(".edit-add-input input");
        submit.addClass("default");                                         //初始化提交按钮
        $("label.terms input").click(function(){                           //若同意条款勾选框勾选则按钮可用，不勾选按钮不可用
        if($("label.terms").find("input").is(':checked')){
            submit.removeClass("default");
            submit.addClass("diabled");
        }else {
            submit.removeClass("diabled");
            submit.addClass("default");
        }
        });

    }

    init();
});









