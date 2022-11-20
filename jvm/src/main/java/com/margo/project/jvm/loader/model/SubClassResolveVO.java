package com.margo.project.jvm.loader.model;

/**
 * 被动引用
 * 
 * 对于静态字段，只有直接定义这个字段的类才会被初始化，因此通过其子类来引用父类中定义的静态字段，只会触发父类的初始化
 */
public class SubClassResolveVO extends ClassResolveVO{
	
	public static int age=28;
	
	static {
		System.out.println("子类初始化");
	}
}
