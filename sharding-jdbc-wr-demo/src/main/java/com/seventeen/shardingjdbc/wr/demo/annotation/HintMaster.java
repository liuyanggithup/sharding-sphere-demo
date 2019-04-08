package com.seventeen.shardingjdbc.wr.demo.annotation;

/**
 * @author: xia_xun
 * @Date: 2019/4/8
 * @description:
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target( { ElementType.METHOD, ElementType.TYPE })
public @interface HintMaster {

}
