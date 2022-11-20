package com.yb.project.algorithm.one.nowcoder.page1;

import java.util.Arrays;
import java.util.Scanner;

public class YbHJ14 {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int length=Integer.parseInt(in.nextLine());
		if(length<1) {
			in.close();
			return;
		}
		String[] arrStr=new String[length];
		for(int i=0;i<length;i++) {
			arrStr[i]=in.nextLine();
		}
		Arrays.sort(arrStr);
		for(int i=0;i<length;i++) {
			System.out.println(arrStr[i]);
		}
		in.close();
		
		
	}
}
