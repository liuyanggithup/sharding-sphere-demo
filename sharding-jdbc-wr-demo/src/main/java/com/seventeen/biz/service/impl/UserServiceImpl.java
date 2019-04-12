package com.seventeen.biz.service.impl;

import com.seventeen.annotation.HintMaster;
import com.seventeen.biz.dao.UserDAO;
import com.seventeen.biz.service.UserService;
import com.seventeen.component.ComponentLocator;
import com.seventeen.model.bo.UserBO;
import com.seventeen.model.entity.UserDO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: seventeen
 * @Date: 2019/4/8
 * @description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDAO userDAO;

    @Override
    public List<UserBO> list() {

        return ComponentLocator.getConvertor().convertList(userDAO.list(), UserBO.class);
    }

    @Override
    @HintMaster
    @Transactional(rollbackFor = Exception.class)
    public List<UserBO> users() {

        //测试事务
//        userDAO.list();
//        UserBO userBO = new UserBO();
//        userBO.setCity("杭州");
//        userBO.setName("水镜");
//        add(userBO);
//        int i = 1/0;
        return ComponentLocator.getConvertor().convertList(userDAO.list(), UserBO.class);
    }

    @Override
    public UserBO findById(Long id) {
        return ComponentLocator.getConvertor().convert(userDAO.findById(id), UserBO.class);
    }

    @Override
    public UserBO getById(Long id) {

        return ComponentLocator.getConvertor().convert(userDAO.getById(id), UserBO.class);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long add(UserBO userBO) {

        UserDO userDO = ComponentLocator.getConvertor().convert(userBO, UserDO.class);
        return userDAO.addUser(userDO);
    }
}
