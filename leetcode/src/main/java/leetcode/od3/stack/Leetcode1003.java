package leetcode.od3.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 1003. 检查替换后的词是否有效
 * 给你一个字符串 s ，请你判断它是否 有效 。
 * 字符串 s 有效 需要满足：假设开始有一个空字符串 t = "" ，你可以执行 任意次 下述操作将 t 转换为 s ：
 * 将字符串 "abc" 插入到 t 中的任意位置。
 * 形式上，t 变为 tleft + "abc" + tright，其中 t == tleft + tright 。
 * 注意，tleft 和 tright 可能为 空 。
 * 如果字符串 s 有效，则返回 true；否则，返回 false。
 */
public class Leetcode1003 {
    public static void main(String[] args) {
        Leetcode1003 yb = new Leetcode1003();
        System.out.println(yb.isValid("aabcbc"));
    }

    public boolean isValid(String s) {
        Deque<Character> deque = new LinkedList<>();
        for(int i=0;i<s.length();i++){
            if(i<s.length()-2){
                if(!"abc".equals(s.substring(i,i+3))){
                    if('c'==s.charAt(i)){
                        if(deque.size()<2 || deque.pollLast() != 'b' || deque.pollLast() != 'a'){
                            return false;
                        }
                    }else{
                        deque.addLast(s.charAt(i));
                    }

                }else{
                    i+=2;
                }
            }else{
                if('c'==s.charAt(i)){
                    if(deque.size()<2 || deque.pollLast() != 'b' || deque.pollLast() != 'a'){
                        return false;
                    }
                }else{
                    deque.addLast(s.charAt(i));
                }
            }
        }
        if(deque.size()>0){
            return false;
        }
        return true;
    }
}
