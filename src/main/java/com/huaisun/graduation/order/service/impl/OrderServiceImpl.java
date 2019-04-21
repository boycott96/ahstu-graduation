package com.huaisun.graduation.order.service.impl;

import com.huaisun.graduation.auto.dao.TDetailOrder;
import com.huaisun.graduation.auto.dao.TOrder;
import com.huaisun.graduation.auto.mapper.TDetailOrderMapper;
import com.huaisun.graduation.auto.mapper.TOrderMapper;
import com.huaisun.graduation.constants.ResultCode;
import com.huaisun.graduation.order.entity.OrderEntity;
import com.huaisun.graduation.order.form.OrderForm;
import com.huaisun.graduation.order.mapper.OrderMapper;
import com.huaisun.graduation.order.service.OrderService;
import com.huaisun.graduation.util.Result;
import com.huaisun.graduation.util.Tools;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author huaisun
 * @date 2019/2/26 12:31
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private TOrderMapper tOrderMapper;

    @Resource
    private TDetailOrderMapper tDetailOrderMapper;

    @Resource
    private OrderMapper orderMapper;


    @Override
    public Result searchOrderAndUser(OrderForm form) {

        if (Tools.isEmpty(form)) {
            return Result.failure(ResultCode.PARAM_IS_BLANK);
        }

        if (Tools.isEmpty(form.getName())) {
            form.setName(null);
        } else {
            form.setName("%" + form.getName() + "%");
        }

        if (Tools.isEmpty(form.getId())) {
            form.setId(null);
        } else {
            form.setId("%" + form.getId() + "%");
        }

        List<OrderEntity> orderEntities = orderMapper.searchOrderAndUser(form);
        return Result.success(orderEntities);
    }

    @Override
    public Result addOrder(OrderForm form) {
        TOrder order = new TOrder();
        order.setId(System.currentTimeMillis() + "");
        order.setCost(form.getCost());
        order.setCreateDate(new Date());
        order.setuId(form.getUId());
        order.setValid(form.getValid());
        form.getOrderDetail().forEach(orderDetail -> {
            TDetailOrder tDetailOrder = new TDetailOrder();
            tDetailOrder.setoId(order.getId());
            tDetailOrder.setmId(orderDetail.getMid());
            tDetailOrder.setNumber(orderDetail.getNumber());
            tDetailOrderMapper.insert(tDetailOrder);
        });
        return tOrderMapper.insert(order) > 0 ? Result.success(order) : Result.failure(ResultCode.INTERFACE_INNER_INVOKE_ERROR);
    }
}
