$(function () {
    user.loadUser('');
    user.searchUser();
    user.saveOrUpdateUser();
});

var user = {};

var userForm = {
    id: '',
    name: '',
    email: '',
    phone: ''
};

var table_color = ['info', 'warning', 'danger', 'success', 'primary'];

user.loadUser = function (name) {
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
                    val.cost + '</td><td>' + val.createDate + '</td><td>' +
                    '<i class="mdi mdi-tooltip-edit text-warning" onclick="editUser(' + val.id + ')">&nbsp;&nbsp;&nbsp;&nbsp;</i>' +
                    '<i class="mdi mdi-delete text-danger" onclick="deleteUser(' + val.id + ')"></i></td></tr>';
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

user.saveOrUpdateUser = function () {

    $("#inputName").change(function () {
        user.checkName()
    });

    $("#inputPhone").change(function () {
        user.checkPhone();
    });

    $("#saveUser").click(function () {
        if (user.checkName() && user.checkPhone()) {
            userForm.name = $("#inputName").val();
            userForm.email = $("#inputEmail").val();
            userForm.phone = $("#inputPhone").val();
            $.ajax({
                url: '/sun/user/saveOrUpdateUser',
                type: 'POST',
                data: userForm,
                success: function (result) {
                    if (result.code === 1) {
                        userForm = {
                            id: '',
                            name: '',
                            email: '',
                            phone: ''
                        };
                        $("#clearForm").trigger("click");
                        alert("保存成功");
                        user.loadUser();
                    } else {
                        $("#phoneHelp").html("").append("添加用户失败，请刷新重试").addClass("text-danger");
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

function editUser(id) {
    $.ajax({
        url: '/sun/user/getUser',
        type: 'GET',
        data: {id: id},
        success: function (result) {
            if (result.code === 1) {
                userForm = result.data;
                $("#inputName").val(userForm.name);
                $("#inputEmail").val(userForm.email);
                $("#inputPhone").val(userForm.phone);
            }
        }
    });
}

function deleteUser(id) {
    var msg = confirm("确定删除吗?");

    if (msg) {
        $.ajax({
            url: 'sun/user/deleteUser',
            type: 'DELETE',
            data: {id: id},
            success: function (result) {
                alert(result.msg);
                user.loadUser();
            }
        })
    }
}