package com.seventeen;

import com.seventeen.exception.BizException;
import com.seventeen.response.ResponseData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 程序异常统一返回
 * @author seventeen
 * @date 2018/10/26
 */

@ControllerAdvice
public class ExceptionController {

    private static final Logger log = LoggerFactory.getLogger("ERROR_LOG");

    @ExceptionHandler(value = BizException.class)
    @ResponseBody
    public String bizException(BizException be) {
        log.error("occur an bizException: ", be);
        return ResponseData.fail(be.getCode(), be.getMsg()).toJson();
    }

    @ExceptionHandler(value = Throwable.class)
    @ResponseBody
    public String defaultError(Exception e) {
        log.error("occur an exception: ", e);
        return ResponseData.toSystemError().toJson();
    }
}
