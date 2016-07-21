"use strict";
$(function () {
    var provinceId;                //省份id
    var cityId;                    //城市id
    var areaId;                    //地区id
    var defaultProvinceId;
    var defaultCityId;
    var dropDownList = $(".edit-add-box").find("label");
    var provinces = dropDownList.find("select:eq(0)");
    var city = dropDownList.find("select:eq(1)");
    var country = dropDownList.find("select:eq(2)");

    //初始化下拉框
    function initDropDownList() {
        areaId = $("#areaId").val();                               //获取前一页面传过来的areaId

        $.get("getProvinceCityCounty", {areaId: areaId}, function (data) {
            defaultProvinceId = data.provinceId;                    //获取areaId对应的provinceId
            defaultCityId = data.cityId;                            //获取areaId对应的cityId
        }, "json");

        $.get("provinces", {}, function (data) {
            $(data).each(function (index) {
                provinces.append("<option value=" + data[index].key + " >" + data[index].value + "</option>");      //为第一个下拉框添加省份节点
            });
            provinces.val(defaultProvinceId);
        }, "json");

        $.get("province/"+defaultProvinceId+"/allCity", {}, function (data) {
            city.empty();
            $(data).each(function (index,city) {
                city.append(                   //为第一个下拉框添加省份节点
                    $("<option></option>")
                        .val(city.key)
                        .text(city.value)
                );
            });
            city.val(defaultCityId);
        }, "json");

        $.get("city/" + defaultCityId     + "/allCounty", {}, function (data) {
            $(data).each(function (index) {
                dropDownList.find("select:eq(2)").append("<option value=" + data[index].key + ">" + data[index].value + "</option>");    //为第三个下拉框添加对应城市的区信息
            });
            country.val(areaId);
        }, "json");

    }

    //第一个下拉框改变事件
    function fistDropDownListChange() {
        provinceId = dropDownList.find("select:eq(0)").val();               //获取第二个下拉框城市对应的provinceId
        $.get("province/" + provinceId + "/allCity", {}, function (data) {
            city.find("option").remove();                                    //移除第二个下拉框节点
            country.find("option").remove();                                 //移除第三个下拉框节点
            city.append("<option value='请选择'>请选择</option>");
            country.append("<option value='请选择'>请选择</option>");
            $(data).each(function (index) {
                city.append("<option value=" + data[index].key + ">" + data[index].value + "</option>");        //为第二个下拉框添加第一个下拉框选择省份的对应城市信息
            });
        }, "json");
    }

    //第二个下拉框改变事件
    function secondDropDownListChange() {
        cityId = dropDownList.find("select:eq(1)").val();              //获取第二个下拉框城市对应的cartId
        $.get("city/" + cityId + "/allCounty", {}, function (data) {
            country.find("option").remove();                            //移除第三个下拉框的城区节点
            country.append("<option value='请选择'>请选择</option>");
            $(data).each(function (index) {
                dropDownList.find("select:eq(2)").append("<option value=" + data[index].key + ">" + data[index].value + "</option>");    //为第三个下拉框添加对应城市的区信息
            });
        }, "json");

    }

    function init() {

        //初始化下拉框
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
        //dropDownList.find("select:eq(2)").change(function () {
        //    areaId = $(this).val();
        //});

        var switchCheck = $(".switch input:eq(0)");              //默认地址选择开关节点
        var addressState = $(".switch input:eq(1)");             //地址状态是否默认状态节点
        var switchValue = switchCheck.val();                     //默认地址选择开关节点的值
        if (switchValue == 'true') {
            switchCheck.attr("checked", true);                  //如果默认地址选择开关值为true，开关显示NO
            addressState.val("1");
        } else {
            switchCheck.removeAttr("checked");                 //如果默认地址选择开关值为false，开关显示OFF
            addressState.val("0");
        }

        var addressForm = $("#frmAddress");
        var addressId = $(".edit-add-box").find("input[name='addressId']").val();
        //删除地址按钮
        $(".edit-add-input input:eq(0)").click(function () {
            addressForm.attr("method", "get");                                                //以get方式提交表单
            addressForm.attr("action", "user/address/deleteAddress?addressId=" + addressId);
            addressForm.submit();                                                            //提交表单
        });
        //保存并使用按钮
        $(".edit-add-input input:eq(1)").click(function () {
            addressForm.attr("method", "post");                                                //以post方式提交表单
            $(".edit-add-box").find("input[name='addressId']").attr("name", "id");
            addressForm.attr("action", "user/address/updateAddress");
            addressForm.submit();
        });

    }

    init();

});


