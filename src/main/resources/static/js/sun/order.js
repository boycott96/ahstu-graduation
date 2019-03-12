$(function () {

});

var order = {};

var table_color = ['info', 'warning', 'danger', 'success', 'primary'];

order.loadOrder = function (name) {
    $.ajax({
        url: '/sun/order/searchOrder',
        type: 'GET',
        data: {name: name, email: name, phone: name, isDate: '0'},
        success: function (result) {
            $("#order-table-data").html("");
            $.each(result.data, function (item, val) {
                var table_data = '<tr class="table-' + table_color[item % 5] + '"><td>' +
                    (item + 1) + '</td><td>' + val.name + '</td><td>' +
                    val.email + '</td><td>' + val.phone + '</td><td>' +
                    val.integral + '</td><td>' + val.balance + '</td><td>' +
                    val.cost + '</td><td>' + val.createDate + '</td><td>' +
                    '<i class="mdi mdi-tooltip-edit text-warning" onclick="editUser(' + val.id + ')">&nbsp;&nbsp;&nbsp;&nbsp;</i>' +
                    '<i class="mdi mdi-delete text-danger" onclick="deleteUser(' + val.id + ')"></i></td></tr>';
                $("#order-table-data").append(table_data);
            });
        }
    });
};