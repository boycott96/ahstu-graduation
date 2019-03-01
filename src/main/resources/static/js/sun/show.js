$(function () {
    show.searchUserOfWeek();
    show.getUserIncrease();

    //订单
    show.searchOrderOfWeek();
    show.getOrderIncrease();
});

var show = {};

var increase_compare_last = "上期相比幅度 ";

show.searchUserOfWeek = function () {
    $.ajax({
        url: '/sun/user/searchUser',
        type: 'GET',
        data: {isDate: '1'},
        success: function (result) {
            $("#user-count").text(result.data.length);
        }
    })
};

show.getUserIncrease = function () {
    $.ajax({
        url: '/sun/user/getUserIncrease',
        type: 'GET',
        success: function (result) {
            $("#user-increase-compare").text(increase_compare_last + result.data + "%");
        }
    })
};

show.searchOrderOfWeek = function () {
    $.ajax({
        url: '/sun/order/searchOrder',
        type: 'GET',
        data: {isDate: '1'},
        success: function (result) {
            $("#order-count").text(result.data.length);
        }
    })
};

show.getOrderIncrease = function () {
    $.ajax({
        url: '/sun/order/getOrderIncrease',
        type: 'GET',
        success: function (result) {
            $("#order-increase-compare").text(increase_compare_last + result.data + "%");
        }

    })
}