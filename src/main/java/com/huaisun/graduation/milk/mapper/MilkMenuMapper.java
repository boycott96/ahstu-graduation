package com.huaisun.graduation.milk.mapper;

import com.huaisun.graduation.auto.dao.TMilkMenu;
import com.huaisun.graduation.milk.form.MilkMenuForm;

import java.util.List;

public interface MilkMenuMapper {
    List<TMilkMenu> queryMilkMenu(MilkMenuForm form);
}
