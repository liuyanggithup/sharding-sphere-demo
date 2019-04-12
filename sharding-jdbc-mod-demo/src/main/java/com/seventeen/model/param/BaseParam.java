package com.seventeen.model.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 基础参数
 * @author seventeen
 * @date 2018/11/5
 */

@Data
public class BaseParam {

    @ApiModelProperty(value = "时间戳")
    private String timestamp;
}
