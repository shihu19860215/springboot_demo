package com.shihu.demo.springboot.union.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;



@Component
@Aspect
public class WorkingTimeAnnotationAspect extends WorkingTimeAspectAbstract {

    @Pointcut("@annotation(com.shihu.demo.springboot.union.aop.annotation.WorkingTimeAnnotation)")
    public void pointcut(){

    }
}
