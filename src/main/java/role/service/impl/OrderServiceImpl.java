package role.service.impl;

import com.huaisun.graduation.auto.dao.TOrder;
import com.huaisun.graduation.auto.dao.TOrderExample;
import com.huaisun.graduation.auto.mapper.TOrderMapper;
import com.huaisun.graduation.constants.ResultCode;
import role.entity.OrderEntity;
import role.form.OrderForm;
import role.mapper.OrderMapper;
import role.service.OrderService;
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
    private TOrderMapper tOrderMapper;

    @Resource
    private OrderMapper orderMapper;

    @Override
    public Result searchOrder(OrderForm form) {

        TOrderExample example = new TOrderExample();
        TOrderExample.Criteria criteria = example.createCriteria();

        if (Tools.isEmpty(form.getIsDate())) {
            criteria.andCreateDateBetween(TimeUtil.getNowWeekStart(), new Date());
        }

        List<TOrder> orders = tOrderMapper.selectByExample(example);

        return Result.success(orders);
    }

    @Override
    public Result getOrderIncrease() {

        TOrderExample example = new TOrderExample();
        TOrderExample.Criteria criteria = example.createCriteria();
        criteria.andCreateDateBetween(TimeUtil.getNowWeekStart(), new Date());
        Long lastWeekOrder = tOrderMapper.countByExample(example);

        TOrderExample example1 = new TOrderExample();
        TOrderExample.Criteria criteria1 = example1.createCriteria();
        criteria1.andCreateDateBetween(TimeUtil.getLastWeekStart(), TimeUtil.getLastWeekEnd());
        Long nowWeekOrder = tOrderMapper.countByExample(example1);

        return Result.success(100.0 * (nowWeekOrder - lastWeekOrder) / (lastWeekOrder == 0 ? 1 : lastWeekOrder));
    }

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

        if (Tools.isEmpty(form.getMode())) {
            form.setMode(null);
        }

        List<OrderEntity> orderEntities = orderMapper.searchOrderAndUser(form);
        return Result.success(orderEntities);
    }
}
