package com.shihu.demo.springboot.union.aop.util;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.PatternLayout;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.encoder.LayoutWrappingEncoder;
import ch.qos.logback.core.rolling.RollingFileAppender;
import ch.qos.logback.core.rolling.TimeBasedRollingPolicy;
import org.slf4j.LoggerFactory;

public class AppenderUtils {
    /**
     * 获取以下配置的一个文件输出
     *     <appender name="WORKING_TIME_FILE" class="ch.qos.logback.core.rolling.RollingFileAppender">
     *         <file>logs/workingtime.log</file>
     *         <!-- 日志格式 -->
     *         <encoder>
     *             <pattern>%d{yyyy-MM-dd HH:mm:ss} [%logger:%line] %-5level - %msg%n</pattern>
     *         </encoder>
     *         <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
     *             <!-- 按天回滚 daily -->
     *             <fileNamePattern>logs/workingtime-%d{yyyy-MM-dd}.log</fileNamePattern>
     *             <!-- 最大保存时间：30天-->
     *             <maxHistory>30</maxHistory>
     *         </rollingPolicy>
     *     </appender>
     * @param filepath
     * @param fileNamePattern
     * @return
     */
    public static RollingFileAppender getRollingFileAppender(String filepath,String fileNamePattern){
        RollingFileAppender<ILoggingEvent> rollingFileAppender=new RollingFileAppender<ILoggingEvent>();
        //fileAppender.setAppend(true);//是否以追加方式输出。默认为true
        rollingFileAppender.setPrudent(false);//是否工作在谨慎模式下
        rollingFileAppender.setFile(filepath);

        LayoutWrappingEncoder<ILoggingEvent> encoder=new LayoutWrappingEncoder<ILoggingEvent>();
        PatternLayout patternLayout=new PatternLayout();
        encoder.setLayout(patternLayout);
        patternLayout.setPattern("%d{yyyy-MM-dd HH:mm:ss} [%logger:%line] %-5level - %msg%n");
        rollingFileAppender.setEncoder(encoder);
        TimeBasedRollingPolicy timeBasedRollingPolicy=new TimeBasedRollingPolicy();
        timeBasedRollingPolicy.setFileNamePattern(fileNamePattern);
        timeBasedRollingPolicy.setMaxHistory(30);
        rollingFileAppender.setRollingPolicy(timeBasedRollingPolicy);

        LoggerContext loggerContext= (LoggerContext) LoggerFactory.getILoggerFactory();

        patternLayout.setContext(loggerContext);
        rollingFileAppender.setContext(loggerContext);
        encoder.setContext(loggerContext);
        timeBasedRollingPolicy.setContext(loggerContext);
        timeBasedRollingPolicy.setParent(rollingFileAppender);
        encoder.start();
        patternLayout.start();
        timeBasedRollingPolicy.start();
        rollingFileAppender.start();
        return rollingFileAppender;
    }
}
