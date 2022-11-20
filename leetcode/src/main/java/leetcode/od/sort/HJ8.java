package leetcode.od.sort;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * 合并表记录
 */
public class HJ8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        Map<Integer,Integer> map =new TreeMap<>();
        int length = in.nextInt();
        for(int i=0;i<length;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            map.put(a,map.getOrDefault(a,0)+b);
        }

        for(Integer key:map.keySet()){
            System.out.println(key+" "+map.get(key));
        }
    }
}
