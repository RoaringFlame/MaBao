"use strict";
$(function () {
    var provinceId;                //省份id
    var cityId;                    //城市id
    var areaId;                    //地区id
    var defaultProvinceId;
    var dropDownList = $(".edit-add-box").find("label");
    var provinces = dropDownList.find("select:eq(0)");                           //省份下拉框
    var cities = dropDownList.find("select:eq(1)");                              //市下拉框
    var countries = dropDownList.find("select:eq(2)");                           //区下拉框
    var addressForm = $("#frmAddress");                                          //获取表单
    var addressId = $(".edit-add-box").find("input[name='addressId']").val();    //获取地址addressId

    //初始化下拉框
    function initDropDownList() {
        defaultProvinceId = provinces.val();
        //defaultCityId = cities.val();
        //defaultCountryId = countries.val();
        $.get("provinces", {}, function (data) {
            $(data).each(function (index, province) {
                if (province.key !== defaultProvinceId) {
                    provinces.append(                   //为第一个下拉框添加省份节点
                        $("<option></option>")
                            .val(province.key)
                            .text(province.value)
                    );
                }
            });
            fistDropDownListChange();
        }, "json");
    }

    //第一个下拉框改变事件
    function fistDropDownListChange() {
        provinceId=provinces.val();                                          //获取第二个下拉框城市对应的provinceId
        $.get("province/" + provinceId + "/allCity", {}, function (data) {
            $(data).each(function (index, city) {                           //为第二个下拉框添加对应城市信息
                if (city.key !== cityId) {
                    cities.append($("<option></option>")
                        .val(city.key)
                        .text(city.value)
                    );
                }
            });
            secondDropDownListChange();
        }, "json");

    }

    //第二个下拉框改变事件
    function secondDropDownListChange() {
        cityId = cities.val();                                               //获取第二个下拉框城市对应的cartId
        $.get("city/" + cityId + "/allCounty", {}, function (data) {
            //countries.empty();                                             //移除第三个下拉框的城区节点
            $(data).each(function (index, country) {
                if (country.key !== areaId) {
                    countries.append($("<option></option>")                  //为第三个下拉框添加对应城市的区信息
                        .val(country.key)
                        .text(country.value)
                    );
                }
            });
        }, "json");
    }

    //弹框事件
    function showMsg(msg) {
        //提示框弹出信息停留3秒消失
        $('#textShow').text(msg).fadeIn(1000).delay(2000).fadeOut(1000);
    }

    function init() {
        //初始化下拉框
        initDropDownList();
        //第一个下拉框值改变事件
        provinces.change(function () {
            cities.empty();                                                  //移除第二个下拉框节点
            countries.empty();//移除第三个下拉框节点
            fistDropDownListChange();
        });
        //第二个下拉框值改变事件
        cities.change(function () {
            countries.empty();                                               //移除第三个下拉框节点
            secondDropDownListChange();

        });
        //第三个下拉框值改变事件
        dropDownList.find("select:eq(2)").change(function () {

        });

        //保存并使用按钮
        $(".edit-add-input input").click(function () {
            var recipients = $(".edit-add-box input:eq(0)").val();
            var tel = $(".edit-add-box input:eq(1)").val();
            var areaId = $(".edit-add-box input[name='area.id']").val();
            var location = $(".edit-add-box input[name='location']").val();
            if (recipients == "" || tel == "" || areaId == "" || location == "") {
                showMsg("请完善地址信息！");
            } else if (!(/^1[3|4|5|7|8]\d{9}$/.test(tel))) {
                showMsg("您的电话格式不对！");
            } else {
                provinceId=provinces.val();                                 //获取当前省份值
                $("#provinceId").val(provinceId);
                cityId=cities.val();                                        //获取当前市值
                $("#cityId").val(cityId);
                areaId = countries.val();                                    //获取当前区值
                $("#areaId").val(areaId);
                addressForm.attr("method", "post");                                                //以post方式提交表单
                addressForm.attr("action", "user/address/updateAddress");
                addressForm.submit();
            }
        });

    }

    init();

});


