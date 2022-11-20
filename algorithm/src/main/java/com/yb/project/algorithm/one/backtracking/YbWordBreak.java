package com.yb.project.algorithm.one.backtracking;

import java.util.Deque;
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
		String s="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
		List<String> wordDict=new LinkedList<String>();
		wordDict.add("a");
		wordDict.add("aa");
		wordDict.add("aaa");
		wordDict.add("aaaa");
		wordDict.add("aaaaa");
		YbWordBreak yb=new YbWordBreak();
		System.out.println(yb.wordBreak(s, wordDict));
	}
	
    public boolean wordBreak(String s, List<String> wordDict) {
    	Deque<String> path=new LinkedList<String>();
    	boolean[] arr=new boolean[s.length()];  // 记录 [i...n-1] 是否可以拆分成单词
    	return dfs(s,0,wordDict,path,arr); 
    }
    
    public boolean dfs(String s,int idx,List<String> wordDict,Deque<String> path,boolean[] arr) {
    	if(idx==s.length()) {
    		return true;
    	}
    	if(arr[idx]==true) {
    		return false;
    	}
    	StringBuilder sb=new StringBuilder();
    	for(int i=idx;i<s.length();i++) {
    		sb.append(s.charAt(i));
        	for(int j=0;j<wordDict.size();j++) {
        		if(sb.toString().equals(wordDict.get(j))) {
        			path.addLast(wordDict.get(j));
        			if(dfs(s,i+1,wordDict,path,arr)) {
        				return true;
        			}else {
        				path.remove();
        			}
        			
        		}
        	}
        	
    	}
    	// 已经完整遍历 [start...n-1] 都无法拆分
    	arr[idx]=true;
    	return false;
    }
	

}
