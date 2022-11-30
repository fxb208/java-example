package leetcode.od2.math;

import java.util.Scanner;

/**
 * HJ107 求解立方根
 */
public class HJ107 {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        // 注意 hasNext 和 hasNextLine 的区别
//        while (in.hasNextInt()) { // 注意 while 处理多个 case
//            int a = in.nextInt();
//            int b = in.nextInt();
//            System.out.println(a + b);
//        }
//        Math.sqrt(12);
//        Math.cbrt(12);
        System.out.println(myCbrt(0.7));
        System.out.println(Math.cbrt(0.7));
    }


    public static double myCbrt(double d){
        boolean bool = d>0;
        if(d<0){
            d = -d;
        }
        double res = 1;
        if(d>1){
            double left = 1;
            double right = d;
            while(right-left>0.0001){
                double middle = (left+right)/2;
                if(middle*middle*middle==d){
                    res = middle;
                    break;
                }if(middle*middle*middle>d){
                    right = middle;
                }else{
                    left = middle;
                }
            }
            res = left;
        }else{
            double left = 0;
            double right = 1;
            while(right-left>0.0001){
                double middle = (left+right)/2;
                if(middle*middle*middle==d){
                    res = middle;
                    break;
                }if(middle*middle*middle>d){
                    right = middle;
                }else{
                    left = middle;
                }
            }
            res = left;
        }
        if(bool){
           return (double)Math.round(res*10)/10;
        }
        return -(double)Math.round(res*10)/10;
    }

}
