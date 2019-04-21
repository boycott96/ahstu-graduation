package com.huaisun.graduation.user.service;

import com.huaisun.graduation.user.form.UserForm;
import com.huaisun.graduation.util.Result;

/**
 * @author huaisun
 * @date 2019/2/25 15:53
 */
public interface UserService {


    /**
     * 根据form条件查询user表
     *
     * @param form form条件
     * @return Result
     */
    Result searchUser(UserForm form);

    /**
     * 新增或更新用户
     *
     * @param form form表单
     * @return Result
     */
    Result saveOrUpdateUser(UserForm form);

    /**
     * 根据id 删除用户
     *
     * @param form 表单
     * @return Result
     */
    Result deleteUser(UserForm form);

    /**
     * 获取用户信息
     *
     * @return
     */
    Result getUser();
}
