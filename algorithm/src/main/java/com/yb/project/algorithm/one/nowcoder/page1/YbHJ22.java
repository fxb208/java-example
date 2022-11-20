package com.yb.project.algorithm.one.nowcoder.page1;

import java.util.Scanner;

/**
 * 汽水瓶
 * @author fxb20
 *
 */
public class YbHJ22 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int[] arr=new int[10];
		int i=sc.nextInt();
		arr[0]=i;
		int length=0;
		while(i>0 && length<10) {
			arr[length]=i;
			length++;
			i=sc.nextInt();			
		}
		for(int j=0;j<length;j++) {
			System.out.println(YbHJ22.hj22(arr[j]));
		}
		sc.close();
	}

	
	public static int hj22(int size) {
		int i=size/3;
		int j=size%3;
		int sum=i;
		int temp=0;
		while(i+j>=3) {	
			temp=(i+j)/3;
			j=(i+j)%3;
			i=temp;
			sum=sum+temp;
		}
		if(i+j==2) {
			sum=sum+1;
		}
		return sum;
	}
}
