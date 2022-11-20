package com.yb.project.algorithm.one.enterprise.embccc.day6;

/**
 * leetcode 5. 最长回文子串
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
		System.out.println(yb.longestPalindrome("cbbd"));
	}
	
    public String longestPalindrome(String s) {
    	int n=s.length();
    	boolean[][] dp=new boolean[n][n];
    	for(int i=0;i<n;i++) {
    		dp[i][i]=true;
    	}
    	int begin=0;
    	int length=1;
    	for(int i=1;i<n;i++) {
    		for(int j=0;i+j<n;j++) {
    			if(s.charAt(j)==s.charAt(i+j)) {
    				if(i==1) {
    					dp[j][i+j]=true;
    				}else {
    					if(dp[j+1][i+j-1]) {
    						dp[j][i+j]=true;
    					}
    				}
    				if(dp[j][i+j] && i+1>length) {
    					begin=j;
    					length=i+1;
    				}
    			}else {
					dp[j][i+j]=false;
    			}
    		}
    	}
    	return s.substring(begin,begin+length);
    }
}
