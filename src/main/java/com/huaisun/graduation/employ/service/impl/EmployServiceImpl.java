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
import com.huaisun.graduation.employ.util.ToEmployForm;
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
public class EmployServiceImpl extends ToEmployForm implements EmployService {

    @Resource
    private EmployMapper employMapper;

    @Resource
    private TEmployMapper tEmployMapper;

    @Override
    public Result login(EmployForm form) {
        TEmployExample example = new TEmployExample();
        TEmployExample.Criteria criteria = example.createCriteria();
        criteria.andValidEqualTo(1);
        criteria.andNameEqualTo(form.getName());
        List<TEmploy> employs = tEmployMapper.selectByExample(example);
        return employs.size() > 0 && employs.get(0).getPassword().equals(form.getPassword()) ? Result.success(employs) : Result.failure(ResultCode.EMPLOY_LOGIN_ERROR);
    }

    @Override
    public Result<PageInfo<TEmploy>> searchEmploy(EmployForm form) {

        Result<PageInfo<TEmploy>> result = new Result<>();
        PageHelper.startPage(form.getCurrentPage(), form.getPageSize());
        List<TEmploy> tEmploys = employMapper.searchEmploy(form);
        result.setPage(new PageInfo<>(tEmploys));
        return result;
    }

    @Override
    public Result saveOrUpdateEmploy(EmployForm form) {
        if (Tools.isEmpty(form)) {
            return Result.failure(ResultCode.PARAM_IS_BLANK);
        }

        if (Tools.isEmpty(form.getId())) {
            //新增
            TEmploy employ = new TEmploy();
            super.toUserForm(form, employ);
            employ.setCreateDate(new Date());
            return tEmployMapper.insert(employ) > 0 ? Result.success() : Result.failure(ResultCode.EMPLOY_SAVE_ERROR);
        }
        TEmployKey key = new TEmployKey();
        key.setId(form.getId());
        TEmploy employ = tEmployMapper.selectByPrimaryKey(key);
        super.toUserForm(form, employ);
        return tEmployMapper.updateByPrimaryKey(employ) > 0 ? Result.success() : Result.failure(ResultCode.EMPLOY_UPDATE_ERROR);
    }

    @Override
    public Result deleteEmploy(EmployForm form) {
        if (Tools.isEmpty(form) || Tools.isEmpty(form.getId())) {
            return Result.failure(ResultCode.PARAM_IS_BLANK);
        }
        TEmployKey key = new TEmployKey();
        key.setId(form.getId());
        return tEmployMapper.deleteByPrimaryKey(key) > 0 ? Result.success() : Result.failure(ResultCode.EMPLOY_DELETE_ERROR);
    }
}
