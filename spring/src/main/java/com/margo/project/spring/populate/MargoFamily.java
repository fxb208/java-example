package com.margo.project.spring.populate;

import org.springframework.beans.factory.annotation.Autowired;

public class MargoFamily {

	@Autowired
	private MargoGirl margoGirl;
	
	public String getFamilyName(){
		return margoGirl.getName()+"：we are family";
	}
}
