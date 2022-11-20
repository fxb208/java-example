package com.margo.project.jvm.singleten;

import com.margo.project.jvm.singleten.model.Resource;
/**
 * 延迟占位
 * @author fxb208
 *
 */
public class ResourceFactory {
	private static class ResourceHolder {
		public static Resource resource=new Resource();
	}
	
	public static Resource getInstance() {
		return ResourceHolder.resource;
	}
}
