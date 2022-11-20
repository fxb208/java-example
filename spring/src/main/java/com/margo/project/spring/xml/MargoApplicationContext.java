package com.margo.project.spring.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.margo.project.utils.SpringHelper;
//https://blog.csdn.net/nuomizhende45/article/details/81158383
public class MargoApplicationContext {
	public static void main(String[] args) {
		//1,spring什么时候注册BeanDefinition
		//AbstractApplicationContext  refresh 方法中  
		//ConfigurableListableBeanFactory beanFactory = obtainFreshBeanFactory();  
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application.xml");
		SpringHelper springHelper=context.getBean(SpringHelper.class);
		springHelper.say();
	}
}
