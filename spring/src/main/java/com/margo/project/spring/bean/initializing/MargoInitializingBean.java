package com.margo.project.spring.bean.initializing;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * 	doCreateBean
 * 		initializeBean
 * 			invokeAwareMethods
 * 			applyBeanPostProcessorsBeforeInitialization 
 * 			invokeInitMethods 这里 InitializingBean接口 的afterPropertiesSet,然后调用init()方法
 * 			applyBeanPostProcessorsAfterInitialization
 * @author fangxingbang
 *
 */
@Component
public class MargoInitializingBean implements InitializingBean{

	public void afterPropertiesSet() throws Exception {
		System.out.println("InitializingBean afterPropertiesSet");

	}

	public void initMethod() {
		System.out.println("MargoInitializingBean  调用initMethod方法");
	}
	
	/**
	 * InitDestroyAnnotationBeanPostProcessor
	 * CommonAnnotationBeanPostProcessor extends InitDestroyAnnotationBeanPostProcessor
	 * 		implements InstantiationAwareBeanPostProcessor, BeanFactoryAware
	 */
	@PostConstruct
	public void construct() {
		System.out.println("MargoInitializingBean  调用construct方法");
	}
	
	@PreDestroy
	public void destory() {
		System.out.println("MargoInitializingBean  调用destory方法");
	}
}
