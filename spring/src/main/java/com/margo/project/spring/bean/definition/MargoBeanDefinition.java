package com.margo.project.spring.bean.definition;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.margo.project.spring.annotation.MargoBeanDefinitionConfiguration;
import com.margo.project.spring.bean.autowired.MargoAutowiredBean;
import com.margo.project.spring.bean.autowired.MargoGirlVO;
import org.testng.annotations.Test;

public class MargoBeanDefinition {	
	//@Test
	public void beanDefinition() {
		AnnotationConfigApplicationContext applicationContext=
				new AnnotationConfigApplicationContext(MargoBeanDefinitionConfiguration.class);

		String[] arrBeanDefinitionName=applicationContext.getBeanDefinitionNames();
		for(String beanDefinitionName:arrBeanDefinitionName) {
			System.out.println(beanDefinitionName);
			System.out.println("************************************");
		}
		
	}
	
	//@Test
	public void autowired() {	
		AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext();
		applicationContext.refresh();
		RootBeanDefinition beanDefinition=new RootBeanDefinition(MargoGirlVO.class);
		beanDefinition.setAttribute("name", "fxb");
		beanDefinition.setAttribute("age", 29);
		//生效
		beanDefinition.getPropertyValues().add("name","test");
		applicationContext.registerBeanDefinition("margoGirlVO", beanDefinition);
		MargoGirlVO margoGirlVO=applicationContext.getBean(MargoGirlVO.class);
		System.out.println(margoGirlVO.getName());
		System.out.println(margoGirlVO.getAge());
		
	}
	
	
	//@Test
	public void registryAutowired() {
		AnnotationConfigApplicationContext applicationContext=
				new AnnotationConfigApplicationContext(MargoBeanDefinitionConfiguration.class);
		
		applicationContext.register(MargoAutowiredBean.class);
		
		BeanDefinition beandefinition=applicationContext.getBeanDefinition("margoAutowiredBean");
		//MutablePropertyValues mutablePropertyValues=beandefinition.getPropertyValues();
		System.out.println(beandefinition.getAttribute("port"));
		MargoAutowiredBean margoAutowiredBean=applicationContext.getBean(MargoAutowiredBean.class);
		System.out.println(beandefinition.getAttribute("port"));
		margoAutowiredBean.getName();
	}
	
	@Test
	public void max() {
		System.out.println(Integer.MAX_VALUE);
	}
	
}
