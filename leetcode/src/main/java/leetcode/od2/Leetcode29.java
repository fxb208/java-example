package leetcode.od2;

/**
 * 29. 两数相除
 *
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 */
public class Leetcode29 {
    public static void main(String[] args) {
        Leetcode29 yb = new Leetcode29();
         // 2147483647   -2147483648
//        System.out.println(Integer.MAX_VALUE); // 2147483647
//        System.out.println(Integer.MIN_VALUE); // -2147483648
//        System.out.println(Math.abs(Integer.MIN_VALUE)); //
//        System.out.println(Math.abs(-111111));
        System.out.println(yb.divide(7,-3));
    }

    public int divide(int dividend, int divisor) {
        if(divisor==1){
            return dividend;
        }
        if(divisor==-1){
            if(dividend==Integer.MIN_VALUE){
                return Integer.MAX_VALUE;
            }else{
                return -dividend;
            }
        }

        int res = 0;
        boolean bool = (dividend>0 && divisor>0) || (dividend<0 && divisor<0);
        if(dividend>0){
            dividend = -dividend;
        }
        if(divisor>0){
            divisor = -divisor;
        }

        while(dividend<=divisor){
            dividend-=divisor;
            if(res==Integer.MAX_VALUE && bool==false){
                return Integer.MIN_VALUE;
            }
            res++;
        }
        if(bool){
            return res;
        }
        return -res;
    }
}
