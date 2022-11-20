package com.margo.project.sysn.atomic;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

/**
 * https://blog.csdn.net/hezuideda/article/details/45132229
 * 1)java.lang.SecurityException: Unsafe
 * 2)getField和getDeclaredField
 * @author fxb208
 *
 */
public class MargoUnsafe {
	
	
	/**
	 * getDeclaredField
	 * @return
	 */
	public static Unsafe getUnsafe() {
		try {
			//Field field=cla.getField("theUnsafe");
			Field field=Unsafe.class.getDeclaredField("theUnsafe");
			field.setAccessible(true);
			return (Unsafe)field.get(null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
