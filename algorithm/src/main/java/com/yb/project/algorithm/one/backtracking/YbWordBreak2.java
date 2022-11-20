package com.yb.project.algorithm.one.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * leetcode 140. 单词拆分 II
 * @author fxb20
 * 
 * 给定一个字符串 s 和一个字符串字典 wordDict ，在字符串 s 中增加空格来构建一个句子，使得句子中所有的单词都在词典中。
 * 以任意顺序 返回所有这些可能的句子。
 * 注意：词典中的同一个单词可能在分段中被重复使用多次。
 * 
 * 示例 1：
 * 输入:s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
 * 输出:["cats and dog","cat sand dog"]
 */
public class YbWordBreak2 {
	
	public static void main(String[] args) {
		String s="leetcode";
		List<String> wordDict=new LinkedList<String>();
		wordDict.add("leet");
		wordDict.add("code");
		YbWordBreak2 yb=new YbWordBreak2();
		System.out.println(yb.wordBreak(s, wordDict));
	}
	
    public List<String> wordBreak(String s, List<String> wordDict) {
    	List<String> list=new LinkedList<String>();
    	ArrayList<String> path=new ArrayList<String>();
    	int max=0;
    	for(int j=0;j<wordDict.size();j++) {
    		max=Math.max(max, wordDict.get(j).length());
    	}
    	dfs(s,0,wordDict,list,path,max);
    	return list;
    }

    public void dfs(String s,int idx,List<String> wordDict,List<String> list,ArrayList<String> path,int max) {
    	if(idx==s.length()) {
    		StringBuilder sb=new StringBuilder();
    		for(int i=0;i<path.size();i++) {
    			sb.append(path.get(i)).append(" ");
    		}
    		list.add(sb.deleteCharAt(sb.length()-1).toString());
    		return;
    	}
    	StringBuilder sb=new StringBuilder();
    	for(int i=idx;i<s.length();i++) {
    		sb.append(s.charAt(i));
        	for(int j=0;j<wordDict.size();j++) {
        		if(sb.toString().equals(wordDict.get(j))) {
        			path.add(wordDict.get(j));
        			dfs(s,i+1,wordDict,list,path,max);
        			path.remove(path.size()-1);
        		}
        	}
    	}
    }
}
