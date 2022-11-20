package com.yb.project.algorithm.one.nowcoder.exam1;

import java.util.ArrayList;
import java.util.List;

/**
 * 两个素数之积
 * @author fxb208
 *
 */
public class Exam1 {
	
	public static void main(String[] args) {
		//System.out.println(Integer.MAX_VALUE);
		//Scanner sc=new Scanner(System.in);
		Integer input=707829217;
		List<Integer> lst=new ArrayList<Integer>();
		lst.add(2);
		//找出所有素数
		for(int i=3;i<=input/2;i++) {
			boolean contains=true;
			for(int k=0;k<lst.size();k++) {
				int j=lst.get(k);
				if(i%j==0) {
					contains=false;
					break;
				}
			}
			if(contains) {
				lst.add(i);
			}
		}
		int a=-1;
		int b=-1;
		//每个素数取余
		for(int i=0;i<lst.size();i++) {
			int m=lst.get(i);
			if(input%m==0) { //整除
				int n=input/m;
				if(lst.contains(n)) {
					a=m;
					b=n;
					break;
				}
			}
		}
		System.out.println(a+" "+b);
	}
	
//	/**
//	 * 2147483647
//	 * @param args
//	 */
//	public static void main(String[] args) {
//	    StringBuilder sb = new StringBuilder();
//        int num=180;
//        int minPrimeNumber = 2;// 定义最小的质数
//        while (minPrimeNumber < num) {
//            if (num % minPrimeNumber == 0) {
//                num = num / minPrimeNumber;
//                sb.append(minPrimeNumber + "*");
//            } else {
//                minPrimeNumber++;
//            }
//        }
//        sb.append(minPrimeNumber);
//        System.out.println(sb.toString());
//	}
}
