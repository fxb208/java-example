package com.margo.project.spring.proxy.jdk;

import java.lang.reflect.Proxy;

public class JDKProxyClient {
	public static void main(String[] args) {
		Woman woman = (Woman) Proxy.newProxyInstance(WomanImpl.class.getClassLoader(), new Class[] { Woman.class },
				new WomanProxy(new WomanImpl()));
		woman.getGirl();
	}
}
