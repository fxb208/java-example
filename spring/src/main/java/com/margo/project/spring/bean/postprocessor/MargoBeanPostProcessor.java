package com.margo.project.spring.bean.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import com.margo.project.spring.bean.initializing.MargoInitializingBean;



/**
 * 	doCreateBean
 * 		initializeBean
 * 			invokeAwareMethods
 * 			applyBeanPostProcessorsBeforeInitialization 调用 postProcessBeforeInitialization(Object bean, String beanName)
 * 			invokeInitMethods
 * 			applyBeanPostProcessorsAfterInitialization 调用 postProcessAfterInitialization(Object bean, String beanName)
 * @author fangxingbang
 *
 */
@Component
public class MargoBeanPostProcessor implements BeanPostProcessor{
	
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if(bean instanceof MargoInitializingBean) {
			System.out.println("MargoInitializingBean 前置处理");
		}
		return bean;
	}
	
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if(bean instanceof MargoInitializingBean) {
			System.out.println("MargoInitializingBean 后置处理");
		}
		return bean;
	}

}
