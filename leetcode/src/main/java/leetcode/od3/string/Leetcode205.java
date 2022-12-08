package leetcode.od3.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 205. 同构字符串
 * 给定两个字符串 s 和 t ，判断它们是否是同构的。
 * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。
 * 不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 */
public class Leetcode205 {
    public static void main(String[] args) {
        String str ="paper";
        for(int i=0;i<str.length();i++){
            System.out.println((int)str.charAt(i));
        }

        String str2 ="title";
        for(int i=0;i<str2.length();i++){
            System.out.println((int)str2.charAt(i));
        }

    }

    public boolean isIsomorphic(String s, String t) {
        if(s.length() !=t.length()){
            return false;
        }
        Map<Character,Character> map1 = new HashMap<>();
        Map<Character,Character> map2 = new HashMap<>();
        for(int i=0;i<s.length();i++){
            Character key1 = s.charAt(i);
            Character key2 = t.charAt(i);
            if(map1.containsKey(key1)){
                if(!map1.get(key1).equals(key2)){
                    return false;
                }
            }else if(map2.containsKey(key2)){
                if(!map2.get(key2).equals(key1)){
                    return false;
                }
            }else{
                map1.put(key1,key2);
                map2.put(key2,key1);
            }
        }
        return true;
    }
}
