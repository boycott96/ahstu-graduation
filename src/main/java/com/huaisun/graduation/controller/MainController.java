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

    @GetMapping("/index")
    @ApiOperation(value = "页面[登陆注册页]")
    public String index() {
        return "index";
    }

    @GetMapping("/home")
    @ApiOperation(value = "页面[导航页]")
    public String home() {
        return "home";
    }

    @GetMapping("/show")
    @ApiOperation(value = "页面[主页]")
    public String show() {
        return "show";
    }
}
