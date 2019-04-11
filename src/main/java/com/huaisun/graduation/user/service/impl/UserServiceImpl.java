package com.huaisun.graduation.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huaisun.graduation.auto.dao.TUser;
import com.huaisun.graduation.auto.dao.TUserExample;
import com.huaisun.graduation.auto.dao.TUserKey;
import com.huaisun.graduation.auto.mapper.TUserMapper;
import com.huaisun.graduation.constants.ResultCode;
import com.huaisun.graduation.user.form.UserForm;
import com.huaisun.graduation.user.service.UserService;
import com.huaisun.graduation.util.Result;
import com.huaisun.graduation.util.TimeUtil;
import com.huaisun.graduation.util.Tools;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
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
    public Result<PageInfo<TUser>> searchUser(UserForm form) {
        Result<PageInfo<TUser>> result = new Result<>();
        TUserExample example = new TUserExample();
        PageHelper.startPage(form.getCurrentPage(), form.getPageSize());

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

        List<TUser> userList = userMapper.selectByExample(example);

        PageInfo<TUser> pageInfo = new PageInfo<>(userList);
        result.setPage(pageInfo);
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

        return Result.success(100.0 * (userCountOne - userCountLast) / (userCountLast == 0 ? 1 : userCountLast));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result saveOrUpdateUser(UserForm form) {
        Result result = new Result();
        if (Tools.isEmpty(form)) {
            result.setResultCode(ResultCode.PARAM_IS_BLANK);
            return result;
        }
        TUser user = new TUser();

        if (Tools.isEmpty(form.getId())) {

            user.setName(form.getName());
            user.setEmail(form.getEmail());
            user.setPhone(form.getPhone());
            user.setCreateDate(new Date());
            user.setIntegral(new BigDecimal(0));
            user.setBalance(new BigDecimal(0));
            user.setCost(new BigDecimal(0));

            int num = userMapper.insert(user);
            if (num < 1) {
                result.setResultCode(ResultCode.USER_SAVE_ERROR);
            } else {
                result.setResultCode(ResultCode.SUCCESS);
            }
        } else {
            user.setId(form.getId());
            TUser user1 = userMapper.selectByPrimaryKey(user);

            if (Tools.isEmpty(user1)) {
                result.setResultCode(ResultCode.PARAM_IS_INVALID);
            } else {
                if (Tools.isNotEmpty(form.getName())) {
                    user1.setName(form.getName());
                }

                if (Tools.isNotEmpty(form.getEmail())) {
                    user1.setEmail(form.getEmail());
                }

                if (Tools.isNotEmpty(form.getPhone())) {
                    user1.setPhone(form.getPhone());
                }

                int num = userMapper.updateByPrimaryKey(user1);

                if (num == 1) {
                    result.setResultCode(ResultCode.SUCCESS);
                } else {
                    result.setResultCode(ResultCode.USER_UPDATE_ERROR);
                }
            }
        }
        return result;
    }

    @Override
    public Result getUser(UserForm form) {
        if (Tools.isEmpty(form) || Tools.isEmpty(form.getId())) {
            return Result.failure(ResultCode.PARAM_IS_BLANK);
        }

        TUserKey userKey = new TUserKey();
        userKey.setId(form.getId());

        TUser user = userMapper.selectByPrimaryKey(userKey);
        if (Tools.isEmpty(user)) {
            return Result.failure(ResultCode.USER_NOT_EXIST);
        }
        return Result.success(user);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result deleteUser(UserForm form) {
        if (Tools.isEmpty(form) || Tools.isEmpty(form.getId())) {
            return Result.failure(ResultCode.PARAM_IS_BLANK);
        }

        TUserKey userKey = new TUserKey();
        userKey.setId(form.getId());

        int num = userMapper.deleteByPrimaryKey(userKey);
        if (num == 1) {
            return Result.success();
        }
        return Result.failure(ResultCode.USER_NOT_EXIST);
    }
}
