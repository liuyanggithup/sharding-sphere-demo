package com.seventeen.biz.facade;

import com.seventeen.model.vo.TestVO;

/**
 * @author seventeen
 * @date 2018/11/26
 */
public interface TestFacade {

    /**
     * 根据主键查询
     */
    TestVO getById(Long id);
}
