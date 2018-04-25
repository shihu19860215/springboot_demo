package com.shihu.demo.springboot.union.aop.config;


import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import com.shihu.demo.springboot.union.aop.aspect.WorkingTimeAspectAbstract;
import com.shihu.demo.springboot.union.aop.property.WorkingTimeProperty;
import com.shihu.demo.springboot.union.aop.util.AppenderUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class LoggerConfiguration {
    @Autowired
    private WorkingTimeProperty workingTimeProperty;
    private static String Defaule_Filepath="logs/workingtime.log";
    private static String Dufaule_FileNamePattern="logs/workingtime-%d{yyyy-MM-dd}.log";
    @Bean
    public Logger createWorkingTimeLogger(){
        LoggerContext loggerContext= (LoggerContext) LoggerFactory.getILoggerFactory();
        Logger workingTimeLogger = loggerContext.getLogger(WorkingTimeAspectAbstract.class);

        //初始化，如果没有数据使用默认数据
        initWorkingTimeProperty(workingTimeProperty);

        workingTimeLogger.addAppender(AppenderUtils.getRollingFileAppender(workingTimeProperty.getFilepath(),workingTimeProperty.getFileNamePattern()));
        return  workingTimeLogger;
    }

    /**
     * 如果配置文件没事指定路径，设置默认路径
     * @param workingTimeProperty
     */
    public void initWorkingTimeProperty(WorkingTimeProperty workingTimeProperty){
        if(null==workingTimeProperty.getFilepath()){
            workingTimeProperty.setFilepath(Defaule_Filepath);
        }
        if(null==workingTimeProperty.getFileNamePattern()){
            workingTimeProperty.setFileNamePattern(Dufaule_FileNamePattern);
        }

    }
}
