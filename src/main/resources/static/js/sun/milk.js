$(function () {
    milk.loadMilkMenu();
});

var milk = {};

milk.loadMilkMenu = function () {
    $.ajax({
        url: '/sun/milk/searchMilkMenu',
        type: 'GET',
        success: function (result) {
            $(".card-deck").html("");
            $.each(result.data, function (item, val) {
                var card = '<div class="card col-md-2"><img src="' + val.milkAddress +
                    '" class="card-img-top" alt="' + val.milkName +
                    '"><div class="card-body"><h5 class="card-title">' + val.milkName +
                    '</h5><p class="card-text">价格:&nbsp;<code>$' + val.milkPrice +
                    '</code></p><button type="button" class="btn btn-outline-warning btn-sm float-right">下单</button></div></div>'
                $(".card-deck").append(card);
            });
        }
    })
};