package com.yb.project.algorithm.one.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * leecode 3. 无重复字符的最长子串
 * @author fxb20
 * 
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * 
 * 输入: s = "abcabcbb"
 * 输出: 3 
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class YbLengthOfLongestSubstring {
	public static void main(String[] args) {
		YbLengthOfLongestSubstring yb=new YbLengthOfLongestSubstring();
		System.out.println(yb.lengthOfLongestSubstring("pwwkew"));
	}
	
    public int lengthOfLongestSubstring(String s) {
    	int result=0;  //长度
    	int k=0; //窗口长度

    	Map<Character,Integer> map=new HashMap<Character,Integer>();
  
    	
    	for(int i=0;i<s.length();i++) {
    		char c=s.charAt(i);
    		if(!map.containsKey(c)) {
    			if(result==k && result==map.size()) {
    		    	k++;
    		    	result++;
    			}
    			map.put(c, i);
    		}else {
    			Integer index=map.get(c);
    			map.clear();
    			for(int j=index+1;j<=i;j++) {
    				map.put(s.charAt(j),j);
    			}
    		}	
    	}
    	return result;
    }

}
