package com.seventeen.exception;

import com.seventeen.enums.CodeEnum;

/**
 * 业务异常
 * @author seventeen
 * @date 2018/11/5
 */

public class BizException extends RuntimeException {

    private Integer code;

    private String msg;

    public BizException() {

    }

    public BizException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public BizException(Integer code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public static BizException systemError() {
        return new BizException(CodeEnum.ERROR.getCode(), CodeEnum.ERROR.getValue());
    }

    public static BizException illegalArgument() {
        return new BizException(CodeEnum.PARAM_INVALIDATE.getCode(), CodeEnum.PARAM_INVALIDATE.getValue());
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
