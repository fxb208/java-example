package leetcode.od2.dindow;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class Leetcode3 {
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0){
            return 0;
        }
        Set<Character> set = new HashSet<>();
        set.add(s.charAt(0));
        int left=0;
        int right=0;
        int res = 1;
        while(right<s.length()-1){
            right++;
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            res=Math.max(res,set.size());
        }
        return res;
    }
}
