package com.margo.project.spring.importbean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ImportBeanClient {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext=
				new AnnotationConfigApplicationContext(MargoImportApplication.class);
		MargoGirlImport margoImportBean=applicationContext.getBean(MargoGirlImport.class);
		System.out.println(margoImportBean.getName());
		applicationContext.close();
	}
}
