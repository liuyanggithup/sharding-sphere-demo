package com.seventeen.response;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.seventeen.enums.CodeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Api 数据返回统一格式
 *
 * @author seventeen
 * @date 2018/11/2
 */

@ApiModel(description = "平台统一数据格式")
public class ResponseData<T> implements Serializable {

    private static final long serialVersionUID = 101L;

    @ApiModelProperty(value = "状态码")
    private Status status;
    @ApiModelProperty(value = "结果集")
    private T data;
    @ApiModelProperty(value = "服务器时间")
    private long currentTime;

    private ResponseData() {}

    private ResponseData(T data) {
        this.status = new Status(CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getValue());
        this.currentTime = System.currentTimeMillis();
        this.data = data;
    }

    private ResponseData(Integer code, String msg, T data) {
        this.status = new Status(code, msg);
        if (code == null) {
            this.status.setRetCode(CodeEnum.FAIL.getCode());
        }
        if (msg == null) {
            this.status.setMsg("");
        }

        this.data = data;
        this.currentTime = System.currentTimeMillis();
    }


    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public long getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(long currentTime) {
        this.currentTime = currentTime;
    }

    public static <T> ResponseData<T> success(T data) {
        return new ResponseData<>(data);
    }

    public static <T> ResponseData<T> success(String msg, T data) {
        return new ResponseData<>(CodeEnum.SUCCESS.getCode(), msg, data);
    }

    public static <T> ResponseData<T> fail(String msg) {
        return new ResponseData(CodeEnum.FAIL.getCode(), msg, new Object());
    }

    public static <T> ResponseData<T> fail(Integer code, String msg) {
        code = code == null ? CodeEnum.FAIL.getCode() : code;
        return new ResponseData(code, msg, new Object());
    }

    public static <T> ResponseData<T> toParamInvalidateJson() {
        return new ResponseData(
                CodeEnum.PARAM_INVALIDATE.getCode(), CodeEnum.PARAM_INVALIDATE.getValue(), new Object());
    }

    public static <T> ResponseData<T> toSystemError() {
        return new ResponseData(
                CodeEnum.ERROR.getCode(), CodeEnum.ERROR.getValue(), new Object());
    }

    public String toJson() {
        return JSON.toJSONString(this, SerializerFeature.DisableCircularReferenceDetect);
    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
