package com.huaisun.graduation.service.impl;

import com.huaisun.graduation.auto.dao.TMilkMenu;
import com.huaisun.graduation.auto.dao.TMilkMenuExample;
import com.huaisun.graduation.auto.dao.TMilkMenuKey;
import com.huaisun.graduation.auto.mapper.TMilkMenuMapper;
import com.huaisun.graduation.constants.ResultCode;
import com.huaisun.graduation.form.MilkMenuForm;
import com.huaisun.graduation.service.MilkMenuService;
import com.huaisun.graduation.util.Result;
import com.huaisun.graduation.util.Tools;
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

    @Override
    public Result getMilk(MilkMenuForm form) {

        if (Tools.isEmpty(form)) {
            return Result.failure(ResultCode.PARAM_IS_BLANK);
        }

        TMilkMenuKey tMilkMenuKey = new TMilkMenuKey();
        tMilkMenuKey.setId(form.getId());

        TMilkMenu tMilkMenu = tMilkMenuMapper.selectByPrimaryKey(tMilkMenuKey);
        return Result.success(tMilkMenu);
    }

    @Override
    public Result saveOrUpdate(MilkMenuForm form) {

        if (Tools.isEmpty(form)) {
            return Result.failure(ResultCode.PARAM_IS_BLANK);
        }

        if (Tools.isEmpty(form.getId())) {
            //新增
            TMilkMenu tMilkMenu = new TMilkMenu();
            tMilkMenu.setMilkName(form.getMilkName());
            tMilkMenu.setMilkPrice(form.getMilkPrice());
            tMilkMenu.setMilkAddress(form.getMilkAddress());
            tMilkMenu.setIsShelf(0);
            tMilkMenuMapper.insert(tMilkMenu);
        } else {
            //更新
            TMilkMenuKey tMilkMenuKey = new TMilkMenuKey();
            tMilkMenuKey.setId(form.getId());

            TMilkMenu tMilkMenu = tMilkMenuMapper.selectByPrimaryKey(tMilkMenuKey);
            if (Tools.isEmpty(tMilkMenu)) {
                return Result.failure(ResultCode.DATA_IS_WRONG);
            }

            if (Tools.isNotEmpty(form.getMilkName())) {
                tMilkMenu.setMilkName(form.getMilkName());
            }

            if (Tools.isNotEmpty(form.getMilkPrice())) {
                tMilkMenu.setMilkPrice(form.getMilkPrice());
            }

            if (Tools.isNotEmpty(form.getMilkAddress())) {
                tMilkMenu.setMilkAddress(form.getMilkAddress());
            }

            if (Tools.isNotEmpty(form.getIsShelf())) {
                tMilkMenu.setIsShelf(form.getIsShelf());
            }

            tMilkMenuMapper.updateByPrimaryKey(tMilkMenu);
        }
        return Result.success();
    }
}
