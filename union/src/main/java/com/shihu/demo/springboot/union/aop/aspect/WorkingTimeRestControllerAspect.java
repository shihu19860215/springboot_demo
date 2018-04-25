package com.shihu.demo.springboot.union.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class WorkingTimeRestControllerAspect extends WorkingTimeAspectAbstract {

    @Pointcut("@within(org.springframework.web.bind.annotation.RestController)")
    public void pointcut(){

    }
}
