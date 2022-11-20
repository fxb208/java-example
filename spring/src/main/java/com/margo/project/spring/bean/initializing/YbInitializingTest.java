package com.margo.project.spring.bean.initializing;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class YbInitializingTest {

	@Test
	public void initializing() {
		AnnotationConfigApplicationContext application=
				new AnnotationConfigApplicationContext(InitMethodConfiguration.class,MargoSmartInitializingSingleton.class);
		application.close();
	}
}
