package com.huaisun.graduation.employ.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huaisun.graduation.auto.dao.TEmploy;
import com.huaisun.graduation.auto.dao.TEmployExample;
import com.huaisun.graduation.auto.dao.TEmployKey;
import com.huaisun.graduation.auto.mapper.TEmployMapper;
import com.huaisun.graduation.constants.ResultCode;
import com.huaisun.graduation.constants.VarConstants;
import com.huaisun.graduation.employ.form.EmployForm;
import com.huaisun.graduation.employ.mapper.EmployMapper;
import com.huaisun.graduation.employ.service.EmployService;
import com.huaisun.graduation.util.Result;
import com.huaisun.graduation.util.Tools;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author huaisun
 * @date 2019/2/22 19:04
 */
@Service
public class EmployServiceImpl implements EmployService {

    @Resource
    private EmployMapper employMapper;

    @Override
    public Result login(EmployForm form) {
        return null;
    }

    @Override
    public Result<PageInfo<TEmploy>> searchEmploy(EmployForm form) {

        Result<PageInfo<TEmploy>> result = new Result<>();
        PageHelper.startPage(form.getCurrentPage(), form.getPageSize());
        List<TEmploy> tEmploys = employMapper.searchEmploy(form);
        result.setPage(new PageInfo<>(tEmploys));
        return result;
    }
}
