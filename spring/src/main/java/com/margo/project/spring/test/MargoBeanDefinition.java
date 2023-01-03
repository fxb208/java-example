package com.margo.project.spring.test;


import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.margo.project.spring.annotation.MargoBeanDefinitionConfiguration;
import com.margo.project.spring.annotation.MargoConfiguration;
import com.margo.project.spring.bean.factorybean.MargoBean;
import org.testng.annotations.Test;

public class MargoBeanDefinition {
	
	@Test
	public void beanDefinition() {
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext applicationContext=
				new AnnotationConfigApplicationContext(MargoBeanDefinitionConfiguration.class);
		String[] arrBeanDefinitionName=applicationContext.getBeanDefinitionNames();
		for(String beanDefinitionName:arrBeanDefinitionName) {
			BeanDefinition beanDefinition=applicationContext.getBeanDefinition(beanDefinitionName);
			System.out.println(beanDefinitionName);
			System.out.println(beanDefinition.getBeanClassName());
			System.out.println(beanDefinition.getFactoryBeanName());
			System.out.println("************************************");
		}
		applicationContext.close();
	}
	
	//@Test
	public void factoryBean() {
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext applicationContext=
				new AnnotationConfigApplicationContext(MargoConfiguration.class);
		MargoBean margoBean=applicationContext.getBean(MargoBean.class);
		System.out.println(margoBean.getName());
		
	}
	
	//@Test
	public void ee() {
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MargoConfiguration.class);
		MargoBean margoBean1=context.getBean(MargoBean.class);
		MargoBean margoBean2=context.getBean(MargoBean.class);
		System.out.println(margoBean1);
		System.out.println(margoBean2);
		System.out.println(margoBean1.equals(margoBean2));
	}
}
