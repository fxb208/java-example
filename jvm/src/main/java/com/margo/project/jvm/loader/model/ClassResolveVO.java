package com.margo.project.jvm.loader.model;

/**
 * 访问静态变量，调用静态方法，都会导致类的初始化
 * 
 * 访问编译时常量不会导致初始化
 * 
 * @author fxb208
 *
 */
public class ClassResolveVO {
	
	public ClassResolveVO() {
		super();
		System.out.println("构造函数");
	}


	/**
	 * 
	 * int类型
	 */
	public static int intField=1;
	
	/**
	 * 字符串类型
	 */
	public static String stringField="margo";
	
	/**
	 * 静态方法
	 */
	public static void staticMethod() {
		System.out.println("调用静态方法");
	}
	
	
	/**
	 * 编译时为常量
	 */
	public static final int finalIntField=1;
	
	/**
	 * 编译时为常量
	 */
	public static final String  finalStringField="margo";
	
	/**
	 * b不是编译时常量，调用会导致初始化
	 */
	public static final int b=(int)(Math.random()*5);
	
	public static final int c;
	
	static {
		c=2;
	}
	
	/**
	 * 静态代码块
	 */
	static {
		System.out.println("执行静态代码块");
	}
}
