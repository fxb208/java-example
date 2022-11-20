package com.margo.project.designpattern.composite;

public class MargoComponentWifeImpl implements MargoComponent{

	@Override
	public boolean supports(String role) {
		if("wife".equals(role)) {
			return true;
		}
		return false;
	}

	@Override
	public Object resolver(String role) {
		return role;
	}

}
