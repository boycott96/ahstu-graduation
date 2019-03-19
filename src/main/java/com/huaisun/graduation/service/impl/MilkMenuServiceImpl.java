package com.huaisun.graduation.service.impl;

import com.huaisun.graduation.auto.dao.TMilkMenu;
import com.huaisun.graduation.auto.dao.TMilkMenuExample;
import com.huaisun.graduation.auto.mapper.TMilkMenuMapper;
import com.huaisun.graduation.service.MilkMenuService;
import com.huaisun.graduation.util.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author sunruiguang
 * @date 2019/3/19
 * Updated by sunruiguang on 2019/3/19.
 */
@Service
public class MilkMenuServiceImpl implements MilkMenuService {

    @Resource
    private TMilkMenuMapper tMilkMenuMapper;

    @Override
    public Result searchMilkMenu() {

        TMilkMenuExample example = new TMilkMenuExample();
        TMilkMenuExample.Criteria criteria = example.createCriteria();

        criteria.andIsShelfEqualTo(1);
        List<TMilkMenu> milkMenuList = tMilkMenuMapper.selectByExample(example);
        return Result.success(milkMenuList);
    }
}
