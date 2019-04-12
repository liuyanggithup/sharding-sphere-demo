package com.seventeen.component.aspect;

import io.shardingsphere.api.HintManager;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author: seventeen
 * @Date: 2019/4/10
 * @description:
 */
@Component
@Aspect
@Order(value = 1)
public class ShardingAspect {


    @Pointcut("@annotation(com.seventeen.annotation.HintMaster)")
    public void hintMasterPointcut() {
    }

    @Pointcut("execution(* com.seventeen.biz.dao.*.get*(..))")
    public void retryMasterPointcut() {
    }

    /**
     * 强制路由主库
     */
    @Before("hintMasterPointcut()")
    public void hintMaster() {
        HintManager.getInstance().setMasterRouteOnly();
    }


    /**
     * 从库无记录强制再读一次主库
     *
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("retryMasterPointcut()")
    public Object retryMaster(final ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        Object result = joinPoint.proceed(args);
        if (Objects.isNull(result)) {
            HintManager.getInstance().setMasterRouteOnly();
            result = joinPoint.proceed(args);
        }

        return result;
    }


}
