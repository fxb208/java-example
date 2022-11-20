package com.margo.project.jvm.loader;


import org.junit.jupiter.api.Test;

public class MargoClassLoaderTest {

	@Test
	public void classLoaderTest() {
		String path="C:/Users/fxb20/git/margo-java-base/margo-jvm/target/classes";
		MargoClassLoader classLoader=new MargoClassLoader(path);
		try {
			Class<?> cla=classLoader.loadClass("com.margo.project.jvm.loader.model.ClassForName");

			Object obj=cla.newInstance();
			System.out.println("MargoClassLoader:"+cla.getClassLoader());
			System.out.println("object classLoader:"+obj.getClass().getClassLoader());
			System.out.println("MargoClassLoader parent:"+classLoader.getParent());
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("#########-------------结束符------------##########");
	}
}
