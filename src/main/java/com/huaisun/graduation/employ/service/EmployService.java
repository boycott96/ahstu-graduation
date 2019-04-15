package com.huaisun.graduation.employ.service;

import com.github.pagehelper.PageInfo;
import com.huaisun.graduation.auto.dao.TEmploy;
import com.huaisun.graduation.employ.form.EmployForm;
import com.huaisun.graduation.util.Result;

/**
 * @author huaisun
 * @date 2019/2/22 19:01
 */
public interface EmployService {

    /**
     * 登陆用户
     *
     * @param form form表单
     * @return Result
     */
    Result login(EmployForm form);

    /**
     * 根据email，手机号码，姓名，进行查询员工
     *
     * @param form form表单信息
     * @return 查询结果
     */
    Result<PageInfo<TEmploy>> searchEmploy(EmployForm form);

    /**
     * 注册和更新员工账号
     * @param form 表单信息
     * @return Result
     */
    Result saveOrUpdateEmploy(EmployForm form);

    /**
     * 删除员工
     * @param form 表单信息
     * @return Result
     */
    Result deleteEmploy(EmployForm form);
}
