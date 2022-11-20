package leetcode.od.sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * HJ14 字符串排序
 */
public class HJ14 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        String[] arr = new String[length];
        for(int i=0;i<length;i++){
            arr[i]=in.next();
        }
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
