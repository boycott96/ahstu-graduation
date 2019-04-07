package com.huaisun.graduation.controller;

import com.huaisun.graduation.constants.ResultCode;
import com.huaisun.graduation.form.EmployForm;
import com.huaisun.graduation.service.EmployService;
import com.huaisun.graduation.util.Result;
import com.huaisun.graduation.util.Tools;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author huaisun
 * @date 2019/2/23 13:36
 */
@Api(description = "员工管理", tags = "EmployManagement")
@RestController
@RequestMapping(value = "/sun/employ")
public class EmployController {

    @Resource
    private EmployService service;

    @ApiOperation(value = "员工管理[员工登陆]")
    @PostMapping("/login")
    public Result login(@RequestBody EmployForm form, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Result result = service.searchEmploy(form);
        session.setAttribute("employ", result.getData());
        result.setData(null);
        return result;
    }

    @ApiOperation(value = "员工管理[员工注册]")
    @PostMapping("/save_update")
    public Result sign(EmployForm form) {
        return service.saveOrUpdate(form);
    }

    @ApiOperation(value = "员工[检查员工是否登陆]")
    @GetMapping("/check_login")
    public Result checkLogin(HttpServletRequest request) {

        Result result = new Result();

        HttpSession session = request.getSession();

        Object object = session.getAttribute("employ");
        if (Tools.isEmpty(object)) {
            result.setResultCode(ResultCode.EMPLOY_NOT_LOGGED_IN);
        } else {
            result.setResultCode(ResultCode.SUCCESS);
            result.setData(object);
        }
        return result;
    }
}
