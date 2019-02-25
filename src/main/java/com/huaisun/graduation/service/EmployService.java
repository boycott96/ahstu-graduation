package com.huaisun.graduation.service;

import com.huaisun.graduation.form.EmployForm;
import com.huaisun.graduation.util.Result;

/**
 * @author huaisun
 * @date 2019/2/22 19:01
 */
public interface EmployService {

    /**
     * 根据email，手机号码，姓名，进行查询员工
     *
     * @param form form表单信息
     * @return 查询结果
     */
    Result searchEmploy(EmployForm form);

    /**
     * 注册或更新员工信息
     *
     * @param form form 表单信息
     * @return 插入或更新结果
     */
    Result saveOrUpdate(EmployForm form);
}
