package com.seventeen.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.seventeen.exception.BizException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Api响应写入工具类
 * @author seventeen
 * @date 2018/10/30
 */

public class ResponseUtils {

    private static final Logger log = LoggerFactory.getLogger(ResponseUtils.class);

    private static final String CONTENT_TYPE = "application/json;charset=UTF-8";

    /**
     * 将对象转换为JSON的格式返回
     */
    public static void writeJsonResponse(Object responseObj, HttpServletResponse response) {
        response.setContentType(CONTENT_TYPE);

        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.write(JSON.toJSONString(responseObj,
                    SerializerFeature.DisableCircularReferenceDetect));
        } catch (Exception e) {
            log.error("unknown exception: ", e);
            throw BizException.systemError();
        } finally {
            if (out != null) {
                out.flush();
                out.close();
            }
        }
    }

}
