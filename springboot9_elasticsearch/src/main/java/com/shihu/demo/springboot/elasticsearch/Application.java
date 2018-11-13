package com.shihu.demo.springboot.elasticsearch;

import com.shihu.demo.springboot.elasticsearch.service.UserService;
import com.shihu.demo.springboot.elasticsearch.service.impl.UserServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {
	public static void main(String[] args) throws Exception {
		ApplicationContext context=SpringApplication.run(Application.class, args);
		UserServiceImpl userServiceImpl=context.getBean(UserServiceImpl.class);
		userServiceImpl.randmonSave();
	}
}
