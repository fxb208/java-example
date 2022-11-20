package leetcode.od.general;

import java.util.Scanner;

/**
 * HJ108 求最小公倍数
 *
 * 正整数A和正整数B 的最小公倍数是指 能被A和B整除的最小的正整数值，设计一个算法，求输入A和B的最小公倍数。
 *
 * 数据范围：1 \le a,b \le 100000 \1≤a,b≤100000
 */
public class HJ108 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int a = in.nextInt();
            int b = in.nextInt();
            int c=a*b;
            if(a>b){
                System.out.println(c/gcd(a,b));
            }else{
                System.out.println(c/gcd(b,a));
            }

        }
    }

    public static int gcd(int a,int b){
        return a%b==0?b:gcd(b,a%b);
    }
}
