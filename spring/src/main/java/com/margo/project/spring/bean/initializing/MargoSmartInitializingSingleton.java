package com.margo.project.spring.bean.initializing;

import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.stereotype.Component;

@Component
public class MargoSmartInitializingSingleton implements SmartInitializingSingleton{

	public void afterSingletonsInstantiated() {
		System.out.println("SmartInitializingSingleton afterSingletonsInstantiated");
		
	}

}
