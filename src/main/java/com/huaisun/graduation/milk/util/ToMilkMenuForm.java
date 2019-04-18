package com.huaisun.graduation.milk.util;

import com.huaisun.graduation.auto.dao.TMilkMenu;
import com.huaisun.graduation.milk.form.MilkMenuForm;
import com.huaisun.graduation.util.Tools;

public class ToMilkMenuForm {

    /**
     * 将form表单转化成奶茶菜单实体
     *
     * @param form     表单信息
     * @param milkMenu 实体
     */
    protected void toMilkMenuForm(MilkMenuForm form, TMilkMenu milkMenu) {
        if (Tools.isNotEmpty(form.getMilkName())) {
            milkMenu.setMilkName(form.getMilkName());
        }
        if (Tools.isNotEmpty(form.getMilkPhoto())) {
            milkMenu.setMilkPhoto(form.getMilkPhoto());
        }
        if (Tools.isNotEmpty(form.getMilkPrice())) {
            milkMenu.setMilkPrice(form.getMilkPrice());
        }
        if (Tools.isNotEmpty(form.getMilkDetail())) {
            milkMenu.setMilkDetail(form.getMilkDetail());
        }
        if (Tools.isNotEmpty(form.getShelf())) {
            milkMenu.setShelf(form.getShelf());
        }
    }
}
