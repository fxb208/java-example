package com.margo.project.jvm.loader;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

/**
 * 使用双亲委派模型，Java类随着它的加载器一起具备了一种带有优先级的层次关系，通过这种层次模型，可以避免类的重复加载，
 * 	也可以避免核心类被不同的类加载器加载到内存中造成冲突和混乱，从而保证了Java核心库的安全
 * @author fxb20
 *
 */
public class MargoClassLoader extends ClassLoader {

	private final String root;

	public MargoClassLoader(String root) {
		super();
		this.root = root;
	}
	
    protected Class<?> loadClass(String name, boolean resolve)
            throws ClassNotFoundException
        {
            synchronized (getClassLoadingLock(name)) {
                // First, check if the class has already been loaded
                Class<?> c = findLoadedClass(name);
                if (c == null) {
                    c = firstFindClass(name);              	
                    if (c == null) {
                    	c=super.loadClass(name, false);
                    }
                }
                if (resolve) {
                    resolveClass(c);
                }
                return c;
            }
        }
    
	/**
	 * 继承ClassLoader类，重写findClass方法
	 */
	protected Class<?> firstFindClass(String className) throws ClassNotFoundException {

		byte[] classData = null;
		try {
			String fileName = root + File.separatorChar + className.replace('.', File.separatorChar) + ".class";
			File file = new File(fileName);
			classData = FileUtils.readFileToByteArray(file);
		} catch (IOException e) {
			System.out.println("类加载报错:"+e.getMessage());
			return null;
		}
		//根据字节数组，返回Class对象
		return defineClass(className, classData, 0, classData.length);
	}

	/**
	 * 继承ClassLoader类，重写findClass方法
	 */
	protected Class<?> findClass(String className) throws ClassNotFoundException {

		byte[] classData = loadClassData(className);
		if (classData == null) {
			throw new ClassNotFoundException(className);
		}
		//根据字节数组，返回Class对象
		return defineClass(className, classData, 0, classData.length);
	}

	private byte[] loadClassData(String className) {
		// TODO Auto-generated method stub
		byte[] classData = null;
		try {
			String fileName = root + File.separatorChar + className.replace('.', File.separatorChar) + ".class";
			File file = new File(fileName);
			classData = FileUtils.readFileToByteArray(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return classData;
	}

}
