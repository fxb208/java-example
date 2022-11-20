package com.yb.project.algorithm.one.nowcoder.page1;

import java.util.Scanner;

/**
 * 合唱队，类似leecode 300. 最长递增子序列
 * 
 * https://blog.csdn.net/weixin_42886699/article/details/121182003
 * @author fxb20
 *
 */
public class YbHJ24 {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int length=sc.nextInt();
		int[] list=new int[length];
		for(int i=0;i<length;i++) {
			list[i]=sc.nextInt();
		}
//		int[] list=new int[] {
//				16,103,132,23,211,75,155,82,32,48,79,183,13,91,51,172,109,102,189,121,12,120,116,133,79,120,116,208,47,110,65,187,69,143,140,173,203,35,184,49,245,50,179,63,204,34,218,11,205,100,90,19,145,203,203,215,72,108,58,198,95,116,125,235,156,133,220,236,125,29,235,170,130,165,155,54,127,128,204,62,59,226,233,245,46,3,14,108,37,94,52,97,159,190,143,67,24,204,39,222,245,233,11,80,166,39,224,12,38,13,85,21,47,25,180,219,140,201,11,42,110,209,77,136
//		};
//		int[] list=new int[] {123,124,125,123,121};
		System.out.println(YbHJ24.chorus(list));
		sc.close();
	}

	public static int chorus(int[] list) {
		int n=list.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0]=1;
        for(int i=1;i<n;i++) {
        	left[i]=1;
        	for(int j=0;j<i;j++) {
        		if(list[j]<list[i]) {
        			left[i]=Math.max(left[j]+1, left[i]);
        		}
        	}
        }

       for(int i=n-1;i>=0;i--) {
    	   right[i]=0;
    	   for(int j=n-1;j>i;j--) {
    		   if (list[j] < list[i]) {
    			   right[i] = Math.max(right[j] + 1, right[i]);
    		   }
                   
    	   }
    	   
       }
        int[] dp=new int[n];
        for(int i=0;i<dp.length;i++) {
        	dp[i]=left[i]+right[i];
        }
		int max=1;
		for(int i=1;i<dp.length;i++) {
			if(dp[i]>max) {
				max=dp[i];
			}
		}
		return n-max;
	}
}
