package com.margo.project.jvm.singleten;

import com.margo.project.jvm.singleten.model.Resource;

/**
 * 提前初始化
 * @author fxb208
 *
 */
public class EagerInitialization {
	private static Resource resource=new Resource();
	
	public static Resource getInstance() {
		return resource;
	}
}
