package com.yb.project.algorithm.one.nowcoder.page1;

import java.util.Scanner;

public class YbHJ01 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        String input = in.nextLine();
		int result=YbHJ01.lastStr(input);
		System.out.println(result);
		in.close();
	}
	
	public static int lastStr(String str) {
		int length=str.length();
		int index=0;
		for(int i=length-1;i>=0;i--) {
			if(str.charAt(i)==' ') {
				break;
			}
			index++;
		}
		return index;
		
	}
}
