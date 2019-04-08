package com.seventeen.shardingjdbc.wr.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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

}
