package com.yb.project.algorithm.one.nowcoder.page1;

import java.util.Scanner;

/**
 * ucyfsmg
 * zuixhuhyjgksyhqkjqxwylkoubykjxtcvkyqjpzgltbemmbmqibxxqpkgbvwbmjotixanvciibubglizmumcrjavakiygyuv
 * 
 * @author fxb20
 *
 */
public class YbHJ52 {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str1=sc.nextLine();
		String str2=sc.nextLine();
		int[][] dp=new int[str1.length()+1][str2.length()+1];
		for(int i=0;i<dp.length;i++) {
			dp[i][0]=i;
		}
		for(int i=0;i<dp[0].length;i++) {
			dp[0][i]=i;
		}
		for(int i=1;i<=str1.length();i++) {
			for(int j=1;j<=str2.length();j++) {
				if(str1.charAt(i-1)==str2.charAt(j-1)) {
					dp[i][j]=dp[i-1][j-1];
				}else {
					dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i - 1][j - 1]), dp[i][j - 1]) + 1;
				}
			}
		}
		int maxlength=dp[str1.length()][str2.length()];  //23
		System.out.println(maxlength);
		sc.close();
	}
}
