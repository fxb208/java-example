package com.margo.project.spring.bean.factorybean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * MargoBean margoBean=context.getBean(MargoBean.class);
 * BeanFactory中包含了MargoBean对象， spring整合mybatis,MapperFactoryBean实现getObject方法中
 * getSqlSession().getMapper(this.mapperInterface)，生成代理对象然后交给ioc容器管理
 * 
 * @author fxb208
 *
 */
@Component
public class MargoFactoryBean implements FactoryBean<MargoBean>{

	@Override
	public MargoBean getObject() throws Exception {
		return new MargoBean();
	}

	@Override
	public Class<?> getObjectType() {
		return MargoBean.class;
	}

}
