package com.seventeen.shardingjdbc.wr.demo;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * @author: xia_xun
 * @Date: 2019/4/8
 * @description:
 */
@SpringBootApplication
@MapperScan(basePackages = "com.seventeen.shardingjdbc.wr.demo.repository")
public class ShardingJdbcWrDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShardingJdbcWrDemoApplication.class, args);
    }

    @Bean
    public FilterRegistrationBean getFilterRegistrationBean(){
        FilterRegistrationBean filter = new FilterRegistrationBean();
        filter.setFilter(new WebStatFilter());
        filter.setName("druidWebStatFilter");
        filter.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*");
        filter.addUrlPatterns("/*");
        return filter;
    }

    @Bean
    public ServletRegistrationBean getServletRegistrationBean(){
        ServletRegistrationBean servlet = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        servlet.setName("druidStatViewServlet");
        servlet.addInitParameter("resetEnable", "false");
        servlet.addInitParameter("loginUsername","admin");
        servlet.addInitParameter("loginPassword","123456");
        return servlet;
    }
}
