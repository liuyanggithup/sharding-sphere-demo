package com.seventeen.shardingjdbc.wr.demo.repository;

import com.seventeen.shardingjdbc.wr.demo.po.User;

import java.util.List;
/**
 * @author: xia_xun
 * @Date: 2019/4/8
 * @description:
 */
public interface UserRepository {

    Long addUser(User user);

    List<User> list();

}
