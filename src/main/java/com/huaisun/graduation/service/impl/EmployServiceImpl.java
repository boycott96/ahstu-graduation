package com.huaisun.graduation.service.impl;

import com.huaisun.graduation.auto.dao.TEmploy;
import com.huaisun.graduation.auto.dao.TEmployExample;
import com.huaisun.graduation.auto.dao.TEmployKey;
import com.huaisun.graduation.auto.mapper.TEmployMapper;
import com.huaisun.graduation.constants.ResultCode;
import com.huaisun.graduation.constants.VarConstants;
import com.huaisun.graduation.form.EmployForm;
import com.huaisun.graduation.service.EmployService;
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
    private TEmployMapper tEmployMapper;

    @Override
    public Result searchEmploy(EmployForm form) {

        Result result = new Result();

        TEmployExample example = new TEmployExample();
        TEmployExample.Criteria criteria = example.createCriteria();

        if (!Tools.isEmpty(form.getEmail())) {
            criteria.andEmailEqualTo(form.getEmail());
        }

        if (!Tools.isEmpty(form.getPhone())) {
            criteria.andPhoneEqualTo(form.getPhone());
        }

        if (!Tools.isEmpty(form.getName())) {
            criteria.andNameEqualTo(form.getName());
        }

        List<TEmploy> tEmployList = tEmployMapper.selectByExample(example);
        if (tEmployList.size() == 1 && tEmployList.get(0).getPassword().equals(form.getPassword())) {
            result.setResultCode(ResultCode.SUCCESS);
            result.setData(tEmployList.get(0));
        } else {
            result.setResultCode(ResultCode.EMPLOY_LOGIN_ERROR);
        }
        return result;
    }

    @Override
    public Result saveOrUpdate(EmployForm form) {

        Result result = new Result();
        TEmploy employ = new TEmploy();

        if (Tools.isEmpty(form.getId())) {
            employ.setName(form.getName());
            employ.setEmail(form.getEmail());
            employ.setPhone(form.getPhone());
            employ.setPassword(form.getPassword());
            employ.setAddress(form.getAddress());
            employ.setValid(VarConstants.STOP);
            employ.setCreateDate(new Date());
            int num = tEmployMapper.insert(employ);
            if (num != 1) {
                result.setResultCode(ResultCode.EMPLOY_SAVE_ERROR);
                return result;
            }
        } else {
            TEmployKey employKey = new TEmployKey();
            employKey.setId(form.getId());
            employ = tEmployMapper.selectByPrimaryKey(employKey);

            if (Tools.isNotEmpty(form.getName())) {
                employ.setName(form.getName());
            }

            if (Tools.isNotEmpty(form.getPhone())) {
                employ.setPhone(form.getPhone());
            }

            if (Tools.isNotEmpty(form.getEmail())) {
                employ.setEmail(form.getEmail());
            }

            if (Tools.isNotEmpty(form.getAddress())) {
                employ.setPassword(form.getPassword());
            }

            if (Tools.isNotEmpty(form.getPassword())) {
                employ.setPassword(form.getPassword());
            }

            int num = tEmployMapper.updateByPrimaryKey(employ);

            if (num != 1) {
                result.setResultCode(ResultCode.EMPLOY_UPDATE_ERROR);
                return result;
            }
        }

        result = Result.success();
        return result;
    }
}
