package leetcode.youdao;

/**
 * 69. x 的平方根
 * https://leetcode.cn/problems/sqrtx/
 */
public class YbMySqrt {

    public static void main(String[] args) {
        YbMySqrt yb = new YbMySqrt();
        System.out.println(yb.mySqrt(2147395599));
    }

    public int mySqrt(int x) {
         long result = bs(x,1,x/2);
         if(result * result >x){
             return (int)result -1;
         }
         return (int)result;
    }
    public long bs(int x,int begin,int end){
        if(begin >= end){
            return begin;
        }
        long middle = (begin+end)/2;
        if(middle * middle == x){
            return middle;
        }else if(middle * middle > x){
            return bs(x,begin,(int)middle-1);
        }else{
            return bs(x,(int)middle+1,end);
        }
    }
}