package com.margo.project.spring.bean.factorybean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class FactoryBeanClient {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext application=
				new AnnotationConfigApplicationContext(MargoFactoryBean.class);
		String[] arrName=application.getBeanDefinitionNames();
		for(String beanName:arrName) {
			System.out.println(beanName);
		}
		Object object=application.getBean("margoFactoryBean");
		System.out.println(object.getClass());
		
		Object obj=application.getBean("&margoFactoryBean");
		System.out.println(obj.getClass());
		
		application.close();
	}
}
