package com.margo.project.spring.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

import com.margo.project.spring.bean.autowired.MargoGirlVO;
import com.margo.project.spring.bean.factorybean.MargoFactoryBean;
import com.margo.project.spring.bean.initializing.MargoInitializingBean;
import com.margo.project.utils.SpringHelper;

@PropertySource(value = {"classpath:easydl.properties"},ignoreResourceNotFound=false,encoding="UTF-8")
@Import(MargoGirlVO.class)
@Configuration
public class MargoBeanDefinitionConfiguration {
	
	@Bean
	public MargoFactoryBean margoFactoryBean() {
		return new MargoFactoryBean();
	}
	
	@Bean
	public SpringHelper springHelper(){
		return new SpringHelper();
	}
	
	@Bean(initMethod="initMethod")
	public MargoInitializingBean margoInitializingBean(){
		return new MargoInitializingBean();
	}
}
