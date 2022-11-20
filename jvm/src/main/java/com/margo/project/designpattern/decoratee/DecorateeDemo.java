package com.margo.project.designpattern.decoratee;

import org.junit.jupiter.api.Test;

public class DecorateeDemo {
	
	@Test
	public void decoratee() {
		Executor delegate=new SimpleExecutor();
		CacheExecutor cache=new CacheExecutor(delegate);
		System.out.println(cache.exec(1));
		System.out.println(cache.exec(2));
	}
}
