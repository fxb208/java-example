package com.yb.project.algorithm.one.backtracking.partition;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author fxb20
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 * 回文串 是正着读和反着读都一样的字符串。
 * 
 * 示例 1：
 * 
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/palindrome-partitioning
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class YbPartition {
	
	public static void main(String[] args) {
		System.out.println("1234".substring(0,1));
		YbPartition yb=new YbPartition();
		System.out.println(yb.partition("a"));
		
		
	}
	
    public List<List<String>> partition(String s) {
    	int n=s.length();
    	//最长回文字串
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
    	List<List<String>> result=new ArrayList<List<String>>();
    	List<String> path=new ArrayList<String>();
    	backtrack(result,path,dp,0,s);
    	return result;
    }
    
    public void backtrack(List<List<String>> result,List<String> path,boolean[][] dp,int idx,String s) {
    	if(idx==s.length()) {
    		result.add(new ArrayList<String>(path));
    		return;
    	}
		for(int j=idx;j<s.length();j++) {
			if(dp[idx][j]) {
				path.add(s.substring(idx,j+1));
				backtrack(result,path,dp,j+1,s);
				path.remove(path.size()-1);
			}
		}
    	
    	
    }
    
}
