package com.margo.project.reflect.constructor;

import java.lang.reflect.Constructor;


/**
 * 	https://www.cnblogs.com/hunt/p/7067141.html
 * 	获取class的三种方法 
 * 	1,Class.forName()
 *  2,ClassName.class
 *  3,object.getClass()
 * @author fangxingbang
 *
 */
public class YbContructorApp {
	public static void main(String[] args) {
		/**
		 * dubbo spi解析文件时，根据  clazz.getConstructor(type) 如果不报错，则加入cachedWrapperClasses
		 * 		try {
		 *    		clazz.getConstructor(type);
		 *    		Set<Class<?>> wrappers = cachedWrapperClasses;
		 *    		if(wrappers == null) {
		 *    			cachedWrapperClasses = new ConcurrentHashSet<Class<?>>();
		 *    			wrappers = cachedWrapperClasses;
		 *    		}
		 *    		wrappers.add(clazz);
		 *  	} catch (NoSuchMethodException e) {
		 *  		//其他逻辑
		 *  	}
		 * 
		 */
		Class<YbConstructorReflect> cla=YbConstructorReflect.class;
		try {
			//java.lang.NoSuchMethodException: com.margo.project.reflect.constructor.MagoConstructorReflect.<init>()
			//Constructor<MagoConstructorReflect> constructor=cla.getConstructor();
			Constructor<YbConstructorReflect> constructor=cla.getConstructor(YbConstructorParam.class);
			System.out.println(constructor.getParameterCount());
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}
}
