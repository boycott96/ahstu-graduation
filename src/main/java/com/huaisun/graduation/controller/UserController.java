package com.huaisun.graduation.controller;

import com.huaisun.graduation.form.UserForm;
import com.huaisun.graduation.service.UserService;
import com.huaisun.graduation.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author huaisun
 * @date 2019/2/25 15:29
 */

@Api(description = "用户管理", tags = "UserManagement")
@RestController
@RequestMapping("/sun/user")
public class UserController {

    @Resource
    private UserService service;

    @ApiOperation(value = "用户[查询用户]")
    @PostMapping("/searchUser")
    public Result searchUser(UserForm form) {
        return service.searchUser(form);
    }

    @ApiOperation(value = "用户[计算星期用户的增长率]")
    @PostMapping("/getUserIncrease")
    public Result getUserIncrease() {
        return service.getUserIncrease();
    }
}
