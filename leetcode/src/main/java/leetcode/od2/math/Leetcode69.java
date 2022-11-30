package leetcode.od2.math;

/**
 * 剑指 Offer II 072. 求平方根
 *
 * 给定一个非负整数 x ，计算并返回 x 的平方根，即实现 int sqrt(int x) 函数。
 * 正数的平方根有两个，只输出其中的正数平方根。
 * 如果平方根不是整数，输出只保留整数的部分，小数部分将被舍去。
 */
public class Leetcode69 {
    public static void main(String[] args) {
        Leetcode69  yb = new Leetcode69();
        System.out.println(yb.mySqrt(1));
    }

    public int mySqrt(int x) {
        long left = 0;
        long right = x;
        while(left<right){
            long middle = (left+right)/2;
            if(middle*middle==x){
                return (int)middle;
            }else if(middle*middle>x){
                right=middle-1;
            }else{
                left=middle+1;
            }
        }
        if(left*left>x){
            return (int)left-1;
        }
        return (int)left;
    }
}
