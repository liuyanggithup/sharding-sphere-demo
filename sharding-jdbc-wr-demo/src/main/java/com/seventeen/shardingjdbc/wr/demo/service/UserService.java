package com.seventeen.shardingjdbc.wr.demo.service;

import com.seventeen.shardingjdbc.wr.demo.po.User;

import java.util.List;
/**
 * @author: xia_xun @Date: 2019/4/8
 * @description:
 */
public interface UserService {

  /**
   * 读从库
   *
   * @return
   */
  List<User> list();

  /**
   * 强制读主库
   *
   * @return
   */
  List<User> users();

  /**
   * 测试重试读主
   *
   * @param id
   * @return
   */
  User getById(Long id);

  /**
   * 新增方法
   *
   * @param user
   * @return
   */
  Long add(User user);
}
