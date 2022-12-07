package leetcode.od3.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 125. 验证回文串
 * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。
 * 则可以认为该短语是一个 回文串 。
 * 字母和数字都属于字母数字字符。
 * 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
 */
public class Leetcode125 {
    public static void main(String[] args) {
        Leetcode125 yb = new Leetcode125();
        System.out.println(yb.isPalindrome("A man, a plan, a canal: Panama"));
    }

    public boolean isPalindrome(String s) {
        List<Character> lst = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch) || Character.isLowerCase(ch)){
                lst.add(ch);
            }else if(Character.isUpperCase(ch)){
                lst.add(Character.toLowerCase(ch));
            }
        }
        int left = 0;
        int right = lst.size()-1;
        while(left<right){
            if(lst.get(left)!=lst.get(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
