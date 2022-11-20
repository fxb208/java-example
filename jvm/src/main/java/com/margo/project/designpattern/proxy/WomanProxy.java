package com.margo.project.designpattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 *	 动态代理类 实现InvocationHandler接口
 * @author fangxingbang
 *
 * @param <T>
 */
public class WomanProxy<T> implements InvocationHandler {
	
//	private final Class<T> mapperInterface;// mapper接口对应的class对象；
//
//	public WomanProxy(Class<T> mapperInterface) {
//		this.mapperInterface = mapperInterface;
//	}
	
	private Woman woman;


	public WomanProxy(Woman woman) {
		super();
		this.woman = woman;
	}



	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		method.invoke(woman, args);
		if ("getGirl".equals(method.getName())) {
			System.out.println("生了个女孩");
		} else if ("getBoy".equals(method.getName())) {
			System.out.println("生了个儿子");
		}
		return null;
	}
}
