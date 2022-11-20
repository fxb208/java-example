package com.margo.project.spring.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.margo.project.spring.bean.initializing.MargoInitializingBean;
import com.margo.project.utils.SpringHelper;

@ComponentScan("com.margo.project.spring.bean.*")
@Configuration
public class MargoConfiguration {
	@Bean
	public SpringHelper springHelper(){
		return new SpringHelper();
	}
	
	@Bean(initMethod="initMethod")
	public MargoInitializingBean margoInitializingBean(){
		return new MargoInitializingBean();
	}
}
