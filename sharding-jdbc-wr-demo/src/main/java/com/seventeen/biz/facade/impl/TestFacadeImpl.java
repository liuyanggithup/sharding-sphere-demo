package com.seventeen.biz.facade.impl;

import com.seventeen.biz.facade.TestFacade;
import com.seventeen.biz.service.TestService;
import com.seventeen.component.ComponentLocator;
import com.seventeen.model.bo.TestBO;
import com.seventeen.model.vo.TestVO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author seventeen
 * @date 2018/11/26
 */

@Component(value = "testFacade")
public class TestFacadeImpl implements TestFacade {

    @Resource
    private TestService testService;

    @Override
    public TestVO getById(Long id) {
        TestBO bo = testService.getById(id);
        return ComponentLocator.getConvertor().convert(bo, TestVO.class);
    }
}
