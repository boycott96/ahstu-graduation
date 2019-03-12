package com.huaisun.graduation.mapper;

import com.huaisun.graduation.entity.OrderEntity;
import com.huaisun.graduation.form.OrderForm;

import java.util.List;

/**
 * 自定义订单mapper
 *
 * @author huaisun
 * @date 2019/3/11 12:57
 */
public interface OrderMapper {

    /**
     * 查询订单表和用户表关联
     *
     * @param form 订单搜索条件
     * @return 订单实体集合
     */
    List<OrderEntity> searchOrderAndUser(OrderForm form);
}
