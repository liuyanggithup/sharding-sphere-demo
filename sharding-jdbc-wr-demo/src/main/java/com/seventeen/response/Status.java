package com.seventeen.response;

import io.swagger.annotations.ApiModelProperty;

/**
 * Api 数据返回统一格式
 * @author seventeen
 * @date 2018/11/2
 */

public class Status {

    @ApiModelProperty(value = "业务状态码")
    private Integer retCode;
    @ApiModelProperty(value = "业务状态信息")
    private String msg;

    public Status() {}

    public Status(Integer retCode, String msg) {
        this.retCode = retCode;
        this.msg = msg;
    }

    public Integer getRetCode() {
        return retCode;
    }

    public void setRetCode(Integer retCode) {
        this.retCode = retCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
