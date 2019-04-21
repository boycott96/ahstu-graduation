package com.huaisun.graduation.user.mapper;

import com.huaisun.graduation.user.entity.UserSelectEntity;

import java.util.List;

public interface UserMapper {

    /**
     * 查询用户下拉框
     *
     * @return 集合
     */
    List<UserSelectEntity> querySelectUser();
}
