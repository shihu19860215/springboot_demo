package com.shihu.demo.springboot.union.aop.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 可以配置文件中配置的路径
 */
@Component
@ConfigurationProperties(prefix = "logback.workingtime")
public class WorkingTimeProperty {
    private String filepath;
    private String fileNamePattern;

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public String getFileNamePattern() {
        return fileNamePattern;
    }

    public void setFileNamePattern(String fileNamePattern) {
        this.fileNamePattern = fileNamePattern;
    }
}
