package leetcode.od.stack;

import java.util.LinkedList;

/**
 * NC52 有效括号序列
 */
public class NC52 {
    public static void main(String[] args) {
        NC52 yb = new NC52();
        yb.isValid("()");
    }

    /**
     *
     * @param s string字符串
     * @return bool布尔型
     */
    public boolean isValid (String s) {
        // write code here
        boolean res = true;
        LinkedList<Character> lst = new LinkedList<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='[' || s.charAt(i)=='{'){
                lst.add(s.charAt(i));
            }else{
                if(lst.size() ==0){
                    res = false;
                    break;
                }
                char ch = lst.pollLast();
                if(s.charAt(i)=='(' && ch !=')'){
                    res = false;
                    break;
                }
                if(s.charAt(i)=='[' && ch !=']'){
                    res = false;
                    break;
                }
                if(s.charAt(i)=='{' && ch !='}'){
                    res = false;
                    break;
                }
            }
        }
        if(res && lst.size()>0){
            res = false;
        }
        return res;
    }
}
