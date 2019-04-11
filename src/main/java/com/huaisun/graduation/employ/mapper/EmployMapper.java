package com.huaisun.graduation.employ.mapper;

import com.huaisun.graduation.auto.dao.TEmploy;
import com.huaisun.graduation.employ.form.EmployForm;

import java.util.List;

/**
 * @author huaisun
 * @date 2019/4/11 12:57
 */
public interface EmployMapper {

    /**
     * 查询员工
     *
     * @param form 查询条件表单
     * @return List
     */
    List<TEmploy> searchEmploy(EmployForm form);
}
