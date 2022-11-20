package com.margo.project.spring.bean.listener.annotation;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

@Component
public class MargoAnnotationEventPublisher implements ApplicationEventPublisherAware{

	private ApplicationEventPublisher publisher;
	
	/**
	 * 	 执行原理  ApplicationContextAwareProcessor
	 */
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.publisher=applicationEventPublisher;
	}
	
	/**
	 *  1, 	自定义ApplicationEvent  MargoApplicationEvent
	 *  2,	自定义ApplicationListener    
	 *  		MargoApplicationListener implements ApplicationListener<ApplicationEvent>
	 *  3,	发布事件 ，ApplicationListener 的 onApplicationEvent 执行逻辑
	 */
	public void publish() {
		this.publisher.publishEvent(new MargoAnnotationApplicationEvent(this));
	}

}
