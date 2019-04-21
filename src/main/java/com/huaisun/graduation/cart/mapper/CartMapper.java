package com.huaisun.graduation.cart.mapper;

import com.huaisun.graduation.cart.entity.CartAndMilkEntity;

import java.util.List;

public interface CartMapper {
    /**
     * 查询购物车中的详细数据
     *
     * @return 集合
     */
    List<CartAndMilkEntity> queryDetailCart();
}
