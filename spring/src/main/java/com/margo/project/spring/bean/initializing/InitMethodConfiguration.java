package com.margo.project.spring.bean.initializing;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * AbstractAutowireCapableBeanFactory
 * 	DefaultListableBeanFactory
 * @author fxb20
 *
 */
@Configuration
public class InitMethodConfiguration {

	@Bean(initMethod="initMethod")
	public MargoInitializingBean margoInitializingBean() {
		return new MargoInitializingBean();
	}
	
	@Bean
	public YbAwareMethods ybAwareMethods() {
		return new YbAwareMethods();
	}
}
