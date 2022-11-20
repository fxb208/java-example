package com.margo.project.designpattern.composite;

public interface MargoComponent {
	boolean supports(String role);
	Object resolver(String role);
}
