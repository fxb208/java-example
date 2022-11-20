package com.margo.project.designpattern.composite;

public class MargoComponentGirlImpl implements MargoComponent{

	@Override
	public boolean supports(String role) {
		if("girl".equals(role)) {
			return true;
		}
		return false;
	}

	@Override
	public Object resolver(String role) {
		return role;
	}

}
