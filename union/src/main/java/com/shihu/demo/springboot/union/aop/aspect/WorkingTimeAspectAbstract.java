package com.shihu.demo.springboot.union.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * 计算运行时间抽象类
 * 实现空的pointcut方法来定义切点
 * 以下两种方式实现aop
 * @Pointcut("@annotation(com.shihu.demo.springboot.union.aop.annotation.WorkingTimeAnnotation)")
 * @Pointcut("execution(* com.jixiang.union.aop..*(..))")
 * 注解或表达式
 */
public abstract class WorkingTimeAspectAbstract {
    public static final Logger logger=LoggerFactory.getLogger(WorkingTimeAspectAbstract.class);
    public abstract  void pointcut();

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint pjd){
        long start=System.currentTimeMillis();
        Object result = null;
        String methodName = pjd.getSignature().getName();
        try {
            result=pjd.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }finally {
            long total=System.currentTimeMillis()-start;
            if(total>3000){
                logger.error("类[{}]执行{}方法,参数{}，运行总时长:{}毫秒.",pjd.getTarget().getClass(),pjd.getSignature().getName(),pjd.getArgs(),total);
            }else if(total>1000){
                logger.warn("类[{}]执行{}方法,参数{}，运行总时长:{}毫秒.",pjd.getTarget().getClass(),pjd.getSignature().getName(),pjd.getArgs(),total);
            }else{
                logger.info("类[{}]执行{}方法,参数{}，运行总时长:{}毫秒.",pjd.getTarget().getClass(),pjd.getSignature().getName(),pjd.getArgs(),total);
            }
        }

        return result;

    }
}
