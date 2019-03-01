package com.huaisun.graduation.service.impl;

import com.huaisun.graduation.auto.dao.TOrder;
import com.huaisun.graduation.auto.dao.TOrderExample;
import com.huaisun.graduation.auto.mapper.TOrderMapper;
import com.huaisun.graduation.form.OrderForm;
import com.huaisun.graduation.service.OrderService;
import com.huaisun.graduation.util.Result;
import com.huaisun.graduation.util.TimeUtil;
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
    private TOrderMapper orderMapper;

    @Override
    public Result searchOrder(OrderForm form) {

        TOrderExample example = new TOrderExample();
        TOrderExample.Criteria criteria = example.createCriteria();

        if (Tools.isEmpty(form.getIsDate())) {
            criteria.andCreateDateBetween(TimeUtil.getNowWeekStart(), new Date());
        }

        List<TOrder> orders = orderMapper.selectByExample(example);

        return Result.success(orders);
    }

    @Override
    public Result getOrderIncrease() {

        TOrderExample example = new TOrderExample();
        TOrderExample.Criteria criteria = example.createCriteria();
        criteria.andCreateDateBetween(TimeUtil.getNowWeekStart(), new Date());
        Long lastWeekOrder = orderMapper.countByExample(example);

        TOrderExample example1 = new TOrderExample();
        TOrderExample.Criteria criteria1 = example1.createCriteria();
        criteria1.andCreateDateBetween(TimeUtil.getLastWeekStart(), TimeUtil.getLastWeekEnd());
        Long nowWeekOrder = orderMapper.countByExample(example1);

        return Result.success(100.0 * (nowWeekOrder - lastWeekOrder) / (lastWeekOrder == 0 ? 1 : lastWeekOrder));
    }
}
