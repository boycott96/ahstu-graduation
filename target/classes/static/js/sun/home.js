$(function () {
    employ.checkLogin();
});

var employ = {};

employ.checkLogin = function () {
    $.ajax({
        url: '/sun/employ/check_login',
        type: 'GET',
        success: function (result) {
            if (result.code === 1) {
                $(".top-name-label").html(result.data.name);
                if (result.data.head != null)
                    $(".head-icon").attr("src", "../static/images/icon/" + result.data.head);
            } else {
                window.location.href = "/index";
            }
        }
    })
};