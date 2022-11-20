package com.margo.project.jvm.loader.model;


public class SupplyResolveVO {
	
	private static class InnerClass {
		/**
		 * 触发类初始化
		 */
		public static int age=28;
		
		static {
			System.out.println("静态内部类初始化");
		}
	}
	
	/**
	 * 静态代码块
	 */
	static {
		System.out.println("执行静态代码块");
	}
	
	/**
	 * 静态方法
	 */
	public static void staticMethod() {
		System.out.println(InnerClass.age);
	}
	
	/**
	 * 触发类初始化
	 */
	public static String name="margo";
}
