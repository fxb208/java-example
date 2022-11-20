package com.yb.project.algorithm.one.nowcoder.page1;

import java.util.Scanner;

/**
 * HJ32 密码截取  最长回文子串
 * @author fxb20
 *
 */
public class YbHJ32 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		boolean[][] dp=new boolean[str.length()][str.length()];
		for(int i=0;i<str.length();i++) {
			dp[i][i]=true;
		}
		int length=1;
		int x=0;
		for(int len=1;len<str.length();len++) {  //字符串长度
			for(int i=0;i+len<str.length();i++) {  //j字符串下标
				if(str.charAt(i)==str.charAt(i+len)) {
					if(len==1 || dp[i+1][i+len-1]) {
						dp[i][len+i]=true;
						if(len+1>length) {
							x=i;
							length=len+1;
						}
					}
				}
			}
		}
		System.out.println(x);
		System.out.println(length);
		sc.close();
	}
}
