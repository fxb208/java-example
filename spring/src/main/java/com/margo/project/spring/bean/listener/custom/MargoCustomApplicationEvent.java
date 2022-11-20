package com.margo.project.spring.bean.listener.custom;

import org.springframework.context.ApplicationEvent;

public class MargoCustomApplicationEvent extends ApplicationEvent{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MargoCustomApplicationEvent(Object source) {
		super(source);
	}

}
