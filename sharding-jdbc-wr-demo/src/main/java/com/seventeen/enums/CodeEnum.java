package com.seventeen.enums;

/**
 * Api 状态码
 * @author seventeen
 * @date 2018/11/2
 */

public enum CodeEnum {

    SUCCESS(0, "成功"),
    FAIL(1, "失败"),
    PARAM_INVALIDATE(2, "不合法参数"),

    ERROR(9999, "系统异常");

    private Integer code;
    private String value;
    CodeEnum(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
