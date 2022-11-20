package com.margo.project.spring.populate;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class MargoPopulateBeanDemo {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext=
				new AnnotationConfigApplicationContext(MargoPopulateConfiguration.class);
		MargoFamily margoFamily=applicationContext.getBean(MargoFamily.class);
		System.out.println(margoFamily.getFamilyName());
		applicationContext.close();
	}
}
