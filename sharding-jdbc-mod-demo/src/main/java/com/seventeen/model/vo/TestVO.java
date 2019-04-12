package com.seventeen.model.vo;

import com.seventeen.component.ComponentLocator;
import com.seventeen.model.bo.TestBO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 *
 * @author seventeen
 * @date 2018/11/26
 */

@Data
public class TestVO {

    @ApiModelProperty(value = "姓名")
    private String name;

    public TestVO convert(TestBO testBO) {
        if (testBO == null) {
            return null;
        }

        // 也可以自己写getter setter方法
        return ComponentLocator.getConvertor().convert(testBO, TestVO.class);
    }
}
