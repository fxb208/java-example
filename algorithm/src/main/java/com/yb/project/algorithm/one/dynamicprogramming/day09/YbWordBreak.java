package com.yb.project.algorithm.one.dynamicprogramming.day09;

import java.util.LinkedList;
import java.util.List;

/**
 * leetcode 139. 单词拆分
 * @author fxb20
 * 
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 * 
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/word-break
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class YbWordBreak {
	
	public static void main(String[] args) {
		String s="catsandog";
		List<String> wordDict=new LinkedList<String>();
		wordDict.add("cats");
		wordDict.add("dog");
		wordDict.add("sand");
		wordDict.add("and");
		wordDict.add("cat");
		YbWordBreak yb=new YbWordBreak();
		System.out.println(yb.wordBreak(s, wordDict));
	}
	
	/**
	 * @param s
	 * @param wordDict
	 * @return
	 */
    public boolean wordBreak(String s, List<String> wordDict) {
    	boolean[] dp=new boolean[s.length()+1];   //
    	dp[0]=true;
    	for(int i=0;i<s.length();i++) {
    		for(String str:wordDict) {
    			if(dp[i] && i+str.length()<=s.length() && str.equals(s.substring(i,i+str.length()))) {
    				dp[i+str.length()]=true;
    			}
    		}
    		
    	}
    	return dp[s.length()];
    }
    
 
 
}
