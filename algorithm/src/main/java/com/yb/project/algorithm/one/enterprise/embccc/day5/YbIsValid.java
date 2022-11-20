package com.yb.project.algorithm.one.enterprise.embccc.day5;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 输入：s = "([)]"
 * 输出：false
 * 
 * 输入：s = "{[]}"
 * 输出：true
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author fxb20
 *
 */
public class YbIsValid {
    public boolean isValid(String s) {
    	Deque<Character> stack=new LinkedList<Character>();
    	for(int i=0;i<s.length();i++) {
    		char m=s.charAt(i);
    		if(m=='(' || m=='[' || m=='{') {
    			stack.push(m);
    		}else {
    			Character n=stack.poll();
    			if(n==null) {
    				return false;
    			}
    			if((n=='(' && m==')') || (n=='[' && m==']') || (n=='{' && m=='}')) {
    				continue;
    			}
    			return false;
    		}
    		
    	}
    	return stack.size()==0;
    }
}
