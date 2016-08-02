var MB = {};
MB.getRootPath = function () {
    //获取当前网址，如： http://localhost:8083/uimcardprj/share/meun.jsp
    var href = window.document.location.href;
    //获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
    var pathName = window.document.location.pathname;
    //获取主机地址，如： http://localhost:8083
    var serverPath = href.substring(0, href.length - pathName.length);
    //获取带"/"的项目名，如：/uimcardprj
    var projectName = "/";
    if (pathName.length > 1) {
        projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
    }
    return (serverPath + projectName);
};
MB.getContextPath = function () {
    var pathName = document.location.pathname;
    var index = pathName.substr(1).indexOf("/");
    var result = pathName.substr(0, index + 1);
    return result;
};
MB.sendAjax = function (type, url, data, successFn, errorFn) {
    var path = MB.getRootPath();
    if (url.indexOf("/") == 0) {
        path += url;
    }
    else {
        path += "/" + url;
    }
    $.ajax({
        async:false,
        type: type,
        data: data,
        url: path,
        dataType: "json",
        success: function (d) {
            if (successFn) {
                successFn(d);
            }
        },
        error: function (e) {
            if (errorFn) {
                errorFn(e);
            }
            else {
                console.log(e);
            }
        }
    });
};