package com.huaisun.graduation.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author huaisun
 * @date 2019/2/19 12:13
 */

@Api(description = "页面管理", tags = "MainManagement")
@Controller
public class MainController {

    @ApiOperation(value = "页面[登陆注册页]")
    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @ApiOperation(value = "页面[导航页]")
    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @ApiOperation(value = "页面[主页]")
    @GetMapping("/show")
    public String show() {
        return "show";
    }

    @ApiOperation(value = "页面[用户管理]")
    @GetMapping("/user")
    public String user() {
        return "user";
    }
}
