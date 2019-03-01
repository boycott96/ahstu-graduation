package com.huaisun.graduation.service;

import com.huaisun.graduation.form.OrderForm;
import com.huaisun.graduation.util.Result;

/**
 * @author huaisun
 * @date 2019/2/26 12:31
 */
public interface OrderService {

    /**
     * 查询订单，根据form表单中的数据
     *
     * @param form form表单
     * @return Result
     */
    Result searchOrder(OrderForm form);

    /**
     * 查询星期内，订单增长率
     *
     * @return Result
     */
    Result getOrderIncrease();
}
