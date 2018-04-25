package com.shihu.demo.springboot.union.aop.filter;

import ch.qos.logback.classic.spi.LoggingEvent;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;

/**
 * 未使用，logback自定义拦截器demo
 */
public class ClassNameFilter extends Filter {
    public ClassNameFilter() {
        System.out.println("");
    }

    @Override
    public FilterReply decide(Object o) {
        LoggingEvent event = (LoggingEvent)o;
        StackTraceElement[] cda = event.getCallerData();
        String className=cda != null && cda.length > 0 ? cda[0].getClassName() : "?";
        System.out.println(className);
        if ("com.shihu.demo.springboot.union.aop.aspect.WorkingTimeAspectAbstract".equals(className)) {
            return FilterReply.ACCEPT;
        } else {
            return FilterReply.DENY;
        }
    }
}
