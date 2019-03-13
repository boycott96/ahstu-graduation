$(function () {
    order.loadOrder('');
});

var order = {};

var table_color = ['info', 'warning', 'danger', 'success', 'primary'];

order.loadOrder = function (name) {
    $.ajax({
        url: '/sun/order/searchOrderAndUser',
        type: 'GET',
        data: {id: name, name: name, mode: name},
        success: function (result) {
            $("#order-table-data").html("");
            $.each(result.data, function (item, val) {
                var table_data = '<tr class="table-' + table_color[item % 5] + '"><td>'
                    + (item + 1) + '</td><td>'
                    + val.id + '</td><td>'
                    + val.name + '</td><td>'
                    + val.phone + '</td><td>'
                    + val.mode + '</td><td>'
                    + val.valid + '</td><td>'
                    + val.price + '</td><td>'
                    + val.count + '</td><td>'
                    + val.cost + '</td><td>'
                    + val.payment + '</td><td>'
                    + val.createDate + '</td><td>';
                $("#order-table-data").append(table_data);
            });
        }
    });
};