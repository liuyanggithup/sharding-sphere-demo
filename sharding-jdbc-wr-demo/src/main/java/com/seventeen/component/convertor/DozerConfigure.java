package com.seventeen.component.convertor;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 注入Dozer, bean属性映射工具
 * @author seventeen
 * @date 2018/11/26
 */

@Configuration
public class DozerConfigure {

    @Bean
    public DozerBeanMapper dozerBeanMapper() {
        DozerBeanMapper mapper = new DozerBeanMapper();
        return mapper;
    }

}
