package com.seventeen;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 程序启动入口
 * <p>
 * 如果使用已经集成spring-cloud
 * 需要开启@SpringCloudApplication和@EnableFeignClients注释
 * 并将@SpringBootApplication去掉
 *
 * @author seventeen
 * @date 2018/10/26
 */

@SpringBootApplication
@MapperScan(basePackages = "com.seventeen.biz.dao")
@EnableTransactionManagement(order = 5)
public class ApplicationMain {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationMain.class, args);
    }


    @Bean
    public FilterRegistrationBean getFilterRegistrationBean() {
        FilterRegistrationBean filter = new FilterRegistrationBean();
        filter.setFilter(new WebStatFilter());
        filter.setName("druidWebStatFilter");
        filter.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*");
        filter.addUrlPatterns("/*");
        return filter;
    }

    @Bean
    public ServletRegistrationBean getServletRegistrationBean() {
        ServletRegistrationBean servlet = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        servlet.setName("druidStatViewServlet");
        servlet.addInitParameter("resetEnable", "false");
        servlet.addInitParameter("loginUsername", "admin");
        servlet.addInitParameter("loginPassword", "123456");
        return servlet;
    }

}
