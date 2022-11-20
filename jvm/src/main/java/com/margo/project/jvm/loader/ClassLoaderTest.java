package com.margo.project.jvm.loader;


import com.margo.project.jvm.loader.model.ClassForName;
import org.junit.jupiter.api.Test;


/**
 * java.net.URLClassLoader@5d3892b3
 * https://www.jianshu.com/p/554c138ca0f5
 * https://www.jianshu.com/p/ebdf0eb76088
 * 自定义类加载器
 * 	不要轻易覆盖 loadClass 方法。否则可能会导致自定义加载器无法加载内置的核心类库。
 * 在使用自定义加载器时，要明确好它的父加载器是谁，将父加载器通过子类的构造器传入。
 * 如果父类加载器是 null，那就表示父加载器是「根加载器」。
 * 
 * @author fangxingbang
 * 
 * ClassLoader抽象类
 * 
 * 面试题：在Java的反射中，Class.forName和ClassLoader的区别
 *
 */
public class ClassLoaderTest{
	
//	/**
//	 * 继承ClassLoader类，重写findClass方法
//	 */
//    protected Class<?> findClass(String name) throws ClassNotFoundException {
//        throw new ClassNotFoundException(name);
//    }
    
	
	/**
	 * Class.forName加载类会初始化
	 * jdbc使用Class.forName("com.mysql.jdbc.Driver")
	 */
	
	@Test
	public void classForNameTest() {
		try {
			// 不会执行构造函数
			Class.forName(ClassForName.class.getName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("#########-------------结束符------------##########");
	}
	
	//@Test
	public void classTest() {	
		Class<ClassForName> t=ClassForName.class; //不会初始化
		System.out.println("#########-------------分割符------------##########");
		try {
			t.newInstance();  //初始化执行静态方法
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**
	 * ClassLoader加载类不会初始化
	 */
	//@Test
	public void classLoaderTest() {
		try {
			ClassLoader.getSystemClassLoader().loadClass(ClassForName.class.getName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("#########-------------结束符------------##########");
	}
	
	/**
	 * 启动类加载器 BootStrap ClassLoader
	 * 扩展类加载器 ExtClassLoader
	 * 应用程序类加载器 AppClassLoader
	 * 
	 * 返回类的类加载器。一些实现可能会使用   null表示引导类加载器。
	 * 这个方法会返回   如果此类由引导程序加载，则在此类实现中为null   类加载器
	 */
	@SuppressWarnings("restriction")
	//@Test
	public void classLoader() {
		ClassLoader loader=ClassLoader.getSystemClassLoader();
		System.out.println(loader.toString());
		System.out.println(loader.getParent().toString());
		System.out.println(loader.getParent().getParent());
		//抛出异常 loader.getParent().getParent()为null
		//System.out.println(loader.getParent().getParent().toString());
		System.out.println("自定义类加载器："+ClassForName.class.getClassLoader()); //应用程序类加载器
		//System.out.println("Launcher类加载器："+sun.misc.Launcher.class.getClassLoader()); //null，启动类加载器
		System.out.println("String类加载器："+String.class.getClassLoader());  //null，启动类加载器
	}
    
}
