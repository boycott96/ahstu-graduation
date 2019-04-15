package com.huaisun.graduation.milk.service;

import com.github.pagehelper.PageInfo;
import com.huaisun.graduation.auto.dao.TMilkMenu;
import com.huaisun.graduation.milk.form.MilkMenuForm;
import com.huaisun.graduation.util.Result;

/**
 * @author sunruiguang
 * @date 2019/3/19
 * Updated by sunruiguang on 2019/3/19.
 */
public interface MilkMenuService {

    /**
     * 获取奶茶列表
     *
     * @return Result
     */
    Result getMilkMenu();

    /**
     * 查询上架奶茶菜单
     *
     * @param from 表单信息
     * @return Result
     */
    Result<PageInfo<TMilkMenu>> searchMilkMenu(MilkMenuForm from);

    /**
     * 修改奶茶菜单
     *
     * @param form 表单信息
     * @return Result
     */
    Result saveOrUpdateMilk(MilkMenuForm form);
}
