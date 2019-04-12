package com.seventeen.component.apollo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * 获取apollo配置的属性
 * 使用该方式获取配置，在配置中心修改配置之后，生效不需要重启
 * @author seventeen
 * @date 2018/12/20
 */

@Configuration
public class AppConfig {

//    @Value("${test.property}")
//    private String pro;

//    public String getPro() {
//        return pro;
//    }
}
