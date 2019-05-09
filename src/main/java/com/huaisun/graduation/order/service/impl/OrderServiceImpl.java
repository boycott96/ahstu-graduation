package com.huaisun.graduation.order.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huaisun.graduation.auto.dao.TDetailOrder;
import com.huaisun.graduation.auto.dao.TOrder;
import com.huaisun.graduation.auto.dao.TUser;
import com.huaisun.graduation.auto.dao.TUserKey;
import com.huaisun.graduation.auto.mapper.TDetailOrderMapper;
import com.huaisun.graduation.auto.mapper.TOrderMapper;
import com.huaisun.graduation.auto.mapper.TUserMapper;
import com.huaisun.graduation.constants.ResultCode;
import com.huaisun.graduation.order.entity.OrderEntity;
import com.huaisun.graduation.order.form.OrderForm;
import com.huaisun.graduation.order.mapper.OrderMapper;
import com.huaisun.graduation.order.service.OrderService;
import com.huaisun.graduation.user.mapper.UserMapper;
import com.huaisun.graduation.util.Result;
import com.huaisun.graduation.util.Tools;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
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

    @Resource
    private TUserMapper tUserMapper;

    @Override
    public Result searchOrderAndUser(OrderForm form) {
        PageHelper.startPage(form.getCurrentPage(), form.getPageSize());
        List<OrderEntity> orderEntities = orderMapper.searchOrderAndUser(form);
        PageInfo<OrderEntity> pageInfo = new PageInfo<>(orderEntities);
        Result<PageInfo<OrderEntity>> result = new Result<>();
        result.setPage(pageInfo);
        return result;
    }

    @Override
    @Transactional
    public Result addOrder(OrderForm form) {
        TOrder order = new TOrder();
        order.setId(System.currentTimeMillis() + "");
        order.setCost(form.getCost());
        order.setCreateDate(new Date());
        order.setuId(form.getUserId());
        order.setValid(form.getValid());
        form.getOrderDetail().forEach(orderDetail -> {
            TDetailOrder tDetailOrder = new TDetailOrder();
            tDetailOrder.setoId(order.getId());
            tDetailOrder.setmId(orderDetail.getMid());
            tDetailOrder.setNumber(orderDetail.getNumber());
            tDetailOrderMapper.insert(tDetailOrder);
        });
        tOrderMapper.insert(order);
        TUserKey key = new TUserKey();
        key.setId(form.getUserId());
        TUser user = tUserMapper.selectByPrimaryKey(key);
        if(Tools.isNotEmpty(user)) {
            user.setCost(user.getCost().add(form.getCost()));
            user.setIntegral(user.getIntegral().add(form.getCost().multiply(new BigDecimal(10))));
        }
        return tUserMapper.updateByPrimaryKey(user) > 0 ? Result.success(order) : Result.failure(ResultCode.INTERFACE_INNER_INVOKE_ERROR);
    }
}
