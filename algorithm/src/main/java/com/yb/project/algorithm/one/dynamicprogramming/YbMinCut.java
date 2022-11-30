package com.yb.project.algorithm.one.dynamicprogramming;

/**
 * leetcode 剑指 Offer II 094. 最少回文分割
 * @author fxb20
 *
 * 给定一个字符串 s，请将 s 分割成一些子串，使每个子串都是回文串。
 * 返回符合要求的 最少分割次数 。
 * 
 * 输入：s = "aab"
 * 输出：1
 * 解释：只需一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
 */
public class YbMinCut {
	
	public static void main(String[] args) {
		YbMinCut yb=new YbMinCut();
		String s="abcc";
		System.out.println(yb.minCut(s));
	}
	
	
	/**
	 * dp[i]是回文字串+ s.subString(i,j)是回文字串，最小值
	 * @param s
	 * @return
	 */
    public int minCut(String s) {
    	int n=s.length();
    	int[] result=new int[n+1];
    	result[0]=0;
    	for(int i=1;i<n;i++) {
    		result[i]=i;
    	}
    	boolean[][] dp=new boolean[n][n];
    	for(int i=0;i<n;i++) {
    		dp[i][i]=true;
    	}
    	for(int i=1;i<n;i++) {
    		for(int j=0;i+j<n;j++) {
    			if(s.charAt(j)==s.charAt(i+j)) {
    				if(i==1) {
    					dp[j][i+j]=true;
    				}else if(dp[j+1][i+j-1]) {
    					dp[j][i+j]=true;
    				}	
    			}
    		}
    	}
    	for(int i=1;i<n;i++) {
    		for(int j=0;j<=i;j++) {
    			if(dp[j][i]) {
    				if(j==0) {
    					result[i]=0;
    					break;
    				}else {
    					result[i]=Math.min(result[j-1]+1, result[i]);
    				}
    				
    			}
    		}
    	}
    	return result[n-1];
    }

	/**
	 * dp[i]是回文字串+ s.subString(i,j)是回文字串，最小值
	 * @param s
	 * @return
	 */
	public int minCut_(String s) {
		int n=s.length();
		int[] result=new int[n+1];
		result[0]=0;
		for(int i=1;i<n;i++) {
			result[i]=i;
		}
		boolean[][] dp=new boolean[n][n];
		for(int i=0;i<n;i++) {
			dp[i][i]=true;
		}
		for(int i=1;i<n;i++) {
			for(int j=0;i+j<n;j++) {
				if(s.charAt(j)==s.charAt(i+j)) {
					if(i==1) {
						dp[j][i+j]=true;
					}else if(dp[j+1][i+j-1]) {
						dp[j][i+j]=true;
					}
				}
			}
		}
		for(int i=0;i<n;i++){
			for(int j=n-1;j>=i;j--){
				if(dp[i][j]){

				}
			}
		}

		for(int i=1;i<n;i++) {
			for(int j=0;j<=i;j++) {
				if(dp[j][i]) {
					if(j==0) {
						result[i]=0;
						break;
					}else {
						result[i]=Math.min(result[j-1]+1, result[i]);
					}

				}
			}
		}
		return result[n-1];
	}
}
