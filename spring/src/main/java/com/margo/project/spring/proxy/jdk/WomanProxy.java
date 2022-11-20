package com.margo.project.spring.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class WomanProxy implements InvocationHandler{

	private Object target;

    public WomanProxy(Object target) {
        this.target = target;
    }
	
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("方法调用之前");
		Object result = method.invoke(target, args);
		System.out.println("方法调用之后");
		return result;
	}

}
