package com.yb.project.algorithm.one.nowcoder.page1;

import java.util.Scanner;

/**
 * 进制转换
 * @author fxb20
 *
 */
public class YbHJ05 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String line=sc.nextLine();
		int result=Integer.parseInt(line.substring(2), 16);
		System.out.println(result);
		sc.close();
	}
}
