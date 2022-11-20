package com.margo.project.spring.context;

import java.lang.reflect.Method;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * 
 * 1)DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory
 * 		implements ConfigurableLisableBeanFactory,BeanDefinitionRegistry, Serializable
 * 
 * 2)AbstractAutowireCapableBeanFactory extends AbstractBeanFactory
 * 			implements AutowireCapableBeanFactory
 * 
 * 3)AbstractBeanFactory implements ConfigurableBeanFactory
 * 
 * 4)ConfigurableListableBeanFactory
		extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory
 * @author fxb208
 *
 */
public class MargoBeanFactoryTest {

	/**
	 * getType
	 * getAliases
	 * getBean
	 * getBean
	 * getBean
	 * getBean
	 * getBean
	 * isSingleton
	 * containsBean
	 * isTypeMatch
	 * isTypeMatch
	 * isPrototype
	 */
	public void beanFactory() {
		Class<BeanFactory> cla=BeanFactory.class;
		
		Method[] arrMethod=cla.getDeclaredMethods();
		for(Method method:arrMethod) {
			System.out.println(method.getName());
		}
	}
	
	/**
	 * getBeansOfType
	 * getBeansOfType
	 * getBeanDefinitionCount
	 * findAnnotationOnBean
	 * getBeanNamesForType
	 * getBeanNamesForType
	 * getBeanNamesForType
	 * getBeanDefinitionNames
	 * getBeanNamesForAnnotation
	 * containsBeanDefinition
	 * getBeansWithAnnotation
	 */
	public void listableBeanFactory() {
		Class<ListableBeanFactory> cla=ListableBeanFactory.class;
		Method[] arrMethod=cla.getDeclaredMethods();
		for(Method method:arrMethod) {
			System.out.println(method.getName());
		}
	}
	
	/**
	 * resolveNamedBean
	 * autowireBean
	 * destroyBean
	 * autowire
	 * initializeBean
	 * configureBean
	 * createBean
	 * createBean
	 * applyBeanPostProcessorsBeforeInitialization
	 * applyBeanPostProcessorsAfterInitialization
	 * autowireBeanProperties
	 * applyBeanPropertyValues
	 */
	//@Test
	public void autowireCapableBeanFactory() {
		Class<AutowireCapableBeanFactory> cla=AutowireCapableBeanFactory.class;
		Method[] arrMethod=cla.getDeclaredMethods();
		for(Method method:arrMethod) {
			System.out.println(method.getName());
		}
	}
	
	/**
	 * setParentBeanFactory
	 * setBeanClassLoader
	 * setTempClassLoader
	 * getTempClassLoader
	 * setCacheBeanMetadata
	 * isCacheBeanMetadata
	 * getBeanExpressionResolver
	 * setConversionService
	 * getBeanClassLoader
	 * getConversionService
	 * addPropertyEditorRegistrar
	 * setBeanExpressionResolver
	 * registerCustomEditor
	 * copyRegisteredEditorsTo
	 * addEmbeddedValueResolver
	 * setCurrentlyInCreation
	 * registerDependentBean
	 * getAccessControlContext
	 * getMergedBeanDefinition
	 * copyConfigurationFrom
	 * getRegisteredScope
	 * destroyScopedBean
	 * getRegisteredScopeNames
	 * addBeanPostProcessor
	 * getDependentBeans
	 * getBeanPostProcessorCount
	 * isCurrentlyInCreation
	 * destroySingletons
	 * hasEmbeddedValueResolver
	 * resolveEmbeddedValue
	 * getDependenciesForBean
	 * registerScope
	 * destroyBean
	 * setTypeConverter
	 * getTypeConverter
	 * resolveAliases
	 * registerAlias
	 * isFactoryBean
	 */
	//@Test
	public void configurableBeanFactory() {
		Class<ConfigurableBeanFactory> cla=ConfigurableBeanFactory.class;
		Method[] arrMethod=cla.getDeclaredMethods();
		for(Method method:arrMethod) {
			System.out.println(method.getName());
		}
	}
	
	/**
	 * getBeanDefinition
	 * ignoreDependencyInterface
	 * isAutowireCandidate
	 * registerResolvableDependency
	 * getBeanNamesIterator
	 * freezeConfiguration
	 * ignoreDependencyType
	 * clearMetadataCache
	 * isConfigurationFrozen
	 * preInstantiateSingletons

	 */
	@Test
	public void configurableListableBeanFactory() {
		Class<ConfigurableListableBeanFactory> cla=ConfigurableListableBeanFactory.class;
		Method[] arrMethod=cla.getDeclaredMethods();
		for(Method method:arrMethod) {
			System.out.println(method.getName());
		}
	}
}
