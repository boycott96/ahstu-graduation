package com.huaisun.graduation.cart.controller;

import com.huaisun.graduation.cart.form.CartForm;
import com.huaisun.graduation.cart.service.CartService;
import com.huaisun.graduation.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author sunruiguang
 * @date 2019/4/10
 * Updated by sunruiguang on 2019/4/10.
 */
@Api(description = "购物车", tags = "Cart")
@RestController
@RequestMapping("/sun/cart")
public class CartController {
    @Resource
    private CartService cartService;

    @ApiOperation(value = "购物车[添加购物车]")
    @PostMapping("/addCart")
    public Result addCart(CartForm form) {
        return cartService.addCart(form);
    }

    @ApiOperation(value = "购物车[获取购物车]")
    @GetMapping("/getCart")
    public Result getCart() {
        return cartService.getCart();
    }

    @ApiOperation(value = "购物车[购物车详细数据]")
    @GetMapping("/getDetailCart")
    public Result getDetailCart() {
        return cartService.getDetailCart();
    }

    @ApiOperation(value = "购物车[删除或清空]")
    @DeleteMapping("/deleteCart")
    public Result deleteCart(CartForm form) {
        return cartService.deleteCart(form);
    }
}
