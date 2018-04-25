package com.shihu.demo.springboot.errorpage.conf;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * @Description 自定义异常页面配置类
 */
@Component
public class ErrorPagesConfiguration {


	/**
	 * 自定义异常处理路径
	 * @return
	 * 出现错误跳转到指定的页面地址
	 */
	@Bean
	public ConfigurableServletWebServerFactory webServerFactory() {
		TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
		factory.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/error/404"));
		factory.addErrorPages(new ErrorPage(HttpStatus.BAD_REQUEST, "/error/400"));
		factory.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error/500"));
		factory.addErrorPages(new ErrorPage(Throwable.class, "/error/500"));
		return factory;
	}
	/**
	 * 自定义异常处理路径 2.0版本之前使用
	 * @return
	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer() {
		return new EmbeddedServletContainerCustomizer() {
			@Override
			public void customize(ConfigurableEmbeddedServletContainer configurableEmbeddedServletContainer) {
				configurableEmbeddedServletContainer.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/error/404"));
				configurableEmbeddedServletContainer.addErrorPages(new ErrorPage(HttpStatus.BAD_REQUEST, "/error/400"));
				configurableEmbeddedServletContainer.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error/500"));
				configurableEmbeddedServletContainer.addErrorPages(new ErrorPage(Throwable.class, "/error/500"));
			}
		};
	}
	 */
}
