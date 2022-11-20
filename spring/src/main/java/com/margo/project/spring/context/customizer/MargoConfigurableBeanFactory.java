package com.margo.project.spring.context.customizer;

import java.beans.PropertyEditor;
import java.security.AccessControlContext;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.TypeConverter;
import org.springframework.beans.factory.BeanDefinitionStoreException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanExpressionResolver;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.config.Scope;
import org.springframework.core.ResolvableType;
import org.springframework.core.convert.ConversionService;
import org.springframework.util.StringValueResolver;

/**
 * Configurable 结构的，可配置的;
 * @author fxb208
 *
 */
public class MargoConfigurableBeanFactory implements ConfigurableBeanFactory{

	@Override
	public BeanFactory getParentBeanFactory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean containsLocalBean(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object getBean(String name) throws BeansException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getBean(String name, Object... args) throws BeansException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T getBean(Class<T> requiredType) throws BeansException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T getBean(Class<T> requiredType, Object... args) throws BeansException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean containsBean(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSingleton(String name) throws NoSuchBeanDefinitionException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isPrototype(String name) throws NoSuchBeanDefinitionException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isTypeMatch(String name, ResolvableType typeToMatch) throws NoSuchBeanDefinitionException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isTypeMatch(String name, Class<?> typeToMatch) throws NoSuchBeanDefinitionException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Class<?> getType(String name) throws NoSuchBeanDefinitionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getAliases(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void registerSingleton(String beanName, Object singletonObject) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object getSingleton(String beanName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean containsSingleton(String beanName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String[] getSingletonNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getSingletonCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getSingletonMutex() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setParentBeanFactory(BeanFactory parentBeanFactory) throws IllegalStateException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setBeanClassLoader(ClassLoader beanClassLoader) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ClassLoader getBeanClassLoader() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setTempClassLoader(ClassLoader tempClassLoader) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ClassLoader getTempClassLoader() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCacheBeanMetadata(boolean cacheBeanMetadata) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isCacheBeanMetadata() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setBeanExpressionResolver(BeanExpressionResolver resolver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BeanExpressionResolver getBeanExpressionResolver() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setConversionService(ConversionService conversionService) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ConversionService getConversionService() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addPropertyEditorRegistrar(PropertyEditorRegistrar registrar) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registerCustomEditor(Class<?> requiredType, Class<? extends PropertyEditor> propertyEditorClass) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void copyRegisteredEditorsTo(PropertyEditorRegistry registry) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTypeConverter(TypeConverter typeConverter) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TypeConverter getTypeConverter() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addEmbeddedValueResolver(StringValueResolver valueResolver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean hasEmbeddedValueResolver() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String resolveEmbeddedValue(String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getBeanPostProcessorCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void registerScope(String scopeName, Scope scope) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String[] getRegisteredScopeNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Scope getRegisteredScope(String scopeName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccessControlContext getAccessControlContext() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void copyConfigurationFrom(ConfigurableBeanFactory otherFactory) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registerAlias(String beanName, String alias) throws BeanDefinitionStoreException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resolveAliases(StringValueResolver valueResolver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BeanDefinition getMergedBeanDefinition(String beanName) throws NoSuchBeanDefinitionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isFactoryBean(String name) throws NoSuchBeanDefinitionException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setCurrentlyInCreation(String beanName, boolean inCreation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isCurrentlyInCreation(String beanName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void registerDependentBean(String beanName, String dependentBeanName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String[] getDependentBeans(String beanName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getDependenciesForBean(String beanName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void destroyBean(String beanName, Object beanInstance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroyScopedBean(String beanName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroySingletons() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <T> ObjectProvider<T> getBeanProvider(Class<T> requiredType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> ObjectProvider<T> getBeanProvider(ResolvableType requiredType) {
		// TODO Auto-generated method stub
		return null;
	}

}
