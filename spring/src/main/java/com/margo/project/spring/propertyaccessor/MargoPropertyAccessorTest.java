package com.margo.project.spring.propertyaccessor;

import org.junit.Test;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.ConfigurablePropertyAccessor;
import org.springframework.beans.PropertyAccessorFactory;

/**
 * 	快速获取PropertyAccessor两个重要实现类的工厂
 * 		BeanWrapperImpl
 * 		DirectFieldAccessor
 * @author fangxingbang
 *
 */
public class MargoPropertyAccessorTest {

	@Test
	public void propertyAccessorFactoryTest() {
		//BeanWrapperImpl需要set，get方法
		MargoSizeVO margoSizeVO=new MargoSizeVO();
		BeanWrapper beanWrapper = PropertyAccessorFactory.forBeanPropertyAccess(margoSizeVO);
		//请保证对应字段有set方法才行，否则抛错：Does the parameter type of the setter match the return type of the getter?
        beanWrapper.setPropertyValue("height", 20); 
        beanWrapper.setPropertyValue("width", 10);
        System.out.println(margoSizeVO);
        
        
        //DirectFieldAccessor 不需要set，get方法
        MargoPropertyAccessorVO propertyAccess=new MargoPropertyAccessorVO();
		ConfigurablePropertyAccessor configurablePropertyAccessor = PropertyAccessorFactory
				.forDirectFieldAccess(propertyAccess);
		 // 设置普通属性
		configurablePropertyAccessor.setPropertyValue("color", "红色"); 
		configurablePropertyAccessor.setPropertyValue("size.height", 10);
		System.out.println(propertyAccess);
	}
}
