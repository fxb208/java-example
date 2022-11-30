package leetcode.od2.math;

/**
 * 50. Pow(x, n)
 *
 * 实现 pow(x, n) ，即计算 x 的整数 n 次幂函数（即，xn ）。
 */
public class Leetcode50 {
    public static void main(String[] args) {
        Leetcode50 yb = new Leetcode50();
        System.out.println(yb.myPow_d(2,-2));;
        System.out.println(yb.myPow(2.7,3));;
        System.out.println(Math.pow(0.00001,Integer.MAX_VALUE));
        System.out.println(Math.pow(0.00001,Integer.MIN_VALUE));
        System.out.println(Math.pow(1.1,Integer.MAX_VALUE));
        System.out.println(Math.pow(1.1,Integer.MIN_VALUE));
    }

    public double myPow_d(double x, int n) {
        if(n==0){
            return 1;
        }
        boolean bool = n>0;
        if(bool){
            n=-n;
        }
        double res = 1;
        double xc = x;
        while(n<-1){
            if(n%2==-1){
                res *=xc;
            }
            xc*=xc;
            n=n/2;
        }
        if(bool){
            return res*xc;
        }else{
            return 1/(res*xc);
        }
    }

    public double myPow(double x, int n) {
        if(n==0){
            return 1;
        }
        if(n==1){
            return x;
        }
        if(n==-1){
            return 1/x;
        }
        double half = myPow(x,n/2);
        double left = myPow(x,n%2);
        return half*half*left;
    }
}
