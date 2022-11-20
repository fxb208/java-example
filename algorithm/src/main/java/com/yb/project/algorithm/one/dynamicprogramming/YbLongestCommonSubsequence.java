package com.yb.project.algorithm.one.dynamicprogramming;

/**
 * leecode 1143 最长公共子序列
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 * @author fxb20
 *
 */
public class YbLongestCommonSubsequence {
	
	public static void main(String[] args) {
		YbLongestCommonSubsequence longestCommonSubsequence=new YbLongestCommonSubsequence();
		
//		String text1 = "abcde";
//		String text2 = "ace";
		
		String text1="zikwvkijajpkaicihcffiemzexmwjjlyrylxcuoewdmpivudhmgkuodjaurazdjnlgtpwz";
		String text2 ="wpnmubqfsnmapqpufmmsphqehjplwjkqspnnpywsvvjilxbcfsrygbelquaalenvkruyltiwqcpdrxgstywaja";
		
		System.out.println(text1.charAt(0)==text2.charAt(0));
		
		System.out.println(longestCommonSubsequence.longestCommonSubsequence(text1, text2));
	}

	public int longestCommonSubsequence(String text1, String text2) {
		int r=text1.length();
		int c=text2.length();
		int[][] dp=new int[r+1][c+1];
		for(int i=0;i<dp.length;i++) {
			dp[i][0]=0;
		}
		for(int i=0;i<dp[0].length;i++) {
			dp[0][i]=0;
		}
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(text1.charAt(i)==text2.charAt(j)) {
					dp[i+1][j+1]=dp[i][j]+1;
				}else {
					dp[i+1][j+1]=max(dp[i+1][j],dp[i][j+1]);
				}
			}
		}
		return dp[r][c];
	}
	
	public int max(int a,int b){
        if(a>b){
            return a;
        }else {
            return b;
        }
    }
}
