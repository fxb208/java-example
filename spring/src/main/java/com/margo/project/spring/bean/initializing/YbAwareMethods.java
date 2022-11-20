package com.margo.project.spring.bean.initializing;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;

/**
 *  doCreateBean
 * 		initializeBean
 * 			invokeAwareMethods  这里调用 setBeanFactory(BeanFactory beanFactory)
 * 			applyBeanPostProcessorsBeforeInitialization
 * 			invokeInitMethods
 * 			applyBeanPostProcessorsAfterInitialization
 * @author fxb20
 *
 */
public class YbAwareMethods implements BeanNameAware, BeanFactoryAware,BeanClassLoaderAware{

	private BeanFactory beanFactory;
	
	@Override
	public void setBeanClassLoader(ClassLoader classLoader) {
		System.out.println("setBeanClassLoader");	
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("setBeanFactory");
		this.beanFactory=beanFactory;  //可以这么设置
	}
	
	public Object getBean(String name) {
		return beanFactory.getBean(name);
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("setBeanName");
		
	}

}
