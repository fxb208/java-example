package com.yb.project.algorithm.one.nowcoder.page1;

import java.util.Scanner;

/**
 *  求int型正整数在内存中存储时1的个数
 * @author fxb20
 * 
 * 19934318
 *
 */
public class YbHJ15 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int i=sc.nextInt();
		int result=0;
//		i=i>>1;
//		while(i>=1) {
//			result++;
//			i=i>>1;
//		}
//		System.out.println(result);
		
		String str=Integer.toBinaryString(i);
		for(int j=0;j<str.length();j++) {
			if(str.charAt(j)=='1') {
				result++;
			}
		}
		System.out.println(result);
		sc.close();
	}
}
