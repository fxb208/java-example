package com.margo.project.spring.bean.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

//https://blog.csdn.net/yangliuhbhd/article/details/80779494
@Component
public class MargoApplicationListener implements ApplicationListener<ApplicationEvent> {

	public void onApplicationEvent(ApplicationEvent event) {
		System.out.println("我都可以收到事件："+event);	
	}

}
