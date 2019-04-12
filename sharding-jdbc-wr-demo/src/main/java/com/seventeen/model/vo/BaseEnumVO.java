package com.seventeen.model.vo;

import lombok.Data;

/**
 * 枚举对象统一返回
 * @author seventeen
 * @date 2018/11/5
 */

@Data
public class BaseEnumVO {

    private Integer code;

    private String value;

    public BaseEnumVO(Integer code, String value) {
        this.code = code;
        this.value = value;
    }
}
