package com.huaisun.graduation.milk.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huaisun.graduation.auto.dao.TMilkMenu;
import com.huaisun.graduation.auto.dao.TMilkMenuExample;
import com.huaisun.graduation.auto.dao.TMilkMenuKey;
import com.huaisun.graduation.auto.mapper.TMilkMenuMapper;
import com.huaisun.graduation.constants.ResultCode;
import com.huaisun.graduation.milk.form.MilkMenuForm;
import com.huaisun.graduation.milk.service.MilkMenuService;
import com.huaisun.graduation.util.Result;
import com.huaisun.graduation.util.Tools;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ClassUtils;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

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
    public Result getMilkMenu() {
        TMilkMenuExample example = new TMilkMenuExample();
        TMilkMenuExample.Criteria criteria = example.createCriteria();
        criteria.andIsShelfEqualTo(0);
        List<TMilkMenu> milkMenuList = tMilkMenuMapper.selectByExample(example);
        return Result.success(milkMenuList);
    }

    @Override
    public Result<PageInfo<TMilkMenu>> searchMilkMenu(MilkMenuForm form) {
        TMilkMenuExample example = new TMilkMenuExample();
        TMilkMenuExample.Criteria criteria = example.createCriteria();
        if (Tools.isNotEmpty(form.getMilkName())) {
            criteria.andMilkNameLike("%" + form.getMilkName() + "%");
        }
        PageHelper.startPage(form.getCurrentPage(), form.getPageSize());
        List<TMilkMenu> milkMenuList = tMilkMenuMapper.selectByExample(example);
        PageInfo<TMilkMenu> pageInfo = new PageInfo<>(milkMenuList);
        Result<PageInfo<TMilkMenu>> result = new Result<>();
        result.setPage(pageInfo);
        return result;
    }
}
