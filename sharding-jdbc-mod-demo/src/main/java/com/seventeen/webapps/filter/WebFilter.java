package com.seventeen.webapps.filter;

import com.seventeen.response.ResponseData;
import com.seventeen.utils.ResponseUtils;
import com.seventeen.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * 过滤器
 * @author seventeen
 * @date 2018/10/26
 */

public class WebFilter implements Filter {

    private static final Logger log = LoggerFactory.getLogger(WebFilter.class);

    private static final String MULTIPART_FORM_DATA = "multipart/form-data";
    private static final String QUESTION_MARK = "?";
    private static final String EQUAL = "=";
    private static final String AND = "&";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        /**
         * 对项目的必要参数进行统一验证
         * // TODO
         */
        if (isValidate()) {
            String timestamp = request.getParameter("timestamp");
            if (!validateRequest(timestamp)) {
                HttpServletResponse response = (HttpServletResponse) servletResponse;
                ResponseUtils.writeJsonResponse(ResponseData.toParamInvalidateJson(), response);
                return;
            }
        }

        // 开始处理业务
        filterChain.doFilter(servletRequest, servletResponse);

        log.info(getRequest(request));
    }

    @Override
    public void destroy() {

    }

    private boolean isValidate() {
        return false;
    }

    private boolean validateRequest(String timestamp) {
        if (timestamp == null) {
            return false;
        }

        return true;
    }

    /**
     * 获取请求的链接和参数
     */
    private String getRequest(HttpServletRequest request) {
        String contentType = request.getContentType();
        // 上传文件
        if (StringUtils.isNotBlank(contentType) && contentType.indexOf(MULTIPART_FORM_DATA) > -1) {
            return request.getRequestURL().toString();
        }

        StringBuilder sb = new StringBuilder();
        // 请求的URL
        sb.append(request.getRequestURL().toString());
        // 请求的参数
        Map<String, String[]> params = request.getParameterMap();
        if (params != null && !params.isEmpty()) {
            sb.append(QUESTION_MARK);
            for (Map.Entry<String, String[]> param : params.entrySet()) {
                sb.append(param.getKey()).append(EQUAL).append(param.getValue()[0]).append(AND);
            }
        }
        return sb.toString();
    }
}
