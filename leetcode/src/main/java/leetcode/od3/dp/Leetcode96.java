package leetcode.od3.dp;

/**
 * 96. 不同的二叉搜索树
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？
 * 返回满足题意的二叉搜索树的种数。
 */
public class Leetcode96 {
    public static void main(String[] args) {
        Leetcode96 yb = new Leetcode96();
        System.out.println(yb.numTrees(4));
    }

    public int numTrees(int n) {
        if(n==0 || n==1){
            return 1;
        }
        int[] dp = new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            for(int j=0;j<i;j++){
                dp[i]+=(dp[j]*dp[i-j-1]);
            }
        }
        return dp[n];
    }
}
