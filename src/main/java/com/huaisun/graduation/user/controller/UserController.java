package com.huaisun.graduation.user.controller;

import com.huaisun.graduation.user.form.UserForm;
import com.huaisun.graduation.user.service.UserService;
import com.huaisun.graduation.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/searchUser")
    public Result searchUser(UserForm form) {
        return service.searchUser(form);
    }

    @ApiOperation(value = "用户[新增用户]")
    @PostMapping("/saveOrUpdateUser")
    public Result saveOrUpdateUser(@RequestBody UserForm form) {
        return service.saveOrUpdateUser(form);
    }

    @ApiOperation(value = "用户[删除用户]")
    @DeleteMapping("/deleteUser")
    public Result deleteUser(UserForm form) {
        return service.deleteUser(form);
    }
}
