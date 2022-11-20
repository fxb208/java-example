package com.margo.project.jvm.singleten;

import com.margo.project.jvm.singleten.model.Resource;
/**
 * 延迟初始化
 * @author fxb208
 *
 */
public class SafeLazyInitialization {

	public static Resource resource;
	
	public synchronized static Resource getInstance() {
		if(resource==null) {
			resource=new Resource();
		}
		return resource;
	}
	
}
