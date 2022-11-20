package com.margo.project.spring.bean.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;


public class MargoAutowiredBean {
	@Autowired
	private MargoGirlVO margoGirlVO;
	
	@Value("${server.port}")
	private String port;
	
	public void getName() {
		margoGirlVO.getName();
		System.out.println("port:"+port);
	}
}
