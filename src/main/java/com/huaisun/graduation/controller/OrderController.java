package com.huaisun.graduation.controller;

import com.huaisun.graduation.form.OrderForm;
import com.huaisun.graduation.service.OrderService;
import com.huaisun.graduation.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @ApiOperation(value = "订单[查询订单]")
    @GetMapping("/searchOrder")
    public Result searchOrder(OrderForm form) {
        return service.searchOrder(form);
    }

    @ApiOperation(value = "订单[计算订单增长率]")
    @GetMapping("/getOrderIncrease")
    public Result getOrderIncrease() {
        return service.getOrderIncrease();
    }
}
