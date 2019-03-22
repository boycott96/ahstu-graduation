package com.huaisun.graduation.service;

import com.huaisun.graduation.form.MilkMenuForm;
import com.huaisun.graduation.util.Result;

/**
 * @author sunruiguang
 * @date 2019/3/19
 * Updated by sunruiguang on 2019/3/19.
 */
public interface MilkMenuService {

    /**
     * 查询上架奶茶菜单
     *
     * @return Result
     * @param from
     */
    Result searchMilkMenu(MilkMenuForm from);

    /**
     * 根据id查询奶茶详情
     *
     * @param form form表单
     * @return Result
     */
    Result getMilk(MilkMenuForm form);

    /**
     * 根据id 进行更新用户或新增用户
     *
     * @param form form表单
     * @return Rsult
     */
    Result saveOrUpdate(MilkMenuForm form);
}
