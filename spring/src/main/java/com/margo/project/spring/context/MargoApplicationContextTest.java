package com.margo.project.spring.context;

import java.lang.reflect.Method;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * ApplicationContext重要的实现类  GenericApplicationContext
 * 
 * 1)GenericApplicationContext extends AbstractApplicationContext
 * 2)AbstractApplicationContext extends DefaultResourceLoader
 * 		implements ConfigurableApplicationContext
 * 3)ConfigurableApplicationContext implements extends ApplicationContext, Lifecycle, Closeable
 * @author fxb208
 *
 */
public class MargoApplicationContextTest {
	/**
	 * getParent
	 * getId
	 * getDisplayName
	 * getApplicationName
	 * getAutowireCapableBeanFactory
	 * getStartupDate
	 */
	
	public void applicationContext() {
		Class<ApplicationContext> cla=ApplicationContext.class;
		Method[] arrMethods=cla.getDeclaredMethods();
		for(Method method:arrMethods) {
			System.out.println(method.getName());
		}
	}
	
	/**
	 * registerShutdownHook
	 * close
	 * setParent
	 * setEnvironment
	 * getBeanFactory
	 * refresh
	 * isActive
	 * getEnvironment
	 * getEnvironment
	 * setId
	 * addBeanFactoryPostProcessor
	 * addApplicationListener
	 * addProtocolResolver
	 */
	@Test
	public void configurableApplicationContext() {
		Class<ConfigurableApplicationContext> cla=ConfigurableApplicationContext.class;
		Method[] arrMethods=cla.getDeclaredMethods();
		for(Method method:arrMethods) {
			System.out.println(method.getName());
		}
	}
}
