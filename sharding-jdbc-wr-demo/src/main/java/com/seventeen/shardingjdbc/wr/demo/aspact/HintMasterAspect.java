package com.seventeen.shardingjdbc.wr.demo.aspact;

import io.shardingsphere.api.HintManager;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author: xia_xun @Date: 2019/4/8
 * @description:
 */
@Component
@Aspect
public class HintMasterAspect {

  @Pointcut("@annotation(com.seventeen.shardingjdbc.wr.demo.annotation.HintMaster)")
  public void hintMasterPointcut() {}

  @Before("hintMasterPointcut()")
  public void hintMaster() {
    HintManager.getInstance().setMasterRouteOnly();
  }
}
