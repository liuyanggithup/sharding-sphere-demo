package com.seventeen.biz.manager;

import com.seventeen.model.bo.DemoBO;

/**
 * 调用其他服务统一处理后输出
 * @author seventeen
 * @date 2018/11/16
 */

public interface DemoManager {

    DemoBO getByCompany(Long companyId);
}
