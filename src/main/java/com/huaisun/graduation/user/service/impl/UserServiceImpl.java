package com.huaisun.graduation.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huaisun.graduation.auto.dao.TUser;
import com.huaisun.graduation.auto.dao.TUserExample;
import com.huaisun.graduation.auto.dao.TUserKey;
import com.huaisun.graduation.auto.mapper.TUserMapper;
import com.huaisun.graduation.constants.ResultCode;
import com.huaisun.graduation.user.entity.UserSelectEntity;
import com.huaisun.graduation.user.form.UserForm;
import com.huaisun.graduation.user.mapper.UserMapper;
import com.huaisun.graduation.user.service.UserService;
import com.huaisun.graduation.user.util.ToUserForm;
import com.huaisun.graduation.util.Result;
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
public class UserServiceImpl extends ToUserForm implements UserService {

    @Resource
    private TUserMapper tUserMapper;

    @Resource
    private UserMapper userMapper;

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

        List<TUser> userList = tUserMapper.selectByExample(example);

        PageInfo<TUser> pageInfo = new PageInfo<>(userList);
        result.setPage(pageInfo);
        return result;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result saveOrUpdateUser(UserForm form) {
        if (Tools.isEmpty(form)) {
            return Result.failure(ResultCode.PARAM_IS_BLANK);
        }

        if (Tools.isEmpty(form.getId())) {
            TUser user = new TUser();
            //新增
            super.toUserForm(form, user);
            user.setCreateDate(new Date());
            user.setIntegral(new BigDecimal(0));
            user.setBalance(new BigDecimal(0));
            user.setCost(new BigDecimal(0));
            return tUserMapper.insert(user) > 0 ? Result.success() : Result.failure(ResultCode.USER_SAVE_ERROR);
        }
        TUserKey key = new TUserKey();
        key.setId(form.getId());
        TUser user = tUserMapper.selectByPrimaryKey(key);
        if (Tools.isEmpty(user)) {
            return Result.failure(ResultCode.PARAM_IS_BLANK);
        } else {
            super.toUserForm(form, user);
            if (Tools.isNotEmpty(form.getBalance())) {
                user.setBalance(form.getBalance());
            }
            if (Tools.isNotEmpty(form.getCost())) {
                user.setCost(form.getCost());
            }
            if (Tools.isNotEmpty(form.getIntegral())) {
                user.setIntegral(form.getIntegral());
            }

        }
        return tUserMapper.updateByPrimaryKey(user) > 0 ? Result.success() : Result.failure(ResultCode.USER_UPDATE_ERROR);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result deleteUser(UserForm form) {
        if (Tools.isEmpty(form) || Tools.isEmpty(form.getId())) {
            return Result.failure(ResultCode.PARAM_IS_BLANK);
        }
        TUserKey userKey = new TUserKey();
        userKey.setId(form.getId());
        return tUserMapper.deleteByPrimaryKey(userKey) > 0 ? Result.success() : Result.failure(ResultCode.USER_DELETE_ERROR);
    }

    @Override
    public Result getUser() {
        List<UserSelectEntity> entities = userMapper.querySelectUser();
        return Result.success(entities);
    }
}
