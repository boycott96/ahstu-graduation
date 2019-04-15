package com.huaisun.graduation.employ.util;

import com.huaisun.graduation.auto.dao.TEmploy;
import com.huaisun.graduation.employ.form.EmployForm;
import com.huaisun.graduation.util.Tools;

public class ToEmployForm {

    /**
     * 转化实体
     *
     * @param form   表单
     * @param employ 实体
     */
    protected void toUserForm(EmployForm form, TEmploy employ) {
        if (Tools.isNotEmpty(form.getName())) {
            employ.setName(form.getName());
        }

        if (Tools.isNotEmpty(form.getPassword())) {
            employ.setPassword(form.getPassword());
        }

        if (Tools.isNotEmpty(form.getPhone())) {
            employ.setPhone(form.getPhone());
        }

        if (Tools.isNotEmpty(form.getEmail())) {
            employ.setEmail(form.getEmail());
        }

        if (Tools.isNotEmpty(form.getAddress())) {
            employ.setAddress(form.getAddress());
        }

        if (Tools.isNotEmpty(form.getValid())) {
            employ.setValid(form.getValid());
        }
    }
}
