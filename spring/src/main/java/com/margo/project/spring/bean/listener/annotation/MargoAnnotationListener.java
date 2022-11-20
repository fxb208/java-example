package com.margo.project.spring.bean.listener.annotation;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MargoAnnotationListener {
	
	@EventListener(classes = { MargoAnnotationApplicationEvent.class }) // classes 监听器的类型
	public void listen(MargoAnnotationApplicationEvent event) {
		System.out.println("监听注解事件：" + event);
	}

}
