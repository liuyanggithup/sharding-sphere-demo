package com.seventeen.biz.manager.impl;

import com.seventeen.biz.manager.DemoManager;
import com.seventeen.model.bo.DemoBO;
import org.springframework.stereotype.Component;

/**
 * 第三方调用demo
 * @author seventeen
 * @date 2018/11/16
 */

@Component(value = "demoManager")
public class DemoManagerImpl implements DemoManager {

//    @Resource
//    private DemoRest demoRest;

    @Override
    public DemoBO getByCompany(Long companyId) {
//        String result = demoRest.getByCompany(companyId);
        return  null;

//        return ComponentLocator.getConvertor().parseResponse(result, DemoBO.class).getData();
    }
}
