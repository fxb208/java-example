package com.yb.project.algorithm.one.nowcoder.page1;


import java.util.Scanner;

/**
 * 统计字符
 * @author fxb20
 * 统计其中英文字符，空格字符，数字字符，其他字符的个数
 *
 */
public class YbHJ40 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		int m=0;
		int n=0;
		int b=0;
		int v=0;
		for(int i=0;i<str.length();i++) {
			if(Character.isLetter(str.charAt(i))) {
				m++;
			}else if(str.charAt(i)==' ') {
				n++;
			}else if(Character.isDigit(str.charAt(i))) {
				b++;
			}else {
				v++;
			}
		}
		System.out.println(m);
		System.out.println(n);
		System.out.println(b);
		System.out.println(v);
		sc.close();
	}
}
