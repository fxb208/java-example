package com.yb.project.algorithm.one.nowcoder.page1;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * HJ38 求小球落地5次后所经历的路程和第5次反弹的高度
 * @author fxb20
 * 
 * 描述
 * 假设一个球从任意高度自由落下，每次落地后反跳回原高度的一半; 再落下, 求它在第5次落地时，共经历多少米?第5次反弹多高？
 * 
 * 输入描述：
 * 输入起始高度，int型
 * 
 * 输出描述：
 * 分别输出第5次落地时，共经过多少米以及第5次反弹多高。
 * 注意：你可以认为你输出保留六位或以上小数的结果可以通过此题。
 *
 */
public class YBHJ38 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int hight=sc.nextInt();
		BigDecimal src=new BigDecimal(hight);
		BigDecimal half=new BigDecimal(2);
		BigDecimal result=new BigDecimal(0);
		for(int i=0;i<5;i++) {
			result=result.add(src);
			src=src.divide(half);
			if(i<4) {
				result=result.add(src);	
			}
		}
		System.out.println(result.setScale(6, BigDecimal.ROUND_HALF_UP).doubleValue());
		System.out.println(src.setScale(6, BigDecimal.ROUND_HALF_UP).doubleValue());
		sc.close();
				
	}
}
