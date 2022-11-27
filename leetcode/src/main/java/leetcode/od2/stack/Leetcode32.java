package leetcode.od2.stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 32. 最长有效括号
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 */
public class Leetcode32 {
    public int longestValidParentheses(String s) {
        Deque<Character> lst = new LinkedList<>();
        int res = 0;
        int left = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                lst.push('(');
            }else{
                if(lst.peekLast()!=null && lst.peekLast()=='('){
                    lst.poll();
                    left +=2;
                    res = Math.max(left,res);
                }else{
                    left=0;
                    lst.clear();
                }
            }
        }
        int right = 0;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)=='('){
                lst.push('(');
            }else{
                if(lst.peekLast()!=null && lst.peekLast()=='('){
                    lst.poll();
                    left +=2;
                    res = Math.max(left,res);
                }else{
                    left=0;
                    lst.clear();
                }
            }
        }
        return res;
    }
}
