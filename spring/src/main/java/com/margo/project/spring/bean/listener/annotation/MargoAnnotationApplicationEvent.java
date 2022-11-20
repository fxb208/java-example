package com.margo.project.spring.bean.listener.annotation;

import org.springframework.context.ApplicationEvent;

public class MargoAnnotationApplicationEvent extends ApplicationEvent{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MargoAnnotationApplicationEvent(Object source) {
		super(source);
	}

}
