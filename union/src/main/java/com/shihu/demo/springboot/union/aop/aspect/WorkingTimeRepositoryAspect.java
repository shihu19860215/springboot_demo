package com.shihu.demo.springboot.union.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class WorkingTimeRepositoryAspect extends WorkingTimeAspectAbstract {

    @Pointcut("@within(org.springframework.stereotype.Repository)")
    public void pointcut(){

    }
}
