package com.margo.project.designpattern.proxy;

import java.lang.reflect.Proxy;
import java.util.Optional;

/**
 * 	动态代理
 * 	
 * @author fangxingbang
 *
 */
public class ChildrenFactory {
	public static void main(String[] args) {

		Woman woman = (Woman) Proxy.newProxyInstance(Woman.class.getClassLoader(), new Class[] {Woman.class},
				new WomanProxy<Object>(new WomanImpl()));
		woman.getGirl();	
	}
}
