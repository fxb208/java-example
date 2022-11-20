package com.margo.project.spring.populate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MargoPopulateConfiguration {
	
	@Bean
	public MargoFamily margoFamily() {
		return new MargoFamily();
	}
	
	@Bean
	public MargoGirl margoGirl() {
		return new MargoGirl();
	}
}
