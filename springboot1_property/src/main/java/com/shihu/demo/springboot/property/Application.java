package com.shihu.demo.springboot.property;

import com.shihu.demo.springboot.property.model.Cat;
import com.shihu.demo.springboot.property.model.Cat2;
import com.shihu.demo.springboot.property.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

/**
 * Spring Boot 应用启动类
 * <p>
 * Created by bysocket on 16/4/26.
 */
// Spring Boot 应用的标识
@SpringBootApplication
public class Application implements CommandLineRunner {
    @Autowired
    private Environment env;

    @Autowired
    private Cat cat;
    @Autowired
    private Cat2 cat2;
    @Autowired
    private User user;



    public static void main(String[] args) {
        // 程序启动入口
        // 启动嵌入式的 Tomcat 并初始化 Spring 环境及其各 Spring 组件
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("------类对应配置文件属性获取值---------------------------------------------------");
        System.out.println(cat.toString());
        System.out.println(user.toString());
        System.out.println("----------------------------------------------------------------------------------------------");
        System.out.println();
        System.out.println("------@value注解标记获取值----------------------------------------------------------");
        System.out.println(cat2.toString());
        System.out.println("----------------------------------------------------------------------------------------------");
        System.out.println();
        System.out.println("------通过注入对象获取配置文件属性值----------------------------------------------------------");
        System.out.println(env.getProperty("cat.name"));
        System.out.println("----------------------------------------------------------------------------------------------");
       //System.exit(1);
    }
}
