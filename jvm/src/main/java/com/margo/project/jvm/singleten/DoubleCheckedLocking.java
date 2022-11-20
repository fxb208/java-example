package com.margo.project.jvm.singleten;

import com.margo.project.jvm.singleten.model.Resource;

/**
 * 双重检查 volatile
 * @author fxb208
 *
 */
public class DoubleCheckedLocking {
	
	private volatile static Resource resource;
	
	public Resource getInstance() {
		if(resource==null) {
			synchronized (DoubleCheckedLocking.class) {
				if(resource==null) {
					resource=new Resource();
				}
			}
		}
		return resource;
	}
}
