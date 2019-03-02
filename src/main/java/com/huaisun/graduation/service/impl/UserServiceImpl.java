package com.huaisun.graduation.service.impl;

import com.huaisun.graduation.auto.dao.TUser;
import com.huaisun.graduation.auto.dao.TUserExample;
import com.huaisun.graduation.auto.mapper.TUserMapper;
import com.huaisun.graduation.constants.ResultCode;
import com.huaisun.graduation.constants.VarConstants;
import com.huaisun.graduation.form.UserForm;
import com.huaisun.graduation.service.UserService;
import com.huaisun.graduation.util.Result;
import com.huaisun.graduation.util.TimeUtil;
import com.huaisun.graduation.util.Tools;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author huaisun
 * @date 2019/2/25 15:54
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    @Resource
    private TUserMapper userMapper;

    @Override
    public Result searchUser(UserForm form) {

        TUserExample example = new TUserExample();
        TUserExample.Criteria criteria = example.createCriteria();

        if (Tools.isNotEmpty(form.getName())) {
            TUserExample.Criteria criteria1 = example.createCriteria();
            criteria1.andNameLike("%" + form.getName() + "%");
            example.or(criteria1);
        }

        if (Tools.isNotEmpty(form.getEmail())) {
            TUserExample.Criteria criteria2 = example.createCriteria();
            criteria2.andEmailLike("%" + form.getEmail() + "%");
            example.or(criteria2);
        }

        if (Tools.isNotEmpty(form.getPhone())) {
            TUserExample.Criteria criteria3 = example.createCriteria();
            criteria3.andPhoneLike("%" + form.getPhone() + "%");
            example.or(criteria3);
        }

        if (form.getIsDate().equals(VarConstants.START)) {
            criteria.andCreateDateBetween(TimeUtil.getNowWeekStart(), new Date());
        }

        List<TUser> userList = userMapper.selectByExample(example);

        return Result.success(userList);
    }

    @Override
    public Result getUserIncrease() {

        TUserExample example = new TUserExample();
        TUserExample.Criteria criteria = example.createCriteria();

        criteria.andCreateDateBetween(TimeUtil.getLastWeekStart(), TimeUtil.getLastWeekEnd());

        Long userCountLast = userMapper.countByExample(example);

        TUserExample example1 = new TUserExample();
        TUserExample.Criteria criteria1 = example1.createCriteria();

        criteria1.andCreateDateBetween(TimeUtil.getNowWeekStart(), new Date());

        Long userCountOne = userMapper.countByExample(example1);

        return Result.success(100.0 * (userCountOne - userCountLast) / (userCountLast == 0 ? 1 : userCountLast));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result addUser(UserForm form) {
        Result result = new Result();
        if (Tools.isEmpty(form) || Tools.isEmpty(form.getName()) || Tools.isEmpty(form.getPhone())) {
            result.setResultCode(ResultCode.USER_SAVE_ERROR);
            return result;
        }

        TUser user = new TUser();
        user.setName(form.getName());
        user.setEmail(form.getEmail());
        user.setPhone(form.getPhone());
        user.setCreateDate(new Date());
        user.setIntegral(0);
        user.setBalance(0f);
        user.setCost(0f);

        int num = userMapper.insert(user);
        if (num < 1) {
            result.setResultCode(ResultCode.USER_SAVE_ERROR);
        } else {
            result.setResultCode(ResultCode.SUCCESS);
        }
        return result;
    }
}
