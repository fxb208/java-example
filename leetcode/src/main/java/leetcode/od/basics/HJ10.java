package leetcode.od.basics;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * HJ10 字符个数统计
 */
public class HJ10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<Character,Integer> map = new HashMap<>();
        String text = in.next();
        for(int i=0;i<text.length();i++){
            map.put(text.charAt(i),map.getOrDefault(text.codePointAt(i),0)+1);
        }
        System.out.println(map.keySet().size());
    }
}
