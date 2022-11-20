package leetcode.od.basics;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * HJ3 明明的随机数
 */
public class HJ3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        Set<Integer> set = new TreeSet<>();
        for(int i=0;i<len;i++){
            set.add(in.nextInt());
        }
        for(int i:set){
            System.out.println(i);
        }
    }
}
