package com.margo.project.spring.bean.wrapper;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;

import org.junit.Test;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.PropertyValue;

import com.margo.project.spring.bean.wrapper.model.MargoGirl;

/**
 * Spring提供
 * BeanWrapper
 * PropertyValue
 * 
 * jdk提供
 * PropertyDescriptor
 * @author fangxingbang
 *
 */
public class BeanWrapperTest {
	
	@Test
	public void beanWrapper() {
		BeanWrapper bean=new BeanWrapperImpl(MargoGirl.class);
		bean.setPropertyValue(new PropertyValue("age", 28));
		bean.setPropertyValue("name", "margo");
		String name = (String) bean.getPropertyValue("name");
		System.out.println(name);
		MargoGirl margoGirl=(MargoGirl)bean.getWrappedInstance();//
		System.out.println(margoGirl.getName());
	}
	
	
	public void beanWrapperObject() {
		BeanWrapper bean=new BeanWrapperImpl(MargoGirl.class);
		MargoGirl margoGirl=(MargoGirl)bean.getWrappedInstance();
		System.out.println(margoGirl.getAge());
	}
	
	//@Test
	public void propertyDescriptor() throws IntrospectionException {
		//报错
		//PropertyDescriptor propertyDescriptor=new PropertyDescriptor("name", String.class);
		PropertyDescriptor propertyDescriptor=new PropertyDescriptor("name", MargoGirl.class);
		System.out.println(propertyDescriptor.getName());   //name
		System.out.println(propertyDescriptor.getPropertyType().getName()); //java.lang.String
		System.out.println(propertyDescriptor.getReadMethod().getName()); //  getName
	}
}
