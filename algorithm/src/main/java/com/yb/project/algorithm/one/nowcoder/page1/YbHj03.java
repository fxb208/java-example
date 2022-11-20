package com.yb.project.algorithm.one.nowcoder.page1;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * 
 * @author fxb20
 *
 */
public class YbHj03 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int length=sc.nextInt();
		TreeSet<Integer> set=new TreeSet<Integer>();
		for(int i=0;i<length;i++) {
			set.add(sc.nextInt());
		}
		for(Integer i:set) {
			System.out.println(i);
		}
		sc.close();
	}
}
