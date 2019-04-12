package com.seventeen.biz.service.impl;

import com.seventeen.biz.dao.TestDAO;
import com.seventeen.biz.service.TestService;
import com.seventeen.component.ComponentLocator;
import com.seventeen.model.bo.TestBO;
import com.seventeen.model.entity.TestDO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author seventeen
 * @date 2018/11/14
 */

@Service(value = "testService")
public class TestServiceImpl implements TestService {

    @Resource
    private TestDAO testDAO;

    @Override
    public TestBO getById(Long id) {
        TestDO po = testDAO.selectById(id);
        return ComponentLocator.getConvertor().convert(po, TestBO.class);
    }
}
