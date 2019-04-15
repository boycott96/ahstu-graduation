package com.huaisun.graduation.user.util;

import com.huaisun.graduation.auto.dao.TUser;
import com.huaisun.graduation.user.form.UserForm;
import com.huaisun.graduation.util.Tools;

public class ToUserForm {

    /**
     * 转化实体
     * @param form 表单
     * @param user 实体
     */
    protected void toUserForm(UserForm form, TUser user) {
        if (Tools.isNotEmpty(form.getName())) {
            user.setName(form.getName());
        }

        if (Tools.isNotEmpty(form.getEmail())) {
            user.setEmail(form.getEmail());
        }

        if (Tools.isNotEmpty(form.getPhone())) {
            user.setPhone(form.getPhone());
        }
    }
}
