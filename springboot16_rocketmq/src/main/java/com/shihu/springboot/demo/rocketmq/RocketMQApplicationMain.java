package com.shihu.springboot.demo.rocketmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.shihu.springboot.demo.rocketmq3"})
public class RocketMQApplicationMain {
    private final static Logger logger=LoggerFactory.getLogger(RocketMQApplicationMain.class);
    public static void main(String[] args) {
        SpringApplication.run(RocketMQApplicationMain.class, args);
        logger.trace("trace");
        logger.debug("debug");
        logger.info("info");
        logger.warn("warn");
        logger.error("error");
    }
}
