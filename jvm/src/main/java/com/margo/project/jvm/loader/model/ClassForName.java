package com.margo.project.jvm.loader.model;

public class ClassForName {

	public ClassForName() {
		super();
		System.out.println("构造函数");
	}

	/**
	 * 静态代码块
	 */
	static {
		System.out.println("执行静态代码块");
	}
	
	/**
	 * 静态变量
	 */
	public static String staticField=staticMethod();
	
	/**
	 * 静态方法
	 * @return
	 */
	public static String staticMethod() {
		System.out.println("执行静态方法");
		return "staticField";
	}
}
