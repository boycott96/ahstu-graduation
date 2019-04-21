package com.huaisun.graduation.order.service;

import com.huaisun.graduation.order.form.OrderForm;
import com.huaisun.graduation.util.Result;

/**
 * @author huaisun
 * @date 2019/2/26 12:31
 */
public interface OrderService {

    /**
     * 关联查询订单用户表，
     *
     * @param form 搜索条件
     * @return Result
     */
    Result searchOrderAndUser(OrderForm form);

    /**
     * 下单
     *
     * @param form 表单
     * @return Result
     */
    Result addOrder(OrderForm form);
}
