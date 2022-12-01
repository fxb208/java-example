package leetcode.od2.map;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

/**
 * 767. 重构字符串
 *
 * 给定一个字符串 s ，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 * 返回 s 的任意可能的重新排列。若不可行，返回空字符串 "" 。
 */
public class Leetcode767 {
    public static void main(String[] args) {
        Leetcode767 yb = new Leetcode767();
        System.out.println(yb.reorganizeString("aaab"));
    }

    public String reorganizeString(String s) {
        Map<Character,Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Character,Integer>> queue =
                new PriorityQueue<>((o1, o2) -> {return o2.getValue()-o1.getValue();});
        for(int i=0;i<s.length();i++){
            char key = s.charAt(i);
            map.put(key,map.getOrDefault(key,0)+1);
        }
        queue.addAll(map.entrySet());
        StringBuilder sb = new StringBuilder();

        Queue<Map.Entry<Character,Integer>> lst = new LinkedList<>();
        while(!queue.isEmpty()){
            Map.Entry<Character,Integer> entry = queue.poll();
            sb.append(entry.getKey());
            entry.setValue(entry.getValue()-1);
            lst.offer(entry);
            if(lst.size()>1){
                Map.Entry<Character,Integer> temp = lst.poll();
                if(temp.getValue()>0){
                    queue.add(temp);
                }
            }
        }
        String res = sb.toString();
        return res.length()==s.length()?res:"";
    }
}
