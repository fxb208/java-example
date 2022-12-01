package leetcode.od2.map;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 621. 任务调度器
 *
 * 给你一个用字符数组 tasks 表示的 CPU 需要执行的任务列表。其中每个字母表示一种不同种类的任务。
 * 任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。在任何一个单位时间，CPU 可以完成一个任务，或者处于待命状态。
 * 然而，两个 相同种类 的任务之间必须有长度为整数 n 的冷却时间，
 * 因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
 * 你需要计算完成所有任务所需要的 最短时间 。
 */
public class Leetcode621 {
    public static void main(String[] args) {
        Leetcode621 yb = new Leetcode621();
        System.out.println(yb.leastInterval(new char[]{'A','A','A','B','B','B'},2));
    }

    public int leastInterval(char[] tasks, int n) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<tasks.length;i++){
            map.put(tasks[i],map.getOrDefault(tasks[i],0)+1);
        }
        PriorityQueue<Map.Entry<Character,Integer>> queue =
                new PriorityQueue<>((o1, o2) -> {return o2.getValue()-o1.getValue();});
        queue.addAll(map.entrySet());

        int res = 0;
        int fact = tasks.length;
        Queue<Map.Entry<Character,Integer>> lst = new LinkedList<>();
        while(!queue.isEmpty()){
            Map.Entry<Character,Integer> entry = queue.poll();
            res++;
            if(!entry.getKey().equals('1')){
                fact--;
            }
            entry.setValue(entry.getValue()-1);
            lst.add(entry);
            if(lst.size()>n){
                Map.Entry<Character,Integer> temp = lst.poll();
                if(temp.getValue()>0){
                    queue.add(temp);
                }
            }
            while(queue.isEmpty() && fact>0){
                queue.add(new Map.Entry<Character, Integer>() {
                    int val=1;

                    @Override
                    public Character getKey() {
                        return '1';
                    }

                    @Override
                    public Integer getValue() {
                        return val;
                    }

                    @Override
                    public Integer setValue(Integer value) {
                        return val=value;
                    }
                });
            }
        }
        return res;
    }
}
