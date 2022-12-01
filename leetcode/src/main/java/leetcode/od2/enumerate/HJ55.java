package leetcode.od2.enumerate;

import java.util.Scanner;

/**
 * HJ55 挑7
 *
 * 描述
 * 输出 1到n之间 的与 7 有关数字的个数。
 * 一个数与7有关是指这个数是 7 的倍数，或者是包含 7 的数字（如 17 ，27 ，37 ... 70 ，71 ，72 ，73...）
 * 数据范围： 1 \le n \le 30000 \1≤n≤30000
 * 输入描述：
 * 一个正整数 n 。( n 不大于 30000 )
 * 输出描述：
 * 一个整数，表示1到n之间的与7有关的数字个数。
 */
public class HJ55 {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int num = in.nextInt();
        int num = 20;
        int res = 0;
        for(int i=1;i<=num;i++){
            if(String.valueOf(i).indexOf("7")>-1 || i%7==0){
                res++;
            }
        }
        System.out.println(res);
    }
}
