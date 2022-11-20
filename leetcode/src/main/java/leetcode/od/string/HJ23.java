package leetcode.od.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *  HJ23 删除字符串中出现次数最少的字符
 */
public class HJ23 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String text = in.next();
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<text.length();i++){
            char ch = text.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int min = Integer.MAX_VALUE;
        for(int count:map.values()){
            min=Math.min(min,count);
        }
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<text.length();i++){
            char ch = text.charAt(i);
            if(map.get(ch)>min){
                sb.append(ch);
            }
        }
        System.out.println(sb.toString());
    }
}
