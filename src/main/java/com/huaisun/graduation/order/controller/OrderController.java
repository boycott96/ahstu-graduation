package com.huaisun.graduation.order.controller;

import com.huaisun.graduation.order.form.OrderForm;
import com.huaisun.graduation.order.service.OrderService;
import com.huaisun.graduation.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author huaisun
 * @date 2019/2/26 12:30
 */
@Api(description = "订单管理", tags = "OrderManagement")
@RestController
@RequestMapping("/sun/order")
public class OrderController {

    @Resource
    private OrderService service;

    @ApiOperation(value = "订单[下单]")
    @PostMapping("/addOrder")
    public Result addOrder(@RequestBody OrderForm form) {
        return service.addOrder(form);
    }

    @ApiOperation(value = "订单[关联查询订单]")
    @GetMapping("/searchOrderAndUser")
    public Result searchOrderAndUser(OrderForm form) {
        return service.searchOrderAndUser(form);
    }
}
