package com.seventeen.shardingjdbc.wr.demo.aspact;

import io.shardingsphere.api.HintManager;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author: xia_xun @Date: 2019/4/8
 * @description:
 */
@Component
@Aspect
public class HintMasterAspect {

  @Pointcut("@annotation(com.seventeen.shardingjdbc.wr.demo.annotation.HintMaster)")
  public void hintMasterPointcut() {}

  @Around("hintMasterPointcut()")
  public Object hintMaster(final ProceedingJoinPoint joinPoint) throws Throwable {
    Object[] args = joinPoint.getArgs();
    Object result = joinPoint.proceed(args);
    if (Objects.isNull(result)) {
      HintManager.getInstance().setMasterRouteOnly();
      result = joinPoint.proceed(args);
    }

    return result;
  }
}
