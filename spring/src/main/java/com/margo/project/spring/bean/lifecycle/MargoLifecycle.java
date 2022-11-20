package com.margo.project.spring.bean.lifecycle;

import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

@Component
public class MargoLifecycle implements SmartLifecycle{

	public void start() {
		System.out.println("start");
	}

	public void stop() {
		System.out.println("stop");
	}

	public boolean isRunning() {
		return false;
	}

	public int getPhase() {
		return 0;
	}

	/**
	 * 是否跟随spring容器启动
	 */
	public boolean isAutoStartup() {
		return true;
	}

	public void stop(Runnable callback) {
		
	}

}
