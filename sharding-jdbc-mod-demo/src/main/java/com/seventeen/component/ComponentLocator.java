package com.seventeen.component;

import com.seventeen.component.adapter.SpringContextHolder;
import com.seventeen.component.apollo.AppConfig;
import com.seventeen.component.convertor.ConvertorFacade;
import com.seventeen.component.convertor.impl.ConvertorFacadeImpl;
import com.seventeen.component.redis.RedisFacade;
import com.seventeen.component.redis.impl.RedisFacadeImpl;

/**
 * 组件定位器，可以减少在所有地方直接注入
 * @author seventeen
 * @date 2018/11/26
 */

public class ComponentLocator {

    private static ConvertorFacade convertorFacade;
    private static RedisFacade redisFacade;

    private static AppConfig appConfig;

    public static ConvertorFacade getConvertor() {
        if (convertorFacade == null) {
            convertorFacade = SpringContextHolder.getBean(ConvertorFacadeImpl.class);
        }
        return convertorFacade;
    }

    public static RedisFacade getRedis() {
        if (redisFacade == null) {
            redisFacade = SpringContextHolder.getBean(RedisFacadeImpl.class);
        }
        return redisFacade;
    }

    public static AppConfig getAppConfig() {
        if (appConfig == null) {
            appConfig = SpringContextHolder.getBean(AppConfig.class);
        }
        return appConfig;
    }

}
