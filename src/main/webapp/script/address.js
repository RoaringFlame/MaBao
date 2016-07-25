"use strict";
$(function () {
    function init() {
        $("input[name='defaultAddress']").click(function () {
            var addressId = $(this).parent().prev(".addressId").text();
            MB.sendAjax("get", "person/address/updateAddressStatus", {addressId: addressId}, function () {

            });
        });
    }

    init();
});
