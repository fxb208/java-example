package com.yb.project.algorithm.one.nowcoder.page1;

import java.util.Scanner;

public class YbHJ04 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		int len=0;
		for(int i=0;i+8<str.length();i=i+8) {
			System.out.println(str.substring(i,i+8));
			len=len+8;
		}
		
		String last=str.substring(len);
		for(int j=last.length();j<8;j++) {
			last=last+"0";
		}
		System.out.println(last);
		sc.close();
	}
}
