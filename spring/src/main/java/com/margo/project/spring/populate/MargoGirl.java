package com.margo.project.spring.populate;

import org.springframework.beans.factory.annotation.Autowired;

public class MargoGirl {
	
	@Autowired
	private MargoFamily margoFamily;
	
	public MargoFamily getMargoFamily() {
		return margoFamily;
	}

	private String name="yb";
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
