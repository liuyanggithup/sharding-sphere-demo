package com.seventeen;

import com.seventeen.webapps.filter.WebFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 应用相关配置
 * @author seventeen
 * @date 2018/10/26
 */

@Configuration
public class WebAppConfig {

    @Bean
    public FilterRegistrationBean getFilter() {
        FilterRegistrationBean filter = new FilterRegistrationBean();
        WebFilter filter1 = new WebFilter();
        filter.setFilter(filter1);
        filter.setOrder(1);
        return filter;
    }

}
