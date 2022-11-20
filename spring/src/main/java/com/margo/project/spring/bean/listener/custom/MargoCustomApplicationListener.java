package com.margo.project.spring.bean.listener.custom;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MargoCustomApplicationListener implements ApplicationListener<MargoCustomApplicationEvent>{

	public void onApplicationEvent(MargoCustomApplicationEvent event) {
		System.out.println("自定义事件："+event);	
	}

}
