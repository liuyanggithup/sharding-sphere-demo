package com.seventeen.biz.dao;

import com.seventeen.model.entity.UserDO;

import java.util.List;

/**
 * @author: seventeen
 * @Date: 2019/4/8
 * @description:
 */
public interface UserDAO {

    Long addUser(UserDO user);

    UserDO getById(Long id);

    UserDO findById(Long id);

    List<UserDO> list();

}
