package com.shihu.demo.springboot.interceptor.config;

import com.shihu.demo.springboot.interceptor.interceptor.CustomInterceptor1;
import com.shihu.demo.springboot.interceptor.interceptor.CustomInterceptor2;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class RegistInterceptorConfigurer implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(new CustomInterceptor1())
                .addPathPatterns("/random1/**");
        registry.addInterceptor(new CustomInterceptor2())
                .addPathPatterns("/random2/**");
    }
}
