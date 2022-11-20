package com.margo.project.jvm.type;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;



/**
 * dubble进度丢失
 * @author fangxingbang
 *
 */
public class DoubleTest {
	
	@Test
	public void doubleTest() {
		double priceA=0.3;
		double priceB=0.2;
		System.out.println(priceA-priceB);  //0.09999999999999998
	}
	
	//@Test
	public void doublTest() {
		//这种还是会丢失精度
		//BigDecimal priceA=new BigDecimal(0.3);
		BigDecimal priceA=new BigDecimal("0.3");
		BigDecimal priceB=new BigDecimal("0.2");
		System.out.println(priceA.subtract(priceB));  //0.1
	}
	
}
