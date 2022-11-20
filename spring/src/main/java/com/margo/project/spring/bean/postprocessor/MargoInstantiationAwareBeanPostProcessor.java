package com.margo.project.spring.bean.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

import com.margo.project.spring.bean.initializing.MargoInitializingBean;

@Component
public class MargoInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor{
	public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
		if(bean instanceof MargoInitializingBean) {
			System.out.println("MargoInitializingBean 前置处理");
		}
		return true;
	}
}
