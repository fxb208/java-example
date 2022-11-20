package com.margo.project.jvm.loader;




import com.margo.project.jvm.loader.model.ClassResolveVO;
import com.margo.project.jvm.loader.model.SubClassResolveVO;
import org.junit.jupiter.api.Test;


/**
 * 类初始化时机
 * 1)使用new关键字实例化对象的时候
 * 	  读取或设置一个类的静态字段的时候（被final，已在编译期把结果放在常量池的静态字段除外）
 * 	  调用一个类的静态方法
 * 2)使用java.lang.reflect包的方法对类进行反射调用的时候，如果没有进行过初始化，则需要触发其初始化
 * 3)当初始化一个类的时候，如果发现其父类还没有初始化，则需要先触发其父类初始化
 * 4)虚拟机启动指定执行主类(main方法那个类)，虚拟机先初始化这个类
 * 5)
 * @author fxb208
 *
 */
public class MargoResolveClass {
	
	@Test
	public void newClassResolve () {
		ClassResolveVO classResolve=new ClassResolveVO();
		System.out.println(classResolve.getClass().getName()+"使用new关键字实例化对象的时候");
		System.out.println("#########-------------结束符------------##########");
	}
	
	/**
	 * 访问类或接口的静态变量
	 */
	//@Test
	public void staticField() {
		System.out.println(ClassResolveVO.intField);
		System.out.println(ClassResolveVO.stringField);
		System.out.println("#########-------------结束符------------##########");
	}
	
	/**
	 * 编译常量不会导致类的初始化
	 */
	//@Test
	public void staticFinalField() {
		System.out.println(ClassResolveVO.finalIntField);
		System.out.println(ClassResolveVO.finalStringField);
		System.out.println("#########-------------结束符------------##########");
	}
	
	/**
	 * 非编译时常亮会导致类的初始化
	 */
	//@Test
	public void staticFinalMethodField() {
		System.out.println(ClassResolveVO.b);
		System.out.println("#########-------------结束符------------##########");
	}
	
	/**
	 * 非编译时常量会导致类的初始化
	 */
	//@Test
	public void staticFinalStaticField() {
		System.out.println(ClassResolveVO.c);
		System.out.println("#########-------------结束符------------##########");
	}
	
	/**
	 * 触发父类初始化
	 */
	//@Test
	public void superClassStaticField() {
		System.out.println(SubClassResolveVO.intField);
		System.out.println("#########-------------结束符------------##########");
	}
	
	/**
	 * 触发父类初始化,子类初始化
	 */
	//@Test
	public void subClassStaticField() {
		System.out.println(SubClassResolveVO.age);
		System.out.println("#########-------------结束符------------##########");
	}
	
	/**
	 * 通过数组定义来引用类，不会触发此类的初始化
	 */
	//@Test
	public void arrayObject() {
		@SuppressWarnings("unused")
		SubClassResolveVO[] arrSubClassResolveVO=new SubClassResolveVO[10];
		System.out.println("#########-------------结束符------------##########");
	}
	
}
