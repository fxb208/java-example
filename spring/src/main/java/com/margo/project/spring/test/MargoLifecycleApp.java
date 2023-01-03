package com.margo.project.spring.test;

import java.util.Map;

import org.springframework.context.SmartLifecycle;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.margo.project.spring.bean.lifecycle.MargoLifecycle;
import org.testng.annotations.Test;

public class MargoLifecycleApp {
	
	@Test
	public void beanDefinition() {
		ThreadLocal local = new ThreadLocal();
		local.set("12");
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext applicationContext=
				new AnnotationConfigApplicationContext(MargoLifecycle.class);
		Map<String, SmartLifecycle> map=applicationContext.getBeansOfType(SmartLifecycle.class);
		for(String key:map.keySet()) {
			System.out.println(map.get(key).isRunning());
		}
		applicationContext.close();
	}
}
