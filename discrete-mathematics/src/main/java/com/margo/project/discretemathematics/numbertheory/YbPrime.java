package com.margo.project.discretemathematics.numbertheory;

import java.util.LinkedList;
import java.util.List;

/**
 * 质素因子
 * @author fxb20
 *
 */
public class YbPrime {
	public static void main(String[] args) {
		List<Integer> lst=new LinkedList<Integer>();
		YbPrime yb=new YbPrime();
		yb.ybPrime(2000000014, lst);
		lst.forEach(e->{
			System.out.println(e);
		});
	}
	
	public void ybPrime(int num,List<Integer> lst) {
		long n=(long)Math.sqrt(num);
		for(int i=2;i<=n;i++) {
			while (num % i == 0) {
				lst.add(i);
	            num /= i;
	        }
		}
		if(num !=1) {
			lst.add(num);	
		}
		
	}
	
	public void ybPrime0(int num,List<Integer> lst) {
		for(int i=2;i<=num;i++) {
			if(num%i==0) {
				lst.add(i);
				ybPrime0(num/i,lst);
				break;
			}
			if(i==num) {
				lst.add(i);
			}
		}
	}
}
