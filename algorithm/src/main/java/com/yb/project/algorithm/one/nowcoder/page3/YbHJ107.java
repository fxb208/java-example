package com.yb.project.algorithm.one.nowcoder.page3;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * 二分法求解立方根
 * @author fxb20
 *
 */
public class YbHJ107 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		BigDecimal big=sc.nextBigDecimal();
		sc.close();
		BigDecimal abs=big.abs(); 
		BigDecimal one=new BigDecimal(1);
		
		if(abs.compareTo(one)<0) {
			BigDecimal min=abs;
			BigDecimal max=one;
			while (max.compareTo(min)>0) {
				BigDecimal mid=max.add(min).divide(new BigDecimal(2));
				BigDecimal result=mid.multiply(mid).multiply(mid);
				if(result.compareTo(abs)>0) {
					max=mid;
				}else if(result.compareTo(abs)<0){
					min=mid;
				}else {
					double d=mid.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
					if(big.compareTo(new BigDecimal(0))>0) {
						System.out.println(d);	
					}else {
						System.out.println(0-d);	
					}
					
					return;
				}
				if(result.subtract(abs).abs().compareTo(new BigDecimal("0.01"))<0) {
					double d=mid.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
					if(big.compareTo(new BigDecimal(0))>0) {
						System.out.println(d);	
					}else {
						System.out.println(0-d);	
					}
					return;
				}		
			}
		}else {
			BigDecimal min=new BigDecimal(0);
			BigDecimal max=abs;
			while (max.compareTo(min)>0) {
				BigDecimal mid=max.add(min).divide(new BigDecimal(2));
				BigDecimal result=mid.multiply(mid).multiply(mid);
				if(result.compareTo(abs)>0) {
					max=mid;
				}else if(result.compareTo(abs)<0){
					min=mid;
				}else {
					double d=mid.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
					if(big.compareTo(new BigDecimal(0))>0) {
						System.out.println(d);	
					}else {
						System.out.println(0-d);	
					}
					return;
				}
				if(result.subtract(abs).abs().compareTo(new BigDecimal("0.01"))<0) {
					double d=mid.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
					if(big.compareTo(new BigDecimal(0))>0) {
						System.out.println(d);	
					}else {
						System.out.println(0-d);	
					}
					return;
				}	
			
			}	
		}
		
		

	}
}
