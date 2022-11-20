package com.yb.project.algorithm.one.dynamicprogramming;

/**
 * leecode 5. 最长回文子串
 * @author fxb20
 * 
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 *
 */
public class YbLongestPalindrome {
	
	public static void main(String[] args) {
		YbLongestPalindrome yb=new YbLongestPalindrome();
		//"xaabacxcabaax"
		String result=yb.longestPalindrome("上海自来水来自海上");
		System.out.println("result:"+result);
	}

	public String longestPalindrome(String s) {
		if(s==null || s.length()<0) {
			return "";
		}
		int start=0;
		int maxLength=1;
		boolean[][] dp =new boolean[s.length()][s.length()];
		for(int i=0;i<s.length();i++) {
			dp[i][i]=true;
		}
		//字符串长度
		for(int i=1;i<s.length();i++) {
			//字符串下表
			for(int j=0;i+j<s.length();j++) {
				if(s.charAt(j)==s.charAt(j+i) && i==1) {
					dp[j][i+j]=true;
					if(i+1>maxLength) {
						maxLength=i+1;
						start=j;
					}
				}else if(s.charAt(j)==s.charAt(j+i) && dp[j+1][j+i-1]) {
					dp[j][i+j]=true;
					if(i+1>maxLength) {
						maxLength=i+1;
						start=j;
					}
				}		
			}
		}
		return s.substring(start, start+maxLength);
	}
}
