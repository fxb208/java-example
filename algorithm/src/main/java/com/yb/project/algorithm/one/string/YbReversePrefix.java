package com.yb.project.algorithm.one.string;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * leetcode 2000. 反转单词前缀
 * @author fxb20
 * 给你一个下标从 0 开始的字符串 word 和一个字符 ch 。找出 ch 第一次出现的下标 i ，
 * 反转 word 中从下标 0 开始、直到下标 i 结束（含下标 i ）的那段字符。如果 word 中不存在字符 ch ，
 * 则无需进行任何操作。
 * 
 * 例如，如果 word = "abcdefd" 且 ch = "d" ，那么你应该 反转 从下标 0 开始、直到下标 3 结束（含下标 3 ）。
 * 结果字符串将会是 "dcbaefd" 。返回 结果字符串 。
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/reverse-prefix-of-word
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class YbReversePrefix {
	
	public static void main(String[] args) {
		YbReversePrefix yb=new YbReversePrefix();
		String word= "xyxzxe";
		char ch = 'z';
		System.out.println(yb.reversePrefix(word, ch));
	}
	
    public String reversePrefix(String word, char ch) {
    	int idx=-1;
    	for(int i=0;i<word.length();i++) {
    		if(word.charAt(i)==ch) {
    			idx=i;
    			break;
    		}
    	}
//    	StringBuilder sb=new StringBuilder(idx);
//    	if(idx>0) {
//    		for(int i=idx;i>=0;i--) {
//    			sb.append(word.charAt(i));
//    		}
//    		return sb.toString()+word.substring(idx+1, word.length());
//    	}
    	
    	if(idx>0) {
    		char[] sb=new char[idx+1];
    		int j=0;
    		for(int i=idx;i>=0;i--) {
    			sb[j]=word.charAt(i);
    			j++;
    		}
    		return new String(sb)+word.substring(idx+1, word.length());
    	}
    	return word;
    }
	
    public String reversePrefix1(String word, char ch) {
    	Deque<Character> deque=new ArrayDeque<Character>();
    	int idx=-1;
    	for(int i=0;i<word.length();i++) {
    		if(word.charAt(i)==ch) {
    			idx=i;
    			break;
    		}else {
    			deque.push(word.charAt(i));
    		}
    		
    	}
    	StringBuffer sb=new StringBuffer();
    	if(idx>0) {
    		while(deque.peek() !=null) {
    			sb.append(deque.pop());
    		}
    		return word.charAt(idx)+sb.toString()+word.substring(idx+1, word.length());
    	}
    	return word;
    }
}
