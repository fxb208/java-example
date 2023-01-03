package leetcode.od3;

/**
 * 343. 整数拆分
 *
 * 给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。
 * 返回 你可以获得的最大乘积 。
 */
public class Leetcode343 {
    public int integerBreak(int n) {
        if(n==1){
            return 0;
        }
        if(n==2){
            return 1;
        }
        if(n==3){
            return 4;
        }
        return numBreak(n);
    }

    public int numBreak(int n) {
        if(n==1 || n==2 || n==3){
            return n;
        }
        int middle1 = n/2;
        int middle2=middle1;
        if(n%middle1==1){
            middle2=n-middle2;
        }
        return Math.max(numBreak(middle1)*numBreak(middle2),numBreak(middle1-1)*numBreak(middle2+1));
    }

}
