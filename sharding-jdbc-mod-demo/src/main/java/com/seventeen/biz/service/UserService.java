package com.seventeen.biz.service;

import com.seventeen.model.bo.UserBO;

import java.util.List;

/**
 * @author: seventeen
 * @Date: 2019/4/8
 * @description:
 */
public interface UserService {

    /**
     * 读从库
     *
     * @return
     */
    List<UserBO> list();

    /**
     * 强制读主库
     *
     * @return
     */
    List<UserBO> users();

    /**
     * 测试重试读主
     *
     * @param id
     * @return
     */
    UserBO getById(Long id);

    /**
     * 不会重试读主
     *
     * @param id
     * @return
     */
    UserBO findById(Long id);

    /**
     * 新增方法
     *
     * @param user
     * @return
     */
    Long add(UserBO user);
}
