package com.huaisun.graduation.service.impl;

import com.huaisun.graduation.auto.dao.TUser;
import com.huaisun.graduation.auto.dao.TUserExample;
import com.huaisun.graduation.auto.mapper.TUserMapper;
import com.huaisun.graduation.constants.ResultCode;
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

        Result result = new Result();

        TUserExample example = new TUserExample();
        TUserExample.Criteria criteria = example.createCriteria();

        if (Tools.isNotEmpty(form.getPhone())) {
            criteria.andPhoneLike(form.getPhone());
        }

        if (Tools.isNotEmpty(form.getName())) {
            criteria.andNameLike(form.getName());
        }

        if (Tools.isNotEmpty(form.getEmail())) {
            criteria.andEmailLike(form.getEmail());
        }

        if (Tools.isNotEmpty(form.getValid())) {
            criteria.andCreateDateBetween(TimeUtil.getNowWeekStart(), new Date());
        }

        List<TUser> userList = userMapper.selectByExample(example);


        if (userList.size() < 1) {
            result.setResultCode(ResultCode.USER_NOT_EXIST);
            return result;
        }
        result = Result.success(userList);
        return result;
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

        return Result.success(100*(userCountOne - userCountLast) / (userCountLast == 0 ? 1 : userCountLast));
    }
}
