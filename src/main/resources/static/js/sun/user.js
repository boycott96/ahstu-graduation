$(function () {
    user.loadUser('');
    user.searchUser();
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