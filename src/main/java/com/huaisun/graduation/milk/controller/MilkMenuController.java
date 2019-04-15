package com.huaisun.graduation.milk.controller;

import com.github.pagehelper.PageInfo;
import com.huaisun.graduation.auto.dao.TMilkMenu;
import com.huaisun.graduation.milk.form.MilkMenuForm;
import com.huaisun.graduation.milk.service.MilkMenuService;
import com.huaisun.graduation.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author sunruiguang
 * @date 2019/3/19
 * Updated by sunruiguang on 2019/3/19.
 */
@Api(description = "奶茶菜单管理", tags = "MilkMenuManagement")
@RestController
@RequestMapping("/sun/milk")
public class MilkMenuController {

    @Resource
    private MilkMenuService milkMenuService;

    @ApiOperation(value = "奶茶菜单[获取奶茶列表")
    @GetMapping("/getMilkMenu")
    public Result getMilkMenu() {
        return milkMenuService.getMilkMenu();
    }

    @ApiOperation(value = "奶茶菜单[查询奶茶菜单]")
    @GetMapping("/searchMilkMenu")
    public Result<PageInfo<TMilkMenu>> searchMilkMenu(MilkMenuForm form) {
        return milkMenuService.searchMilkMenu(form);
    }

    @ApiOperation(value = "奶茶菜单[修改奶茶菜单]")
    @PostMapping("/saveOrUpdateMilk")
    public Result saveOrUpdateMilk(MilkMenuForm form) {
        return milkMenuService.saveOrUpdateMilk(form);
    }

    @ApiOperation(value = "奶茶菜单[删除奶茶]")
    @DeleteMapping("/deleteMilk")
    public Result deleteMilk(MilkMenuForm form) {
        return milkMenuService.deleteMilk(form);
    }
}
