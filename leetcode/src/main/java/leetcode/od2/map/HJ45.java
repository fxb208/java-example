package leetcode.od2.map;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * HJ45 名字的漂亮度
 *
 * 给出一个字符串，该字符串仅由小写字母组成，定义这个字符串的“漂亮度”是其所有字母“漂亮度”的总和。
 * 每个字母都有一个“漂亮度”，范围在1到26之间。没有任何两个不同字母拥有相同的“漂亮度”。字母忽略大小写。
 * 给出多个字符串，计算每个字符串最大可能的“漂亮度”。
 * 本题含有多组数据。
 */
public class HJ45 {

    /**
     * 2
     * zhangsan
     * lisi
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = Integer.parseInt(in.nextLine());
        String[] arr = new String[len];
        int[] res = new int[len];
        for(int i=0;i<len;i++){
            arr[i]=in.nextLine();
        }
        for(int i=0;i<len;i++){
            String str = arr[i];
            Map<Character,Integer> map = new HashMap<>();
            for(int j=0;j<str.length();j++){
                Character key = Character.toLowerCase(str.charAt(j));
                map.put(key,map.getOrDefault(key,0)+1);
            }
            PriorityQueue<Integer> queue =
                    new PriorityQueue<>((o1, o2) -> {return o2- o1;});
            queue.addAll(map.values());
            int unit = 26;
            while(!queue.isEmpty()){
                int num = queue.poll();
                res[i]+=(unit*num);
                unit--;
            }
        }
        for(int i=0;i<len;i++){
            System.out.println(res[i]);
        }
    }
}
