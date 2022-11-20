package com.yb.project.algorithm.one.nowcoder.page1;

import java.math.BigDecimal;
import java.util.Scanner;

public class YbHJ07 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		BigDecimal big=new BigDecimal(str);
		System.out.println(big.setScale(0, BigDecimal.ROUND_HALF_UP).intValue());
		
		System.out.println(big.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
		sc.close();
	}

}
