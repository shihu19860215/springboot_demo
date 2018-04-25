package com.shihu.demo.springboot.logback;


import com.shihu.demo.springboot.logback.debug.DebugWork;
import com.shihu.demo.springboot.logback.info.InfoWork;
import com.shihu.demo.springboot.logback.trace.TraceWork;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Date;

/**
 * 官方文档
 * http://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-logging.html
 */
@SpringBootApplication
public class Applaction {
    private static final Logger LOGGER = LoggerFactory.getLogger(Applaction.class);

    public static String index() {
        /*
            logback.xml中指定的默认输出级别为INFO，所以低于INFO级别(DEBUG、TRACE)的日志不会输出
            级别排序为： TRACE < DEBUG < INFO < WARN < ERROR
         */
        LOGGER.info("This is a primary with logback., Current time {}.", new Date());
        LOGGER.trace("This level is TRACE.");
        LOGGER.debug("This level is DEBUG.");
        LOGGER.debug("This level is DEBUG.", LOGGER.isDebugEnabled());
        LOGGER.info("This level is INFO.");
        LOGGER.info("isInfoEnabled:" + LOGGER.isInfoEnabled());
        LOGGER.warn("This level is WARN.");
        LOGGER.error("This level is ERROR.");
        System.out.println("-----------------------------------------------------------------");
        return "logback.";
    }

    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext=SpringApplication.run(Applaction.class, args);
        applicationContext.getBean(DebugWork.class).work();
        applicationContext.getBean(InfoWork.class).work();
        applicationContext.getBean(TraceWork.class).work();
        index();
    }
}
