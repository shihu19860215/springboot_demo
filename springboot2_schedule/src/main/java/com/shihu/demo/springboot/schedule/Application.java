package com.shihu.demo.springboot.schedule;

import com.shihu.demo.springboot.schedule.task.DynamicScheduleConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@SpringBootApplication
@RestController
public class Application{
    @Autowired
    DynamicScheduleConfig dynamicScheduledConfig;


    // 修改动态定时任务的cron值
    @RequestMapping("/updateTask")
    public Object updateTask() {
        dynamicScheduledConfig.setCron("0/2 * * * * ?");
        return "success";
    }

    public static void main(String[] args) throws IOException {
        // 程序启动入口
        // 启动嵌入式的 Tomcat 并初始化 Spring 环境及其各 Spring 组件
        SpringApplication.run(Application.class, args);
    }
}
