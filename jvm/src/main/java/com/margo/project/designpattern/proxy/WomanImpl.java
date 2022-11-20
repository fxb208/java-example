package com.margo.project.designpattern.proxy;

/**
 *  	代理接口
 * @author fangxingbang
 *
 */
public class WomanImpl implements Woman{

	@Override
	public void getGirl() {
		// TODO Auto-generated method stub
		System.out.println("女孩");
	}

	@Override
	public void getBoy() {
		// TODO Auto-generated method stub
		System.out.println("男孩");
	}

}
