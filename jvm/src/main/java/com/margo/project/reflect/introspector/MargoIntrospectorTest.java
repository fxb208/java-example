package com.margo.project.reflect.introspector;

import org.junit.jupiter.api.Test;

import java.beans.BeanDescriptor;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.MethodDescriptor;
import java.beans.PropertyDescriptor;
import java.util.Arrays;



/**
 * 	https://segmentfault.com/a/1190000019810277
 * java内省
 * @author fangxingbang
 *
 */
public class MargoIntrospectorTest {
	
	/**
	 * Mybatis框架有用到 PropertyDescriptor
	 * @throws IntrospectionException
	 */
	//@Test
	public void propertyDescriptorTest() throws IntrospectionException {
		PropertyDescriptor age = new PropertyDescriptor("age", MargoIntrospectorVO.class);
		System.out.println(age.getPropertyType()); // class java.lang.Integer
		System.out.println(age.getDisplayName()); // age

		// 最重要的两个方法~~~
		// public int com.margo.project.reflect.introspector.MargoIntrospectorVO.getAge()
		System.out.println(age.getReadMethod()); 
		// public void com.margo.project.reflect.introspector.MargoIntrospectorVO.setAge(int)
		System.out.println(age.getWriteMethod()); // 
	}
	
	@Test
	public void beanInfoTest() throws IntrospectionException {
		BeanInfo beanInfo = Introspector.getBeanInfo(MargoIntrospectorVO.class);
		
		BeanDescriptor beanDescriptor = beanInfo.getBeanDescriptor();
        MethodDescriptor[] methodDescriptors = beanInfo.getMethodDescriptors();
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        
        // 打印
        System.out.println(beanDescriptor);
        System.out.println("------------------------------");
        Arrays.stream(methodDescriptors).forEach(x -> System.out.println(x));
        System.out.println("------------------------------");
        Arrays.stream(propertyDescriptors).forEach(x -> System.out.println(x));
        System.out.println("------------------------------");
	}
}
