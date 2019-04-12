package com.seventeen.biz.dao;

import com.seventeen.model.entity.TestDO;

/**
 * 测试类数据访问层
 * @author seventeen
 * @date 2018/11/14
 */
public interface TestDAO {

    /**
     * 根据ID查询
     */
    TestDO selectById(Long id);
}
