package leetcode.od3.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 451. 根据字符出现频率排序
 * 给定一个字符串 s ，根据字符出现的 频率 对其进行 降序排序 。
 * 一个字符出现的 频率 是它出现在字符串中的次数。
 * 返回 已排序的字符串 。如果有多个答案，返回其中任何一个。
 */
public class Leetcode451 {
    public static void main(String[] args) {
        Leetcode451 yb = new Leetcode451();
        yb.frequencySort("tree");
    }

    public String frequencySort(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        Set<Map.Entry<Character,Integer>> set = map.entrySet();
        Map.Entry<Character,Integer>[] arr = new Map.Entry[map.size()];
        int idx = 0;
        for(Map.Entry<Character,Integer> entry : set){
            arr[idx]=entry;
            idx++;
        }
        Arrays.sort(arr,(o1, o2) -> {return o2.getValue()-o1.getValue();});
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<arr.length;i++){
            char key = arr[i].getKey();
            int val = arr[i].getValue();
            while(val>0){
                sb.append(key);
                val--;
            }
        }
        return sb.toString();
    }
}
