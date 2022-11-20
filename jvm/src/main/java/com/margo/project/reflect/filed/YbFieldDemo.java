package com.margo.project.reflect.filed;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;




/**
 * 1)getField返回public属性，包括从父类继承的public属性
 * 2)getDeclaredField返回类本身定义的属性，包括public,private,protected
 * @author fxb208
 *
 */
public class YbFieldDemo {
	
	@Test
	public void getField() {
		/**
		 * 获取所有public修饰的属性，包括父类
		 */
		Field[] arrFiled=YbFiledVO.class.getFields();
		for(Field field:arrFiled) {
			System.out.println(field.getName());//name,mother
		}
	}
	
	//@Test
	public void getDeclaredFields() {
		/**
		 * 获取所有属性，不包括父类
		 */
		Field[] arrFiled=YbFiledVO.class.getDeclaredFields();
		for(Field field:arrFiled) {
			System.out.println(field.getName());//name,age,cup
		}
	}
	
}
