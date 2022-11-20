package com.margo.project.spring.annotation;

import org.junit.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.margo.project.spring.bean.autowired.MargoAutowiredBean;
import com.margo.project.spring.bean.factorybean.MargoBean;
import com.margo.project.spring.bean.listener.annotation.MargoAnnotationEventPublisher;
import com.margo.project.spring.bean.listener.custom.MargoCustomEventPublisher;

/*
 * ApplicationContext 与  BeanFactory
 */
//https://blog.csdn.net/shenmaxiang/article/details/79377236
public class MargoApplication {

	public void springEvent() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MargoConfiguration.class);
		MargoCustomEventPublisher margoEventPublisher = context.getBean(MargoCustomEventPublisher.class);
		margoEventPublisher.publish();

		MargoAnnotationEventPublisher margoAnnotationEventPublisher = context
				.getBean(MargoAnnotationEventPublisher.class);
		margoAnnotationEventPublisher.publish();
	}
	
	//@Test
	public void springFactoryBean() {
		AnnotationConfigApplicationContext context = 
			new AnnotationConfigApplicationContext(MargoConfiguration.class);
		MargoBean margoBean1=context.getBean(MargoBean.class);
		MargoBean margoBean2=context.getBean(MargoBean.class);
		System.out.println(margoBean1);
		System.out.println(margoBean2);
		System.out.println(margoBean1.equals(margoBean2));
	}
	
	//@Test
	public void getAttribute() {
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(MargoConfiguration.class);
		
		BeanDefinition beanDefinition=context.getBeanDefinition("margoConfiguration");
		String full=(String) beanDefinition.getAttribute("org.springframework.context.annotation.ConfigurationClassPostProcessor.configurationClass");
		System.out.println(full); //full
		      
		BeanDefinition beanDefinition_1=context.getBeanDefinition("margoFactoryBean");
		String lite=(String) beanDefinition_1.getAttribute("org.springframework.context.annotation.ConfigurationClassPostProcessor.configurationClass");
		System.out.println(lite);  //lite
	}
	
	@Test
	public void registerBean() {
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(MargoBeanDefinitionConfiguration.class);
		context.register(MargoAutowiredBean.class);
		MargoAutowiredBean margoAutowiredBean=(MargoAutowiredBean) context.getBean(MargoAutowiredBean.class);
		margoAutowiredBean.getName();
	
	}
}
