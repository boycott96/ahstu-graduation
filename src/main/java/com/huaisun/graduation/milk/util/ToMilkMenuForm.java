package com.huaisun.graduation.milk.util;

import com.huaisun.graduation.auto.dao.TMilkMenu;
import com.huaisun.graduation.milk.form.MilkMenuForm;
import com.huaisun.graduation.util.Tools;

public class ToMilkMenuForm {

    /**
     * 将form表单转化成奶茶菜单实体
     *
     * @param form 表单信息
     * @return TMilkMenu
     */
    protected TMilkMenu toMilkMenuForm(MilkMenuForm form) {
        TMilkMenu tMilkMenu = new TMilkMenu();
        if (Tools.isNotEmpty(form.getMilkName())) {
            tMilkMenu.setMilkName(form.getMilkName());
        }
        if (Tools.isNotEmpty(form.getMilkAddress())) {
            tMilkMenu.setMilkAddress(form.getMilkAddress());
        }
        if (Tools.isNotEmpty(form.getMilkPrice())) {
            tMilkMenu.setMilkPrice(form.getMilkPrice());
        }
        return tMilkMenu;
    }
}
