package com.margo.project.utils;

import org.springframework.beans.factory.config.BeanPostProcessor;

public class SpringHelper implements BeanPostProcessor{
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void say() {
		System.out.println("margo");
	}
	
}
