package com.margo.project.jvm.loader;



import com.margo.project.jvm.loader.model.SupplyResolveVO;
import org.junit.jupiter.api.Test;

public class SupplyResolveClass {

	/**
	 * 外部类初始化不会触发静态内部类初始化
	 */
	//@Test
	public void staticInnerClass() {
		System.out.println(SupplyResolveVO.name);
		System.out.println("#########-------------结束符------------##########");
	}
	
	/**
	 * 静态内部类初始化
	 */
	@Test
	public void staticInnerClassResolve() {
		SupplyResolveVO.staticMethod();
		System.out.println("#########-------------结束符------------##########");
	}
}
