package com.margo.project.spring.proxy.cglib;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;


// https://blog.csdn.net/yhl_jxy/article/details/80633194 
public class MyMethodInterceptor implements MethodInterceptor{

	//Method 方法名   Object[] 入参
	public Object intercept(Object object, Method arg1, Object[] arg2, MethodProxy methodProxy) throws Throwable {
		   System.out.println("======插入前置通知======");
	        Object obj = methodProxy.invokeSuper(object, arg2);
	        System.out.println("======插入后者通知======");
	        return obj;
	}


}
