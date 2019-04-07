package com.huaisun.graduation.controller;

import com.huaisun.graduation.form.MilkMenuForm;
import com.huaisun.graduation.service.MilkMenuService;
import com.huaisun.graduation.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @ApiOperation(value = "奶茶菜单[查询奶茶菜单]")
    @GetMapping("/searchMilkMenu")
    public Result searchMilkMenu(MilkMenuForm from) {
        return milkMenuService.searchMilkMenu(from);
    }

    @ApiOperation(value = "奶茶菜单[根据id获取对应的奶茶详情]")
    @GetMapping("/getMilk")
    public Result getMilk(MilkMenuForm form) {
        return milkMenuService.getMilk(form);
    }

    @ApiOperation(value = "奶茶菜单[更新或新增]")
    @PostMapping("/save_update")
    public Result saveOrUpdate(MilkMenuForm form) {
        return milkMenuService.saveOrUpdate(form);
    }

}
