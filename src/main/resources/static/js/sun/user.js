$(function () {
    user.loadUser('');
    user.searchUser();
    user.addUser();
});

var user = {};

var table_color = ['info', 'warning', 'danger', 'success', 'primary'];

user.loadUser = function (name) {
    console.log(name);
    $.ajax({
        url: '/sun/user/searchUser',
        type: 'GET',
        data: {name: name, email: name, phone: name, isDate: '0'},
        success: function (result) {
            $("#user-table-data").html("");
            $.each(result.data, function (item, val) {
                var table_data = '<tr class="table-' + table_color[item % 5] + '"><td>' +
                    (item + 1) + '</td><td>' + val.name + '</td><td>' +
                    val.email + '</td><td>' + val.phone + '</td><td>' +
                    val.integral + '</td><td>' + val.balance + '</td><td>' +
                    val.cost + '</td><td>' + val.createDate + '</td></tr>';
                $("#user-table-data").append(table_data);
            });
        }
    });
};

user.searchUser = function () {
    $("#button-search").click(function () {
        var name = $("#queryName").val();
        user.loadUser(name);
    })
};

user.addUser = function () {

    $("#inputName").change(function () {
        user.checkName()
    });

    $("#inputPhone").change(function () {
        user.checkPhone();
    });

    $("#saveUser").click(function () {
        if (user.checkName() && user.checkPhone()) {
            $.ajax({
                url: '/sun/user/addUser',
                type: 'POST',
                data: $("#addForm").serialize(),
                success: function (result) {
                    if(result.code === 1){
                        $("#clearForm").trigger("click");
                        user.loadUser();
                    }
                }
            })
        }
    });
};

user.checkName = function () {
    var name = $("#inputName").val();
    if (name === "" || name.trim() === "") {
        $("#nameHelp").html("").append("姓名不能为空").addClass("text-danger");
        return false;
    } else {
        $("#nameHelp").html("");
        return true;
    }
};

user.checkPhone = function () {
    var phone = $("#inputPhone").val();
    if (phone === "" || phone.trim() === "") {
        $("#phoneHelp").html("").append("密码不能为空").addClass("text-danger");
        return false;
    } else {
        $("#phoneHelp").html("");
        return true;
    }
};