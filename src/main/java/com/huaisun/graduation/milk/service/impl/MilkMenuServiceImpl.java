package com.huaisun.graduation.milk.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huaisun.graduation.auto.dao.TMilkMenu;
import com.huaisun.graduation.auto.dao.TMilkMenuExample;
import com.huaisun.graduation.auto.dao.TMilkMenuKey;
import com.huaisun.graduation.auto.mapper.TMilkMenuMapper;
import com.huaisun.graduation.constants.ResultCode;
import com.huaisun.graduation.milk.form.MilkMenuForm;
import com.huaisun.graduation.milk.mapper.MilkMenuMapper;
import com.huaisun.graduation.milk.service.MilkMenuService;
import com.huaisun.graduation.milk.util.ToMilkMenuForm;
import com.huaisun.graduation.util.Result;
import com.huaisun.graduation.util.Tools;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author sunruiguang
 * @date 2019/3/19
 * Updated by sunruiguang on 2019/3/19.
 */
@Service
public class MilkMenuServiceImpl extends ToMilkMenuForm implements MilkMenuService {


    @Resource
    private MilkMenuMapper milkMenuMapper;

    @Resource
    private TMilkMenuMapper tMilkMenuMapper;

    @Override
    public Result getMilkMenu() {
        TMilkMenuExample example = new TMilkMenuExample();
        TMilkMenuExample.Criteria criteria = example.createCriteria();
        criteria.andShelfEqualTo(0);
        List<TMilkMenu> milkMenuList = tMilkMenuMapper.selectByExample(example);
        return Result.success(milkMenuList);
    }

    @Override
    public Result<PageInfo<TMilkMenu>> searchMilkMenu(MilkMenuForm form) {
        PageHelper.startPage(form.getCurrentPage(), form.getPageSize());
        List<TMilkMenu> milkMenuList = milkMenuMapper.queryMilkMenu(form);
        PageInfo<TMilkMenu> pageInfo = new PageInfo<>(milkMenuList);
        Result<PageInfo<TMilkMenu>> result = new Result<>();
        result.setPage(pageInfo);
        return result;
    }

    @Override
    @Transactional
    public Result saveOrUpdateMilk(MilkMenuForm form) {
        //判断form表单中传入的是新增或更新
        if (Tools.isEmpty(form.getId())) {
            //新增
            TMilkMenu tMilkMenu = new TMilkMenu();
            super.toMilkMenuForm(form, tMilkMenu);
            return tMilkMenuMapper.insert(tMilkMenu) > 0 ? Result.success() : Result.failure(ResultCode.USER_SAVE_ERROR);
        }
        //更新
        TMilkMenuKey key = new TMilkMenuKey();
        key.setId(form.getId());
        TMilkMenu tMilkMenu = tMilkMenuMapper.selectByPrimaryKey(key);
        super.toMilkMenuForm(form, tMilkMenu);
        return tMilkMenuMapper.updateByPrimaryKey(tMilkMenu) > 0 ? Result.success() : Result.failure(ResultCode.USER_UPDATE_ERROR);
    }

    @Override
    public Result deleteMilk(MilkMenuForm form) {
        if (Tools.isEmpty(form) || Tools.isEmpty(form.getId())) {
            return Result.failure(ResultCode.PARAM_IS_BLANK);
        }
        TMilkMenuKey key = new TMilkMenuKey();
        key.setId(form.getId());
        return tMilkMenuMapper.deleteByPrimaryKey(key) > 0 ? Result.success() : Result.failure(ResultCode.MILK_DELETE_ERROR);
    }
}
