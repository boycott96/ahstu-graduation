$(function () {
    button.loading();
});

var button = {};

button.loading = function () {
    $("#login-loading").hide();
    $("#sign-loading").hide();
};


function checkEmploy() {
    var email = document.getElementById("inputEmail").value;
    var password = document.getElementById("inputPassword").value;

    var flag = true;
    if (email === "" || email.trim() === "") {
        $("#emailHelp").html("").append("登陆名不能为空").addClass("text-danger");
        flag = false;
    } else {
        $("#emailHelp").html("");
    }

    if (password === "" || password.trim() === "") {
        $("#passwordHelp").html("").append("密码不能为空").addClass("text-danger");
        flag = false;
    } else {
        $("#passwordHelp").html("");
    }

    if (flag) {
        $("#login-loading").show();
        $.ajax({
            type: 'POST',
            url: '/sun/employ/login',
            data: $("#login-form").serialize(),
            success: function (result) {
                button.loading();
                if (result.code === 1) {
                    window.location.href = "/home";
                } else {
                    $("#passwordHelp").html("").append(result.msg).addClass("text-danger");
                }
            }
        });
    }
}

function checkSign() {
    var email = document.getElementById("signEmail").value;
    var password = document.getElementById("signEmail").value;
    var name = document.getElementById("signEmail").value;
    var flag = true;

    if (email === "" || email.trim() === "") {
        $("#emailSignHelp").html("").append("邮箱不能为空").addClass("text-danger");
        flag = false;
    } else {
        $("#emailSignHelp").html("");
    }

    if (password === "" || password.trim() === "") {
        $("#passwordSignHelp").html("").append("密码不能为空").addClass("text-danger");
        flag = false;
    } else {
        $("#passwordSignHelp").html("");
    }

    if (name === "" || name.trim() === "") {
        $("#nameSignHelp").html("").append("姓名不能为空").addClass("text-danger");
        flag = false;
    } else {
        $("#nameSignHelp").html("");
    }

    if (flag) {
        $("#sign-loading").show();
        $.ajax({
            type: 'POST',
            url: '/sun/employ/save_update',
            data: $("#sign-form").serialize(),
            success: function (result) {
                button.loading();
                if (result.code === 1) {
                    alert("注册成功，请登陆");
                    document.getElementById("sign-form").reset();
                } else {
                    $("#signHelp").html("").append(result.msg).addClass("text-danger");
                }
            }
        });
    }
}