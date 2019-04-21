package com.huaisun.graduation.cart.service;

import com.huaisun.graduation.cart.form.CartForm;
import com.huaisun.graduation.util.Result;

/**
 * @author sunruiguang
 * @date 2019/4/10
 * Updated by sunruiguang on 2019/4/10.
 */
public interface CartService {

    /**
     * 添加购物车
     *
     * @param form 购物车信息
     * @return Result
     */
    Result addCart(CartForm form);

    /**
     * 获取购物车事件
     *
     * @return Result
     */
    Result getCart();

    /**
     * 获取购物车详细数据
     *
     * @return
     */
    Result getDetailCart();

    /**
     * 清空或删除购物车
     *
     * @return
     */
    Result deleteCart(CartForm form);
}
