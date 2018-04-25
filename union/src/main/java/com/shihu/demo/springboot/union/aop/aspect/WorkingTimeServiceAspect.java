package com.shihu.demo.springboot.union.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class WorkingTimeServiceAspect extends WorkingTimeAspectAbstract {

    @Pointcut("@within(org.springframework.stereotype.Service)")
    public void pointcut(){

    }
}
